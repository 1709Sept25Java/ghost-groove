package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.revature.domain.Playlist;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.revature.dao.PlaylistDao;
import com.revature.dao.UserDao;
import com.revature.domain.User;

@Controller
@Scope(value = "session")
@RequestMapping("/playlist")

public class PlaylistController {

	@Autowired
	PlaylistDao pDao;

	@Autowired
	UserDao uDao;
	

	@RequestMapping (value ="/share", method = RequestMethod.POST, headers ="Content-Type: application/json")
	public String shareList(HttpSession session, @RequestBody Playlist playlist, RedirectAttributes redirect) {

		String username = (String) session.getAttribute("username");
		String name = (String) session.getAttribute("playlistName");
		System.out.println(username + " "+name);
		User user = uDao.getUserByUsername(username);
		System.out.println("Ok1");
		playlist = pDao.getPlaylistByName(name);
		System.out.println("Ok2");
		Set<User> owner = new HashSet<>();
		owner.add(user);
		System.out.println("Ok3");
		playlist.setOwners(owner);
		System.out.println(playlist);
		if (pDao.addPlaylist(playlist) != 0) {
			 redirect.addAttribute("Your playlist was shared with", username);
			return "redirect:/static/views/editPlaylist.html";
		}
		return "redirect:/static/views/editPlaylist.html";
	}
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String viewPLaylist(HttpSession session) {
		Integer uid  = (Integer) session.getAttribute("uid");
		if(uid != null) {
			return "forward:/static/views/playlist.html";
		} else {
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String editPLaylist(HttpSession session) {
		Integer uid  = (Integer) session.getAttribute("uid");
		if(uid != null) {
			return "forward:/static/views/editPlaylist.html";
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/byuser", method = RequestMethod.GET)
	@ResponseBody
	public List<Playlist> playlistByUser(HttpSession session) {
		Integer id = (Integer) session.getAttribute("uid");
		List<Playlist> playlists = pDao.playlistsByUser(id);
		return playlists;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String newPlaylist(HttpSession session, @RequestBody Playlist playlist) {
		Integer uid = (Integer) session.getAttribute("uid");
		User user = uDao.getUserById(uid);
		Set<User> owner = new HashSet<>();
		owner.add(user);
		playlist.setOwners(owner);
		System.out.println(playlist);
		if (pDao.addPlaylist(playlist) != 0) {
			return "redirect:/user/home";
		}
		return "redirect:/user/home";
	}

}
