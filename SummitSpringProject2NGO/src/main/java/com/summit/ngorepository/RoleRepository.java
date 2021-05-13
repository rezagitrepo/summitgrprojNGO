package com.summit.ngorepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.summit.ngomodel.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
