package WorkingwithAbstractionLab;

import java.util.Scanner;

public class RhombusofStars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        printFirstHalf(n);
        printSecondHalf(n);
    }

    private static void printSecondHalf(int n) {
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i - 1; j++) {
                System.out.print("* ");
            }
            System.out.println("*");
        }
    }

    private static void printFirstHalf(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i - 1; j++) {
                System.out.print("* ");
            }
            System.out.println("*");
        }
    }
}
