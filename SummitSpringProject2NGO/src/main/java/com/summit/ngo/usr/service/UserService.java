package com.summit.ngo.usr.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.summit.ngo.usr.dto.UsrRegistrationDto;
import com.summit.ngo.usr.model.Role;
import com.summit.ngo.usr.model.User;
import com.summit.ngo.usr.repository.UserRepository;




@Service
public class UserService implements UserDetailsInterface
//implements UserDetailsInterface
{
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
	
    public User findByEmail(String email){
        return userRepo.findByEmail(email);
    }

	public User saveEditUser(User user) { 
		User userContain = new User();
        userContain.setId(user.getId());
		userContain.setFirst_name(user.getFirst_name());
        userContain.setLast_name(user.getLast_name());
        userContain.setEmail(user.getEmail());
		return userRepo.save(userContain);
	} 
	
	public User saveNewUser(User user) { 
		User userContain = new User();
        userContain.setId(user.getId());
		userContain.setFirst_name(user.getFirst_name());
        userContain.setLast_name(user.getLast_name());
        userContain.setEmail(user.getEmail());
        userContain.setPassword(user.getPassword());
        userContain.setRoles(user.getRoles());
		return userRepo.save(userContain);
	} 
	
	public void updateById(Long id, User user) { 
		userRepo.save(user); 
	}

	
	@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

	@Override
	public User save(UsrRegistrationDto registration) {
		// TODO Auto-generated method stub
		return null;
	}
}
