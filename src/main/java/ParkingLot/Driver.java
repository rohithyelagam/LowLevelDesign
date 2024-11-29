package ParkingLot;

import ParkingLot.Models.ParkingLot;
import ParkingLot.Services.ParkingLotManager;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        sc.next();

        ParkingLotManager parkingLotManager = new ParkingLotManager(new ParkingLot(sc.next(),sc.nextInt(), sc.nextInt()));

        sc.nextLine();

        String s = sc.next();

        while(!s.equals("exit")){
            String input = sc.nextLine().trim();
            switch (s) {
                case "display" -> parkingLotManager.display(input);
                case "park_vehicle" -> parkingLotManager.parkVehicle(input);
                case "unpark_vehicle" -> parkingLotManager.unParkVehicle(input);
            }
            s = sc.next().trim();
        }


    }
}
