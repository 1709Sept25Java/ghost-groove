package com.revature.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.revature.domain.Comment;
import com.revature.domain.Playlist;


@Transactional
@Component(value = "commentDao")
@Scope(value = "prototype")
public class CommentDaoImpl implements CommentDao {
	
	@Autowired
	public SessionFactory sessionFactory;

	@Override
	public List<Comment> getAllComments() {

		Session s = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Comment> comments = s.createQuery("from Comments").list();
			for( Comment comment : comments){
				System.out.println(comment);
			}
		s.close();
		return comments;
	}

	@Override
	public Comment getCommenteByPlaylist(Playlist playlist) {

		Session s = sessionFactory.getCurrentSession();
		Comment comment = (Comment) s.get(Comment.class, playlist);
		s.close();

		return comment;
	}

	@Override
	public Comment addComment(Comment comment) {

		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.save(comment);
		tx.commit();
		s.close();
		return comment;
	}

	@Override
	public void updateComment(Comment comment) {

		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.merge(comment);
		tx.commit();
		s.close();

	}

	@Override
	public void deleteComment(Comment comment) {

		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.delete(comment);
		tx.commit();
		s.close();
		
	}

}
