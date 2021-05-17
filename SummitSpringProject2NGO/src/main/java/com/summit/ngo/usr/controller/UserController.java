package com.summit.ngo.usr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.summit.ngo.usr.model.User;
import com.summit.ngo.usr.repository.RoleRepository;
import com.summit.ngo.usr.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepo;
	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	 
	@GetMapping("/")
	public String root() {
	     
		System.out.println("Here it is index controller");
		
		//@RequestParam("principal.username")String email
//		 User user = userRepo.findByEmail(email);
//	        String roleName = roleRepo.findRole(user.getId());
//	        
//	        Boolean password = passwordEncoder.matches(email, user.getPassword());
//	        
//	        if(roleName.equals("ROLE_ADMIN") && password) {System.out.println("I am Admin User");return "redirect:/hello";}
//	        else {System.out.println("I am General User"); return "index";}
		 
		 return "index";
	    }

//	    @GetMapping("/login")
//	    public String login(Model model) {
//	        return "login";
//	    }
	   
	 
	//@PostMapping("/login")
	  
	 //@RequestMapping(value = "/login", method = RequestMethod.GET)
	 @GetMapping("/login") 
	 public String login(Model model,String error, String logout) {
	        //public String login(Model model, String error, String logout)
	    	
	    	
	    	if (error != null)
	            model.addAttribute("errorMsg", "Your username and password are invalid.");

	        if (logout != null)
	            model.addAttribute("msg", "You have been logged out successfully.");
	     System.out.println("LogIn page Executed");   
	     return "login";
	       
	        
	        //model.addAttribute("msg", "Value of email is "+email);
	        
	     
	     
	     
	    }
	    

	    
		@PostMapping("/hello")
		public String hello(Model model, @RequestParam("username") String email, @RequestParam("password") String pass) {

			model.addAttribute("msg", "Hi." + email + "!");
			// model.addAttribute("lists",lists);
			System.out.println("hello Controller is Executed");
			System.out.println("UserName(webpage): " + email);

			User user = userRepo.findByEmail(email);
			String roleName = roleRepo.findRole(user.getId());
			
			System.out.println("this is from database role name:"+roleName);
			
			Boolean password = passwordEncoder.matches(pass, user.getPassword());

			System.out.println("Value of Boolean Password: "+password);
			
			if (roleName.equals("ROLE_ADMIN") && password) {
				System.out.println("I am Admin User");
				return "hello";
			} else {
				if (roleName.equals("ROLE_USER") && password) {
					System.out.println("I am General User");
					return "redirect:/hello1";
				} else
					return "login";

			}

			// return "hello";
		}
	    
	    @GetMapping("/hello1")
	    public String hello1(Model model) {
	        //@RequestParam("username")String id
	    	model.addAttribute("msg","Hi.");
	    	//model.addAttribute("lists",lists);
	    	System.out.println("Hello is Executed");
	    	//System.out.println("ID:"+id);
	    	return "hello1";
	    }
	    

}
