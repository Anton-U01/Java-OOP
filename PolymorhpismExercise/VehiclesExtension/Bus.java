package PolymorhpismExercise.VehiclesExtension;

public class Bus extends Vehicle{

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
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

    public boolean driveWithPeople(double kilometers){
        double currentConsumption = this.getFuelConsumption() + 1.4;
        double neededFuel = kilometers * currentConsumption;
        if(this.getFuelQuantity() >= neededFuel){
            double leftFuel = this.getFuelQuantity() - neededFuel;
            this.setFuelQuantity(leftFuel);
            return true;
        }
        return false;
    }
    public String toString(){
        return String.format("Bus: %.2f",this.getFuelQuantity());
    }

}
