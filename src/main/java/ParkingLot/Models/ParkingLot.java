package ParkingLot.Models;

import ParkingLot.Enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    String id;
    List<Floor> floors;

    public ParkingLot(String id,int floorsCount, int capacity){
        this.id = id;
        this.floors = new ArrayList<>();
        for(int i=1;i<=floorsCount;i++){
            floors.add(new Floor(i,capacity));
        }
        System.out.println("Created parking lot with "+floorsCount+" floors and "+capacity+" slots per floor");
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void getFreeSlots(VehicleType type){
        for(Floor f: floors){
            System.out.print("Free slots for "+type.getDesc()+" on Floor "+f.number+": ");
            List<Integer> freeSlots = new ArrayList<>();
            for(Slot s: f.slots){
                if(!s.getType().getDesc().equals(type.getDesc()) || s.isOccupied)continue;
                freeSlots.add(s.getNumber());
            }
            for(int i=0;i<freeSlots.size();i++){
                System.out.print(freeSlots.get(i)+((i!=freeSlots.size()-1)?(","):("")));
            }
            System.out.println();
        }
    }

    public void getOccupiedSlots(VehicleType type){
        for(Floor f: floors) {
            System.out.print("Occupied slots for " + type.getDesc() + " on Floor " + f.number + ": ");
            List<Integer> occupiedSlots = new ArrayList<>();
            for (Slot s : f.slots) {
                if (!s.getType().equals(type) || !s.isOccupied) continue;
                occupiedSlots.add(s.getNumber());
            }
            for(int i=0;i<occupiedSlots.size();i++){
                System.out.print(occupiedSlots.get(i)+((i!=occupiedSlots.size()-1)?(","):("")));
            }
            System.out.println();
        }
    }

    public void getFreeCount(VehicleType type){
        for(Floor f: floors){
            f.getFreeCount(type);
        }
    }

    public void freeSlot(Floor floor, Slot slot){
        this.floors.stream().filter(f -> f.getNumber() == floor.getNumber()).forEach(ff -> {
            ff.getSlots().stream().filter(ss -> ss.getNumber() == slot.getNumber()).forEach(s -> {
                s.setOccupied(false);
            });
        });
    }

}
