package com.revature.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.dao.PlaylistDao;
import com.revature.dao.UserDao;
import com.revature.domain.Playlist;
import com.revature.domain.User;

@Controller
@Scope(value="session")
@RequestMapping("/playlist")
public class PlaylistController {

	@Autowired
	PlaylistDao pDao;
	@Autowired
	UserDao uDao;
	
	@RequestMapping(value="/byuser",method=RequestMethod.GET)
	@ResponseBody
	public List<Playlist> playlistByUser(HttpSession session){
		Integer id = (Integer)session.getAttribute("uid");
		List<Playlist> playlists = pDao.playlistsByUser(id);
		return playlists;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String newPlaylist(HttpSession session,@RequestBody Playlist playlist) {
		Integer uid=(Integer) session.getAttribute("uid");
		User user = uDao.getUserById(uid);
		Set<User> owner = new HashSet<>();
		owner.add(user);
		playlist.setOwners(owner);
		System.out.println(playlist);
		if(pDao.addPlaylist(playlist) != 0) {
			return "redirect:/user/home";
		}
		return "redirect:/user/home";
	}
	
}
