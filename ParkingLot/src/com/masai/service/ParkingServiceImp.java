package com.masai.service;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import com.masai.cost.CostStrategy;
import com.masai.exception.NoSpaceAvailableException;
import com.masai.exception.WrongDetailException;
import com.masai.parking.Floor;
import com.masai.parking.ParkingLot;
import com.masai.vehicle.ParkedVehicle;
import com.masai.vehicle.Vehicle;
import com.masai.vehicle.VehicleSpace;
import com.masai.vehicle.VehicleType;

public class ParkingServiceImp implements ParkingService {

	ParkingLot parkingLot;

	Map<Integer, ParkedVehicle> parkedVehicles;

	public ParkingServiceImp(int totoalFloor, int spacePerFloorPerVehicle) {
		super();
		initializeParking(totoalFloor, spacePerFloorPerVehicle);
		this.parkedVehicles = new HashMap<>();
	}

	@Override
	public String parkVehicle(int floorNumber, int spaceNumber, Vehicle vehicle) throws WrongDetailException, NoSpaceAvailableException {
		Map<Integer, Floor> floors = parkingLot.getFloors();

		if (floors.containsKey(floorNumber)) {

			Floor floor = floors.get(floorNumber);

			if (floor.getSpaces().containsKey(spaceNumber)) {
				VehicleSpace vehicleSpace = floor.getSpaces().get(spaceNumber);

				if (vehicleSpace.getType() == vehicle.getType()) {
					vehicleSpace.setAvailable(false);
					floor.getSpaces().put(spaceNumber, vehicleSpace);
					floors.put(floorNumber, floor);
					parkingLot.setFloors(floors);
					int size = parkedVehicles.size() + 1;
					parkedVehicles.put(size, new ParkedVehicle(size, floorNumber, spaceNumber, vehicle));
					System.out.println("<******************************************************************->");
					System.out.println("Your TokenNumber is " + size );
					System.out.println("Vehicle Parked At floorNumber :" + floorNumber  );
					System.out.println("Vehicle Parked At spaceNumber :" + spaceNumber  );
					return "Parked Sucessfully";

				} else {
					throw new NoSpaceAvailableException("No space Available for this VehiclType , Please check Availibility");
				}
			} else {
				throw new WrongDetailException("Invalid Space Number , Please check Availibility");
			}
		} else {
			throw new WrongDetailException("Invalid Floor Number , Please check Availibility");
		}
	}

	@Override
	public String removeVehicle(ParkedVehicle parkedVehicle) {

		if (!parkedVehicles.containsKey(parkedVehicle.getTokenNumber())) {
			return "wrong Token Number";
		}

		Map<Integer, Floor> totalFloors = parkingLot.getFloors();

		Floor floor = totalFloors.get(parkedVehicle.getFloorNumber());

		VehicleSpace vehicleSpace = floor.getSpaces().get(parkedVehicle.getSpaceNumber());

		vehicleSpace.setAvailable(true);

		parkedVehicles.remove(parkedVehicle.getTokenNumber());

		return "vehicle removed. Thanks for using this parking System";

	}

	@Override
	public boolean checkAvailability(VehicleType type) throws NoSpaceAvailableException {

		boolean flag = false;

		boolean printOrNot = true;

		Map<Integer, Floor> floors = parkingLot.getFloors();

		for (var floor : floors.values()) {
			Map<Integer, VehicleSpace> vehicleSpace = floor.getSpaces();

			for (var space : vehicleSpace.values()) {
				if (space.getType() == type) {

					if (space.isAvailable()) {
						flag = true;
						if (flag && printOrNot) {
							System.out.println("All available space for Vehicle :" + type);

							System.out.println("Please notedown floorNumber and spaceNumber");
							printOrNot = false;
						}
						System.out.println("****************************************");
						System.out.println("Floor Number " + floor.getFloorNumber());

						System.out.println("Space Number " + space.getSpaceNumber());
						System.out.println("****************************************");

					}

				}
			}
		}
		if (!flag) {
			throw new NoSpaceAvailableException("There is no space available for vehicle " + type);
		}
		return flag;
	}

	@Override
	public int checkCost(ParkedVehicle parkedVehicle) {
		Instant exitTime = Instant.now();
		Duration duration = Duration.between(parkedVehicle.getEntryTime(), exitTime);
		// Total hours including days
		long totalHours = duration.toHours();
		long remainingMinutes = duration.minusHours(totalHours).toMinutes();
		// Round up to the next hour if there are remaining minutes
		if (remainingMinutes >= 0) {
			totalHours++;
		}

		return CostStrategy.getCost(parkedVehicle.getVehicle().getType()) * (int) totalHours;

	}

	@Override
	public void initializeParking(int totalFloor, int spacePerFloorPerVehicle) {
		parkingLot = new ParkingLot(totalFloor, spacePerFloorPerVehicle);

	}

	public Map<Integer, ParkedVehicle> getParkedVehicles() {
		return parkedVehicles;
	}

	public void setParkedVehicles(Map<Integer, ParkedVehicle> parkedVehicles) {
		this.parkedVehicles = parkedVehicles;
	}

	@Override
	public ParkedVehicle getParkedVehicleDetail(int tokenId) throws WrongDetailException {
		if (!parkedVehicles.containsKey(tokenId)) {
			throw new WrongDetailException("please enter valid enput");
		}

		return parkedVehicles.get(tokenId);
	}

}
