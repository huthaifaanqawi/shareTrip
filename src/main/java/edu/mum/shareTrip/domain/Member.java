package edu.mum.shareTrip.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity(name="MEMBER")
public class Member {

	@Id
	@Column(name="ID", nullable=false ,unique = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="AGE")
	private int age;
	
	@Column(name="PHONE")
	private String phone;
	
	@OneToOne
	@JoinColumn(name="USERNAME")
	private Credentials credentials;

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}
}
