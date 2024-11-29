package ParkingLot.Strategy;

import ParkingLot.Models.ParkingLot;
import ParkingLot.Models.Ticket;
import ParkingLot.Models.Vehicle;

public interface SlotFindStrategy {
    public Ticket findSlot(ParkingLot parkingLot, Vehicle vehicle);
}
