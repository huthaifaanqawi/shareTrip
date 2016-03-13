package edu.mum.shareTrip.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import edu.mum.shareTrip.domain.Vechile;


@Repository
public interface VechileRepository extends  CrudRepository<Vechile, Long> {

}