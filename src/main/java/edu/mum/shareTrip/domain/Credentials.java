package edu.mum.shareTrip.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "USERS")
public class Credentials {

	@Id
	@Column(name = "USERNAME", nullable = false, unique = true)
	@NotEmpty
	@Pattern(regexp="[A-Za-z]*")
	private String username;
	
	@Column(name = "PASSWORD", nullable = false)
	@Pattern(regexp="[A-Za-z0-9]{6,8}")
	@NotEmpty
	private String password;
	
	@Column(name = "VERIFY_PASSWORD", nullable = false)
	private String verifyPassword;
	

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "USERNAME",referencedColumnName="USERNAME")
	private List<Authority> authority;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	public List<Authority> getAuthority() {
		return authority;
	}

	public void setAuthority(List<Authority> authority) {
		this.authority = authority;
	}

}
