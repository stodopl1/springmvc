package com.packt.webstore.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.packt.webstore.domain.Product;
import com.packt.webstore.service.ProductService;
import com.packt.webstore.*;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping
	public String list(Model model){
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}
	
	@RequestMapping("/all")
	public String allProducts(Model model){
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}
	
	@RequestMapping("/{category}")
	public String getProductsByCategory(
			Model model, @PathVariable("category") String productCategory){
		model.addAttribute("products", productService.getProductsByCategory(productCategory));
		return "products";
	}

	@RequestMapping("/filter/{ByCriteria}")
	public String getProductsByFilter(
		@MatrixVariable(pathVar="ByCriteria") Map<String, List<String>> filterParams, Model model){
		model.addAttribute("products", productService.getProductsByFilter(filterParams));
		return "products";
	}
	
	@RequestMapping("/{category}/{price}")
	public String getProductsByPriceFilter(Model model, @PathVariable("category") String productsCategory,
			@MatrixVariable(pathVar="price") Map<String, List<String>> filterParams,
			@RequestParam("manufacturer") String manufacturer
	){

		List<Product> listByCategory = productService.getProductsByCategory(productsCategory);
		Set<Product> listByPrice = productService.getProductsByPriceFilter(filterParams);
		List<Product> listByManufacturer = productService.getProductsByManufacturer(manufacturer);
		
		System.out.println("controller: ");
		System.out.println("price: " + listByPrice);
		System.out.println("category: " + listByCategory);
		System.out.println("manufacturer: " + listByManufacturer);
		
		listByPrice.retainAll(listByCategory);
		listByPrice.retainAll(listByManufacturer);
		
		model.addAttribute("products", listByPrice);
		
		return "products";
	}
	
	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") String productId, Model model){
		model.addAttribute(productService.getProductById(productId));
		return "product";
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model){
		Product newProduct = new Product();
		model.addAttribute("newProduct", newProduct);
		return "addProduct";
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct){
		productService.addProduct(newProduct);
		return "redirect:/products";
	}
}
