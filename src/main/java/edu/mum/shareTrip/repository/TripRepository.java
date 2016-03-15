package edu.mum.shareTrip.repository;

import org.springframework.data.repository.CrudRepository;

import edu.mum.shareTrip.domain.Trip;

public interface TripRepository extends CrudRepository<Trip, Long> {

}
