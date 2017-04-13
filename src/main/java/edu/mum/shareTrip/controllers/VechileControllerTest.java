package edu.mum.shareTrip.controllers;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import edu.mum.shareTrip.domain.Member;
import edu.mum.shareTrip.domain.Rental;
import edu.mum.shareTrip.domain.Vechile;
import edu.mum.shareTrip.exceptions.PlateNumberFoundException;
import edu.mum.shareTrip.exceptions.UserNotHaveVechileExpction;
import edu.mum.shareTrip.service.MemberService;











@Controlle
@RequestMapping("userDashBoard")
public class VechileController {
      @Autowired
     VechileService vechileService;
      @Autowired MemberService memberService;
     @RequestMapping(value={"borrowList"},method=RequestMethod.GET)
	public String borrowVechile(Model model)
	{
		List<Vechile> vechiles=vechileService.getAvialble();
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
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); 
		Member member = memberService.getMemberByUserName(name);
	newvechile.setMember(member);
	newvechile=vechileService.save(newvechile);
//		MultipartFile vechileImage = newvechile.getVechileImage();
//		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
//		newvechile=vechileService.save(newvechile);
//			if (vechileImage!=null && !vechileImage.isEmpty()) {
//		       try {
//		    	   vechileImage.transferTo(new File(rootDirectory+"\\resources\\images\\"+newvechile.getId() + ".png"));
//		       } catch (Exception e) {
//				throw new RuntimeException(" Image saving failed", e);
//		   }}
//		
		return "redirect:userBorrowList";
	}
	@RequestMapping(value={"userBorrowList"},method=RequestMethod.GET)
	public String userBorrowList( Model model)
	{
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	String name = auth.getName(); 
	Member member = memberService.getMemberByUserName(name);
	List<Vechile> vechiles=vechileService.getUserVehicles(member.getId());
		model.addAttribute("vechiles", vechiles);
		return "userBorrowList";
	}
	@RequestMapping(value={"/checkPlate/{plateNumber}"} ,method=RequestMethod.GET)
	public @ResponseBody JsonResponse  checkifowner(@PathVariable("plateNumber")  String plateNumber,Model model,@ModelAttribute Rental rental){
JsonResponse res= new JsonResponse();
	if(vechileService.CheckPlateFound(plateNumber).equals(null))
			{
		res.setStatus("nocar");
		throw  new PlateNumberFoundException();
			}
	else {
		res.setStatus("hascar");
	}
	return  res;
	}

}
//hello huthayfa
//hello ahmed
//hello doaa.
//hello moath.
