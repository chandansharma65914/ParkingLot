package com.masai.vehicle;

import java.time.Instant;

public class ParkedVehicle {
	
	private int tokenNumber;
	
	private int floorNumber;
	
	private int spaceNumber;
	
	private Vehicle vehicle;
	
	private Instant entryTime;
	
	

	public ParkedVehicle(int tokenNumber, int floorNumber, int spaceNumber, Vehicle vehicle) {
		super();
		this.tokenNumber = tokenNumber;
		this.floorNumber = floorNumber;
		this.spaceNumber = spaceNumber;
		this.vehicle = vehicle;
		this.entryTime = Instant.now();
	}

	public int getTokenNumber() {
		return tokenNumber;
	}

	public void setTokenNumber(int tokenNumber) {
		this.tokenNumber = tokenNumber;
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public int getSpaceNumber() {
		return spaceNumber;
	}

	public void setSpaceNumber(int spaceNumber) {
		this.spaceNumber = spaceNumber;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Instant getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Instant entryTime) {
		this.entryTime = entryTime;
	}

	@Override
	public String toString() {
		return "ParkedVehicle [tokenNumber=" + tokenNumber + ", floorNumber=" + floorNumber + ", spaceNumber="
				+ spaceNumber + ", vehicle=" + vehicle + ", entryTime=" + entryTime + "]";
	}

	

	   
	

}
