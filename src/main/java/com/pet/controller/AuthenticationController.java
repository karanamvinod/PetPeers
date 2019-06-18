package com.pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pet.model.PetUser;
import com.pet.service.AuthenticationService;

@RestController
public class AuthenticationController {
	@Autowired
	AuthenticationService authenticationService;
	
	@PostMapping("/adduser/{userName}/{password}/{confirmPassword}")
	public String addUser(@PathVariable String userName, @PathVariable String password, @PathVariable String confirmPassword) {
	return authenticationService.addUser(userName, password, confirmPassword);
	
	}
	@PostMapping("/login")
	public String login(@RequestBody  PetUser petUser)
	{
		return authenticationService.login(petUser);
	}
	
	
		
	}
