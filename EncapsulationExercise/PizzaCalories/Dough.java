package EncapsulationExercise.PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    protected double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if(!(flourType.equals("White") || flourType.equals("Wholegrain"))){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if(!(bakingTechnique.equals("Crispy") || bakingTechnique.equals("Chewy") || bakingTechnique.equals("Homemade"))){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if(weight < 1 || weight > 200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public String getFlourType() {
        return flourType;
    }

    public double getWeight() {
        return weight;
    }

    public String getBakingTechnique() {
        return bakingTechnique;
    }

    public double calculateCalories(){
        double modifier = 0.0;
        switch (getFlourType()){
            case "White":
                modifier = 1.5;
                break;
            case "Wholegrain":
                modifier = 1.0;
                break;
        }
        switch (getBakingTechnique()){
            case "Crispy":
                modifier *= 0.9;
                break;
            case "Chewy":
                modifier *= 1.1;
                break;
            case "Homemade":
                modifier *= 1.0;
                break;
        }
        return modifier * 2 * getWeight();
    }
}
