package edu.mum.shareTrip.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.shareTrip.domain.Member;
import edu.mum.shareTrip.domain.Vechile;

@Repository
public interface MemberRepository extends CrudRepository<Member, Integer>{

	@Query("SELECT m FROM MEMBER m, TRIP t where "
	 		+ "m.id=:memberid "
	 		+ "and t.member.id = m.id "
	 		+ "and t.id !=:tripid "
	 		+ "and ((t.departTime<=:min and t.returnTime>=:max) "
	 		+ "or (t.returnTime>=:max and t.departTime<=:min))")
	 public List<Member> getMemberAvailabilityTrip(@Param("memberid")long memberid, 
			 @Param("min") Date mindate,
			 @Param("max") Date maxdate,
			 @Param("tripid")long idtrip);
	 
	 @Query("SELECT m FROM MEMBER m, TRIP t, BOOK b where "
		 		+ "b.trip.id = t.id "
		 		+ "and m.id=:memberid "
		 		+ "and b.member.id = m.id "
		 		+ "and ((t.departTime<=:min and t.returnTime>=:max) "
		 		+ "or (t.returnTime>=:max and t.departTime<=:min))")
	public List<Member> getMemberAvailabilityBook(@Param("memberid")long id, 
				 @Param("min") Date mindate,
				 @Param("max") Date maxdate);
	 
	@Query("SELECT m FROM MEMBER m where m.credentials.username=:name")
	public Member getMemberByUserName(@Param("name")String username);
}
