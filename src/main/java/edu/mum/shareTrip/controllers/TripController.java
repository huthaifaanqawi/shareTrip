package edu.mum.shareTrip.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.shareTrip.domain.Member;
import edu.mum.shareTrip.domain.Place;
import edu.mum.shareTrip.domain.Trip;
import edu.mum.shareTrip.domain.Vechile;
import edu.mum.shareTrip.service.MemberService;
import edu.mum.shareTrip.service.PlaceService;
import edu.mum.shareTrip.service.TripService;
import edu.mum.shareTrip.service.VechileService;

@Controller
@RequestMapping("userDashBoard")
public class TripController {
	
	@Autowired
	PlaceService placesService;
	
	@Autowired
	VechileService vehicleService;
	
	@Autowired
	TripService tripService;
	
	@Autowired
	MemberService memberService;
	
	@ModelAttribute
	public void loadList(Model model){
		model.addAttribute("placeslist", placesService.getAllPlaces());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName(); //get logged in username
	    Member member = memberService.getMemberByUserName(name);
		
		model.addAttribute("carlist", vehicleService.getUserVehicles(member.getId()));
	}
	
	@RequestMapping(value={"addTrip"}, method=RequestMethod.GET)
	public String addTrip(Trip trip, Model model){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName(); //get logged in username
	    Member member = memberService.getMemberByUserName(name);
	    trip.setMember(member);
	    
		model.addAttribute("trip", trip);
		return "addTrip";
	}
	
	@RequestMapping(value={"addTrip"}, method=RequestMethod.POST)
	public String saveTrip(@RequestParam("origin.id")int originId,
			@RequestParam("destination.id")int destinationId,
			@RequestParam("vehicle.id")int carId, 
			@Valid @ModelAttribute("trip") Trip trip, 
			BindingResult result, 
			Model model){
		
		if(result.hasErrors()){
			return "addTrip";
		}
		
		Place origin = placesService.getPlaceById(originId);
		Place destination = placesService.getPlaceById(destinationId);
		Vechile car = vehicleService.getVehicleById(carId);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName(); //get logged in username
	    Member member = memberService.getMemberByUserName(name);
	    trip.setMember(member);
	    
		trip.setOrigin(origin);
		trip.setDestination(destination);
		trip.setVehicle(car);
		trip.setSeats(car.getSeatNumber()-1);
		
		car.setStatus("TRIP");
		vehicleService.save(car);
		
		tripService.saveTrip(trip);
		
		return "redirect:/userDashBoard/tripList";
	}
}
