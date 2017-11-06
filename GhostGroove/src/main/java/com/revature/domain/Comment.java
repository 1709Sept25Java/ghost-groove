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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
=======
import javax.persistence.*;
>>>>>>> 27a9c8d76bb278c071baa35349906e6f91467e69

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
<<<<<<< HEAD
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="P_ID")
	private int id;
	
	@Column(name="P_ID")
	private int playlistId;
	
	@Column(name="P_CONTENT")
	private String content;
=======
	private int id;
	
	@Column(name="C_CONTENT")
	private String content;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="P_ID")
	private int playlistId;
	
>>>>>>> 27a9c8d76bb278c071baa35349906e6f91467e69
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
