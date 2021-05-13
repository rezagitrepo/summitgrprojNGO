package com.summit.ngo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.summit.ngo.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
