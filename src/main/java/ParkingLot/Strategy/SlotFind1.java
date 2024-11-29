package ParkingLot.Strategy;

import ParkingLot.Models.*;

public class SlotFind1 implements SlotFindStrategy{
    @Override
    public Ticket findSlot(ParkingLot parkingLot, Vehicle vehicle) {
        Ticket ticket = null;
        for(Floor f: parkingLot.getFloors()){
            for(Slot s: f.getSlots()){
                if(!s.getIsOccupied() && s.getType().getDesc().equals(vehicle.getType().getDesc())){
                    ticket = new Ticket(parkingLot,f,s);
                    s.setOccupied(true);
                    return ticket;
                }
            }
        }
        return ticket;
    }
}
