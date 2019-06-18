package com.pet.service;

import org.springframework.stereotype.Service;

import com.pet.model.PetUser;

@Service
public interface AuthenticationService  {
	public String addUser(String userName,String password,String confirmPassword);

	public String login(PetUser petUser);

}
