package zoo.entities.areas;

import zoo.entities.animals.Animal;

import java.util.stream.Collectors;

public class LandArea extends BaseArea{

    public LandArea(String name) {
        super(name, 25);
    }


    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (%s):",getName(),getClass().getSimpleName())).append(System.lineSeparator());
        sb.append("Animals: ");
        if(getAnimals().isEmpty()){
            sb.append("none").append(System.lineSeparator());
        }else {
            String string = getAnimals().stream().map(Animal::getName).collect(Collectors.joining(" "));
            sb.append(string).append(System.lineSeparator());
        }
        sb.append(String.format("Foods: %d",getFoods().size())).append(System.lineSeparator());
        sb.append(String.format("Calories: %d",sumCalories())).append(System.lineSeparator());
        return sb.toString();
    }
}
