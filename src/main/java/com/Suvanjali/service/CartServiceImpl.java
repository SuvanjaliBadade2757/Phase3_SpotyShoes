package com.Suvanjali.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Suvanjali.entity.Cart;
import com.Suvanjali.entity.CartQuantity;
import com.Suvanjali.entity.User;
import com.Suvanjali.repository.CartQuantityRepository;
import com.Suvanjali.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	CartQuantityRepository cartQuantityRepository;
	
	@Autowired
	UserService userService;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	@Override
	public Cart saveOrUpdate(CartQuantity cartQuantity, User userDetached) {
		User user = userService.findById(userDetached.getId());
		logger.info("=======>user.getCart() = "+user.getCart());
		logger.info("=======>Inside Cart service");
			for(Cart cart: user.getCart()) {
				logger.info("=======>User has existing cart");
				if(!cart.isCheckedOut()) {
					logger.info("=======>User has active cart");
					cartQuantity.setCart(cart);
					cart.getCartQuantity().add(cartQuantity);
					cart.setTotal(cart.getTotal()+cartQuantity.getQuantity()*Integer.parseInt(cartQuantity.getProductSize().getProduct().getPrice()));
					return cartRepository.save(cart);
					
				}
			}		
		Cart cart = new Cart();
				logger.info("=======>Created new cart");
		cartQuantity.setCart(cart);
		Set<Cart> carts = new  HashSet<Cart>();
		carts.add(cart);
		user.setCart(carts);
		cart.setUser(user);
		cart.setCheckedOut(false);
		Set<CartQuantity> products = new HashSet<CartQuantity>();
		products.add(cartQuantity);
		cart.setCartQuantity(products);
		cart.setTotal(cartQuantity.getQuantity()*Integer.parseInt(cartQuantity.getProductSize().getProduct().getPrice()));
		return cartRepository.save(cart);
	}

	@Override
	public Cart findById(int id) {
		
		Optional<Cart> findCart = cartRepository.findById(id);
		if(findCart.isPresent()) {
			return findCart.get();
		}
		
		return null;
	}

	

}
