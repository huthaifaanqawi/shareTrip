package edu.mum.shareTrip.domain;

import java.io.Serializable;
import java.util.Date;
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
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import edu.mum.shareTrip.validator.Credential;

@Entity(name="MEMBER")
public class Member implements Serializable{

	private static final long serialVersionUID = 4939605490184287786L;

	@Id
	@Column(name="ID", nullable=false ,unique = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="FIRST_NAME")
	@NotEmpty
	@Pattern(regexp="[a-zA-Z]*",message="first name is Not Valid")
	private String firstName;
	
	@Column(name="LAST_NAME")
	@NotEmpty
	@Pattern(regexp="[a-zA-Z]*",message="last name is Not Valid")
	private String lastName;
	
	@Column(name="BIRTHDAY")
	@NotNull
	private Date birthday;
	
	@Column(name="PHONE")
	@NotEmpty
	private String phone;
	
    @Column(name="EMAIL")
    @Email
    @NotEmpty
	private String email;
    
    @Column(name="GENDER")
    @NotEmpty
    private String gender;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="USERNAME",referencedColumnName="USERNAME")
	@Valid
	@Credential(message="Passwords Dont match")
	private Credentials credentials;
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.REMOVE,mappedBy="member")
	private List<Book> bookList;
	
	@OneToMany(cascade=CascadeType.REMOVE,fetch=FetchType.LAZY,mappedBy="member")
	private List<Rental> rentals;
	
	@OneToMany(cascade={CascadeType.REMOVE},fetch=FetchType.LAZY,mappedBy="member")
	private List<Trip> trips;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ADDRESS_ID",referencedColumnName="ID")
	@Valid
	private Address address;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="member")
	private List<Vechile> vechile;

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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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

	public List<Vechile> getVechile() {
		return vechile;
	}

	public void setVechile(List<Vechile> vechile) {
		this.vechile = vechile;
	}
	
}
