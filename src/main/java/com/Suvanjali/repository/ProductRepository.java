package com.Suvanjali.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Suvanjali.entity.Category;
import com.Suvanjali.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByNameContainingIgnoreCase(String name);
	
	List<Product> findByCategory(Category category);
}
