package edu.mum.shareTrip.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.shareTrip.domain.Place;

@Repository
public interface PlaceRepository extends CrudRepository<Place, Long> {

}
