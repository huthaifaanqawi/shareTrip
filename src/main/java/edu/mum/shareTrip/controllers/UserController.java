package edu.mum.shareTrip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.shareTrip.domain.Credentials;
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
	
	@RequestMapping(value="/loginfailed")
	public String loginFailed(@ModelAttribute("user") Credentials user, Model model){
		model.addAttribute("loginFailed",true);
		return "login";
	}
}
