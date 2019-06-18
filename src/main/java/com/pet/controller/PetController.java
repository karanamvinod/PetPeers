package com.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pet.model.Pets;
import com.pet.service.PetService;

@RestController
public class PetController {
	
	@Autowired
	PetService petService;
	
	@PostMapping("/addPets")
	public String addPet(@RequestBody Pets pets)
	{
		return petService.addPet(pets);
	}
	
	@GetMapping("/getPet/{id}")
	public Object petDetails(@PathVariable ("id") Integer id)
	{
		return petService.getPets(id);
	}
	
	@GetMapping("/getPets")
	public List<Pets> getAllPets()
	{
		return petService.getAllPets();
	}
	@GetMapping("/buyPet/{petid}/{userid}")
	public String buyPet(@PathVariable int petid,@PathVariable int userid) {
		
		return petService.buyPet(petid,userid);
	}
	
	@GetMapping("/getPetByUser/{userid}")
	public List<Pets> getPetList(@PathVariable int userid) {	
		return petService.myPet(userid);
	}

}
