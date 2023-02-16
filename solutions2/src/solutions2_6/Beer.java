package solutions2_6;

import java.util.Random;

public class Beer {
    private final int number;

    public Beer() {
        Random random = new Random();
        this.number = random.nextInt();
    }

    @Override
    public String toString() {
        return String.format("beer %d", number);
    }
}
