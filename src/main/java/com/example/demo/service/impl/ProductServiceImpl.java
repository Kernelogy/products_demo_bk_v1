package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepo;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepo productRepo;

	@Override
	public Product findById(int id) {
		
		Optional<Product> tproduct = productRepo.findById(id);
		
		if(!tproduct.isEmpty())
			return tproduct.get();			
		else
			return null;	
	}

	@Override
	public Product updateProduct(int id, String name, String description, double price) {
		
		Product product = productRepo.findById(id).get();		
		product.setName(name);
		product.setDescription(description);
		product.setPrice(price);
		
		
		Product savedEntity = productRepo.save(product);
		
		return savedEntity;
	}

}
