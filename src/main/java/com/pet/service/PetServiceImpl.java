package com.pet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.model.PetUser;
import com.pet.model.Pets;
import com.pet.repository.PetRepository;
import com.pet.repository.PetUserRepository;

@Service
public class PetServiceImpl implements PetService {

	@Autowired
	PetRepository petRepository;

	@Autowired
	PetUserRepository petUserRepository;

	@Override
	public String addPet(Pets pets) {
		petRepository.save(pets);
		return "pet added successfully";
	}
	
	@Override
	public Pets getPets(Integer id) {
		Pets pets = petRepository.findById(id).get();
		
		return pets;
	}

	@Override
	public List<Pets> getAllPets() {

		return petRepository.findAll();
	}

	@Override
	public String buyPet(int id, int userid) {
		Optional<Pets> pets = petRepository.findById(id);
		Optional<PetUser> user = petUserRepository.findById(userid);
		String status = null;

		if (user.isPresent()) {
			if (pets.isPresent()) {
				if (pets.get().getStatus().equalsIgnoreCase("Buy")) {
					pets.get().setStatus("sold out");
					PetUser petUser = new PetUser();
					petUser.setUserid(userid);
					pets.get().setPetUser(petUser);
					petRepository.save(pets.get());
				} else {
					status = "Already sold out";
				}
			} else {
				status = "Pet is not availble";
			}
		} else {
			status = "User not found";
		}
		return status;
	}
	public List<Pets> myPet(int userId) {
		return petRepository.findByPetUserId(userId);
	}

	
	

}
