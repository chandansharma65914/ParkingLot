package com.masai.service;

import com.masai.exception.NoSpaceAvailableException;
import com.masai.exception.WrongDetailException;
import com.masai.vehicle.ParkedVehicle;
import com.masai.vehicle.Vehicle;
import com.masai.vehicle.VehicleType;

public interface ParkingService {

	

	public ParkedVehicle getParkedVehicleDetail(int tokenId) throws WrongDetailException;

	public String parkVehicle(int floorNumber, int spaceNumber, Vehicle vehicle);

	public String removeVehicle(ParkedVehicle parkedVehicle);

	public boolean checkAvailability(VehicleType type) throws NoSpaceAvailableException;

	public int checkCost(ParkedVehicle parkedVehicle);

	public void initializeParking(int totalFloor, int spacePerFloorPerVehicle);

}
