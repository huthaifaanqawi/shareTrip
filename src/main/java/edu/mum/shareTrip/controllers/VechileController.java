package edu.mum.shareTrip.controllers;


import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import edu.mum.shareTrip.domain.Vechile;
import edu.mum.shareTrip.service.RentalService;
import edu.mum.shareTrip.service.VechileService;

@Controller
public class VechileController {
      @Autowired
     VechileService vechileService;
      RentalService rentalService;
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
	public String saveVechile(@Valid@ModelAttribute("vechile") Vechile newvechile,  BindingResult result,HttpServletRequest request)
	{
		if(result.hasErrors())
			{
			return "addVehicle";
			}
		MultipartFile vechileImage = newvechile.getVechileImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		System.out.println(rootDirectory);
		newvechile.setId(vechileService.save(newvechile).getId());
		
		//isEmpty means file exists BUT NO Content
			if (vechileImage!=null && !vechileImage.isEmpty()) {
		       try {
		    	   vechileImage.transferTo(new File(rootDirectory+"\\resources\\images\\"+newvechile.getId() + ".png"));
		       } catch (Exception e) {
				throw new RuntimeException("Vechile Image saving failed", e);
		   }
		   }
  	vechileService.save(newvechile);
		if(result.hasErrors())
			return "addVehicle";
		return "redirect:/userBorrowList";
	}
	@RequestMapping(value={"/userBorrowList"},method=RequestMethod.GET)
	public String userBorrowList( Model model)
	{
		return "userBorrowList";
	}
@RequestMapping(value="rent", method=RequestMethod.PUT)
public @ResponseBody String rent(@RequestParam("id")int id)
	{
	
		return "Message";
	}
}
