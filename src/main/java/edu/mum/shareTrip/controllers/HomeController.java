package edu.mum.shareTrip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value={"/","welcome"})
	public String welcome(){
		return "welcome";
	}
	@RequestMapping(value={"about"})
	public String about(){
		return "about";
	}
	@RequestMapping(value={"contactUs"})
	public String contactUs(){
		return "contactUs";
	}
	@RequestMapping(value={"login"})
	public String login(){
		return "login";
	}
	@RequestMapping(value={"logout"})
	public String logout(){
		return "logout";
	}
	@RequestMapping(value={"userDashBoard"})
	public String userDashBoard(){
		return "userDashBoard";
	}
}
