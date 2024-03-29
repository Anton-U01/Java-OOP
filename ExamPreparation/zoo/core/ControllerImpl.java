package zoo.core;

import zoo.common.ConstantMessages;
import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.animals.TerrestrialAnimal;
import zoo.entities.areas.Area;
import zoo.entities.areas.LandArea;
import zoo.entities.areas.WaterArea;
import zoo.entities.foods.Food;
import zoo.entities.foods.Meat;
import zoo.entities.foods.Vegetable;
import zoo.repositories.FoodRepository;
import zoo.repositories.FoodRepositoryImpl;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private FoodRepository foodRepository;
    private Collection<Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new ArrayList<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {
        Area area;
        switch (areaType){
            case "WaterArea":
                area = new WaterArea(areaName);
                break;
            case "LandArea":
                area = new LandArea(areaName);
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_AREA_TYPE);
        }
        areas.add(area);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AREA_TYPE,areaType);
    }

    @Override
    public String buyFood(String foodType) {
        Food food;
        switch (foodType){
            case "Vegetable":
                food = new Vegetable();
                break;
            case "Meat":
                food = new Meat();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_FOOD_TYPE);
        }
        foodRepository.add(food);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_TYPE,foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Food food;
        switch (foodType){
            case "Vegetable":
                food = new Vegetable();
                break;
            case "Meat":
                food = new Meat();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.NO_FOOD_FOUND);
        }
        Area area = null;
        for (Area area1 : areas) {
            if(area1.getName().equals(areaName)){
                area = area1;
                break;
            }
        }
        area.addFood(food);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_IN_AREA,foodType,areaName);
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Animal animal;
        switch (animalType){
            case "AquaticAnimal":
                animal = new AquaticAnimal(animalName,kind,price);
                break;
            case "TerrestrialAnimal":
                animal = new TerrestrialAnimal(animalName,kind,price);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_ANIMAL_TYPE);
        }
        Area area = null;
        for (Area area1 : areas) {
            if(area1.getName().equals(areaName)){
                area = area1;
                break;
            }
        }
        switch (area.getClass().getSimpleName()){
            case "WaterArea":
                if(area.getAnimals().size() >= 10){
                    return ExceptionMessages.NOT_ENOUGH_CAPACITY;
                }
                if(animal.getClass().getSimpleName().equals("TerrestrialAnimal")){
                    return ConstantMessages.AREA_NOT_SUITABLE;
                }
                break;
            case "LandArea":
                if(area.getAnimals().size() >= 25){
                    return ExceptionMessages.NOT_ENOUGH_CAPACITY;
                }
                if(animal.getClass().getSimpleName().equals("AquaticAnimal")){
                    return ConstantMessages.AREA_NOT_SUITABLE;
                }
                break;
        }
        area.addAnimal(animal);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_ANIMAL_IN_AREA,animalType,areaName);
    }

    @Override
    public String feedAnimal(String areaName) {
        Area area = null;
        for (Area area1 : areas) {
            if(area1.getName().equals(areaName)){
                area = area1;
                break;
            }
        }
        area.feed();
        return String.format(ConstantMessages.ANIMALS_FED,area.getAnimals().size());
    }

    @Override
    public String calculateKg(String areaName) {
        double totalKgs = 0;
        Area area = null;
        for (Area area1 : areas) {
            if (area1.getName().equals(areaName)) {
                area = area1;
                break;
            }
        }
        for (Animal animal : area.getAnimals()) {
            totalKgs += animal.getKg();
        }
        return String.format(ConstantMessages.KILOGRAMS_AREA,areaName,totalKgs);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Area area : areas) {
            sb.append(area.getInfo());
        }
        return sb.toString();
    }
}
