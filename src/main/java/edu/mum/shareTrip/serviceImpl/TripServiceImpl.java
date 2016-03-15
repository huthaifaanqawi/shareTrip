package edu.mum.shareTrip.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.shareTrip.domain.Trip;
import edu.mum.shareTrip.repository.TripRepository;
import edu.mum.shareTrip.service.TripService;

public class TripServiceImpl implements TripService{

	@Autowired
	TripRepository tripRepository;

	public Trip saveTrip(Trip newTrip){
		return tripRepository.save(newTrip);
	}
	
	public List<Trip> getAllTrip(){
		return (List<Trip>) tripRepository.findAll();
	}
}
