package com.revature.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.revature.domain.Song;

@Controller
@RequestMapping("/")
public class PlaylistServlet {

	@RequestMapping(value="/queue",method=RequestMethod.GET)
	public String getQue() {
		return "forward:/static/views/GhostGroove.html";
	}
	public @ResponseBody Song getSongsInJSON(@RequestParam String videoid, String title) {

		Song song = new Song();
		song.setYoutubeId(videoid);
		song.setTitle(title);
		System.out.println("Info: "+videoid+" "+title+" "+song);
		return song;

	}
	public void handlePost(@RequestParam String selectedId, String selectedTitle, Model m) {
        if(!selectedId.equals(null)&!selectedTitle.equals(null)){
            //handle 
            m.addAttribute("youtubeId", selectedId);
            m.addAttribute("title", selectedTitle);
         }
	}
	public void validSong(@Valid Song song, Model m, HttpSession sess) {
		sess.setAttribute("youtubeId", song.getYoutubeId());
		sess.setAttribute("title", song.getTitle());
	} 
}
