package com.revature.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
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
