package ExceptionsAndErrorHandling;

import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            int n = Integer.parseInt(scan.nextLine());
            System.out.printf("%.2f\n",Math.sqrt(n));
        } catch (Exception e){
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }

    }
}
