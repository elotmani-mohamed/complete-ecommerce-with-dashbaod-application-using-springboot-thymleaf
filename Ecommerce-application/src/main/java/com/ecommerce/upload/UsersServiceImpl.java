package com.ecommerce.upload;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepo repo;
	@Autowired
	private UploadPathServices pathService;
	@Autowired
	private UsersFileRepo fileRepo;

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Users saveUsers(Users users) {
		// TODO Auto-generated method stub
		Users savedUser = repo.save(users);
		if (savedUser != null && !savedUser.getFiles().isEmpty() && savedUser.getFiles().size() > 0) {

			for (MultipartFile file : savedUser.getFiles()) {
				String fileName = file.getOriginalFilename();
				String modifiedFileName = FilenameUtils.getBaseName(fileName).concat("_")
						.concat("_" + System.currentTimeMillis()).concat(".").concat(FilenameUtils.getExtension(fileName));
				File storeFile = pathService.getFilePath(modifiedFileName, "images");
				if (storeFile != null) {
					try {
						FileUtils.writeByteArrayToFile(storeFile, file.getBytes());
					} catch (Exception e) {
						e.printStackTrace();
					}
				} 
				
				UsersFile usersFile = new UsersFile();
				usersFile.setFileName(fileName);
				usersFile.setModifiedFileName(modifiedFileName);
				usersFile.setFileExtension(FilenameUtils.getExtension(fileName));
				usersFile.setUser(savedUser);
				fileRepo.save(usersFile);
			   
			}

		}
		
		return savedUser;
	}

}
