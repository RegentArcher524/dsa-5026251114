package lw01.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(Main.class.getResourceAsStream("rentals.txt"));
        int n = input.nextInt();
        Object[] rentals = new Object[n];
        int i = 0;

        for (int j = 0; j < n; j++) {
            String type = input.next();
            String id = input.next();
            int days = input.nextInt();
            int units = input.nextInt();
            if (days <= 0) {
                throw new IllegalArgumentException("Days must be greater than 0");
            }
            if (units <= 0) {
                throw new IllegalArgumentException("Units must be greater than 0");
            }
            if (type.equals("LAPTOP")) {
                rentals[i] = new LaptopRental(id, days, units);
            } else if (type.equals("PROJECTOR")) {
                rentals[i] = new ProjectorRental(id, days, units);
            }
            i++;
        }

        for(Object rental : rentals) {
            System.out.println(((Rental) rental).summary());
        }
        input.close();
    }
}
