package com.ecommerce.upload;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecommerce.models.Photo;

@Controller
public class UsersController {

	@Autowired private UsersService service;
	
	@GetMapping("upload-file")
	public String showUploadForm(Model model) {
		
		 List<Users> users = service.getAllUsers();		
		 model.addAttribute("allUsers", users);
		 model.addAttribute("users", new Users());
		 model.addAttribute("files",new ArrayList<Photo>());
		
		return "dashboard/file-upload";
	}
	
	@PostMapping("save-users")
	public String save(@ModelAttribute Users users) {
		service.saveUsers(users);
		return "redirect:/upload-file";
	}
	
}
