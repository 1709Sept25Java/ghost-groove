package com.revature.controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.revature.domain.Playlist;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.dao.PlaylistDao;
import com.revature.dao.UserDao;
import com.revature.domain.User;

@Controller
@Scope(value="session")
@RequestMapping("/playlist")

public class PlaylistController {

	@Autowired
	PlaylistDao pDao;
	
	@Autowired
	UserDao userdao;

	ModelAndView modelAndView = new ModelAndView();
	@Autowired
	SessionFactory sessionFactory;
	
	@RequestMapping(value = "/sharePlaylist", method = RequestMethod.POST)
	@Transactional
	public String shareList(@RequestParam("username") String username, @RequestParam("playlistName") String name,
			RedirectAttributes redirect) {
		
			if (username != null && name != null) {
				System.out.println(username + "" + name);
				Session s = sessionFactory.getCurrentSession();
				 Transaction tx = s.beginTransaction();
				pDao.sharePlaylist(pDao.getPlaylistByName(name), userdao.getUserByUsername(username));
				System.out.println("shared");
				tx.commit();
				s.close();
				redirect.addFlashAttribute("Your playlist was shared with", username);

				System.out.println("Ok");
				return "redirect:/static/editPlaylist.html";
			} else {

				redirect.addFlashAttribute("We were unable to share your playlist");

				System.out.println("error");
				return "redirect:/static/editPlaylist.html";
			}
			
			


	}


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
