package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class TestServlet {

	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String getQue() {
		return "forward:/static/views/test.jsp";
	}
	@RequestMapping("/test")
	public ModelAndView changeQ() {
		String test="test msg"; //last arg
		//"jsp name" "name in jsp... ${test}"
		return new ModelAndView("test","test",test);
	}
}