package edu.mum.shareTrip.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="ADDRESS")
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@Column(name="CITY")
	@NotEmpty
	@Pattern(regexp="[A-Za-z]{6,}")
	private String city;
	
	@Column(name="STATE")
	@NotEmpty
	@Pattern(regexp="[A-Z]{2}")
	private String state;
	
	@Column(name="STREET")
	@NotEmpty
	@Pattern(regexp="^([0-9]+ )?[a-zA-Z ]+$")
	private String street;
	
	@Column(name="ZIP_CODE")
	@Pattern(regexp="^[0-9]{5}(?:-[0-9]{4})?$")
	private String zipCode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
