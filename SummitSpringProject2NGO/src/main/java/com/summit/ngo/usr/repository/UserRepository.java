package com.summit.ngo.usr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.summit.ngo.usr.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByEmail(String email);
	
	@Query( value = "select * from user a left join users_roles b on b.user_id = a.id left join role c on c.id = b.role_id",nativeQuery = true)
	public List<User> userAndRole();
}
