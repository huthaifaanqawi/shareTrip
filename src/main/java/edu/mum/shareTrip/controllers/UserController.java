package edu.mum.shareTrip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@RequestMapping(value={"signUp"})
	public String userDashBoard(){
		return "signUp";
	}
}
