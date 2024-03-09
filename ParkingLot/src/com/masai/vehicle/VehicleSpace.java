package com.masai.vehicle;

public class VehicleSpace {
	
	private int spaceNumber;
	
	private boolean isAvailable;
	
	private VehicleType type;

	public VehicleSpace(int spaceNumber,  VehicleType type) {
		super();
		this.spaceNumber = spaceNumber;
		this.isAvailable = true;
		this.type = type;
	}

	public int getSpaceNumber() {
		return spaceNumber;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}

	public VehicleType getType() {
		return type;
	}
	
	public void setAvailable(boolean available) {
		isAvailable = available;
	}
	

}
