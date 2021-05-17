package com.summit.ngo.usr.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.summit.ngo.usr.dto.UsrRegistrationDto;
import com.summit.ngo.usr.model.User;


public interface UserDetailsInterface extends UserDetailsService
{
	User findByEmail(String email);

    User save(UsrRegistrationDto registration);
	
}
