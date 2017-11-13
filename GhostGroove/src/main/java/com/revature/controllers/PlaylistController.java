package com.revature.controllers;

import java.util.ArrayList;
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

import com.revature.dao.*;
import com.revature.domain.Playlist;


@Controller
@Scope("session")
@RequestMapping("/playlist")

public class PlaylistController {

	@Autowired
	PlaylistDao pDao;
	
	@Autowired
	UserDao userdao;

	ModelAndView modelAndView = new ModelAndView();
	@Autowired
	SessionFactory sessionFactory;

	/*@SuppressWarnings("unchecked")
	@RequestMapping(value = "/allPlaylists", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Playlist> getPlaylists() {

		
		  HttpServletRequest request String username =
		  request.getUserPrincipal().getName(); List<Playlist> userPlaylists = new
		  ArrayList<Playlist>(); UserDaoImpl userDao = new UserDaoImpl(); User user =
		  userDao.getUserByUsername(username);
		 

		 if (user != null) {
		 List<Playlist> listPlaylists = new ArrayList<Playlist>();
		Playlist listPlaylists = pDao.getPlaylistByName("French Contemporary");

		return userPlaylists;
		 }
		System.out.println(listPlaylists.toString());
		return (List<Playlist>) listPlaylists;
	}

	/
	 * @Autowired SongDao songDao;
	 * 
	 * @RequestMapping(value = "/addSongPlaylists", method = RequestMethod.POST,
	 * headers = "Accept=application/json") public Song addSong (@RequestBody Song
	 * song) {
	 * 
	 * songDao.addSong(song); return song;
	 * 
	 * }
	 */
	
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
}