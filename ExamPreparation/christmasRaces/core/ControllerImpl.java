package christmasRaces.core;

import christmasRaces.common.ExceptionMessages;
import christmasRaces.common.OutputMessages;
import christmasRaces.core.interfaces.Controller;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.cars.MuscleCar;
import christmasRaces.entities.cars.SportsCar;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;
import christmasRaces.entities.races.Race;
import christmasRaces.entities.races.RaceImpl;
import christmasRaces.repositories.CarRepository;
import christmasRaces.repositories.DriverRepository;
import christmasRaces.repositories.RaceRepository;
import christmasRaces.repositories.interfaces.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller{
    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(DriverRepository driverRepository, CarRepository carRepository, RaceRepository raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driver) {
        if(driverRepository.getByName(driver) != null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_EXISTS,driver));
        }
        Driver driver1 = new DriverImpl(driver);
        driverRepository.add(driver1);
        return String.format(OutputMessages.DRIVER_CREATED,driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        if(carRepository.getByName(model) != null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAR_EXISTS,model));
        }
        Car car = null;
        switch (type){
            case "Muscle":
                car = new MuscleCar(model,horsePower);
                break;
            case "Sports":
                car = new SportsCar(model,horsePower);
                break;
        }
        carRepository.add(car);
        return String.format(OutputMessages.CAR_CREATED,type + "Car",model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        if(driverRepository.getByName(driverName) == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_FOUND,driverName));
        } else if(carRepository.getByName(carModel) == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAR_NOT_FOUND,carModel));
        }
        driverRepository.getByName(driverName).addCar(carRepository.getByName(carModel));
        return String.format(OutputMessages.CAR_ADDED,driverName,carModel);

    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        if(raceRepository.getByName(raceName) == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_NOT_FOUND,raceName));
        } else if (driverRepository.getByName(driverName) == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_FOUND,driverName));
        }
        raceRepository.getByName(raceName).addDriver(driverRepository.getByName(driverName));
        return String.format(OutputMessages.DRIVER_ADDED,driverName,raceName);
    }

    @Override
    public String startRace(String raceName) {
        if(raceRepository.getByName(raceName) == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_NOT_FOUND,raceName));
        }
        if (raceRepository.getByName(raceName).getDrivers().size() < 3){
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_INVALID,raceName,3));
        }
        Race race = raceRepository.getByName(raceName);
        int numberOfLaps = race.getLaps();
        List<Driver> winners = race.getDrivers().stream().sorted( (d1, d2) -> (int)(d2.getCar().calculateRacePoints(numberOfLaps) - d1.getCar().calculateRacePoints(numberOfLaps)))
                .limit(3)
                .collect(Collectors.toList());
        raceRepository.remove(race);
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(OutputMessages.DRIVER_FIRST_POSITION + "\n",winners.get(0).getName(),race.getName()));
        builder.append(String.format(OutputMessages.DRIVER_SECOND_POSITION + "\n",winners.get(1).getName(),race.getName()));
        builder.append(String.format(OutputMessages.DRIVER_THIRD_POSITION,winners.get(2).getName(),race.getName()));
        return builder.toString();
    }

    @Override
    public String createRace(String name, int laps) {
        if(raceRepository.getAll().contains(name)){
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_EXISTS,name));
        }
        Race race = new RaceImpl(name,laps);
        raceRepository.add(race);
        return String.format(OutputMessages.RACE_CREATED,name);
    }
}
