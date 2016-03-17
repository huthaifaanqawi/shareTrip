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
public List<Vechile> getUserVehicles(@Param("mm") long mm);

@Query("SELECT p FROM VECHILE p WHERE p.member.id=:id and p.status='available'")
 public List<Vechile> getUserAvialbleVehicles(@Param("id") long id);

@Query("SELECT p FROM VECHILE p WHERE p.status='available'")
public List<Vechile> getAvialbleVehicles();

@Query("SELECT v FROM VECHILE v WHERE  v.plateNumber=:plateNumber")
public Vechile checkPlateNumber(@Param("plateNumber")String plateNumber);


@Query("SELECT p FROM VECHILE p WHERE p.member.id=:mem and p.id=:vec")
public Vechile checkIfOwner(@Param("vec")long vechileid,@Param("mem")long memberid);

@Query("Update VECHILE p set p.status=:status  WHERE p.id=:id")
public void updateStatus(@Param("id") long id,@Param("status")String status);
}