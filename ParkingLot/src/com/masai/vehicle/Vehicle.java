package com.masai.vehicle;

public class Vehicle {
     
	private String registrationNumber;
	
	private String color;
	
	private VehicleType type;

	public Vehicle(String registrationNumber, String color, VehicleType type) {
		super();
		this.registrationNumber = registrationNumber;
		this.color = color;
		this.type = type;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public String getColor() {
		return color;
	}

	public VehicleType getType() {
		return type;
	}
	
	
}
