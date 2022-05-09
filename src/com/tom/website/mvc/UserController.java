package com.tom.website.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		//Create a new user object
		User theUser = new User();
		
		// Add user object to the model
		theModel.addAttribute("user", theUser);
		
		return "user-form";
	}
	
	@RequestMapping("/processform")
	public String processForm(@ModelAttribute("user") User theUser) {
		
		System.out.println(theUser.getFirstName());
		
		return "user-confirmation";
	}
}
