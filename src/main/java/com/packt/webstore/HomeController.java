package com.packt.webstore;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String welcome(Model model){
		
		model.addAttribute("greeting", "Welcome to my on-line shop!");
		model.addAttribute("tagline", "Very special on-line shop");
		
		return "welcome";
	}
	
}
