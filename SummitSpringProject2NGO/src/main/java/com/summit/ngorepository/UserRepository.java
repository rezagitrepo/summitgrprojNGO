package com.summit.ngorepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.summit.ngomodel.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
