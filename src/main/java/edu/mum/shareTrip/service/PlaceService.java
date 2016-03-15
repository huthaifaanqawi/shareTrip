package edu.mum.shareTrip.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.shareTrip.domain.Place;

public interface PlaceService {
	
	public List<Place> getAllPlaces();
	
	public Place getPlaceById(long id);
}
