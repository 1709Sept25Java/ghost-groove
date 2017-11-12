package com.revature.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.revature.domain.Playlist;

@Repository(value="playlistDao")
@Scope(value="session")
public class PlaylistDaoImpl implements PlaylistDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Playlist> getAllPlaylists() {

		return null;
	}

	@Override
	public Playlist getPlaylistById(int playlistId) {

		return null;
	}

	@Override
	public int addPlaylist(Playlist playlist) {

		return 0;
	}

	@Override
	public void updatePlaylist(Playlist updatePL) {

	}

	@Override
	public void deletePlaylist(Playlist deletePL) {

	}

	@Override
	public void sharePlaylist(Playlist sharePL) {

	}

	@Override
	public List<Playlist> playlistsByUser(int uId) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Query q = s.createQuery("select p from Playlist p join p.owners o where o.id=:idVar");
		q.setInteger("idVar", uId);
		List<Playlist> playlists = q.list();
		tx.commit();
		return playlists;
	}

}
