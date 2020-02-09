package com.rits.court.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class Player{
	@NotNull(message="Name cannot be null")
	@Size(min=1, message="Palyer name can not be blank")
	private String name;
	
	@Size(max=10, min=10, message="Phone Number should be of 10 digits")
	private String phone;
	public String getName(){
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Player(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}
	public Player(){}

}
