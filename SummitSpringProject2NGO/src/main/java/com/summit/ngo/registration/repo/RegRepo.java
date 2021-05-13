package com.summit.ngo.registration.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.summit.ngo.registration.model.Registration;

@Repository
public interface RegRepo extends JpaRepository<Registration, Integer>{

}
