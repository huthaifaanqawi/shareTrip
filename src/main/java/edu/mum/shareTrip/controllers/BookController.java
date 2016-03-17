package edu.mum.shareTrip.controllers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.shareTrip.domain.Book;
import edu.mum.shareTrip.domain.Member;
import edu.mum.shareTrip.domain.Trip;
import edu.mum.shareTrip.exceptions.UserDriverException;
import edu.mum.shareTrip.exceptions.UserNotAvailableException;
import edu.mum.shareTrip.service.BookService;
import edu.mum.shareTrip.service.MemberService;
import edu.mum.shareTrip.service.TripService;

@Controller
@RequestMapping("userDashBoard")
public class BookController {
	
	@Autowired
	TripService tripservice;
	
	@Autowired 
	BookService bookService;
	
	@Autowired
	MemberService memberService;
	
	@ModelAttribute
	public void loadList(Model model){
		List<Trip> trips = tripservice.getTripsWithSeats();
		model.addAttribute("trips", trips);
	}
	
	@RequestMapping(value={"tripList"}, method=RequestMethod.GET)
	public String tripTrip(Model model){
		return "tripList";
	}
	
	// @Valid - but NO BindResult! an exception will be thrown...
	 @RequestMapping(value = "addBook", method = RequestMethod.POST)
	 public @ResponseBody String saveBook(@RequestParam String id) {
		 
		long tripid = Long.parseLong(id);
		Trip mytrip = tripservice.getTripById(tripid);
		
		Book newBook = new Book();
		//Descomentar este
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
		Member member = memberService.getMemberByUserName(name);
		newBook.setMember(member);
		
		if(member.getId()==mytrip.getMember().getId()){
			throw new UserDriverException();
		}
		
		if(memberService.getMemberAvailabilityBook(member.getId(), mytrip.getDepartTime(), mytrip.getReturnTime()).size()>0 ||
				memberService.getMemberAvailabilityTrip(member.getId(), mytrip.getDepartTime(), mytrip.getReturnTime(), mytrip.getId()).size()>0){
			throw new UserNotAvailableException();
		}
		
		newBook.setMember(member);
		
		mytrip.setSeats(mytrip.getSeats()-1);
		tripservice.saveTrip(mytrip);
		newBook.setTrip(mytrip);
		bookService.saveBook(newBook);
		
	    return ""+mytrip.getSeats();
	 }
	 
	 @RequestMapping(value={"bookList"}, method=RequestMethod.GET)
		public String bookTrips(Model model){
		 	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 	String name = auth.getName(); //get logged in username
			Member member = memberService.getMemberByUserName(name);
			List<Trip> books = tripservice.getTripsByMemberBook(member.getId());
			
			model.addAttribute("bookings", books);
		 
			return "bookList";
		}

}
