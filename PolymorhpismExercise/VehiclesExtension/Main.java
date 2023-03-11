package PolymorhpismExercise.VehiclesExtension;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] carInfo = scan.nextLine().split(" ");
        Vehicle car = new Car(Double.parseDouble(carInfo[1]),Double.parseDouble(carInfo[2]),Double.parseDouble(carInfo[3]));
        String[] truckInfo = scan.nextLine().split(" ");
        Vehicle truck = new Truck(Double.parseDouble(truckInfo[1]),Double.parseDouble(truckInfo[2]),Double.parseDouble(truckInfo[3]));
        String[] busInfo = scan.nextLine().split(" ");
        Bus bus = new Bus(Double.parseDouble(busInfo[1]),Double.parseDouble(busInfo[2]),Double.parseDouble(busInfo[3]));
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] line = scan.nextLine().split(" ");
            String command = line[0];
            double value = Double.parseDouble(line[2]);
            DecimalFormat decimalFormat = new DecimalFormat("##.##");
            switch (command){
                case "Drive":
                    if(line[1].equals("Car")){
                        if(car.drive(value)){
                            System.out.printf("Car travelled %s km\n",decimalFormat.format(value));
                        } else {
                            System.out.println("Car needs refueling");
                        }
                    } else if(line[1].equals("Truck")){
                        if(truck.drive(value)){
                            System.out.printf("Truck travelled %s km\n",decimalFormat.format(value));
                        } else {
                            System.out.println("Truck needs refueling");
                        }
                    } else {
                        if(bus.driveWithPeople(value)){
                            System.out.printf("Bus travelled %s km\n",decimalFormat.format(value));
                        } else {
                            System.out.println("Bus needs refueling");
                        }
                    }
                    break;

                case "Refuel":
                    if (value <= 0){
                        System.out.println("Fuel must be a positive number");
                        continue;
                    }
                    if(line[1].equals("Car")){
                        car.refuel(value);
                    }else if(line[1].equals("Truck")){
                        truck.refuel(value);
                    } else {
                        bus.refuel(value);
                    }

                    break;
                case "DriveEmpty":
                        if(bus.drive(value)){
                            System.out.printf("Bus travelled %s km\n",decimalFormat.format(value));
                        } else {
                            System.out.println("Bus needs refueling");

                        }
                    break;
            }
        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());
    }
}
