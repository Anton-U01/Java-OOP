package WorkingwithAbstractionExercise.TrafficLights;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] signals = scan.nextLine().split(" ");
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < signals.length; j++) {
                TrafficLights lights = TrafficLights.valueOf(signals[j]);
                System.out.print(lights.getSignal() + " ");
                signals[j] = lights.getSignal();
            }
            System.out.println();
        }
    }
}
