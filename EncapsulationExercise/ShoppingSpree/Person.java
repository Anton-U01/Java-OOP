package EncapsulationExercise.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        products = new ArrayList<>();
    }

    private void setName(String name) {
        if(name.length() < 1 || name.contains(" ")){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if(money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void buyProduct(Product product){
        if(product.getCost() > this.getMoney()){
            System.out.println(this.getName() + " can't afford " + product.getName());
        } else {
            products.add(product);
            this.money -= product.getCost();
            System.out.println(this.getName() + " bought " + product.getName());
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getMoney() {
        return money;
    }
}
