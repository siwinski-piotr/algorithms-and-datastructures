package spot;

import vehicle.Vehicle;
import vehicle.VehicleSize;

public class RegularSpot implements ParkingSpot {

    private final int spotNumber;
    private Vehicle vehicle = null;

    public RegularSpot(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    @Override
    public boolean isAvailable() {
        return vehicle == null;
    }

    @Override
    public void occupy(Vehicle vehicle) {
        if (isAvailable()) {
            this.vehicle = vehicle;
        } else {
            // spot already occupied...
        }
    }

    @Override
    public void vacate() {
        this.vehicle = null;
    }

    @Override
    public int getSpotNumber() {
        return 0;
    }

    @Override
    public VehicleSize getSize() {
        return VehicleSize.MEDIUM;
    }
}
