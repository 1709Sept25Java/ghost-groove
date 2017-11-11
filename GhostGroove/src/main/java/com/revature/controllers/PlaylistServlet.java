package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class PlaylistServlet {

	@RequestMapping(value="/queue",method=RequestMethod.GET)
	public String getQue() {
		return "forward:/static/views/GhostGroove.html";
	}
	@RequestMapping("/queue")
	public ModelAndView changeQ() {
		String test="test msg"; //last arg
		//"jsp name" "name in jsp... ${test}"
		return new ModelAndView("testjsp","test",test);
	}
}
