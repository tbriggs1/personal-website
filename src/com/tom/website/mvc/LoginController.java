package com.tom.website.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	// need a controller method to show the from
	@RequestMapping("/form")
	public String showForm() {
		return "login-form";
	}
	
	// need a controller method to procces the html form
	@RequestMapping("/processLogin")
	public String processForm() {
		return "process-login";
	}
	
	
	// controller method to read form data and add data to a model
	@RequestMapping("/checkUser")
	public String checkUser(@RequestParam("loginName") String theUser, Model model) {
		
		//Read the data from the HTML form
		
		String result = "You aren't Tom";
		
		if (theUser.toLowerCase() == "tom") {
			result = "Login successful";
		}
		
		if (theUser.toLowerCase() != "tom") {
			result = "Login failed";
		}
		
		
		model.addAttribute("verify", result);
		
		// Convert the data to all caps
		return "process-login";
	}
	
	
	
}
