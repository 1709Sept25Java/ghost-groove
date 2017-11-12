package com.revature.dao;

import java.util.List;

import com.revature.domain.*;

public interface GenreDao {

	public List<Genre> getAllGenres();

	public Genre getGenreByName(String g_name);

	public Genre addGenre(Genre genre);

	public void updateGenre(Genre genre);

	public void deleteGenre(Genre genre);

}
