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
	@Autowired
	private UserRepository userRepo;
	
	
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
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User findByEmail(String email){
        return userRepo.findByEmail(email);
    }

	public User save(UsrRegistrationDto userDto) { 
		User user = new User();
        user.setFirst_name(userDto.getFirstName());
        user.setLast_name(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        //user.setPassword(userDto.getPassword());
        user.setRoles(Arrays.asList(new Role("ROLE_ADMIN")));
		//return userRepo.save(user);
		return userRepo.save(user);
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
}
