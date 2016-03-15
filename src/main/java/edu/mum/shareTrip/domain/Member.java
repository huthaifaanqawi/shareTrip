package edu.mum.shareTrip.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
	
    @Column(name="EMAIL")
	private String email;
    
    @Column(name="GENDER")
    private String gender;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="USERNAME",referencedColumnName="USERNAME")
	private Credentials credentials;
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	@JoinColumn(name="MEMBER_ID",referencedColumnName="ID")
	private List<Book> bookList;
	
	@OneToMany(cascade=CascadeType.REMOVE,fetch=FetchType.LAZY)
	@JoinColumn(name="MEMBER_ID",referencedColumnName="ID")
	private List<Rental> rentals;
	
	@OneToMany(cascade={CascadeType.REMOVE},fetch=FetchType.LAZY)
	@JoinColumn(name="MEMBER_ID",referencedColumnName="ID")
	private List<Trip> trips;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ADDRESS_ID",referencedColumnName="ID")
	private Address address;

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}

	public List<Trip> getTrips() {
		return trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
