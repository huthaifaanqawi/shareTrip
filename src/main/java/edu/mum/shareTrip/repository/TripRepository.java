package edu.mum.shareTrip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.shareTrip.domain.Trip;

@Repository
public interface TripRepository extends CrudRepository<Trip, Long> {

	@Query("select t from TRIP t where t.seats>0")
	public List<Trip> getTripsWithSeats();
	
	@Query("select t from TRIP t, BOOK b where b.member.id =:id"
			+ " and b.trip.id=t.id")
	public List<Trip> getTripsByMemberBook(@Param("id")long id);
}
