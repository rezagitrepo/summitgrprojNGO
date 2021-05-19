package com.summit.ngo.evnt.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.summit.ngo.evnt.model.Event;
import com.summit.ngo.evnt.service.EvntService;

import antlr.collections.List;

@RestController
public class EvntController {
	
	@Autowired
	EvntService evntService;
	
	@GetMapping("/event")
	public ModelAndView event(Model model) {
		System.out.println("event executed");
		List<Event> lists = evntService.findAll();
		model.addAttribute("lists", lists);
		return new ModelAndView("/event");
	}
	
	@GetMapping("/new_event")
	public ModelAndView newEvent(Model model) {
		System.out.println("newEvent executed");
		return new ModelAndView("/new_event");
	}
	
	@GetMapping("/edit_event/{id}")
	public ModelAndView editEvent(@PathVariable(name="id") int id) {
		System.out.println("edit executes");
		ModelAndView mav = new ModelAndView("edit_event");
		Event event = evntService.findById(id);
		mav.addObject("event",event);
		return mav;
	} 
	
	@PostMapping("/save_event")
	public String saveEvent(@Valid Event event, Model model) {
		evntService.save(event);
		model.addAttribute("event",event);
		return "redirect:/event";
	}
	
	@PostMapping("/saveEvent")
	public String saveEvent(@Valid Event event, Model model,@RequestParam("id") int id) {
		Event evntInDb = evntService.findById(id);
		System.out.println("id of event:"+id);
		System.out.println("evntInDb:"+evntInDb.getId());
		System.out.println("event"+event.getId());
		evntService.saveEvent(event);
		model.addAttribute("event",event);
		return "redirect:/event";
	}
}
