package WorkingwithAbstractionLab.HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] line = scan.nextLine().split(" ");
        double pricePerDay = Double.parseDouble(line[0]);
        int days = Integer.parseInt(line[1]);
        Season season = Season.valueOf(line[2]);
        DiscountType discountType = DiscountType.valueOf(line[3]);
        System.out.println(PriceCalculator.finalPrice(pricePerDay,days,season,discountType));
    }
}
