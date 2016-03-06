package edu.mum.shareTrip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value={"/"})
	public String welcome(){
		return "welcome";
	}
}
