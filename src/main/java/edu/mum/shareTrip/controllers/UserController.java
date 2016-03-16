package edu.mum.shareTrip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.shareTrip.exceptions.UserExistException;
import edu.mum.shareTrip.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/getUser/{username}")
	public @ResponseBody void getUser(@PathVariable("username") String username){
		if(userService.findUser(username) != null){
			throw new UserExistException();
		}
	}
}
