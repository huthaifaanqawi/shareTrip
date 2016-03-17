package edu.mum.shareTrip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.shareTrip.domain.Credentials;

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
	public String login(@ModelAttribute("user") Credentials user){
		return "login";
	}
	@RequestMapping(value={"logout"})
	public String logout(){
		return "logout";
	}
	@RequestMapping(value={"redirectToUserDashBoard"})
	public String redirectToUserDashBoard(){
		return "redirect:/userDashBoard";
	}
	
	@RequestMapping(value={"userDashBoard"})
	public String userDashboard(){
		return "userDashBoard";
	}
}
