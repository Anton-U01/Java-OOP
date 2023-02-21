package EncapsulationExercise.ShoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] personData = scan.nextLine().split(";");
        Map<String,Person> personList = new LinkedHashMap<>();
        for (String person : personData) {
            String[] dataOfPerson = person.split("=");
            String name = dataOfPerson[0];
            double money = Double.parseDouble(dataOfPerson[1]);
            Person person1 = new Person(name,money);
            personList.put(name,person1);
        }
        String[] productData = scan.nextLine().split(";");
        Map<String,Product> productList = new LinkedHashMap<>();
        for (String product : productData) {
            String[] dataOfProduct = product.split("=");
            String name = dataOfProduct[0];
            double cost = Double.parseDouble(dataOfProduct[1]);
            Product product1 = new Product(name,cost);
            productList.put(name,product1);
        }
        String command = scan.nextLine();
        while (!command.equals("END")){
            String person = command.split(" ")[0];
            String productName = command.split(" ")[1];
            Product product = productList.get(productName);
            personList.get(person).buyProduct(product);
            command = scan.nextLine();
        }
        for (Map.Entry<String, Person> entry : personList.entrySet()) {
            if(entry.getValue().getProducts().size() != 0){
                System.out.print(entry.getKey() + " - ");
                String separator = "";
                for (Product product : entry.getValue().getProducts()) {
                    System.out.print(separator + product.getName());
                    separator = ", ";
                }
                System.out.println();
            } else {
                System.out.print(entry.getKey() + " - Nothing bought");
            }
        }
    }
}
