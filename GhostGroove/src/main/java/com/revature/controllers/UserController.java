package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.dao.UserDao;
import com.revature.domain.User;
import com.revature.model.Login;

@Controller
@Scope("session")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserDao uDao;

	@RequestMapping(value="/create",method=RequestMethod.GET)
	public String createUserForm(Model m) {
		m.addAttribute("user", new User());
		return "newUser";
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String createUser(@Valid User user,BindingResult br,Model m) {
		//ApplicationContext ac = new ClassPathXmlApplicationContext("dbBeans.xml");
		user.setIsManager(false);
		System.out.println(user);
		if(uDao.addUser(user) != 0) {
			return "redirect:/";
		} else {
			return "redirect:/user/create";
		}
		
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginform(Model m) {
		m.addAttribute("login", new Login());
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String validateLogin(@Valid Login login,Model m,HttpSession session) {
		
		User user = uDao.login(login.getUsername(), login.getPassword());
		if(user != null) {
			session.setAttribute("uid", user.getId());
			session.setAttribute("usename", user.getUsername());
			session.setAttribute("admin", user.getIsManager());
			if(user.getIsManager()) {
				return "mgrHome";
			}
		} else {
			return "redirect:/login";
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="/mgrhome",method=RequestMethod.GET)
	public String mgrProfile(HttpSession session) {
		Boolean mgr = (Boolean)session.getAttribute("admin");
		if(mgr) {
			return "mgrHome";
		} else {
			return "redirect:/";
		}
	}
	
}
