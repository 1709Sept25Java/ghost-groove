package com.revature.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 
@Table(name="PLAYLIST")
public class Playlist implements Serializable{
	
	public Playlist() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="playlistSequence")
	@SequenceGenerator(allocationSize=1,name="playlistSequence",sequenceName="SQ_PLAYLIST_PK")
	@Column(name="P_ID")
	private int id;
	
	@Column(name="P_NAME")
	@NotNull
	private String name;
	
	@Column(name="P_DESCRIPTION")
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="P_GENRE")
	private Genre genre;
	
	@OneToMany(mappedBy="playlist",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Comment> comments;
	
	@JsonIgnore
	@ManyToMany(mappedBy="playlists",fetch=FetchType.EAGER)
	private Set<User> owners;
	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="PLAYLIST_SONG",joinColumns= {@JoinColumn(name="P_ID")},inverseJoinColumns= {@JoinColumn(name="S_ID")})
	private Set<Song> songs;
	
	
	public Set<User> getOwners(){
		return this.owners;
	}
	
	public void setOwners(Set<User> owners){
		this.owners=owners;
	}
	
	
	public Set<Song> getPlaylists(){
		return this.songs;
	}
	
	public void setSongs(Set<Song> songs){
		this.songs=songs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Genre getGenreId() {
		return genre;
	}

	public void setGenreId(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Playlist [id=" + id + ", name=" + name + ", genre=" + genre + ", owners=" + owners + "]";
	}
}
