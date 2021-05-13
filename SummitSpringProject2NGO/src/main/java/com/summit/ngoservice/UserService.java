package com.summit.ngoservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summit.ngomodel.User;
import com.summit.ngorepository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public UserService() {
	}
	
	public List<User> findAll(){
		List<User> users = new ArrayList<User>();
		userRepo.findAll().forEach(e->users.add(e));
		return users;
	}
	
	public User findById(int id) { 
		User users = userRepo.findById(id).get(); 
		return users; 
	} 
	
	public void deleteById(int id) { 
		userRepo.deleteById(id); 
	} 

	public User save(User user) { 
		userRepo.save(user); 
		return user; 
	} 
	
	public void updateById(Long id, User user) { 
		
		userRepo.save(user); 
	}

}
