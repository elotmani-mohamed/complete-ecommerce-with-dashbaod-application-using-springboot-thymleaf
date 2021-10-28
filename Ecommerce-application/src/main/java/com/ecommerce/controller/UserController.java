package com.ecommerce.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
 
@Controller 
public class UserController  {
     
	
	@GetMapping("/")
	public String index() {
		
		
		
		return "home/index";
	}
	
	@GetMapping("/admin/dashboard")
	public String dashboard() {
		return "dashboard/index";
	}
	
	
	
}      
 