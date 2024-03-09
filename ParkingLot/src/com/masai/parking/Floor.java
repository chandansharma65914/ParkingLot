package com.masai.parking;

import java.util.HashMap;
import java.util.Map;

import com.masai.vehicle.VehicleSpace;
import com.masai.vehicle.VehicleType;

public class Floor {
   
	private int floorNumber;
	
	private Map<VehicleType,Integer> capacity;
	
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
                spaces.put(i, new VehicleSpace(i, type));
            }
        }
	}
	public int getFloorNumber() {
		return floorNumber;
	}
	
	public boolean isFull(VehicleType type) {
		 return spaces.values().stream()
	                .filter(space -> space.getType() == type)
	                .noneMatch(VehicleSpace::isAvailable);
	}
	
	public int getAvailableSpaces(VehicleType type) {
		 return (int) spaces.values().stream()
	                .filter(space -> space.getType() == type && space.isAvailable())
	                .count();
	}
	
	public VehicleSpace parkVehicle(VehicleType type) {
		for (VehicleSpace space : spaces.values()) {
            if (space.getType() == type && space.isAvailable()) {
                space.setAvailable(false);
                return space;
            }
        }
        return null;
	}
	
	public void removeVehicle(int spaceNumber) {
		VehicleSpace space = spaces.get(spaceNumber);
        if (space != null) {
            space.setAvailable(true);
            
        }
	}
}
