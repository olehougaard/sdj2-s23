package dk.via.exercise16_1_2;

public class Carrot {
    private static int nextNumber = 0;

    private final int number;

    public Carrot() {
        this.number = nextNumber++;
    }

    @Override
    public String toString() {
        return "Carrot #" + number;
    }
}
