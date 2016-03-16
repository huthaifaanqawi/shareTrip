package edu.mum.shareTrip.service;

import edu.mum.shareTrip.domain.Credentials;

public interface UserService {

	public Credentials findUser(String username);
}
