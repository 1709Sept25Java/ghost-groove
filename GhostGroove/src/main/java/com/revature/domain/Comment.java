package com.revature.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity 
@Table(name="COMMENTS")
public class Comment implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	public Comment() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="commentSequence")
	@SequenceGenerator(allocationSize=1,name="commentSequence",sequenceName="SQ_COMMENT_PK")
	@Column(name="C_ID")
	private int id;
	
	@Column(name="C_CONTENT")
	private String content;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="C_PLAYLIST")
	private Playlist playlist;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Playlist getPlaylist() {
		return playlist;
	}
	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
