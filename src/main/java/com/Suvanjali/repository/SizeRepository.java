package com.Suvanjali.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Suvanjali.entity.Product;
import com.Suvanjali.entity.Size;

@Repository
public interface SizeRepository extends JpaRepository<Size, Integer> {

	
	List<Size> findByProduct(Product product);
	
}
