package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.User;
import com.demo.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;

	@GetMapping("/")
	public String getLoginPage(Model model) {
		User user = new User();
		model.addAttribute("userobj", user);
		model.addAttribute("message", "Please login");
		return "logout";
	}

	@PostMapping("/loginprocess")
	public String authenticateUser(@ModelAttribute User theUser) {
		System.out.println(theUser);
		boolean isAuthenticated = loginService.isAutheticatedUser(theUser);
		if (isAuthenticated) {
			return "dashboard";
		}
		return "redirect:/";

	}
	

	@GetMapping("/users")
	public ModelAndView getAllUsers() {
		ModelAndView mv = new ModelAndView();
		List<User> list = loginService.getAllUsers();
//		for (User user : list) {
//			System.out.println(user);
//		}
		mv.addObject("users", list);
		mv.setViewName("users");
		return mv;
	}

	@RequestMapping(value = { "/addUser", "/updateUser/{id}" })
	public String addUser(@PathVariable(required = false) Integer id, Model model) {
		User user;
		if (id != null) {
			user = loginService.getUserById(id);
		} else {
			user = new User();
		}
		model.addAttribute("userobj", user);
		return "add_user";
	}

	@RequestMapping(value = {"/saveuser","/updateUser/saveuser"})
	public String saveUser(@ModelAttribute User user) {
		System.out.println(user);
		loginService.saveUser(user);
		return "redirect:/users";

	}

	@GetMapping("/deleteuser/{id}")
	public String deleteUserById(@PathVariable Integer id) {
		System.out.println("user....." + id);
		loginService.deleteUserById(id);
		return "redirect:/users";

	}
	
	@RequestMapping(value = { "/registeruser" })
	public String registerUser(Model model) {
		User user = new User();
		model.addAttribute("userobj", user);
		return "register";
		
	}
	
	@RequestMapping(value = {"/addregistereduser"})
	public String addRegisteredUser(@ModelAttribute User user) {
		System.out.println(user);
		user.setCourse("Java");
		user.setGender("Male");
		user.setState("MH");
		loginService.addRegisteredUser(user);
		return "redirect:/";

	}

	/*
	 * @GetMapping("/updateuser/{id}") public ModelAndView
	 * updateUserById(@PathVariable Integer id) { System.out.println("user....." +
	 * id); User user = loginService.getUserById(id); return new
	 * ModelAndView("add_user", "userobj", user);
	 * 
	 * }
	 */
}
