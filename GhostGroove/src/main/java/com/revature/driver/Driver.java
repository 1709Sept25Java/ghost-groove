package com.revature.driver;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.dao.*;
import com.revature.domain.*;

public class Driver {

	//can't find bean.xml for driver.. Don't have time to figure out why!!
	
	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		/*SongDao songDao = (SongDao) ac.getBean("songDao");

		
		GenreDao genreDao = (GenreDao) ac.getBean("genreDao");
		Genre genre = (Genre) ac.getBean("genre");
		genre.setDescription("This is a music genre that combines elements of rhythm and blues, pop, soul, hip hop, electro, and synthpop");
		genre.setName("Contemporary R&B");
		genreDao.addGenre(genre);
		
		Song song = (Song) ac.getBean("song");
		song.setTitle("Indila - Dernière Danse");
		song.setYoutubeId("K5KAc5CoCuk");
		song.setUrl("https://youtu.be/K5KAc5CoCuk");
		song.setGenreId(genre);
		songDao.addSong(song);
		
		Song song2 = (Song) ac.getBean("song");
		song2.setTitle("Indila - S.O.S");
		song2.setYoutubeId("m65jhGwtWrg");
		song2.setUrl("https://youtu.be/m65jhGwtWrg");
		song2.setGenreId(genre);
		songDao.addSong(song2);
		
		//List <Song> songs = songDao.getAllSongs();
		
		
	PlaylistDao playlistDao = (PlaylistDao) ac.getBean("playlistDao");
		Playlist playlist = (Playlist) ac.getBean("playlist");
		playlist.setGenreId(genre);
		playlist.setName("French Contemporary");
		
		playlistDao.addPlaylist(playlist);
		
	UserDao userDao = (UserDao) ac.getBean("userDao");
		
		User user = (User) ac.getBean("user");
		user.setEmail("crazymonster@ghost.com");
		user.setFirstname("Crazy");
		user.setLastname("Monster");
		user.setIsManager(false);
		user.setUsername("monster");
		user.setPassword("abc123");
		userDao.addUser(user);		
		*/
		((AbstractApplicationContext) ac).close();
	}
	


}
