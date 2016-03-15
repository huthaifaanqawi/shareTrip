package edu.mum.shareTrip.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.shareTrip.domain.Member;
import edu.mum.shareTrip.domain.Place;
import edu.mum.shareTrip.domain.Trip;
import edu.mum.shareTrip.domain.Vechile;
import edu.mum.shareTrip.service.PlaceService;
import edu.mum.shareTrip.service.TripService;
import edu.mum.shareTrip.service.UserService;
import edu.mum.shareTrip.service.VechileService;

@Controller
public class TripController {
	
	@Autowired
	PlaceService placesService;
	
	@Autowired
	VechileService vehicleService;
	
	@Autowired
	TripService tripservice;
	
	@Autowired
	UserService userservice;
	
	@ModelAttribute
	public void loadList(Model model){
		model.addAttribute("placeslist", placesService.getAllPlaces());
		model.addAttribute("carlist", vehicleService.getAll());
	}
	
	@RequestMapping(value={"addTrip"}, method=RequestMethod.GET)
	public String addTrip(@ModelAttribute("trip") Trip trip){
		return "addTrip";
	}
	
	@RequestMapping(value={"addTrip"}, method=RequestMethod.POST)
	public String saveTrip(@RequestParam("origin.id")int originId,
			@RequestParam("destination.id")int destinationId,
			@RequestParam("car.id")int carId, 
			@Valid @ModelAttribute("trip") Trip trip, 
			BindingResult result, RedirectAttributes redirectAttributes,
			Model model){
		
		Place origin = placesService.getPlaceById(originId);
		Place destination = placesService.getPlaceById(destinationId);
		Vechile car = vehicleService.getVehicleById(carId);
		
		Member member =  new Member();
		member.setFirstName("Ana");
		member.setLastName("Smith");
		member.setId(1);
		
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//	    String name = auth.getName(); //get logged in username
//	    //
//	    Member member = userservice.getMemberByUserName(name);
		
	    trip.setMember(member);
		trip.setOrigin(origin);
		trip.setDestination(destination);
		trip.setVehicle(car);
		
		if(result.hasErrors()){
			return "addTrip";
		}
		
		redirectAttributes.addFlashAttribute("trip", trip);
		
		tripservice.saveTrip(trip);
		
		
		return "redirect:/showTripDetails";
	}
	
	@RequestMapping(value={"showTripDetails"}, method=RequestMethod.GET)
	public String detailsTrip(Model model){
		List<Trip> tripList = tripservice.getAllTrip();
		model.addAttribute("trips", tripList);
		return "tripList";
	}
	
	@RequestMapping(value={"tripList"}, method=RequestMethod.POST)
	public String tripTrip(Model model){
		List<Trip> tripList = tripservice.getAllTrip();
		model.addAttribute("trips", tripList);
		return "tripList";
	}
}
