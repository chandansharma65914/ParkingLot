package com.masai.vehicle;

public class Vehicle {

	private String registrationNumber;

	private VehicleType type;

	public Vehicle(String registrationNumber, VehicleType type) {
		super();
		this.registrationNumber = registrationNumber;

		this.type = type;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public VehicleType getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Vehicle [registrationNumber=" + registrationNumber + ", type=" + type + "]";
	}
    
}
