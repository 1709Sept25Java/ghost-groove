package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class LandingServlet {

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String getMain() {
		return "forward:/static/index.html";
	}
	@RequestMapping(value="/queue",method=RequestMethod.GET)
	public String getQue() {
		return "forward:/static/views/GhostGroove.html";
	}
}
