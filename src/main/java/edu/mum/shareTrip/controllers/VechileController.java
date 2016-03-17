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
import org.springframework.web.multipart.MultipartFile;

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
	public String saveVechile(@Valid@ModelAttribute("vechile") Vechile newvechile,  BindingResult result,HttpServletRequest request)
	{
		if(result.hasErrors())
			{
			return "addVehicle";
			}
	Member member=new Member();
	member.setId(1);
	newvechile.setMember(member);
	newvechile=vechileService.save(newvechile);

		MultipartFile vechileImage = newvechile.getVechileImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		newvechile=vechileService.save(newvechile);
			if (vechileImage!=null && !vechileImage.isEmpty()) {
		       try {
		    	   vechileImage.transferTo(new File(rootDirectory+"\\resources\\images\\"+newvechile.getId() + ".png"));
		       } catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
		   }}
		
		return "redirect:/borrowList";
	}
	@RequestMapping(value={"/userBorrowList"},method=RequestMethod.GET)
	public String userBorrowList( Model model)
	{
	List<Vechile> vechiles=vechileService.getUserVehicles(1);
		model.addAttribute("vechiles", vechiles);
		return "userBorrowList";
	}
    

}
