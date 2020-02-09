package com.rits.court.web;

import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class WelcomeController {
	@RequestMapping("/welcome")
	String welcome(Model model){
		Date dt = new Date();
		model.addAttribute("sachin", dt);
		System.out.println("hello !!!!!!!!");
		return "welcome";
	}
}
