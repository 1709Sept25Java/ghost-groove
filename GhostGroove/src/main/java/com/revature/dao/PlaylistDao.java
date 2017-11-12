package com.revature.dao;

import java.util.List;

import com.revature.domain.Playlist;

public interface PlaylistDao {

	public List<Playlist> getAllPlaylists();

	public Playlist getPlaylistById(int playlistId);

	public int addPlaylist(Playlist playlist);

	public void updatePlaylist(Playlist updatePL);

	public void deletePlaylist(Playlist deletePL);

	public void sharePlaylist(Playlist sharePL);
	
	public List<Playlist> playlistsByUser(int uId);

}
