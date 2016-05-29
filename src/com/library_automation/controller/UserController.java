package com.library_automation.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library_automation.classes.Book;
import com.library_automation.classes.User;
import com.library_automation.dao.UsersDAO;
import com.library_automation.service.DebtService;
import com.library_automation.service.ReservationDetailsService;
import com.library_automation.service.ReservationService;

@Controller
public class UserController {
	
	private ArrayList<User> users;
	
	@Autowired
	private UsersDAO usersDAO;
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private ReservationDetailsService service;
	
	@Autowired 
	private DebtService debtService;
	
	// This method renders My Profile page for users
	
	@RequestMapping("/profile")
	public String showProfilePage(HttpServletRequest request, ModelMap model){
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("username"));
		 users = new ArrayList<User>();
		User user = usersDAO.getAuthenticatedUser(String.valueOf(session.getAttribute("username")));
		session.setAttribute("authUserID", user.getId());
		System.out.println(user);
		users.add(user);
		model.addAttribute("user", users);
		model.addAttribute("message","");
		System.out.println("giris yapan kullanici id: "+user.getId());
		List<Book> myReservations = reservationService.getMyActiveReservations(user.getId());
		
		model.addAttribute("res", service.getMyReservations(user));
		
		model.addAttribute("books", myReservations);
		
		request.setAttribute("debt", debtService.getMyTotalDebt(user).getTotal_debt());
		
		return "myprofile";
	}
	
	// This method renders Admin page for admin
	@RequestMapping(value="/admin")
	public String showAdminPage(ModelMap model){
	//	List<User> users = usersDAO.getAllUsers();
		//model.addAttribute("users", users);
		
		return "admin";
	}
	
	@RequestMapping(value="/admin/users/")
	public String showManageUsersPage(ModelMap model){
		List<User> users = usersDAO.getAllUsers();
		model.addAttribute("users", users);
		return "manu";
	}
	
	@RequestMapping("/update")
	public String updateUser(User user, HttpServletRequest request, ModelMap map, HttpServletResponse response){
		HttpSession session = request.getSession();
		System.out.println("UPDATE");
		String id  = String.valueOf(session.getAttribute("authUserID"));
		user.setId(Integer.parseInt(id));
		System.out.println("Guncellencek olan kullanicinin id si:"+user.getId());
		//user.setId(Integer.parseInt());
		System.out.println(user);
		usersDAO.updateUser(user);
		users = new ArrayList<>();
		session.setAttribute("username", user.getUsername());
		User authUser = usersDAO.getAuthenticatedUser(String.valueOf(session.getAttribute("username")));
		users.add(authUser);
		map.addAttribute("user", users);
		map.addAttribute("message", "Your account has been updated");
		
		
		return "myprofile";
	}
	
	@RequestMapping("/admin/deleteuser")
	public String deleteUser(ModelMap model, HttpServletRequest request){
		
		String id = request.getParameter("id");
		usersDAO.deleteUser(id);
		List<User> users = usersDAO.getAllUsers();
		model.addAttribute("users", users);
		
		return "manu";
	}
	@RequestMapping("/admin/edituser")
	public String editUser(ModelMap map, HttpServletRequest request, User user){
		/*User user = new User();
		user.setId(Integer.parseInt(request.getParameter("id")));
		user.setName(request.getParameter("name"));
		user.setSurname(request.getParameter("surname"));
		user.setEmail(request.getParameter("email"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));*/
		
		// database 
		System.out.println(user);
		usersDAO.editUser(user);
		
		List<User> users = usersDAO.getAllUsers();
		map.addAttribute("users", users);
		return "manu";
	}

}
