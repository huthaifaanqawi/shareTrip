package edu.mum.shareTrip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userDashBorad")
public class UserController {

	@RequestMapping(value={"/","welcome"})
	public String welcome(){
		return "welcome";
	}

}
