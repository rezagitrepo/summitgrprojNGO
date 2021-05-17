package com.summit.ngo.usr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.summit.ngo.usr.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

	@Query( value = "select r.name from Role r join users_roles ur on r.id=ur.role_id join user u on u.id=ur.user_id and u.id=:userId",nativeQuery = true)
	public String findRole(@Param("userId") Integer userId);

	
	
	
}
