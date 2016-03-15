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

import edu.mum.shareTrip.domain.Member;
import edu.mum.shareTrip.domain.Vechile;
import edu.mum.shareTrip.service.VechileService;

@Controller
public class VechileController {
     @Autowired
     VechileService vechileService;
	@RequestMapping(value={"borrowList"},method=RequestMethod.GET)
	public String borrowVechile(Model model)
	{
		List<Vechile> vechiles=vechileService.getAll();
		model.addAttribute("vechiles", vechiles);
		return "borrowList";
	}
	@RequestMapping(value={"addVehicle"},method=RequestMethod.GET)
	public String addVechile(@ModelAttribute Vechile vechile,  Model model)
	{
		return "addVehicle";
	}
	@RequestMapping(value={"addVehicle"},method=RequestMethod.POST)
	public String saveVechile(@Valid@ModelAttribute("vechile") Vechile vechile,  BindingResult result,Model model)
	{
		Member member= new Member();
		member.setFirstName("Ahmad");
		vechile.setMember(member);
	//	vechileService.save(vechile);
		if(result.hasErrors())
			return "addVehicle";
		return "redirect:/userBorrowList";
	}
	@RequestMapping(value={"/userBorrowList"},method=RequestMethod.GET)
	public String userBorrowList( Model model)
	{
		return "userBorrowList";
	}
}
