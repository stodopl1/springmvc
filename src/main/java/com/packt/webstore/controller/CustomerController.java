package com.packt.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.packt.webstore.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping("/customers")
	public String showCustomers(Model model){
		System.out.println("kurcze!" + customerService.getAllCustomers());
		model.addAttribute("customers", customerService.getAllCustomers());
		return "customers";
	}
	
	
}
