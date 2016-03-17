package edu.mum.shareTrip.service;

import java.util.List;

import edu.mum.shareTrip.domain.Trip;

public interface TripService {
	public Trip saveTrip(Trip newTrip);
	
	public List<Trip> getAllTrip();
	
	public Trip getTripById(long id);
	
	public List<Trip> getTripsWithSeats();
	
	public List<Trip> getTripsByMemberBook(long id);
	
}
