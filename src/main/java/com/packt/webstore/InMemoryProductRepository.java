package com.packt.webstore;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Product;

@Repository
public class InMemoryProductRepository implements ProductRepository {

	private List<Product> listOfProducts = new ArrayList<>();
	
	public InMemoryProductRepository(){
		
		Product iphone = new Product("P1234", "iPhone 5s", new BigDecimal(500));
		iphone.setDescription("Apple iPhone 5s, smartphone with 5-inch screen with resolution of 640x1136"
				+ " and 8Mpx camera.");	
		iphone.setCategory("Smart Phone");
		iphone.setManufacturer("Apple");
		iphone.setUnitsInStock(1000);
		
		Product laptop_dell = new Product("P1235", "Dell Inspiron", new BigDecimal(700));
		laptop_dell.setDescription("Dell Inspiron 14 inch laptop (black); with Intel Core 3 processor");
		laptop_dell.setCategory("Laptop");
		laptop_dell.setManufacturer("Dell");
		laptop_dell.setUnitsInStock(1000);
		
		Product tablet_Nexus = new Product("P1236", "Nexus 7", new BigDecimal(300));
		tablet_Nexus.setDescription("Google Nexus 7 is the lightest 7 inch tablet with 4-core processor Qualcomm Snapdragon S4 Dragon");
		tablet_Nexus.setCategory("Tablet");
		tablet_Nexus.setManufacturer("Google");
		tablet_Nexus.setUnitsInStock(1000);
		
		listOfProducts.add(iphone);
		listOfProducts.add(laptop_dell);
		listOfProducts.add(tablet_Nexus);
	}
	
	public Product getProductById(String productId){
		Product productById = null;
		
		for(Product product: listOfProducts){
			if(product != null && product.getProductId() != null &&
					product.getProductId().equals(productId)){
				productById = product;
				break;
			}
		}
		
		if(productById == null){
			throw new IllegalArgumentException("No product with the given id: " + productId);
		}
		
		return productById;
	}
	
	
	public List<Product> getAllProducts(){
		return listOfProducts;
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		List<Product> productsByCategory = new ArrayList<Product>();
		
		for(Product product: listOfProducts){
			if(product.getCategory().equalsIgnoreCase(category)){
				productsByCategory.add(product);
			}
		}
		return productsByCategory;
	}

	@Override
	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		Set<Product> productsByBrand = new HashSet<Product>();
		Set<Product> productsByCategory = new HashSet<Product>();
		Set<String> criterias = filterParams.keySet();
		if(criterias.contains("brand")){
			for(String brandName: filterParams.get("brand")){
				for(Product product:listOfProducts){
					if(product.getManufacturer().equalsIgnoreCase(brandName)){
						productsByBrand.add(product);
					}
				}
			}
		}
		if(criterias.contains("category")){
			for(String category: filterParams.get("category")){
				productsByCategory.addAll(this.getProductsByCategory(category));
			}
		}
		
		productsByCategory.retainAll(productsByBrand);

		return productsByCategory;
	}

	@Override
	public List<Product> getProductsByManufacturer(String manufacturer) {
		
		List<Product> productsByManufacturer = new ArrayList<>();
		for(Product product: listOfProducts){
			if(product.getManufacturer().equalsIgnoreCase(manufacturer)){
				productsByManufacturer.add(product);
			}
		}
		return productsByManufacturer;
	}

	@Override
	public Set<Product> getProductsByPriceFilter(Map<String, List<String>> filterParams) {
		Set<Product> productsLower = new HashSet<Product>();
		Set<Product> productsHigher = new HashSet<Product>();
		Set<String> criterias = filterParams.keySet();
		
		
		BigDecimal low = new BigDecimal(filterParams.get("low").get(0));
		BigDecimal high = new BigDecimal(filterParams.get("high").get(0));
		
		if(criterias.contains("low")){
			for(Product product: listOfProducts){
				if(product.getUnitPrice().compareTo(low) >= 0){
					productsHigher.add(product);
				}
			}
		}
		if(criterias.contains("high")){
			for(Product product: listOfProducts){
				if(product.getUnitPrice().compareTo(high) <= 0){
					productsLower.add(product);
				}
			}
		}
		productsLower.retainAll(productsHigher);
		System.out.println("all price bounded products: " + productsLower);
		return productsLower;
	}

	@Override
	public void addProduct(Product product) {
		listOfProducts.add(product);
	}
}
