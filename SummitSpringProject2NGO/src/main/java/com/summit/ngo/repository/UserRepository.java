package com.summit.ngo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.summit.ngo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
