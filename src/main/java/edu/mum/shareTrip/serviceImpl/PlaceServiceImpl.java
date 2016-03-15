package edu.mum.shareTrip.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.shareTrip.domain.Place;
import edu.mum.shareTrip.repository.PlaceRepository;
import edu.mum.shareTrip.service.PlaceService;

public class PlaceServiceImpl implements PlaceService{

	@Autowired
	PlaceRepository placeRepository;
	
	public List<Place> getAllPlaces(){
		return (List<Place>) placeRepository.findAll();
	}
	
	public Place getPlaceById(long id){
		return placeRepository.findOne(id);
	}
}
