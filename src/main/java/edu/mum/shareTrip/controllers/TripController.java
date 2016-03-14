package edu.mum.shareTrip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TripController {
	@RequestMapping(value={"addTrip"})
	public String addTrip(){
		return "addTrip";
	}
	@RequestMapping(value={"tripList"})
	public String tripTrip(){
		return "tripList";
	}
}
