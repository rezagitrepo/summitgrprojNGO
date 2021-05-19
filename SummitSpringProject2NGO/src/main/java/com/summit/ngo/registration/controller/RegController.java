package com.summit.ngo.registration.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.summit.ngo.registration.model.Registration;
import com.summit.ngo.registration.service.RegService;


@RestController
public class RegController {
	@Autowired
	RegService regService;
	
	@GetMapping("/view")
	public ModelAndView view(Model model) {
		System.out.println("view executed");
		List<Registration> lists = regService.findAll();
		model.addAttribute("lists",lists);
		return new ModelAndView("/view");
	}
	
	@GetMapping("/register")
	public ModelAndView register(Model model) {
		System.out.println("register executed");
		return new ModelAndView("/register_event");
	}
	
	@PostMapping("/regEvent")
	public String regEvent(@Valid Registration reg, Model model,@RequestParam("id") int id) {
		Registration regInDb = regService.findById(id);
		regService.save(reg);
		model.addAttribute("regInDb",regInDb);
		return "redirect:/view";
	}
}
