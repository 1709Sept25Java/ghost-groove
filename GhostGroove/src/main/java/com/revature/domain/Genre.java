package com.revature.domain;

<<<<<<< HEAD
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
=======
import java.util.List;

import javax.persistence.*;
>>>>>>> 27a9c8d76bb278c071baa35349906e6f91467e69
import javax.validation.constraints.NotNull;

@Entity 
@Table(name="GENRE")
public class Genre {
	
	public Genre() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="GENRE_SEQ")
	@SequenceGenerator(allocationSize=1,name="GenreSequence",sequenceName="SQ_GENRE_PK")
	@Column(name="G_ID")
<<<<<<< HEAD
	//@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	//@JoinColumn(name="P_ID")
=======
>>>>>>> 27a9c8d76bb278c071baa35349906e6f91467e69
	private int id;
	
	@Column(name="G_NAME")
	@NotNull
	private String name;
	
	@Column(name="G_DESCRIPTION")
	private String description;
	
<<<<<<< HEAD
=======
	@OneToMany(mappedBy="genreId",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Playlist> playlists;
	
	@OneToMany(mappedBy="genreId",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Song> songs;
	
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
		this.name=name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description=description;
	}
}
