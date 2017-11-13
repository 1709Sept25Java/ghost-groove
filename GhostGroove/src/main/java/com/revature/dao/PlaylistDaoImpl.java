package com.revature.dao;

import java.util.List;
import java.util.Set;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.revature.domain.Genre;
import com.revature.domain.Playlist;
import com.revature.domain.User;

@Transactional
@Component(value = "playlistDao")
@Scope(value = "prototype")
public class PlaylistDaoImpl implements PlaylistDao {

	@Autowired
	public SessionFactory sessionFactory;

	@Override
	public List<Playlist> getAllPlaylists() {

		Session s = sessionFactory.getCurrentSession();

		@SuppressWarnings("unchecked")
		List<Playlist> playlists = s.createQuery("from Playlists").list();
		for (Playlist playlist : playlists) {
			System.out.println(playlist);
		}
		s.close();
		return playlists;
	}

	@Override
	public Playlist getPlaylistByName(String name) {

		Session s = sessionFactory.getCurrentSession();
		Playlist playlist = (Playlist) s.get(Playlist.class, name);
		s.close();

		return playlist;
	}

	@Override
	public void addPlaylist(Playlist playlist) {

		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.save(playlist);
		tx.commit();
		s.close();

	}

	@Override
	public void updatePlaylist(Playlist playlist) {

		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.merge(playlist);
		tx.commit();
		s.close();
	}

	@Override
	public void deletePlaylist(Playlist playlist) {

		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.delete(playlist);
		tx.commit();
		s.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void sharePlaylist(Playlist playlist, User user) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		List<Playlist> playlists = (List<Playlist>) user.getPlaylists();
		playlists.add(playlist);
		s.save(playlists);
		tx.commit();
		s.close();

	}

	@Override
	public Playlist getPlaylistByGenre(Genre genre) {

		Session s = sessionFactory.getCurrentSession();
		Playlist playlist = (Playlist) s.get(Playlist.class, genre);
		s.close();

		return playlist;

	}

	@Override
	public List<Playlist> getPlaylistsByUserId(User user) {
		Session s = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Playlist> playlists = (List<Playlist>) s.get(Playlist.class, user.getId());
		s.close();

		return playlists;

	}

}
