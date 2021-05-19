package com.summit.ngo.evnt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summit.ngo.evnt.model.Event;
import com.summit.ngo.evnt.repo.EvntRepo;

@Service
public class EvntService {
	
	@Autowired
	private EvntRepo evntRepo;
	
	public List<Event> findAll(){
		List<Event> events = new ArrayList<Event>();
		evntRepo.findAll().forEach(e->events.add(e));
		return events;
	}
	
	public Event findById(int id) { 
		Event events = evntRepo.findById(id).get(); 
		return events; 
	} 
	
	public void deleteById(int id) { 
		evntRepo.deleteById(id); 
	} 

	public Event save(Event event) { 
		evntRepo.save(event); 
		return event; 
	} 
	
	public void updateById(Long id, Event event) { 
		
		evntRepo.save(event); 
	}
	
	public Event saveEvent(Event event) { 
		Event evntContain = new Event();
		evntContain.setId(event.getId());
		evntContain.setName(event.getName());
		evntContain.setCategory(event.getCategory());
		evntContain.setLocation(event.getLocation());
		evntContain.setStart_date(event.getStart_date());
		evntContain.setEnd_date(event.getEnd_date());
		return evntRepo.save(evntContain);
	} 
}