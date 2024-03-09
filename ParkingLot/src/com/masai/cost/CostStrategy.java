package com.masai.cost;

import com.masai.vehicle.VehicleType;

public class CostStrategy {
    
	private static final int BIKE_COST = 10;
	
	private static final int CAR_COST = 20;
	
	private static final int TRUCK_COST = 30;
	
	private static final int BUS_COST = 30;
	
	
	public static int getCost(VehicleType type) {
		
		switch(type) {
		case CAR : return CAR_COST;
		case BUS : return BUS_COST;
		case TRUCK : return TRUCK_COST;
		default :  return BIKE_COST;
		}
	}
}
