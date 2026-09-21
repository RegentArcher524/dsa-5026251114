package lw01.unguided;

public abstract class Rental implements Chargable {
    private String id;
    private int days;
    private int unit;

    protected Rental(String id, int days,int unit) {
        this.id = id;
        this.days = days;
        this.unit = unit;
    }

    public int getUnits() {
        return unit;
    }

    public String getId() {
        return id;
    }

    public int getDays() {
        return days;
    }

    public abstract int calculateCharge();

    public int calculateCharge(int units) {
        return units * calculateCharge();
    }

    public String label() {
        return "Rental";
    }

    public String summary() {
        return id + " | " + label() + " | " + calculateCharge();
    }
}
