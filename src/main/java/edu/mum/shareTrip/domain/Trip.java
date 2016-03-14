package edu.mum.shareTrip.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="TRIP")
public class Trip {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@Column(name="DEPART_TIME")
	private Date departTime;
	
	@Column(name="RETURN_TIME")
	private Date returnTime;
	
	@Column(name="TYPE")
	private String type;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ORIGIN_ID",referencedColumnName="ID")
	private Place origin;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="DESTIONATION_ID",referencedColumnName="ID")
	private Place destination;
	
	@OneToOne
	@JoinColumn(name="CAR_ID",referencedColumnName="ID")
	private Car car;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
}
