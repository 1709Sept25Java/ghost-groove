package com.revature.dao;

import java.util.List;

import com.revature.domain.Song;

public interface SongDao {

	public List<Song> getAllSongs();

	public Song getSongById(int songId);

	public Song getSongByGenreId(int genreId);

	public Song getSongByYoutubeId(int youtubeId);

	public int addSong(Song song);

	public void updateSong(Song updateSong);

	public void deleteSong(Song deleteSong);

}
