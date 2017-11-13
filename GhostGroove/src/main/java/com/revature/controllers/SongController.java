package com.revature.controllers;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.dao.SongDao;
import com.revature.domain.Playlist;
import com.revature.domain.Song;
import com.revature.domain.User;


@Controller
@Scope("session")
@RequestMapping("/song")
public class SongController {

	@Autowired
	SongDao sDao;

	@RequestMapping(value="/all",method=RequestMethod.GET)
	@ResponseBody
	public List<Song> allSongs() {
		List<Song> songs = sDao.getAllSongs();
		return songs;
	}
	
	@RequestMapping(value="/all",method=RequestMethod.POST)
	public String addSong(HttpSession session, @RequestBody Song song){
		
		String youtubeId = (String) session.getAttribute("videoId");
		String title = (String) session.getAttribute("videoTitle");
		String url = (String) session.getAttribute("url");
		
		
		System.out.println(youtubeId + " "+title);
		song.setYoutubeId(youtubeId);
		song.setTitle(title);
		song.setUrl(url);
		sDao.addSong(song);
		
		return "redirect:/static/views/editPlaylist.html";
		
		
	}
}
