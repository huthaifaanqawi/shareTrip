package edu.mum.shareTrip.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.shareTrip.domain.Rental;
@Repository
public interface RentalRepository extends CrudRepository<Rental, Long> {

}