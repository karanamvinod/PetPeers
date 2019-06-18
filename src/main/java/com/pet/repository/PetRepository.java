package com.pet.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pet.model.Pets;

public interface PetRepository  extends JpaRepository<Pets, Integer>{

	@Query(value="select * from petssdb.pets where pet_user_id=?1", nativeQuery = true)
	List<Pets> findByPetUserId(int userId);

	
	
}
