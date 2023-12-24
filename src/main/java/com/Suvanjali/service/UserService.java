package com.Suvanjali.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.Suvanjali.dto.OrderDetailsDto;
import com.Suvanjali.dto.UserRegistrationDto;
import com.Suvanjali.entity.User;

public interface UserService extends UserDetailsService{

	User save(UserRegistrationDto userRegistrationDto);
	User findById(long id);
	List<OrderDetailsDto> findAllOrders(User user);
	List<User> findAll();
	List<User> findByFirstNameIgnoreCaseContainingOrLastNameIgnoreCaseContainingOrEmailIgnoreCaseContaining(String firstName, String lastName, String email);
	User changePwd(User user, String newPwd);
	
}
