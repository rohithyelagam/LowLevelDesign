package ParkingLot.Models;

import ParkingLot.Enums.VehicleType;

public class Slot {
    VehicleType type;
    int number;
    boolean isOccupied;

    Slot(VehicleType type,int number){
        this.type = type;
        this.number = number;
    }

    public void setOccupied(boolean occupied){
        this.isOccupied = occupied;
    }

    public boolean getIsOccupied(){
        return  this.isOccupied;
    }


    public VehicleType getType() {
        return type;
    }

    public int getNumber(){
        return number;
    }
}
