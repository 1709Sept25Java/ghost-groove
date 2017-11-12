package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.dao.GenreDao;
import com.revature.domain.Genre;

@Controller
@Scope("session")
@RequestMapping("/genre")
public class GenreController {
	
	@Autowired
	GenreDao gDao;

	@RequestMapping(value="/all",method=RequestMethod.GET)
	@ResponseBody
	public List<Genre> allGenres() {
		List<Genre> genres = gDao.getAllGenres();
		return genres;
	}
	
}
