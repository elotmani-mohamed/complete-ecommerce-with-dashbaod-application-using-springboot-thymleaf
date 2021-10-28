package com.ecommerce.dashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping()
	public String login(@RequestParam(value = "error",required = false) String error,
			@RequestParam(value = "logout",required = false ) String logout,
			ModelMap map) {
		
		if(error!=null) {
			map.put("error","Invalid username/password");
		}
		if(logout!=null) {
			map.put("logout","successfully logout");
		}
		
		
		return "dashboard/login";
	}
	
}
