package edu.mum.shareTrip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.shareTrip.domain.Trip;
import edu.mum.shareTrip.repository.TripRepository;

@Service
@Transactional
public class TripService {
	@Autowired
	TripRepository tripRepository;

	public Trip saveTrip(Trip newTrip){
		return tripRepository.save(newTrip);
	}
	
	public List<Trip> getAllTrip(){
		return (List<Trip>) tripRepository.findAll();
	}
	
}
