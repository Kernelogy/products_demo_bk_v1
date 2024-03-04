package com.example.demo.service;

import com.example.demo.model.Product;

public interface ProductService {
	Product findById(int id);
	Product updateProduct(int id, String name, String description, double price);

}
