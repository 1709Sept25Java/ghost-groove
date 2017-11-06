package com.revature.dao;

import java.util.List;

import com.revature.domain.*;

public interface GenreDao {

	public List<Genre> getAllGenres();

	public Genre getGenreById(int id);

	public int addGenre(Genre genre);

	public void updateGenre(Genre updateGen);

	public void deleteGenre(Genre deleteGen);

}
