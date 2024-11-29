package ParkingLot.Services;

import ParkingLot.Enums.VehicleType;
import ParkingLot.Models.ParkingLot;
import ParkingLot.Models.Ticket;
import ParkingLot.Models.Vehicle;
import ParkingLot.Strategy.SlotFind1;
import ParkingLot.Strategy.SlotFindStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotManager {

    ParkingLot parkingLot;
    Map<Ticket, Vehicle> vehicles;
    SlotFindStrategy slotFindStrategy;

    public ParkingLotManager(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
        slotFindStrategy = new SlotFind1();
    }

    public void parkVehicle(String s){
        String[] input = s.split(" ");
        String regNo = input[1];
        String color = input[2];
        VehicleType vehicleType = Vehicle.getVehicle(input[0]);

        Vehicle vehicle = new Vehicle(vehicleType,regNo,color);
        Ticket t = slotFindStrategy.findSlot(parkingLot,vehicle);
        if(t==null){
            System.out.println("Parking Lot Full");
            return;
        }
        vehicle.setTicket(t);
        System.out.println("Parked vehicle. Ticket ID: "+t.getId());
    }

    public void unParkVehicle(String s){
        Vehicle v = null;
        Ticket t = null;
        for(Map.Entry<Ticket, Vehicle> m : vehicles.entrySet()){
            if(m.getKey().getId().equals(s)){
                v = m.getValue();
                t = m.getKey();
                break;
            }
        }
        if(v == null){
            System.out.println("Invalid Ticket");
            return;
        }
        System.out.println("Unparked vehicle with Registration Number: "+v.getRegNo()+" and Color: "+v.getColor());
        vehicles.remove(t);
        parkingLot.freeSlot(v.getTicket().getFloor(), v.getTicket().getSlot());
        v.setTicket(null);
    }

    public void getFreeSlots(VehicleType type){
        parkingLot.getFreeSlots(type);
    }

    public void getOccupiedSlots(VehicleType type){
        parkingLot.getOccupiedSlots(type);
    }

    public void getFreeCount(VehicleType type){
        parkingLot.getFreeCount(type);
    }

    public void display(String s) {
        String[] input = s.split(" ");
        String type = input[0];
        VehicleType vehicleType = Vehicle.getVehicle(input[1]);
        switch (type){
            case "free_count":
                getFreeCount(vehicleType);
                return;
            case "free_slots":
                getFreeSlots(vehicleType);
                return;
            case "occupied_slots":
                getOccupiedSlots(vehicleType);
        }
    }



}
