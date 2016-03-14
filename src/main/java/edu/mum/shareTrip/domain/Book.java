package edu.mum.shareTrip.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="BOOK")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CURRENT_LOCATION",referencedColumnName="ID")
	private Place currentLocation;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="DESTIONATION",referencedColumnName="ID")
	private Place destionation;
	
	@Column(name="TIME_TO_STAY")
	private int timeToStay;
	
	@Column(name="REASON")
	private String reason;
	
	@Column(name="COME_BACK")
	private boolean comeBack;
	
	@OneToOne
	@JoinColumn(name="TRIP_ID",referencedColumnName="ID")
	private Trip trip;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Place getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Place currentLocation) {
		this.currentLocation = currentLocation;
	}

	public Place getDestionation() {
		return destionation;
	}

	public void setDestionation(Place destionation) {
		this.destionation = destionation;
	}

	public int getTimeToStay() {
		return timeToStay;
	}

	public void setTimeToStay(int timeToStay) {
		this.timeToStay = timeToStay;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public boolean isComeBack() {
		return comeBack;
	}

	public void setComeBack(boolean comeBack) {
		this.comeBack = comeBack;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}
}
