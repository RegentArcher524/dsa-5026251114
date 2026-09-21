package lw01.unguided;

public class ProjectorRental extends Rental {
    public ProjectorRental(String id, int days,int units) {
        super(id, days,units);
    }

    @Override
    public int calculateCharge() {
        int days = getDays();
        int units = getUnits();
        if (days <= 3) {
            return units * ((days * 60000) + 20000);
        } else {
            return units * ((60000 * 3) + ((days - 3) * 45000) + 20000);
        }
    }

    @Override
    public String label() {
        return "Projector";
    }
}
