package edu.mum.shareTrip.controllers;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import edu.mum.shareTrip.domain.JsonResponse;
import edu.mum.shareTrip.domain.Member;
import edu.mum.shareTrip.domain.Rental;
import edu.mum.shareTrip.domain.Vechile;
import edu.mum.shareTrip.exceptions.UserNotHaveVechileExpction;
import edu.mum.shareTrip.service.MemberService;
import edu.mum.shareTrip.service.RentalService;
import edu.mum.shareTrip.service.VechileService;
@Controller
@RequestMapping("userDashBoard")
public class RentVechileController {
@Autowired
VechileService vechileService;
@Autowired 
RentalService rentalService;
@Autowired MemberService memberService;
@RequestMapping(value={"getVechile"},method= RequestMethod.GET)
	public String userBorrowList(@RequestParam("id")  int id,Model model)
	{
Vechile vechile=vechileService.getVehicleById(id);
model.addAttribute("vechile", vechile);
return "rentVechile";
	}
@RequestMapping(value={"rentVechile"} ,method=RequestMethod.GET)
public String rentVechile(@RequestParam("id")  int id,Model model,@ModelAttribute Rental rental){
Vechile vechile=vechileService.getVehicleById(id);
	model.addAttribute("vechile", vechile);
return  "rentVechile";

}
@RequestMapping(value={"rentVechile"} ,method=RequestMethod.POST)
public  String  saverent(@RequestParam("vechile.id") int vechileId,@Valid@ModelAttribute Rental rental,BindingResult result,Model model){
	Vechile vechile=vechileService.getVehicleById(vechileId);
	if(result.hasErrors())
	{
		return "rentVechile";
	}
rental.setVeichle(vechile);
Authentication auth = SecurityContextHolder.getContext().getAuthentication();
String name = auth.getName(); 
Member member = memberService.getMemberByUserName(name);
rental.setMember(member);
rentalService.saveRental(rental);
vechile.setStatus("rent");
vechileService.save(vechile);
return  "redirect:/userRentList";

}
@RequestMapping(value={"userRentList"} ,method=RequestMethod.GET)
public String userRentList(Model model){
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	String name = auth.getName(); 
	Member member = memberService.getMemberByUserName(name);
model.addAttribute("rentals",rentalService.getUserRental(member.getId()));
return  "userRentList";  
}
@RequestMapping(value={"/rentUserCheckOwner/{vechileid}"} ,method=RequestMethod.GET)
public @ResponseBody JsonResponse  checkifowner(@PathVariable("vechileid")  int vechileid,Model model,@ModelAttribute Rental rental){
	JsonResponse res=new JsonResponse();
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	String name = auth.getName(); 
	Member member = memberService.getMemberByUserName(name);
if(vechileService.checkIfOwner(vechileid, member.getId()).equals(null))
		{
	res.setStatus("nocar");
	throw  new UserNotHaveVechileExpction();
		}
else {
	res.setStatus("hascar");
}
return  res;
}
}
