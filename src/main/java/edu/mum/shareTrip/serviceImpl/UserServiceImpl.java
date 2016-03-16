package edu.mum.shareTrip.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.shareTrip.domain.Credentials;
import edu.mum.shareTrip.repository.UserRepository;
import edu.mum.shareTrip.service.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	public Credentials findUser(String username){
		return userRepository.findOne(username);
	}
}
