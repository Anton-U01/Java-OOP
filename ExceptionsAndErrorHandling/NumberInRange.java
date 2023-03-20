package ExceptionsAndErrorHandling;

import java.util.Scanner;

public class NumberInRange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] data = scan.nextLine().split(" ");
        System.out.printf("Range: [%s...%s]\n",data[0],data[1]);
        while (true){
            String line = scan.nextLine();
            try {
                int number = Integer.parseInt(line);
                if(number < Integer.parseInt(data[0]) || number > Integer.parseInt(data[1])){
                    System.out.println("Invalid number: " + number);
                } else {
                    System.out.println("Valid number: " + number);
                    return;
                }
            } catch (Exception e){
                System.out.println("Invalid number: " + line);
            }
        }
    }
}
