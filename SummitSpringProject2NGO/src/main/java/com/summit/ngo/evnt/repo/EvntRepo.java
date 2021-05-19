package com.summit.ngo.evnt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.summit.ngo.evnt.model.Event;

@Repository
public interface EvntRepo extends JpaRepository<Event, Integer>{

}