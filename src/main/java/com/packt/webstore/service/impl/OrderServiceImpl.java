package com.packt.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.ProductRepository;
import com.packt.webstore.domain.Product;
import com.packt.webstore.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public void processOrder(String productId, int count) {
		Product productById = productRepository.getProductById(productId);
		if (productById.getUnitsInStock() < count){
			throw new IllegalArgumentException(
			"Too few units. Current units in stock: " + productById.getUnitsInStock());
		}
		productById.setUnitsInStock(productById.getUnitsInStock() - count);
	}

}
