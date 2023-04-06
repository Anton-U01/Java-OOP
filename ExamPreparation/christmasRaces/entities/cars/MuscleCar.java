package christmasRaces.entities.cars;

import christmasRaces.common.ExceptionMessages;

public class MuscleCar extends BaseCar{
    public MuscleCar(String model, int horsePower) {
        super(model, horsePower, 5000);
    }

    @Override
    protected void checkHorsePower(int horsePower) {
        if(horsePower < 400 || horsePower > 600){
            String message = String.format(ExceptionMessages.INVALID_HORSE_POWER,horsePower);
            throw new IllegalArgumentException(message);
        }
    }
}
