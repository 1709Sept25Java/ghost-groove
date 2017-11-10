package com.revature.domain;


import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity 
@Table(name="GENRE")
public class Genre implements Serializable{
	
	public Genre() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="genreSequence")
	@SequenceGenerator(allocationSize=1,name="genreSequence",sequenceName="SQ_GENRE_PK")
	@Column(name="G_ID")
	private int id;
	
	@Column(name="G_NAME")
	@NotNull
	private String name;
	
	@Column(name="G_DESCRIPTION")
	private String description;

	@OneToMany(mappedBy="genre",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Playlist> playlists;
	
	@OneToMany(mappedBy="genre",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Song> songs;

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
		this.name=name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description=description;
	}
}
