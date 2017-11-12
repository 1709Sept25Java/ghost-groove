package com.revature.dao;

import java.util.List;

import com.revature.domain.Genre;
import com.revature.domain.Song;

public interface SongDao {

	public List<Song> getAllSongs();

	public Song getSongById(int id);

	public Song getSongByGenreName(Genre genre);

	public Song getSongByYoutubeId(int youtubeId);

	public Song addSong(Song song);

	public void updateSong(Song song);

	public void deleteSong(Song song);

}
