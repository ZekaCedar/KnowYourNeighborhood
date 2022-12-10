package com.kyn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kyn.entity.Users;
import com.kyn.exception.ResourceNotFoundException;
import com.kyn.repository.UsersRepository;
import com.kyn.service.UsersPrincipal;

@RestController
@RequestMapping(value = "/kyn")
public class UsersController {
	
	@Autowired
	private UsersRepository usersRepo;

	@GetMapping("/user/me") 
	public Users getUser(@CurrentUser UsersPrincipal usersPrincipal) {
	   return usersRepo.findById((usersPrincipal.getUsersId())) 
	                .orElseThrow(() -> new ResourceNotFoundException("Users", "userId", usersPrincipal.getUsersId()));
	}
}
