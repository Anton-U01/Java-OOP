package PolymorhpismExercise.VehiclesExtension;

public abstract class Vehicle {

    private double tankCapacity;
    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption,double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
       this.tankCapacity = tankCapacity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        if(fuelQuantity + this.fuelQuantity > tankCapacity){
            System.out.println("Cannot fit fuel in tank");
        }else if (fuelQuantity < 0){
            System.out.println("Fuel must be a positive number");
        }else {
            this.fuelQuantity = fuelQuantity;
        }

    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public abstract boolean drive(double kilometers);
    public abstract void refuel(double liters);

    public double getTankCapacity() {
        return tankCapacity;
    }
}
