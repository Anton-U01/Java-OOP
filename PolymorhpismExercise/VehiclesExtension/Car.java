package PolymorhpismExercise.VehiclesExtension;

public class Car extends Vehicle {

    public Car(double fuelQuantity,double fuelConsumption,double tankQuantity) {
        super(fuelQuantity,fuelConsumption + 0.9,tankQuantity);
    }


    @Override
    public boolean drive(double kilometers) {
        double neededFuel = kilometers * this.getFuelConsumption();
        if(this.getFuelQuantity() >= neededFuel){
            double leftFuel = this.getFuelQuantity() - neededFuel;
            this.setFuelQuantity(leftFuel);
            return true;
        }
        return false;
    }

    @Override
    public void refuel(double liters) {
        this.setFuelQuantity(this.getFuelQuantity() + liters);
    }

    public String toString(){
        return String.format("Car: %.2f",this.getFuelQuantity());
    }
}
