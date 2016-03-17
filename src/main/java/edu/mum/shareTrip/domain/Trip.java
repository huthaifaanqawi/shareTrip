package edu.mum.shareTrip.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import edu.mum.shareTrip.validator.DateTrip;
import edu.mum.shareTrip.validator.Destination;
import edu.mum.shareTrip.validator.UserAvailability;

@Entity(name="TRIP")
@Destination
@DateTrip
@UserAvailability //uncomment when it is ready
public class Trip {

	//
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	
	@NotEmpty
	@Column(name="TITLE")
	private String title;
	
	@NotEmpty
	@Column(name="DESCRIPTION")
	private String description;
	
	@NotNull
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	@Column(name="DEPART_TIME")
	private Date departTime;
	
	@NotNull
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	@Column(name="RETURN_TIME")
	private Date returnTime;
	
	@NotEmpty
	@Column(name="TYPE")
	private String type;
	
	@Column(name="SEATS")
	private Integer seats;
	
	@NotNull
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ORIGIN_ID",referencedColumnName="ID")
	private Place origin;
	
	@NotNull
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="DESTIONATION_ID",referencedColumnName="ID")
	private Place destination;
	
	@NotNull
	@OneToOne
	@JoinColumn(name="VEHICLE_ID",referencedColumnName="ID")
	private Vechile vehicle;
	
	@ManyToOne
	@JoinColumn(name="MEMBER_ID",referencedColumnName="ID")
    private Member member;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDepartTime() {
		return departTime;
	}

	public void setDepartTime(Date departTime) {
		this.departTime = departTime;
	}

	public Date getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Place getOrigin() {
		return origin;
	}

	public void setOrigin(Place origin) {
		this.origin = origin;
	}

	public Place getDestination() {
		return destination;
	}

	public void setDestination(Place destination) {
		this.destination = destination;
	}

	public Vechile getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vechile vehicle) {
		this.vehicle = vehicle;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Member getMember(){
		return member;
	}
	
	public void setMember(Member member){
		this.member = member;
	}
	
	public Integer getSeats(){
		return seats;
	}
	
	public void setSeats(Integer seats){
		this.seats = seats;
	}
}
