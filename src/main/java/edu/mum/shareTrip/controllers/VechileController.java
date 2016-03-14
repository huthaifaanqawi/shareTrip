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

import edu.mum.shareTrip.domain.Vechile;
import edu.mum.shareTrip.service.VechileService;

@Controller
@RequestMapping("/userDashBoard")
public class VechileController {
     @Autowired
     VechileService vechileService;
	@RequestMapping(value={"/borrowVechiles"},method=RequestMethod.GET)
	public String borrowVechile(Model model)
	{
		List<Vechile> vechiles=vechileService.getAll();
		model.addAttribute("vechiles", vechiles);
		return "borrowVechiles";
	}
	@RequestMapping(value={"/addVechile"},method=RequestMethod.GET)
	public String addVechile(@ModelAttribute Vechile vechile,  Model model)
	{
		return "addVechile";
	}
	@RequestMapping(value={"/addVechile"},method=RequestMethod.POST)
	public String saveVechile(@Valid@ModelAttribute Vechile vechile,  Model model,BindingResult result)
	{
		if(result.hasErrors())
			return "addVechile";
		return "redirect:/userBorrowList";
	}
	@RequestMapping(value={"/userBorrowList"},method=RequestMethod.GET)
	public String userBorrowList( Model model)
	{
		return "userBorrowList";
	}
}
