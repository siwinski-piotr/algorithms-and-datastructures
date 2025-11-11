import fare.FareCalculator;
import fare.Ticket;
import spot.ParkingManager;
import vehicle.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ParkingLot {

    private final ParkingManager parkingManager;
    private final FareCalculator fareCalculator;

    public ParkingLot(ParkingManager parkingManager, FareCalculator fareCalculator) {
        this.parkingManager = parkingManager;
        this.fareCalculator = fareCalculator;
    }

    public Ticket enterVehicle(Vehicle vehicle) {
        var spot = parkingManager.parkVehicle(vehicle);

        if (spot != null) {
            var ticket = new Ticket(
                    generateTicketId(),
                    vehicle,
                    spot,
                    LocalDateTime.now()
            );
            return ticket;
        } else {
            return null;
        }
    }

    public BigDecimal leaveVehicle(Ticket ticket) {
        if (ticket != null && ticket.getExitTime() == null) {
            ticket.setExitTime(LocalDateTime.now().plusMinutes(120));

            parkingManager.unparkVehicle(ticket.getVehicle());

            // calculate fare
            BigDecimal bigDecimal = fareCalculator.calculateFare(ticket);
            return bigDecimal;

        }
        return null;
    }

    // Helper method to generate a unique ticket ID
    private String generateTicketId() {
        return "TICKET-" + System.currentTimeMillis();
    }


}
