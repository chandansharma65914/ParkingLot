
package com.masai;

import com.masai.parking.ParkingLot;
import com.masai.vehicle.Vehicle;
import com.masai.vehicle.VehicleType;

public class Main {
	public static void main(String[] args) {

		ParkingLot parkingLot = new ParkingLot(5, 10);

		// Check availability
		VehicleType typeToCheck = VehicleType.CAR;
		if (parkingLot.isFull(typeToCheck)) {
			System.out.println("Parking is full for " + typeToCheck);
		} else {
			System.out.println("Parking is available for " + typeToCheck);
		}
		
		

		// Add vehicles
		Vehicle car1 = new Vehicle("ABC123", "Red", VehicleType.CAR);

		Vehicle car2 = new Vehicle("XYZ456", "Blue", VehicleType.CAR);

		parkingLot.addVehicle(car1);

		parkingLot.addVehicle(car2);

		// Remove a vehicle
		parkingLot.removeVehicle(VehicleType.CAR, 1);

		// Calculate cost
		int cost = parkingLot.calculateCost(VehicleType.CAR, 2);

		System.out.println("Total cost: ₹" + cost);
	}
}
