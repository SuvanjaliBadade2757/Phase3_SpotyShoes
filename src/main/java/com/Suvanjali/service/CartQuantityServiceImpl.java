package com.Suvanjali.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Suvanjali.entity.CartQuantity;
import com.Suvanjali.repository.CartQuantityRepository;

@Service
public class CartQuantityServiceImpl implements CartQuantityService {

	@Autowired
	CartQuantityRepository cartQuantityRepository;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void deleteById(int id) {
		
		cartQuantityRepository.deleteById(id);
		Optional<CartQuantity> cartQuant = cartQuantityRepository.findById(id);
		if(cartQuant.isPresent()) {
			logger.info("==========>Deleting Cart ietm with quantity "+cartQuant.get().getQuantity());
			cartQuantityRepository.delete(cartQuant.get());
		}

	}

}
