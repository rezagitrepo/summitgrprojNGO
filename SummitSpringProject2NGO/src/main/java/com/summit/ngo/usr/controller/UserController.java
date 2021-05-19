package com.summit.ngo.usr.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.summit.ngo.usr.model.User;
import com.summit.ngo.usr.repository.RoleRepository;
import com.summit.ngo.usr.repository.UserRepository;
import com.summit.ngo.usr.service.UserService;




@Controller
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	RoleRepository roleRepo;
	@Autowired
	UserRepository userRepo;
	
	
	@GetMapping("/")
	public String index() {
		System.out.println("index executed");
		return "index";
		
	}
	
	@GetMapping("/login")
	public String login(Model model, String error, String logout) {

		if (error != null)
			model.addAttribute("errorMsg", "Your username and password are invalid.");

		if (logout != null)
			model.addAttribute("msg", "You have been logged out successfully.");
		System.out.println("LogIn page Executed");
		return "login";
	}

	
	@GetMapping("/generalUser")
	public String generalUser(Model model) {
		model.addAttribute("msg", "Hi.");
		System.out.println("generalUser is Executed");
		return "/generalUser";
	}
	
	@GetMapping("/user")
	public ModelAndView user(Model model) {
		//System.out.println("index executed");
		List<User> lists = userRepo.findAll();
		//List<String> roleNames = roleRepo.findAllRole();
		String first_name = "";
		String last_name = "";
		String role="";
		
		System.out.println(lists);
		for(int i=0; i<lists.size(); i++) {
			first_name = lists.get(i).getFirst_name();
			last_name = lists.get(i).getLast_name();
			role = lists.get(i).getRole();
		}
		
		// first name + last name
		String name = first_name+" "+last_name;
		
		model.addAttribute("name",name);
		model.addAttribute("lists",lists);
		//model.addAttribute("roleNames",role);
		return new ModelAndView("/user");
	}
	
	@GetMapping("/edit_popup/{id}")
	public ModelAndView editUser(@PathVariable(name="id") int id) {
		System.out.println("edit executes");
		ModelAndView mav = new ModelAndView("edit_popup");
		User user = userService.findById(id);
		mav.addObject("user",user);
		return mav;
	} 
	
	@PostMapping("/saveEditUser")
	public String saveEditUser(@Valid User user, Model model,@RequestParam("id") int id) {
		User userInDb = userService.findById(id);
		userService.saveEditUser(user);
		model.addAttribute("userInDb",userInDb);
		return "redirect:/user";
	}
	
	@PostMapping("/saveNewUser")
	public String saveNewUser(@Valid User user, Model model) {
		//String temPassword = user.getPassword();
		//user.setPassword(passwordEncoder.encode(temPassword));
		userService.saveNewUser(user);
		return "redirect:/user";
	}
	
	@GetMapping("/delete_popup/{id}")
	public String delete(@PathVariable(name="id") int id) {
		System.out.println("delete executes");
		userService.deleteById(id);
		return "redirect:/user";
	}
	
	
//	@GetMapping("/newUser_popup")
//	public ModelAndView newUser() {
//		ModelAndView mav = new ModelAndView("newUser_popup");
//		User user = new User();
//		mav.addObject("user",user);
//		return mav;
//	}
	
	
//	@GetMapping("/new_user")
//	public String newUser() {
//		System.out.println("newUser executes");
//		return "new_user";
//	}
	
	@GetMapping("/new_user")
	public ModelAndView newUser() {
		System.out.println("newUser executes");
		ModelAndView mav = new ModelAndView("new_user");
		User user = new User();
		mav.addObject("user",user);
		return mav;
	}
	
}
