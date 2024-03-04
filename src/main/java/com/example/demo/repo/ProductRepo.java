
package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
	
	@Query(value = "SELECT * FROM PRODUCTS WHERE price <= :price", nativeQuery = true)
	List<Product> findByPrice(double price);
	
//	@Query(value = "SELECT * FROM PRODUCTS WHERE price >= :p1 AND price <= :p2", nativeQuery = true)
	@Query(value = "SELECT * FROM PRODUCTS WHERE price >= ?1 AND price <= ?2", nativeQuery = true)
	List<Product> findBetweenPrice(double p1, double p2);
	
	@Query(value = "SELECT * FROM PRODUCTS WHERE name = :name", nativeQuery = true)
	List<Product> findByName(String name);
}
