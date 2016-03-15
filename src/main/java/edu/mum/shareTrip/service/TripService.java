package edu.mum.shareTrip.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.shareTrip.domain.Trip;

@Service
@Transactional
public interface TripService {
	public Trip saveTrip(Trip newTrip);
	
	public List<Trip> getAllTrip();
	
}
