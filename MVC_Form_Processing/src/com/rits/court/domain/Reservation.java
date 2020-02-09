package com.rits.court.domain;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Reservation {
	@NotEmpty(message="courtName must be not null")
	@Size(min=5,max=7,message="Must be min 5 characters max 7 chars")
	private String courtName;
	private Date date;
    @Min(2)
	private int hour;
    @Valid
	private Player player;
    @Valid
	private SportType sportType;
	
	public Reservation() {
		
	}
	
	public Reservation(String courtName, Date date, int hour, Player player,
			SportType sportType) {
		super();
		this.courtName = courtName;
		this.date = date;
		this.hour = hour;
		this.player = player;
		this.sportType = sportType;
	}

	public String getCourtName() {
		return courtName;
	}
	@Override
	public String toString() {
		return "Rservation [courtName=" + courtName + ", hour=" + hour + ", Date= "+date+",player= "+player+ "]";
	}
	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}
	public Date getDate() {
		//String dt[] =
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public SportType getSportType() {
		return sportType;
	}
	public void setSportType(SportType sportType) {
		this.sportType = sportType;
	}
	

}
