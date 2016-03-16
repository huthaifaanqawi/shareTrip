package edu.mum.shareTrip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import edu.mum.shareTrip.domain.Vechile;
@Repository
public interface VechileRepository extends  CrudRepository<Vechile, Long>, JpaSpecificationExecutor<Vechile>  {

@Query("SELECT p FROM VECHILE p WHERE p.member.id=:mm")
 public List<Vechile> getUserVehicles(@Param("mm") Integer mm);
}