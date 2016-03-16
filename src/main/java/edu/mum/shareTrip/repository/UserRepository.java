package edu.mum.shareTrip.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.shareTrip.domain.Credentials;

@Repository
public interface UserRepository extends CrudRepository<Credentials, String>{

}
