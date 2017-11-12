package com.revature.dao;

import java.util.List;

import com.revature.domain.Comment;
import com.revature.domain.Playlist;

public interface CommentDao {

	public List<Comment> getAllComments();

	public Comment getCommenteByPlaylist(Playlist playlist);

	public Comment addComment(Comment comment);

	public void updateComment(Comment comment);

	public void deleteComment(Comment comment);

}
