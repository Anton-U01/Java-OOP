package WorkingwithAbstractionLab.HotelReservation;

public enum DiscountType {
    VIP(0.20),
    SecondVisit(0.1),
    None(0.0);
    private double discount;

    DiscountType(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
}
