package com.mypet.web.hdl;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import com.mypet.web.dog.Dogs;

@Repository
public interface DogHandler {
	@Insert("INSERT INTO DOG (SPECIES,SIZE,NAME,HAIRLENGTH,COLOR,SEX,BREED,AGE,BIRTHDATE,VACCIN)values(" + 
			"#{species}, #{size},#{name},#{hairLength},#{color},#{sex},#{breed},#{age},#{birthdate},#{vaccin})")
	public void insertDogs(Dogs param);
}	
