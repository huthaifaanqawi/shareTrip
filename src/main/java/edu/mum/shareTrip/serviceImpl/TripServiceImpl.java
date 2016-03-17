package edu.mum.shareTrip.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.shareTrip.domain.Trip;
import edu.mum.shareTrip.repository.TripRepository;
import edu.mum.shareTrip.service.TripService;


@Service
@Transactional
public class TripServiceImpl implements TripService{

	@Autowired
	TripRepository tripRepository;

	public Trip saveTrip(Trip newTrip){
		return tripRepository.save(newTrip);
	}
	
	public List<Trip> getAllTrip(){
		return (List<Trip>) tripRepository.findAll();
	}

	@Override
	public Trip getTripById(long id) {
		return tripRepository.findOne(id);
	}

	@Override
	public List<Trip> getTripsWithSeats() {
		return tripRepository.getTripsWithSeats();
	}

	@Override
	public List<Trip> getTripsByMemberBook(long id) {
		return tripRepository.getTripsByMemberBook(id);
	}
}
