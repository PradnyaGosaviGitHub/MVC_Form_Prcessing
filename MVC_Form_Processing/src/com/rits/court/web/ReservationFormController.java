package com.rits.court.web;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rits.court.domain.Player;
import com.rits.court.domain.Reservation;
import com.rits.court.service.ReservationService;

@Controller
@RequestMapping("/ ")
//@SessionAttributes("reservation")
public class ReservationFormController {
	
   public ReservationFormController(){
		
	}
	@Autowired
	ReservationService service;
	//create validator factor which returns validator
	static ValidatorFactory factory=Validation.buildDefaultValidatorFactory();
	
	@RequestMapping(method=RequestMethod.GET)
	String showForm(Model model){
		Reservation reservation = new Reservation();
		System.out.println("Reservation : "+reservation);
		model.addAttribute("res",reservation);
		//returns reservationForm to DispatcherServlet and DispatcherServlet goes to reservationForm.jsp
		
		return "reservationForm";
	}
	@RequestMapping(method=RequestMethod.POST)
	String makeReservation(HttpServletRequest request, @RequestParam(required=false,value="date") String dt,@ModelAttribute("res")Reservation reservation,BindingResult result){
		HttpSession session = request.getSession(false);
		if(session!=null){
		System.out.println("Session is "+session.getId());
		}
		/*List<ObjectError> errors = result.getAllErrors();
		System.out.println("Errors "+errors.size());
		if(errors.size()>0){
			//return "reservationForm";
		}*/
	/*	for(ObjectError err : errors){
			System.out.println(" Error "+err.getDefaultMessage());
		}*/
		if(valid(reservation,result)){
			service.makeReservation(reservation);
			return "reservationSuccess";
		}
		
			/*String date = dt;
			SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date dat = sdt.parse(date);
				reservation.setDate(dat);
				return "reservationSuccess";
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "reservationSuccess";
			}
		}else{
			System.out.println("Failed to Parse");
		}*/
		return "reservationForm";

	}
	private boolean valid(Reservation reservation,BindingResult result) {
	//	return true;
		
		//it validates the bean instance
		Validator validator = factory.getValidator();
		
	//	Player player = reservation.getPlayer();
		
		//it validates the bean(here it validates the reservation class members) 
		Set<ConstraintViolation<Reservation>> violations = validator.validate(reservation);
		//Set<ConstraintViolation<Player>> violationsPlayer = validator.validate(reservation.getPlayer());

		if(violations.size()==0 )
			return true;
		
		//ConstraintViolation is a interface and reservation is a custom class.
		//it returns the constraint(metadata about the failure), failure messages and the path of property which has validated
		
		for(ConstraintViolation<Reservation> violation : violations){
			String constraint = violation.getConstraintDescriptor().toString();
			String message = violation.getMessage();
			String propertyPath = violation.getPropertyPath().toString();
			
			System.out.println("DEBUG : validation failed "+constraint+"  "+propertyPath+" "+message);

			result.addError(new FieldError("Reservation", propertyPath, message));
		}
		/*for(ConstraintViolation<Player> violation : violationsPlayer){
			String constraint = violation.getConstraintDescriptor().toString();
			String message = violation.getMessage();
			String propertyPath = violation.getPropertyPath().toString();
			System.out.println("DEBUG : validation failed "+constraint+"  "+propertyPath+" "+message);

			result.addError(new FieldError("Player", "player."+propertyPath, message));
		}*/
		return false;
	}

}
