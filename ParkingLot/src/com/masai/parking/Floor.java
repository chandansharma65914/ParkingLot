package com.masai.parking;

import java.util.HashMap;
import java.util.Map;

import com.masai.vehicle.VehicleSpace;
import com.masai.vehicle.VehicleType;

public class Floor {

	private int floorNumber;

	private Map<VehicleType, Integer> capacity;

	private Map<Integer, VehicleSpace> spaces;

	public Floor(int floorNumber, Map<VehicleType, Integer> capacity) {
		super();
		this.floorNumber = floorNumber;
		this.capacity = capacity;
		this.spaces = new HashMap<>();
		initializeSpaces();
	}
	

	private void initializeSpaces() {

		for (Map.Entry<VehicleType, Integer> entry : capacity.entrySet()) {
			VehicleType type = entry.getKey();
			int spaceCount = entry.getValue();
			for (int i = 1; i <= spaceCount; i++) {
				spaces.put(i, new VehicleSpace(floorNumber,i,type));
			}
		}
	}


	public int getFloorNumber() {
		return floorNumber;
	}


	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}


	public Map<VehicleType, Integer> getCapacity() {
		return capacity;
	}


	public void setCapacity(Map<VehicleType, Integer> capacity) {
		this.capacity = capacity;
	}


	public Map<Integer, VehicleSpace> getSpaces() {
		return spaces;
	}


	public void setSpaces(Map<Integer, VehicleSpace> spaces) {
		this.spaces = spaces;
	}
   

}
