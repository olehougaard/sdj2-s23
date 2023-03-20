package dk.via.restaurant;

import java.util.Random;

public class Omnivore extends Diner {

    private final Random random;

    public Omnivore(String name) {
        super(name);
        random = new Random();
    }

    @Override
    protected Meal makeMeal() {
        if (random.nextBoolean()) {
            return new VegetarianMeal();
        } else {
            return new Beef();
        }
    }
}
