package com.revature.dao;

import java.util.List;

import com.revature.domain.Genre;
import com.revature.domain.Playlist;
import com.revature.domain.User;

public interface PlaylistDao {

	public List<Playlist> getAllPlaylists();
	
	public List<Playlist> getPlaylistsByUserId(User user);

	public Playlist getPlaylistByName(String name);

	public Playlist getPlaylistByGenre(Genre genre);

	public void addPlaylist(Playlist playlist);

	public void updatePlaylist(Playlist playlist);

	public void deletePlaylist(Playlist playlist);

	public void sharePlaylist(Playlist playlist, User user);

}
