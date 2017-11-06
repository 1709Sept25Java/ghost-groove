package com.revature.domain;

<<<<<<< HEAD
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
=======
import java.util.List;
import java.util.Set;

import javax.persistence.*;
>>>>>>> 27a9c8d76bb278c071baa35349906e6f91467e69
import javax.validation.constraints.NotNull;

@Entity 
@Table(name="PLAYLIST")
public class Playlist {
	
	public Playlist() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="PLAYLIST_SEQ")
	@SequenceGenerator(allocationSize=1,name="PlaylistSequence",sequenceName="SQ_PLAYLIST_PK")
	@Column(name="P_ID")
<<<<<<< HEAD
	
	//@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	//@JoinColumn(name="U_ID")
	
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="S_ID")
	
	//@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	//@JoinColumn(name="G_ID")
	private int id;
	
	@Column(name="NAME")
	@NotNull
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="GENREID")
	private int genreId;
=======
	private int id;
	
	@Column(name="P_NAME")
	@NotNull
	private String name;
	
	@Column(name="P_DESCRIPTION")
	private String description;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="G_ID")
	private int genreId;
	
	@OneToMany(mappedBy="playlistId",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Comment> comments;
	
	private Set<User> owners;
	
	private Set<Song> songs;
	
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="playlists")
	public Set<User> getOwners(){
		return this.owners;
	}
	
	public void setOwners(Set<User> owners){
		this.owners=owners;
	}
	
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(name="PLAYLIST_SONG",joinColumns= {@JoinColumn(name="P_ID")},inverseJoinColumns= {@JoinColumn(name="S_ID")})
	public Set<Song> getPlaylists(){
		return this.songs;
	}
	
	public void setSongs(Set<Song> songs){
		this.songs=songs;
	}
>>>>>>> 27a9c8d76bb278c071baa35349906e6f91467e69

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

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
}
