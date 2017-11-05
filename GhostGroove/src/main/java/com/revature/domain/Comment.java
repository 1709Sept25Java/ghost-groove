package com.revature.domain;

import javax.persistence.*;

@Entity 
@Table(name="COMMENT")
public class Comment {
	
	public Comment() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="COMMENT_SEQ")
	@SequenceGenerator(allocationSize=1,name="CommentSequence",sequenceName="SQ_COMMENT_PK")
	@Column(name="C_ID")
	private int id;
	
	@Column(name="C_CONTENT")
	private String content;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="P_ID")
	private int playlistId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPlaylistId() {
		return playlistId;
	}
	public void setPlaylistId(int playlistId) {
		this.playlistId = playlistId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
