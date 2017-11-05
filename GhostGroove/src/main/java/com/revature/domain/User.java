package com.revature.domain;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity 
@Table(name="USER")
public class User {

	public User() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="USER_SEQ")
	@SequenceGenerator(allocationSize=1,name="UserSequence",sequenceName="SQ_USER_PK")
	@Column(name="U_ID")
	private int id;
	
	@Column(name="U_USERNAME")
	@NotNull
	private String Username;
	
	@Column(name="U_PASSWORD")
	@NotNull
	private String Password;
	
	@Column(name="U_FIRSTNAME")
	private String Firstname;
	
	@Column(name="U_LASTNAME")
	private String Lastname;
	
	@Column(name="U_EMAIL")
	private String Email;
	
	@Column(name="U_ISMANAGER")
	@NotNull
	private String isManager;
	
	private Set<Playlist> playlists;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(name="USER_PLAYLIST",joinColumns= {@JoinColumn(name="U_ID")},inverseJoinColumns= {@JoinColumn(name="P_ID")})
	public Set<Playlist> getPlaylists(){
		return this.playlists;
	}
	
	public void setPlaylists(Set<Playlist> playlists) {
		this.playlists=playlists;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}	
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getIsManager() {
		return isManager;
	}
	public void setIsManager(String isManager) {
		this.isManager = isManager;
	}

}
