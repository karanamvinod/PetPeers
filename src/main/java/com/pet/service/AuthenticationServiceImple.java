package com.pet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.model.PetUser;
import com.pet.repository.PetUserRepository;
@Service
public class AuthenticationServiceImple implements AuthenticationService {
	
	@Autowired
	PetUserRepository petUserRepository;

	@Override
	public String addUser(String userName, String password, String confirmPassword) {
		if(password.equalsIgnoreCase(confirmPassword)) {
			PetUser user= petUserRepository.getUserDetails(userName);
			if(user!=null) {
				return "user already Exist";
			}
			else {
				PetUser petUser=new PetUser();
				petUser.setUsername(userName);
				petUser.setUserpassword(password);
			if(petUserRepository.save(petUser)!=null)
				return "user registration sucessfully";
			else 
				return "user registration failed please try agin";
		}
	}
	else
	{
			return "password validation failed";
		}
	}
	@Override
	public String login(PetUser petUser) {
		
		PetUser petuser =  petUserRepository.getUserDetails(petUser.getUsername());

		if(petuser != null) {
			if(petuser.getUsername().equalsIgnoreCase(petUser.getUsername()) &&
					petuser.getUserpassword().equalsIgnoreCase(petUser.getUserpassword())){
				return "login successful"; 
			}else if(petuser.getUserpassword() != petUser.getUserpassword()) {
				return "Password entered is wrong"; 
			}
		}else {
			return "User Name entered is wrong";
		}
		
		return null;
	}

}
