package zoo.repositories;

import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;

public class FoodRepositoryImpl implements FoodRepository{
    private Collection<Food> foods;

    public FoodRepositoryImpl() {
        this.foods = new ArrayList<>();
    }


    @Override
    public void add(Food food) {
        foods.add(food);
    }

    @Override
    public boolean remove(Food food) {
        if(foods.contains(food)){
            foods.remove(food);
            return true;
        }
        return false;
    }

    @Override
    public Food findByType(String type) {
        for (Food food : foods) {
            if(food.getClass().getSimpleName().equals(type)){
                return food;
            }
        }
        return null;
    }
}
