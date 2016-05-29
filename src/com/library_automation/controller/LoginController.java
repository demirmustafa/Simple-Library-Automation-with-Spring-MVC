package com.library_automation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.library_automation.classes.User;
import com.library_automation.dao.UsersDAO;
import com.library_automation.service.DebtService;

@Controller
public class LoginController {
	
	@Autowired
	private UsersDAO usersDAO;
	
	@Autowired
	private DebtService debtService;
	
	
	@RequestMapping("/")
	public String showWelcomePage(){
		return "welcome";
	}
	
	@RequestMapping("/loginpage")
	public String showLoginPage(ModelMap map){
		map.addAttribute("message", "");
		map.addAttribute("message2", "");
		return "login";
	}
	
	@RequestMapping(value="/registerpage", method=RequestMethod.POST)
	public String showRegisterPage(ModelMap map){
		map.addAttribute("message", "");
		return "register";
		
	}
	
	@RequestMapping("/loggedout")
	public String showLogoutPage(){
		return "logoutsuccess";
	}
	
	@RequestMapping("/loginfailure")
	public String loginFailure(){
		return "login";
	}
	
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String createAccount(User user, ModelMap map){
		user.setEnabled(true);
		user.setAuthority("ROLE_USER");
		System.out.println(user);
		if(usersDAO.isAccountExist(user)){
			map.addAttribute("message", "An account already exist with this username or email address");
			return "register";
		}
		else{
			usersDAO.createUser(user);
			
			debtService.createDebt(usersDAO.getAuthenticatedUser(user.getUsername()));
			map.addAttribute("message", "Your account created successfully. Please log in!"); 
			map.addAttribute("message2", "");
			return "login";
		}
		
		
	}
	
}
