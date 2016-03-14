package edu.mum.shareTrip.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.shareTrip.domain.Trip;

@Controller
public class TripController {
	
	@RequestMapping(value={"addTrip"}, method=RequestMethod.GET)
	public String addTrip(@ModelAttribute("trip") Trip trip){
		return "addTrip";
	}
	
	@RequestMapping(value={"addTrip"}, method=RequestMethod.POST)
	public String saveTrip(@Valid @ModelAttribute("trip") Trip trip, BindingResult result, RedirectAttributes redirectAttributes){
		
		if(result.hasErrors()){
			return "addTrip";
		}
		
		redirectAttributes.addFlashAttribute("trip", trip);
		//Save
		
		return "redirect:/showTripDetails";
	}
	
	@RequestMapping(value={"showTripDetails"}, method=RequestMethod.GET)
	public String detailsTrip(){
		return "tripDetails";
	}
	
	@RequestMapping(value={"tripList"})
	public String tripTrip(){
		return "tripList";
	}
}
