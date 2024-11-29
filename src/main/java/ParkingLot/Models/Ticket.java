package ParkingLot.Models;

public class Ticket {
    String id;
    ParkingLot parkingLot;
    Floor floor;
    Slot slot;
    public Ticket(ParkingLot lot, Floor floor, Slot slot){
        this.id = lot.id+"_"+floor.getNumber()+"_"+slot.getNumber();
        this.parkingLot = lot;
        this.floor = floor;
        this.slot = slot;
    }

    public String getId(){
        return id;
    }

    public Floor getFloor() {
        return floor;
    }

    public Slot getSlot() {
        return slot;
    }
}
