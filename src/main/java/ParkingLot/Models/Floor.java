package ParkingLot.Models;

import ParkingLot.Enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    int number;
    List<Slot> slots;
    int capacity;
    int filled;

    public Floor(int number,int capacity){
        this.number = number;
        this.capacity = capacity;
        this.slots = new ArrayList<>();
        this.generateSlots();
    }

    private void generateSlots(){
        for(int i=1;i<=this.capacity;i++){
            if(i==1){
                slots.add(new Slot(VehicleType.TRUCK, i));
            }else if(i<=3){
                slots.add(new Slot(VehicleType.BIKE,i));
            }else{
                slots.add(new Slot(VehicleType.CAR, i));
            }
        }
        this.filled = 0;
    }

    public void getFreeCount(VehicleType type){
        int count = 0;
        for(Slot s: slots){
            if(!s.getType().equals(type) || s.getIsOccupied())continue;
            count++;
        }
        System.out.println("No. of free slots for "+type.getDesc()+" on Floor "+this.number+": "+count);
    }

    public int getNumber(){
        return this.number;
    }

    public List<Slot> getSlots(){
        return this.slots;
    }

}
