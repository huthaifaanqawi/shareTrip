package edu.mum.shareTrip.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.shareTrip.domain.Member;
import edu.mum.shareTrip.service.MemberService;

@Controller
public class UserController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value={"/signUp"},method=RequestMethod.GET)
	public String inputMember(@ModelAttribute("member") Member member){
		return "signUp";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String processMemberInfo(@Valid @ModelAttribute("member") Member memberToRegister,
			BindingResult bindingResult,Model model,RedirectAttributes redirectAttributes){
		if(bindingResult.hasErrors()){
			return "signUp";
		}
		memberService.saveMember(memberToRegister);
		
		return "signUp";
	}
}
