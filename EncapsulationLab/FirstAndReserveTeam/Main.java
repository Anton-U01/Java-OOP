package EncapsulationLab.FirstAndReserveTeam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");
            people.add(new Person(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3])));
        }
        Team team = new Team("Black Eagles");
        for (Person person : people) {
            team.addPlayer(person);
        }
        System.out.println("First team  have " + team.getFirstTeam().size() + " players");
        System.out.println("Reserve team have " + team.getReserveTeam().size() + " players");
    }
}