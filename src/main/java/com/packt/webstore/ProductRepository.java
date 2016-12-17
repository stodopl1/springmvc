package com.packt.webstore;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.packt.webstore.domain.*;

public interface ProductRepository {
	List<Product> getAllProducts();
	Product getProductById(String productId);
	List<Product> getProductsByCategory(String category);
	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	List<Product> getProductsByManufacturer(String manufacturer);
	Set<Product> getProductsByPriceFilter(Map<String, List<String>> filterParams);
	
}
