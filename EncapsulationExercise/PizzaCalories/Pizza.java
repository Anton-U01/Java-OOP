package EncapsulationExercise.PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dought;

    private List<Topping> toppings;

    public Pizza(String name,int numberOfToppings) {
        if(numberOfToppings < 1 || numberOfToppings > 10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.setName(name);
        this.toppings = new ArrayList<>();
    }


    private void setName(String name) {
        if(name.length() < 1 || name.contains(" ") || name.length() > 15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setDought(Dough dought) {
        this.dought = dought;
    }

    public String getName() {
        return name;
    }

    public void addTopping(Topping topping){
        this.toppings.add(topping);
    }
    public double getOverallCalories(){
        double calories = 0.0;
        for (Topping topping : toppings) {
            calories += topping.calculateCalories();
        }
        calories += dought.calculateCalories();
        return calories;
    }
}
