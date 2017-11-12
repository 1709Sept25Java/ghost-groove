package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.dao.PlaylistDao;
import com.revature.domain.Playlist;

@Controller
@Scope(value="session")
@RequestMapping("/playlist")
public class PlaylistController {

	@Autowired
	PlaylistDao pDao;
	
	@RequestMapping(value="/byuser",method=RequestMethod.GET)
	@ResponseBody
	public List<Playlist> playlistByUser(){
		List<Playlist> playlists = null;
		return playlists;
	}
	
}
