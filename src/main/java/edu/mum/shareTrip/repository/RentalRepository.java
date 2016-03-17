package edu.mum.shareTrip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import edu.mum.shareTrip.domain.Rental;
@Repository
public interface RentalRepository extends CrudRepository<Rental, Long>, JpaSpecificationExecutor<Rental> {
@Query("SELECT r FROM RENTAL r WHERE r.member.id=:id")
public List<Rental> getUserRentalList(@Param("id") long memberid);
}