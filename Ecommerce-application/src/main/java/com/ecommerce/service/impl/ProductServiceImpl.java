package com.ecommerce.service.impl;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.models.Photo;
import com.ecommerce.models.Product;
import com.ecommerce.repositories.PhotoRepo;
import com.ecommerce.repositories.ProductRepo;
import com.ecommerce.user.service.ProductService;
import com.ecommerce.user.service.UploadPathService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private UploadPathService pathService;
	
	@Autowired
	private PhotoRepo photoRepo;
	
	@Override
	public List<Product> allProducts() {
		// TODO Auto-generated method stub
		
		return productRepo.findAll();
	}

	@Override
	public Product saveProduct(Product product) {
		Product savedProduct = productRepo.save(product);
		if (savedProduct != null && !savedProduct.getFiles().isEmpty() && savedProduct.getFiles().size() > 0) {

			for (MultipartFile file : savedProduct.getFiles()) {
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
				
				Photo photo = new Photo();
				photo.setFileName(fileName);
				photo.setModifiedFileName(modifiedFileName);
				photo.setFileExtension(FilenameUtils.getExtension(fileName));
				photo.setProduct(savedProduct);
				photoRepo.save(photo);
			   
			}

		}
		return savedProduct;
		
	}

	@Override
	public void removeProduct(Long id) {
		productRepo.deleteById(id);
		
	}

	@Override
	public Product getProductById(Long id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id).get();
	}
	
	

}
