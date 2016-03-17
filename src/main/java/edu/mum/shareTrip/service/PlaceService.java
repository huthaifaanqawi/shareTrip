package edu.mum.shareTrip.service;

import java.util.List;

import edu.mum.shareTrip.domain.Place;

public interface PlaceService {
	
	public List<Place> getAllPlaces();
	
	public Place getPlaceById(long id);
}
