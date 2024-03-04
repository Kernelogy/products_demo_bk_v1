package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepo;
import com.example.demo.service.ProductService;

import jakarta.websocket.server.PathParam;


@RestController
@RequestMapping("/product")

public class ProductController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepo productRepo;
	
//	@GetMapping("/set")
////	public ResponseEntity<?> setProduct(@RequestParam int id,  @RequestParam String name, @RequestParam String description, @RequestParam double price){
//	public ResponseEntity<?> setProduct(@RequestParam String name, @RequestParam String description, @RequestParam double price){
//		
////		Product product = new Product(id, name, description, price);
//		
//		Product product = new Product();
////		product.setId(id);
//		product.setName(name);
//		product.setDescription(description);
//		product.setPrice(price);
//		
//		
//		Product savedEntity = productRepo.save(product);
//	
//	
//		return ResponseEntity.status(HttpStatus.OK)
//				.body(savedEntity);
//	}
	
	@PostMapping("/set")
//	public ResponseEntity<?> setProduct(){
	public ResponseEntity<?> setProduct(@RequestBody Product product){
	
		
		
//		Product savedEntity = productRepo.save(product);
		Product savedEntity = productRepo.saveAndFlush(product);
	
		return ResponseEntity.status(HttpStatus.OK)
				.body(savedEntity);
	}
	
	@GetMapping("/delete")
	public ResponseEntity<?> deleteProduct(@RequestParam int id){
		Product product =  productRepo.findById(id).get();
		productRepo.delete(product);
	
	
		return ResponseEntity.status(HttpStatus.OK)
				.body("Deleted");
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<?> findById(@PathVariable int id){
		
		Product product = productService.findById(id);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(product);
		
	}
	
	@GetMapping("/findByPrice")
	public ResponseEntity<?> findByPrice(@RequestParam double price){
		List<Product> products = productRepo.findByPrice(price);
	
		return ResponseEntity.status(HttpStatus.OK)
				.body(products);
	}
	
	@GetMapping("/findBetweenPrice")
	public ResponseEntity<?> findBetweenPrice(@RequestParam double p1, @RequestParam double p2){
		List<Product> products = productRepo.findBetweenPrice(p1, p2);
	
		return ResponseEntity.status(HttpStatus.OK)
				.body(products);
	}
	
	@GetMapping("/update")
	public ResponseEntity<?> updateProduct(@RequestParam int id, @RequestParam String name, @RequestParam String description, @RequestParam double price){

		Product product = productService.updateProduct(id, name, description, price);
	
		return ResponseEntity.status(HttpStatus.OK)
				.body(product);
	}
	
	@GetMapping("/get")
	public ResponseEntity<?> getProduct() {
		Product p1 = new Product();
		p1.setId(1);
		p1.setName("Coffee");
		p1.setDescription("Narasus Coffee");
		p1.setPrice(105.50);
//		return(p1);
		
//		return ResponseEntity.status(HttpStatus.OK)
//		.body("Hello World");
		
		ResponseEntity.BodyBuilder builder = ResponseEntity.status(HttpStatus.OK);		
		ResponseEntity response = builder.body(p1);
		return(response);
		
	}
	@GetMapping("/list")
	public ResponseEntity<?>  getProducts() {
//		Product p1 = new Product();
//		p1.setId(1);
//		p1.setName("Coffee");
//		p1.setDescription("Narasus Coffee");
//		p1.setPrice(105.50);
//		
//		Product p2 = new Product();
//		p2.setId(2);
//		p2.setName("Tea");
//		p2.setDescription("Tajmahal Tea");
//		p2.setPrice(89.50);
//;
//		Product p3 = new Product();
//		p1.setId(3);
//		p1.setName("Oil");
//		p1.setDescription("Sunflower Oil");
//		p1.setPrice(205.50);
		Product p1 = new Product(1, "Coffee" , "Narasus Coffee", 105.50);
		Product p2 = new Product(2, "Tea", "Tajmahal Tea", 89.50);
		Product p3 = new Product(3, "Oil", "Sunflower Oil", 205.50);
		
		
		List<Product> list = new ArrayList<Product>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(list);
				

	}
}
