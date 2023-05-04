package dk.via.exercise16_2;

import java.util.Random;

public class Passenger {
    private final String nationality;
    private final int passportNumber;

    private final static String[] NATIONALITIES = {"US", "DK", "UK", "DE"};

    public static Passenger random() {
        Random random = new Random();
        String nationality = NATIONALITIES[random.nextInt(NATIONALITIES.length)];
        int passportNumber = random.nextInt(900_000_000) + 100_000_000;
        return new Passenger(nationality, passportNumber);
    }

    public Passenger(String nationality, int passportNumber) {
        this.nationality = nationality;
        this.passportNumber = passportNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public String toString() {
        return "{" + nationality + ", " + passportNumber + "}";
    }
}
