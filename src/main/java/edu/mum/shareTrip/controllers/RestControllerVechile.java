package edu.mum.shareTrip.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.shareTrip.domain.Rental;
import edu.mum.shareTrip.domain.Vechile;
import edu.mum.shareTrip.service.VechileService;
@Controller
public class RestControllerVechile {
@Autowired
VechileService vechileService;
@RequestMapping(value={"getVechile"},method= RequestMethod.GET)
	public String userBorrowList(@RequestParam("id")  int id,Model model)
	{
Vechile vechile=vechileService.getVehicleById(id);
model.addAttribute("vechile", vechile);
return "rentVechile";
	}
@RequestMapping(value={"/rentVechile"} ,method=RequestMethod.GET)
public String rentVechile(@RequestParam("id")  int id,Model model){
	System.out.println("Hello");
Vechile vechile=vechileService.getVehicleById(id);
	model.addAttribute("vechile", vechile);
return  "rentVechile";

}
}
