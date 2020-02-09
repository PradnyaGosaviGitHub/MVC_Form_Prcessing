package com.rits.court.service;



import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rits.court.domain.Player;
import com.rits.court.domain.Reservation;
@Component
public class ReservationServiceImpl implements ReservationService {
	private List<Reservation> reservations;
	@Override
	public void makeReservation(Reservation reservation) {
		System.out.println("Impl makeReservation Called");
		reservations.add(reservation);	
	}
	ReservationServiceImpl(){
		reservations = new ArrayList<Reservation>();
		reservations.add(new Reservation("TennisCourt#1",new GregorianCalendar(2011,6,13).getTime(),16,new Player("Vivek","9860632616"),TENNIS));
		reservations.add(new Reservation("KabaddiCourt#2",new GregorianCalendar(2011,6,13).getTime(),16,new Player("Pankaj","9860632616"),CRICKET));
		reservations.add(new Reservation("TennisCourt#2",new GregorianCalendar(2011,6,13).getTime(),17,new Player("Krishna","9860632616"),TENNIS));
	}
	@Override
	public List<Reservation> query(String courtName) {
		List<Reservation> result=new ArrayList<Reservation>();
		if(courtName.equals("*")){
			return reservations;
		}else{
			for(Reservation reservation : reservations){
				if(reservation.getCourtName().equalsIgnoreCase(courtName)){
					result.add(reservation);
				}
			}
		}
		return result;
	}
}
