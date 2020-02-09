package com.rits.court.service;
import java.util.List;

import com.rits.court.domain.*;

public interface ReservationService {
	public List<Reservation>  query(String courtName);
    public void makeReservation(Reservation reservation);
    public SportType TENNIS = new SportType(1,"Tennis");
    public SportType BADMINTON = new SportType(2,"Badminton");
    public SportType CRICKET = new SportType(3,"Cricket");
}
