package com.pet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pet.model.Pets;

@Service
public interface PetService {
	
	public String addPet(Pets pets);
	
	public Pets getPets(Integer id);
	
	public List<Pets> getAllPets();
	
	public String buyPet(int id,int userId);
	
	public List<Pets> myPet(int userid);
		
	
}
