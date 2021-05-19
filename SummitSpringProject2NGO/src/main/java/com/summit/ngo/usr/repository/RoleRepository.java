package com.summit.ngo.usr.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.summit.ngo.usr.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

	@Query( value = "select r.name from Role r join users_roles ur on r.id=ur.role_id join user u on u.id=ur.user_id and u.id=:userId",nativeQuery = true)
	public String findRole(@Param("userId") Integer userId);

//<<<<<<< HEAD
////	@Modifying
////    @Transactional
////    @Query("update Role r set r.name = ?1 where c.id = ?2")
////    public void updateRoleName(String email,Integer id);
//=======
//	@Query( value = "select r.name from Role r join users_roles ur on r.id=ur.role_id join user u on u.id=ur.user_id",nativeQuery = true)
//	public List<String> findAllRole();
//>>>>>>> branch 'master' of https://github.com/rezagitrepo/summitgrprojNGO.git
	
}
