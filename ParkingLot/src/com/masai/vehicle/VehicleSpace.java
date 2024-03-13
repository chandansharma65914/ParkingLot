package com.masai.vehicle;

public class VehicleSpace {
	private int floorNumber;
	
	private int spaceNumber;
	
	private boolean isAvailable;
	
	private VehicleType type;

	public VehicleSpace(int floorNumber, int spaceNumber,  VehicleType type) {
		super();
		this.floorNumber = floorNumber;
		this.spaceNumber = spaceNumber;
		this.isAvailable = true;
		this.type = type;
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

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
	}

    

}
