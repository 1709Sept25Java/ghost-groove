package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.revature.domain.Genre;

@Repository(value="genreDao")
@Scope(value="session")
public class GenreDaoImpl implements GenreDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Genre> getAllGenres() {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		List<Genre> genres=s.createQuery("from Genre").list();
		tx.commit();
		return genres;
	}

	@Override
	public Genre getGenreById(int id) {

		return null;
	}

	@Override
	public int addGenre(Genre genre) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.saveOrUpdate(genre);
		tx.commit();
		return genre.getId();
	}

	@Override
	public void updateGenre(Genre updateGen) {

	}

	@Override
	public void deleteGenre(Genre deleteGen) {

	}

}
