package ParkingLot.Enums;

public enum VehicleType {
    CAR("CAR"),
    BIKE("BIKE"),
    TRUCK("TRUCK");

    private String type;

    VehicleType(String type){
        this.type = type;
    }

    public String getDesc(){
        return this.type;
    }
}
