package com.summit.ngo.usr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summit.ngo.usr.model.Role;
import com.summit.ngo.usr.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepo;
	
	public RoleService() {
	}
	
	public List<Role> findAll(){
		List<Role> roles = new ArrayList<Role>();
		roleRepo.findAll().forEach(e->roles.add(e));
		return roles;
	}
	
	public Role findById(int id) { 
		Role roles = roleRepo.findById(id).get(); 
		return roles; 
	} 
	
	public void deleteById(int id) { 
		roleRepo.deleteById(id); 
	} 

	public Role save(Role role) { 
		roleRepo.save(role); 
		return role; 
	} 
	
	public void updateById(Long id, Role role) { 
		
		roleRepo.save(role); 
	}

}
