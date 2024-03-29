package christmasRaces.repositories;

import christmasRaces.entities.cars.Car;
import christmasRaces.repositories.interfaces.Repository;

import java.util.*;

public class CarRepository implements Repository<Car> {
    private Map<String,Car> cars;

    public CarRepository() {
        this.cars = new LinkedHashMap<>();
    }

    @Override
    public Car getByName(String name) {
        return cars.get(name);
    }

    @Override
    public Collection<Car> getAll() {
        return Collections.unmodifiableCollection(cars.values());
    }

    @Override
    public void add(Car car) {
        cars.put(car.getModel(),car);
    }

    @Override
    public boolean remove(Car car) {
        if(cars.containsKey(car.getModel())){
            cars.remove(car.getModel());
            return true;
        }
        return false;
    }
}
