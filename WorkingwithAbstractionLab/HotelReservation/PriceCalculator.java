package WorkingwithAbstractionLab.HotelReservation;

public class PriceCalculator {
    public static String finalPrice(double pricePerDay,int days,Season season,DiscountType discountType){
        return String.format("%.2f",pricePerDay * days * season.getMultiplier() * (1 - discountType.getDiscount()));
    }
}
