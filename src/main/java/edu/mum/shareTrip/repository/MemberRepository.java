package edu.mum.shareTrip.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.shareTrip.domain.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member, Integer>{

}
