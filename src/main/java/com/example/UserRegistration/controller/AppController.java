package com.example.UserRegistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.example.UserRegistration.entity.User;
import com.example.UserRegistration.entity.UserDetails;
import com.example.UserRegistration.repository.UserRepository;
import com.example.UserRegistration.service.UserDetailsService;

@Controller
public class AppController {

	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("")
	public String viewHomePage() {
	return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
	model.addAttribute("user", new User());
	return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user) { 
	
	userRepo.save(user);
	return "register_success";
	}
	
	 @Autowired
	    private UserDetailsService service;

	    @GetMapping("/")
	    public String viewHomePage(Model model) {
	        List<User> listuser = service.listAll();
	        model.addAttribute("listuser", listuser);
	        System.out.print("Get / ");	
	        return "index";
	    }

	    @GetMapping("/saveStudent")
	    public String add(Model model) {
	        model.addAttribute("Student", new User());
	        return "saveStudent";
	    }

	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String saveUser(@ModelAttribute("Student") User user) {
	        service.save(user);
	        return "redirect:/index";
	    }
	    
	    @RequestMapping("/edit/{id}")
	    public ModelAndView showEditStudentPage(@PathVariable(name = "id") long id) {
	        ModelAndView mav = new ModelAndView("saveStudent");
	        User user = service.get(id);
	        mav.addObject("User", user);
	        return mav;
	        
	    }
	    @RequestMapping("/delete/{id}")
	    public String deletestudent(@PathVariable(name = "id") long id) {
	        service.delete(id);
	        return "redirect:/";
	    }
}



