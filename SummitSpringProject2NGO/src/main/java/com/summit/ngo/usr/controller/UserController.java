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

import com.summit.ngo.usr.dto.UsrRegistrationDto;
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
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/")
	public String index() {
		System.out.println("index executed");
		//return "/login";
		return "index";
		//return "redirect:/checkUser";
	}
	
	@GetMapping("/login")
	public String login(Model model, String error, String logout) {

		if (error != null)
			model.addAttribute("errorMsg", "Your username and password are invalid.");

		if (logout != null)
			model.addAttribute("msg", "You have been logged out successfully.");
		System.out.println("LogIn page Executed");
		
//		String password = "123";
//		String encPass = passwordEncoder.encode(password);
//		System.out.println("Encoded Password="+encPass);
		return "login";
		
		
	}
	
//	@PostMapping("/checkUser")
//	public String checkUser(Model model, @RequestParam("username") String email, @RequestParam("password") String pass) {
//
//		model.addAttribute("msg", "Hi." + email + "!");
//		System.out.println("checkUser is Executed");
//
//		User user = userService.findByEmail(email);
//		String roleName = roleRepo.findRole(user.getId());
//
//
//		Boolean password = passwordEncoder.matches(pass, user.getPassword());
//
//
//		if (roleName.equals("ROLE_ADMIN") && password) {
//			System.out.println("I am Admin User");
//			return "redirect:/user";
//		} else {
//			if (roleName.equals("ROLE_USER") && password) {
//				System.out.println("I am General User");
//				return "redirect:/view";
//			} else
//				return "/login";
//		}
//	}
	
	@GetMapping("/generalUser")
	public String generalUser(Model model) {
		model.addAttribute("msg", "Hi.");
		System.out.println("generalUser is Executed");
		return "/generalUser";
	}
	
	@GetMapping("/user")
	public ModelAndView user(Model model) {
		System.out.println("index executed");
		List<User> lists = userRepo.userAndRole();
		String first_name = "";
		String last_name = "";
		String user = "";
		
		for(int i=0; i<lists.size(); i++) {
			first_name = lists.get(i).getFirst_name();
			last_name = lists.get(i).getLast_name();
			
			System.out.println(lists);
			// role validation
			if(lists.equals("ROLE_ADMIN")) {
				user = "admin";
			}else {
				user = "user";
			}
		}
		
		// first name + last name
		String name = first_name+" "+last_name;
		
		
		model.addAttribute("name",name);
		model.addAttribute("lists",lists);
		model.addAttribute("user",user);
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
	
	@PostMapping("/saveUser")
	public String saveUser(@Valid User user, Model model,@RequestParam("id") int id) {
		User userInDb = userService.findById(id);
		System.out.println("id of user:"+id);
		System.out.println("userInDb:"+userInDb.getId());
		System.out.println("user"+user.getId());
		//user.setId(userInDb.getId());
		user.setPassword(userInDb.getPassword());
		System.out.println("verify from DB"+userInDb.getPassword());
		System.out.println("user b4 save:"+user.getPassword());
		userService.saveUserServe(user);
		model.addAttribute("user",user);
		return "redirect:/user";
	}
	
	@GetMapping("/delete_popup/{id}")
	public String delete(@PathVariable(name="id") int id) {
		System.out.println("delete executes");
		userService.deleteById(id);
		return "redirect:/user";
	}
	
	@GetMapping("/new")
	public String newUser() {
		return "/newUser_popup";
	}
	
	@GetMapping("/event")
	public ModelAndView event(Model model) {
		System.out.println("event executed");
		return new ModelAndView("/event");
	}
	
	@GetMapping("/view")
	public ModelAndView view(Model model) {
		System.out.println("event executed");
		return new ModelAndView("/view");
	}
}
