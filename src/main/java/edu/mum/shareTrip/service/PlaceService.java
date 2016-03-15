package edu.mum.shareTrip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.shareTrip.domain.Place;
import edu.mum.shareTrip.repository.PlaceRepository;

@Service
@Transactional
public class PlaceService {

	@Autowired
	PlaceRepository placeRepository;
	
	public List<Place> getAllPlaces(){
		return (List<Place>) placeRepository.findAll();
	}
	
	public Place getPlaceById(long id){
		return placeRepository.findOne(id);
	}
}
