package com.summit.ngo.registration.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summit.ngo.registration.model.Registration;
import com.summit.ngo.registration.repo.RegRepo;

@Service
public class RegService {

	@Autowired
	private RegRepo regRepo;
	
	public List<Registration> findAll(){
		List<Registration> registrations = new ArrayList<Registration>();
		regRepo.findAll().forEach(e->registrations.add(e));
		return registrations;
	}
	
	public Registration findById(int id) { 
		Registration registrations = regRepo.findById(id).get(); 
		return registrations; 
	} 
	
	public void deleteById(int id) { 
		regRepo.deleteById(id); 
	} 

	public Registration save(Registration event) { 
		regRepo.save(event); 
		return event; 
	} 
	
	public void updateById(Long id, Registration event) { 
		
		regRepo.save(event); 
	}
}