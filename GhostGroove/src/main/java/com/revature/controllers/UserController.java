package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
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
	public String validateLogin(@Valid Login login,Model m) {
		
		User user = uDao.login(login.getUsername(), login.getPassword());
		if(user != null) {
			
		}
		
		return "redirect:/";
	}
	
}
