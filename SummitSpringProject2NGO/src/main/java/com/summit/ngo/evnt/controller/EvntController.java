package com.summitworks.ngo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.summit.ngo.evnt.model.Event;
import com.summit.ngo.evnt.service.EvntService;

@Controller
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
	public String newEvent(Model model) {
		System.out.println("newEvent executed");
		model.addAttribute("event",new Event());
		return "/new_event";
	}
	
	@GetMapping("/edit_event/{id}")
	public ModelAndView editEvent(@PathVariable(name="id") int id) {
		System.out.println("edit executes");
		ModelAndView mav = new ModelAndView("edit_event");
		Event event = evntService.findById(id);
		mav.addObject("event",event);
		return mav;
	} 
	
	@PostMapping("/saveNewEvent")
	public String saveNewEvent(@Validated @ModelAttribute Event event, Model model) {
		System.out.println(event.getStart_date());
		evntService.save(event);
		model.addAttribute("event",event);
		return "redirect:/event";
	}
	
	@PostMapping("/saveEditEvent")
	public String saveEditEvent(@Valid Event event, Model model,@RequestParam("id") int id) {
		Event evntInDb = evntService.findById(id);
		evntService.saveEditEvent(event);
		model.addAttribute("evntInDb",evntInDb);
		return "redirect:/event";
	}
}
