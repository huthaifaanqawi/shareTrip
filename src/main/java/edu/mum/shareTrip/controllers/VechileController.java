package edu.mum.shareTrip.controllers;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
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
	
	File uploadedFile = null; 
		String rootDirectory = request.getSession().getServletContext() .getRealPath("/");
		MultipartFile image = newvechile.getVechileImage();
		System.out.println(image.getSize());
		newvechile=vechileService.save(newvechile);
	if (image != null && !image.isEmpty()) { 
				try { 
			uploadedFile = new File(rootDirectory + "/resources/images/" 
						+  newvechile.getId()+ ".jpg"); 
		image.transferTo(uploadedFile); 
		} catch (Exception e) { 
			throw new RuntimeException("Product Image saving failed", e); 
	} 
			}
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
