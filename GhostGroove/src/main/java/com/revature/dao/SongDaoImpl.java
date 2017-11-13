package com.revature.dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.revature.domain.Genre;
import com.revature.domain.Song;

@Transactional
@Component(value = "songDao")
@Scope(value = "prototype")
public class SongDaoImpl implements SongDao {

	@Autowired
	public SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Song> getAllSongs() {
		
		Session s = sessionFactory.getCurrentSession();
		List<Song> songs = s.createQuery("from Song").list();
			for(Song song : songs){
				System.out.println(song);
			}
		s.close();
		return songs;
	}

	@Override
	public Song getSongById(int id) {

		Session s = sessionFactory.getCurrentSession();
		Song song = (Song) s.get(Song.class, id);
		s.close();

		return song;
	}

	@Override
	public Song getSongByGenreName(Genre genre) {

		Session s = sessionFactory.getCurrentSession();
		Song song = (Song) s.get(Song.class, genre.getName());
		s.close();

		return song;
	}

	@Override
	public Song getSongByYoutubeId(int youtubeId) {

		Session s = sessionFactory.getCurrentSession();
		Song song = (Song) s.get(Song.class, youtubeId);
		s.close();

		return song;
	}

	@Override
	public Song addSong(Song song) {

		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.save(song);
		tx.commit();
		s.close();
		return song;

	}

	@Override
	public void updateSong(Song song) {

		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.merge(song);
		tx.commit();
		s.close();
	}

	@Override
	public void deleteSong(Song song) {

		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.delete(song);
		tx.commit();
		s.close();
	}

}
