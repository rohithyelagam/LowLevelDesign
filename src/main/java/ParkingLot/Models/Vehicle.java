package ParkingLot.Models;

import ParkingLot.Enums.VehicleType;

public class Vehicle {
    VehicleType type;
    String regNo;
    String color;
    Ticket ticket;

    public Vehicle(VehicleType type, String regNo,String color){
        this.type = type;
        this.regNo = regNo;
        this.color = color;
        this.ticket = null;
    }

    public VehicleType getType() {
        return type;
    }

    public String getRegNo() {
        return regNo;
    }

    public String getColor() {
        return color;
    }

    public static VehicleType getVehicle(String s){
        return switch (s) {
            case "CAR" -> VehicleType.CAR;
            case "BIKE" -> VehicleType.BIKE;
            case "TRUCK" -> VehicleType.TRUCK;
            default -> null;
        };
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
