package com.Suvanjali.controller;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Suvanjali.entity.CustomRole;
import com.Suvanjali.entity.Role;
import com.Suvanjali.security.MyUserDetails;
import com.Suvanjali.service.CategoryService;
import com.Suvanjali.service.ProductService;

@Controller
public class LoginController {
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	
	@GetMapping({"/login"})
	public String showLogin() {
		return "login";
	}
	
	
	@GetMapping("/")
	public String homePage(@AuthenticationPrincipal MyUserDetails userDetails, Model model ) {
		if(userDetails!=null) {
			Set<Role> authorities = userDetails.getUser().getRole();
			for(Role role:authorities) {
				if(role.getName().equals(CustomRole.ROLE_ADMIN))
					return "redirect:/admin/dashboard";
			}
		}
//		List<Product> products = productService.findAll();
//		model.addAttribute("allProducts",products);
//		model.addAttribute("categories", categoryService.findAll());
		return "redirect:/default/list";			
	}

}
