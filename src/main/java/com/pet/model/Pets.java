

 package com.pet.model;
  
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
  @Entity 
  @Table(name = "PETS")
  public class Pets {
	  
	  @Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
	  
	  @Column(name = "PET_NAME")
		private String petName;

		@Column(name = "PET_AGE")
		private String petAge;

		@Column(name = "PET_PLACE")
		private String petPlace;

		@Column(name = "STATUS")
		private String status;

		@ManyToOne
		PetUser petUser;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getPetName() {
			return petName;
		}

		public void setPetName(String petName) {
			this.petName = petName;
		}

		public String getPetAge() {
			return petAge;
		}

		public void setPetAge(String petAge) {
			this.petAge = petAge;
		}

		public String getPetPlace() {
			return petPlace;
		}

		public void setPetPlace(String petPlace) {
			this.petPlace = petPlace;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public PetUser getPetUser() {
			return petUser;
		}

		public void setPetUser(PetUser petUser) {
			this.petUser = petUser;
		}
		
		@Override
		public String toString() {
			return "Pets [id=" + id + ", petName=" + petName + ", petAge=" + petAge + ", petPlace=" + petPlace
					+ ", petUser=" + petUser + "]";
		}

	  
	  
  
  }
 