package com.Suvanjali.service;

import com.Suvanjali.entity.Cart;
import com.Suvanjali.entity.CartQuantity;
import com.Suvanjali.entity.User;


public interface CartService {
	
	Cart findById(int id);
	Cart saveOrUpdate(CartQuantity cartQuantity, User user);
	

}
