package com.masai.parking;

import java.util.HashMap;
import java.util.Map;

import com.masai.cost.CostStrategy;
import com.masai.vehicle.Vehicle;
import com.masai.vehicle.VehicleSpace;
import com.masai.vehicle.VehicleType;

public class ParkingLot {

	private int totalFloors;
	private int spacesPerFloor;
	private Map<Integer, Floor> floors;

	public ParkingLot(int totalFloors, int spacesPerFloor) {
		super();
		this.totalFloors = totalFloors;
		this.spacesPerFloor = spacesPerFloor;
		this.floors = new HashMap<>();
		initializeFloors();
	}
    private void initializeFloors() {
    	for (int i = 1; i <= totalFloors; i++) {
            Map<VehicleType, Integer> capacity = new HashMap<>();
            capacity.put(VehicleType.CAR, spacesPerFloor);
            capacity.put(VehicleType.BIKE, spacesPerFloor);
            capacity.put(VehicleType.TRUCK, spacesPerFloor);
            capacity.put(VehicleType.BUS, spacesPerFloor);
            floors.put(i, new Floor(i, capacity));
        }
    }
    public boolean isFull(VehicleType type) {
        return floors.values().stream().allMatch(floor -> floor.isFull(type));
    }
    
    public boolean addVehicle(Vehicle vehicle) {
    	for (Floor floor : floors.values()) {
            if (!floor.isFull(vehicle.getType())) {
                VehicleSpace space = floor.parkVehicle(vehicle.getType());
                if (space != null) {
                    System.out.println("Vehicle parked at space number: " + space.getSpaceNumber());
                    return true;
                }
            }
        }
        System.out.println("Parking lot is full for " + vehicle.getType() + ".");
        return false;
    }
    
    public void removeVehicle(VehicleType type, int spaceNumber) {
        floors.values().forEach(floor -> {
            if (floor.getAvailableSpaces(type) < spacesPerFloor) {
                floor.removeVehicle(spaceNumber);
            }
        });
    }
    
    public int calculateCost(VehicleType type, int hours) {
        return CostStrategy.getCost(type) * hours;
    }
}
