package edu.mum.shareTrip.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.shareTrip.domain.Member;

@Controller
public class UserController {
	
	@RequestMapping(value={"signUp"},method=RequestMethod.GET)
	public String inputMember(@ModelAttribute("member") Member member){
		return "signUp";
	}
	
	public String processMemberInfo(@Valid @ModelAttribute("member") Member memberToRegister,
			RedirectAttributes redirectAttributes,BindingResult bindingResult){
		
		return "";
	}
}
