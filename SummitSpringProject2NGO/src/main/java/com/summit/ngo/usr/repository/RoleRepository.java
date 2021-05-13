package com.summit.ngo.usr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.summit.ngo.usr.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
