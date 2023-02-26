package InterfacesandAbstractionLab.BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        List <Robot>robots = new ArrayList<>();
        List <Citizen> citizens = new ArrayList<>();
        while (!line.equals("End")){
            String[] data = line.split("\\s++");
            if(data.length == 3){
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String id = data[2];
                Citizen citizen = new Citizen(name,age,id);
                citizens.add(citizen);
            } else {
                String model = data[0];
                String id = data[1];
                Robot robot = new Robot(id,model);
                robots.add(robot);
            }
            line = scan.nextLine();
        }
        String lastDigits = scan.nextLine();
        for (Citizen citizen : citizens) {
            if(citizen.getId().endsWith(lastDigits)){
                System.out.println(citizen.getId());
            }
        }
        for (Robot robot : robots) {
            if(robot.getId().endsWith(lastDigits)){
                System.out.println(robot.getId());
            }
        }
    }
}
