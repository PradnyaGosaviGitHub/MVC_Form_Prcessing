package com.rits.court.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rits.court.domain.Reservation;
import com.rits.court.service.ReservationService;

@Controller
public class ReservationQueryController {
	@Resource(name="xyz")
	ReservationService service;
	@RequestMapping(value="/enquiry",method=RequestMethod.POST)
	
	//**Model** The object of HttpServletRequest reads the information provided by the user and pass it to the Model interface.
	//a view page easily accesses the data from the model part
     String reservationEnquiry(Model model,@RequestParam("courtName") String courtName,HttpServletRequest req){
		//@RequestParam annotation is used to read the form data and bind it automatically to the parameter 
		//present in the provided method
		System.out.println("hello again");
    	 List<Reservation> list =service.query(courtName);
    	 System.out.println(courtName+" "+list.size());
    	 System.out.println("Request param is "+req.getParameter("courtName"));
    	 System.out.println("List "+list);
    	 
    	 //it binds the attribute with the provided name.
    	 model.addAttribute("reservations",list);
    	 
    	//returns reservationQuery it goes to viewResolver and find the route to reservationQuery.jsp and print on browser
    	 return "reservationQuery";
     }
	@RequestMapping("/enquiry")
	String showForm(){
		
		//returns reservationQuery it goes to viewResolver and find the route to reservationQuery.jsp and print on browser
		return "reservationQuery";
	}
}
