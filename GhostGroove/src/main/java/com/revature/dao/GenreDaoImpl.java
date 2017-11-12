package com.revature.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.revature.domain.Genre;


@Transactional
@Component(value = "genreDao")
@Scope(value = "prototype")
public class GenreDaoImpl implements GenreDao {

	@Autowired
	public SessionFactory sessionFactory;
	
	@Override
	public List<Genre> getAllGenres() {

		Session s = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<Genre> genres = s.createQuery("from Genres").list();
			for(Genre genre : genres){
				System.out.println(genre);
			}
		s.close();
		return genres;
	}

	@Override
	public Genre getGenreByName(String g_name) {

		Session s = sessionFactory.getCurrentSession();
		Genre genre = (Genre) s.get(Genre.class, g_name);
		s.close();

		return genre;
	}

	@Override
	public Genre addGenre(Genre genre) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.save(genre);
		tx.commit();
		s.close();
		return genre;
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
