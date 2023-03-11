package PolymorhpismExercise.Vehicles;

public class Truck extends Vehicle{
    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + 1.6);
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
        this.setFuelQuantity(this.getFuelQuantity() + 0.95 * liters);
    }
    public String toString(){
        return String.format("Truck: %.2f",this.getFuelQuantity());
    }
}
