package com.revature.domain;

import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity 
@Table(name="SONG")
public class Song {
	
	public Song() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="songSequence")
	@SequenceGenerator(allocationSize=1,name="songSequence",sequenceName="SQ_SONG_PK")
	@Column(name="S_ID")
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
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="S_GENRE")
	private Genre genre;
	
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="songs")
	private Set<Playlist> playlists;
	
	
	public Set<Playlist> getPlaylists(){
		return this.playlists;
	}
	
	public void setOwners(Set<Playlist> playlists){
		this.playlists=playlists;
	}

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

	public Genre getGenreId() {
		return genre;
	}

	public void setGenreId(Genre genre) {
		this.genre = genre;
	}
}
