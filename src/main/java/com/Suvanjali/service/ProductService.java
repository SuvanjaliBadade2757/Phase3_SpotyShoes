package com.Suvanjali.service;

import java.util.List;

import com.Suvanjali.entity.Category;
import com.Suvanjali.entity.Product;

public interface ProductService {
	
	Product findById(int id);
	
	List<Product> findAll();
	
	Product saveOrUpdate(Product product);
	
	void removeById(int id);
	
	List<Product> findByNameContainingIgnoreCase(String name);
	
	List<Product> findByCategory(Category category);
}
