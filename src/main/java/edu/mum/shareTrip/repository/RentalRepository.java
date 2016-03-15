package edu.mum.shareTrip.repository;

import org.springframework.data.repository.CrudRepository;

import edu.mum.shareTrip.domain.Rental;

public interface RentalRepository extends CrudRepository<Rental, Long> {

}
