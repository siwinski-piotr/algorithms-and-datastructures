package spot;

import vehicle.Vehicle;
import vehicle.VehicleSize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingManager {

    private final Map<VehicleSize, List<ParkingSpot>> availableSpots;
    private final Map<Vehicle, ParkingSpot> vehicleToSpotMap = new HashMap<>();


    public ParkingManager(Map<VehicleSize, List<ParkingSpot>> availableSpots) {
        this.availableSpots = availableSpots;
    }

    ParkingSpot findSpotForVehicle(Vehicle vehicle) {
        var vehicleSize = vehicle.getSize();

        // Start looking from the smallest spot that can fit the vehicle
        for (var size : VehicleSize.values()) {
            if (size.ordinal() >= vehicleSize.ordinal()) {
                var spots = availableSpots.get(size);
                for (ParkingSpot spot : spots) {
                    if (spot.isAvailable()) {
                        return spot;
                    }
                }
            }
        }
        // cant find appropriate spot
        return null;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle) {
        var spot = findSpotForVehicle(vehicle);
        if (spot != null) {
            spot.occupy(vehicle);
            vehicleToSpotMap.put(vehicle, spot);
            availableSpots.get(spot.getSize()).remove(spot);
            return spot;
        }
        return null;
    }

    public void unparkVehicle(Vehicle vehicle) {
        ParkingSpot parkingSpot = vehicleToSpotMap.get(vehicle);
        if (parkingSpot != null) {
            parkingSpot.vacate();
            availableSpots.get(parkingSpot.getSize()).add(parkingSpot);
        }
    }

    public ParkingSpot findVehicleSpot(Vehicle vehicle) {
        return vehicleToSpotMap.get(vehicle);
    }


}
