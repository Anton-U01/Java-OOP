package InheritanceExercise.animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        while (!line.equals("Beast!")){
            String animalType = line;
            Animal animal = null;
            String[] animalInfo = scan.nextLine().split(" ");
            String name = animalInfo[0];
            int age = Integer.parseInt(animalInfo[1]);
            String gender = animalInfo[2];
            try {
                switch (animalType){
                    case "Cat":
                        animal = new Cat(name,age,gender);
                        break;
                    case "Dog":
                        animal = new Dog(name,age,gender);
                        break;
                    case "Frog":
                        animal = new Frog(name,age,gender);
                        break;
                    case "Kitten":
                        animal = new Kitten(name,age,gender);
                        break;
                    case "Tomcat":
                        animal = new Tomcat(name,age,gender);
                        break;
                    default:
                        continue;
                }
                System.out.println(animal);
                animal.produceSound();
            } catch (IllegalArgumentException ex){
                System.out.println("Invalid input!");
            }

            line = scan.nextLine();
        }
    }
}
