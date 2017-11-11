package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.SessionFactoryUtils;

import com.revature.domain.Genre;
import com.revature.domain.Song;

public class SongDaoImpl implements SongDao {

	private SessionFactory session;
	
	@Override
	public List<Song> getAllSongs() {
		Session sess= session.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List <Song> song= sess.createQuery("from Songs").list();
		sess.close();
		return song;
	}

	@Override
	public Song getSongById(int songId) {
		Session sess= session.getCurrentSession();
		Song song= (Song) sess.get(Song.class, songId);
		return song;
	}

	@Override
	public Song getSongByGenreId(int genreId) {
		Session sess= session.getCurrentSession();
		Song song= (Song) sess.get(Genre.class, genreId);
		return song;
	}

	@Override
	public Song getSongByYoutubeId(int youtubeId) {
		Session sess= session.getCurrentSession();
		Song song= (Song) sess.get(Song.class, youtubeId);
		return song;
	}

	@Override
	public int addSong(Song song) {
		Session sess= session.openSession();
		Transaction tx=sess.beginTransaction();
		String hqlInsert = "insert into Playlist Values("+song.getId()+","+
			song.getTitle()+","
			+song.getUrl()+","+
			song.getYoutubeId()+")";
		
		int createdSong = sess.createQuery(hqlInsert).executeUpdate();
		tx.commit();
		session.close();
		return createdSong;
	}

	@Override
	public void updateSong(Song updateSong) {
		Session sess= session.getCurrentSession();
		Transaction tx=sess.beginTransaction();
		tx.commit();
	}

	@Override
	public void deleteSong(Song deleteSong) {
		Session sess= session.getCurrentSession();
	}

}
