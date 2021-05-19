package com.summit.ngo.registration.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.summit.ngo.evnt.model.Event;
import com.summit.ngo.evnt.service.EvntService;
import com.summit.ngo.registration.model.Registration;
import com.summit.ngo.registration.service.RegService;
import com.summit.ngo.usr.model.User;


@RestController
public class RegController {
	@Autowired
	RegService regService;
	
	@Autowired
	EvntService evntService;
	
	@GetMapping("/view")
	public ModelAndView viewEvent(Model model) {
		System.out.println("view executed");
		List<Event> lists = evntService.findAll();
		model.addAttribute("lists",lists);
		List<Registration> lists1 = regService.findAll();
		model.addAttribute("lists1",lists1);
		
		System.out.println(lists1);
		System.out.println((lists1.get(3).getEventName()));
		model.addAttribute("test",lists.get(0).getCategory());
		
		return new ModelAndView("/view");
	}
	
//	@GetMapping("/view")
//	public ModelAndView viewReg(Model model) {
//		System.out.println("view executed");
//		List<Registration> lists1 = regService.findAll();
//		model.addAttribute("lists1",lists1);
//		return new ModelAndView("/view");
//	}
	
	@GetMapping("/register")
	public ModelAndView register() {
		System.out.println("register executed");
		
		ModelAndView mav = new ModelAndView("register_event");
		Registration registration = new Registration();
		mav.addObject("reg",registration);
		return mav;
		
		//return new ModelAndView("/registration");
		//return new ModelAndView("/register_event");
	}
	
	@PostMapping("/regEvent")
	public ModelAndView regEvent(@Valid Registration reg, Model model) {
		//@RequestParam("id") int id
		//Registration regInDb = regService.findById(id);
		regService.save(reg);
		List<Event> lists = evntService.findAll();
		model.addAttribute("lists",lists);
		model.addAttribute("lists1",reg);
		//return "redirect:/view";
		return new ModelAndView("view");
	}
}