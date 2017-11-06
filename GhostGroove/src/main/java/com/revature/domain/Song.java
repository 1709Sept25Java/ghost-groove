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
import java.util.Set;

import javax.persistence.*;
>>>>>>> 27a9c8d76bb278c071baa35349906e6f91467e69
import javax.validation.constraints.NotNull;

@Entity 
@Table(name="SONG")
public class Song {
	
	public Song() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SONG_SEQ")
	@SequenceGenerator(allocationSize=1,name="SongSequence",sequenceName="SQ_SONG_PK")
	@Column(name="S_ID")
<<<<<<< HEAD
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="P_ID")
	
	//@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	//@JoinColumn(name="G_ID")
=======
>>>>>>> 27a9c8d76bb278c071baa35349906e6f91467e69
	private int id;
	
	@Column(name="S_TITLE")
	@NotNull
	private String title;
	
	@Column(name="S_URL")
	@NotNull
	private String url;
	
	@Column(name="S_YOUTUBE_ID")
	@NotNull
	private int youtubeId;
	
<<<<<<< HEAD
	@Column(name="S_GENRE_ID")
	private int genreId;
=======
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="G_ID")
	private int genreId;
	
	private Set<Playlist> playlists;
	
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="songs")
	public Set<Playlist> getPlaylists(){
		return this.playlists;
	}
	
	public void setOwners(Set<Playlist> playlists){
		this.playlists=playlists;
	}
>>>>>>> 27a9c8d76bb278c071baa35349906e6f91467e69

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getYoutubeId() {
		return youtubeId;
	}

	public void setYoutubeId(int youtubeId) {
		this.youtubeId = youtubeId;
	}

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
}
