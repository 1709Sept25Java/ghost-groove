package com.revature.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@NamedQueries({@NamedQuery(name="login",query="from User where Username=:unameVar and Password=:pwVar")})

@Component(value="user")
@Scope(value="session")
@Entity 
@Table(name="USERS")
public class User implements Serializable{



	private static final long serialVersionUID = 1L;
	
	public User(String username, String password, String firstname, String lastname, String email, boolean isManager) {
		super();
		this.Username = username;
		this.Password = password;
		this.Firstname = firstname;
		this.Lastname = lastname;
		this.Email = email;
		this.isManager = isManager;
	}


	public User() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="userSequence")
	@SequenceGenerator(allocationSize=1,name="userSequence",sequenceName="SQ_USER_PK")
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
	private boolean isManager;
	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="USER_PLAYLIST",joinColumns= {@JoinColumn(name="U_ID")},inverseJoinColumns= {@JoinColumn(name="P_ID")})
	private Set<Playlist> playlists;
	
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
	public boolean getIsManager() {
		return isManager;
	}
	public void setIsManager(boolean isManager) {
		this.isManager = isManager;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", Username=" + Username + ", Password=" + Password + ", Firstname=" + Firstname
				+ ", Lastname=" + Lastname + ", Email=" + Email + ", isManager=" + isManager + "]";
	}

}
