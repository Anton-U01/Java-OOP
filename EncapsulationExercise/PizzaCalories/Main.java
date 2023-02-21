package EncapsulationExercise.PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] pizzaData = scan.nextLine().split(" ");
        String pizzaName = pizzaData[1];
        int toppingsCount = Integer.parseInt(pizzaData[2]);
        Pizza pizza = new Pizza(pizzaName,toppingsCount);
        String[] doughData = scan.nextLine().split(" ");
        String flourType = doughData[1];
        String bakingTechnique = doughData[2];
        double doughWeight = Double.parseDouble(doughData[3]);
        Dough dough = new Dough(flourType,bakingTechnique,doughWeight);
        pizza.setDought(dough);
        String line = scan.nextLine();
        while (!line.equals("END")){
            String[] toppingData = line.split(" ");
            String toppingType = toppingData[1];
            double toppingWeight = Double.parseDouble(toppingData[2]);
            Topping topping = new Topping(toppingType,toppingWeight);
            pizza.addTopping(topping);
            line = scan.nextLine();
        }
        System.out.println(pizza.getName() + " - " + String.format("%.2f",pizza.getOverallCalories()));
    }
}
