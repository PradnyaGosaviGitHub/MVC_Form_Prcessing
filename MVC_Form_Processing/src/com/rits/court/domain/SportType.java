package com.rits.court.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class SportType {

	private int id;
	
	@NotNull(message="Name must be not null")
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public SportType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
