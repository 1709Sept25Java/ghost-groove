package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.dao.*;
import com.revature.domain.Playlist;
import com.revature.domain.Song;
import com.revature.domain.User;

@Controller
@Scope("session")
@RequestMapping("/playlist")
public class PlaylistController {

	@Autowired
	PlaylistDao pDao;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/allPlaylists", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Playlist> getPlaylists() {
		
		/*HttpServletRequest request
		String username = request.getUserPrincipal().getName();
		List<Playlist> userPlaylists = new ArrayList<Playlist>();
		UserDaoImpl userDao = new UserDaoImpl();
		User user = userDao.getUserByUsername(username);*/
		
		//if (user != null) {
		//List<Playlist> listPlaylists = new ArrayList<Playlist>();
    	Playlist listPlaylists = pDao.getPlaylistByName("French Contemporary");

			//return userPlaylists;
		//}
		return (List<Playlist>) listPlaylists;
	}

	@Autowired
	SongDao songDao;
	
	@RequestMapping(value = "/addSongPlaylists", method = RequestMethod.POST, headers = "Accept=application/json")
	public Song addSong (@RequestBody Song song) {

	songDao.addSong(song);
	return song;

	}
}
