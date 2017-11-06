package com.revature.dao;

import java.util.List;

import com.revature.domain.Comment;

public interface CommentDao {

	public List<Comment> getAllComments();

	public Comment getCommenteById(int id);

	public int addComment(Comment comment);

	public void updateComment(Comment updateCom);

	public void deleteComment(Comment deleteCom);

}
