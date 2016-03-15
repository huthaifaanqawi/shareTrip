package edu.mum.shareTrip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.shareTrip.domain.Member;

@Controller
public class UserController {
	@RequestMapping(value={"signUp"})
	public String userDashBoard(@ModelAttribute("member") Member member){
		return "signUp";
	}
}
