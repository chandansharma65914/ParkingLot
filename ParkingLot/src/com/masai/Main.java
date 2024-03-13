
package com.masai;

import java.util.Scanner;

import com.masai.exception.NoSpaceAvailableException;
import com.masai.exception.WrongDetailException;
import com.masai.service.ParkingService;
import com.masai.service.ParkingServiceImp;
import com.masai.vehicle.Vehicle;
import com.masai.vehicle.VehicleType;

public class Main {
	private static ParkingService parkingService;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("<********************-Welcome to the Parking Lot System********************->");
		System.out.println();

		// Initialize the parking lot
		initializeParkingLot(sc);

		while (true) {
			System.out.println("<****************************************->");
			System.out.println("Please select an option:");
			System.out.println("1. Add vehicle");
			System.out.println("2. Remove vehicle");
			System.out.println("3. Check availability");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				addVehicle(sc);
				break;
			case 2:
				removeVehicle(sc);
				break;
			case 3:
				checkAvailability(sc);
				break;
			case 4:
				System.out.println("Thank you for using the Parking Lot System!");
				sc.close();
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private static void initializeParkingLot(Scanner sc) {
		System.out.print("Enter the number of floors: ");
		int totalFloors = sc.nextInt();
		System.out.print("Enter the number of spaces per floor: ");
		int capacityPerFloor = sc.nextInt();
		parkingService = new ParkingServiceImp(totalFloors, capacityPerFloor);
		System.out.println("<****************************************->");
		System.out.println("Parking lot initialized with " + totalFloors + " floors and " + capacityPerFloor
				+ " spaces per floor.");

		System.out.println();
	}

	private static void addVehicle(Scanner scanner) {
		try {
			System.out.print("Enter the vehicle registration number: ");
			String registrationNumber = scanner.nextLine();
			System.out.print("Enter the vehicle type in UpperCase(CAR, BUS, TRUCK, BIKE): ");
			String input = scanner.nextLine().toUpperCase();

			VehicleType vehicleType = VehicleType.valueOf(input);
			System.out.println("Selected vehicle type: " + vehicleType);
			Vehicle vehicle = new Vehicle(registrationNumber,vehicleType);
			
			System.out.print("Enter the floor Number: ");
			int floorNumber = scanner.nextInt();
			
			System.out.print("Enter the space Number: ");
			int spaceNumber = scanner.nextInt();
			
			
			parkingService.parkVehicle(floorNumber, spaceNumber, vehicle);

			System.out.println("Vehicle added successfully.");
		} catch (Exception e) {
			System.out.println("An error occurred while adding the vehicle.");
			e.printStackTrace();
		}
	}
	private static void checkAvailability(Scanner sc) {
		System.out.print("Enter the vehicle type in UpperCase(CAR, BUS, TRUCK, BIKE): ");
		String input = sc.nextLine().toUpperCase();

		VehicleType vehicleType = VehicleType.valueOf(input);
		try {
			parkingService.checkAvailability(vehicleType);
		} catch (NoSpaceAvailableException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}

	}

	private static void removeVehicle(Scanner sc) {
		
		System.out.print("Enter the token Number: ");
		int tokenNumber = sc.nextInt();
		
		try {
			parkingService.removeVehicle(parkingService.getParkedVehicleDetail(tokenNumber));
		} catch (WrongDetailException e) {
			System.out.println(e.getMessage());
		}

	}

	
}
