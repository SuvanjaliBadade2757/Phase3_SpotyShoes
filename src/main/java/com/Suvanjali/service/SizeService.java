package com.Suvanjali.service;

import java.util.List;

import com.Suvanjali.entity.Size;


public interface SizeService {

	Size findById(int id);
	
	List<Size> findAll();
	
	Size saveOrUpdate(Size size);
	
	void removeById(int id);
	
}
