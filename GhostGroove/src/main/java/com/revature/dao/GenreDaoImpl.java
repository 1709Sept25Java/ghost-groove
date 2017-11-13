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
	public Genre getGenreByName(String g_name) {

		Session s = sessionFactory.getCurrentSession();
		Genre genre = (Genre) s.get(Genre.class, g_name);
		s.close();

		return genre;
	}

		
	public int addGenre(Genre genre) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.saveOrUpdate(genre);
		tx.commit();
		return genre.getId();
	}

	@Override
	public void updateGenre(Genre genre) {
		
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.merge(genre);
		tx.commit();
		s.close();

	}

	@Override
	public void deleteGenre(Genre genre) {

		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.delete(genre);
		tx.commit();
		s.close();
	}

}
