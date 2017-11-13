package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping(value="/new",method=RequestMethod.GET)
	public String addGenreForm(HttpSession session,Model m) {
		Boolean mgr = (Boolean)session.getAttribute("admin");
		if(mgr) {
			m.addAttribute("genre", new Genre());
			return "addGenre"; 
		} else {
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/new",method=RequestMethod.POST)
	public String addGenre(@Valid Genre genre,Model m) {
		if(gDao.addGenre(genre)!= 0) {
			return "redirect:/user/mgrhome";
		} else {
			return "redirect:/genre/new";
		}
	}
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String viewGenre(HttpSession session) {
		Integer uid  = (Integer) session.getAttribute("uid");
		if(uid != null) {
			return "forward:/static/views/genre.html";
		} else {
			return "redirect:/";
		}
	}
	
}
