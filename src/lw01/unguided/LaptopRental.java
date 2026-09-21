package lw01.unguided;

public class LaptopRental extends Rental {

    public LaptopRental(String id, int days,int units) {
        super(id, days,units);
    }

    @Override
    public int calculateCharge() {
        int units = getUnits();
        return units * ((getDays() * 40000) + 10000);
    }

    @Override
    public String label() {
        return "Laptop";
    }
    
}
