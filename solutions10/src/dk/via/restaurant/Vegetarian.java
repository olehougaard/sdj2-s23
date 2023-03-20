package dk.via.restaurant;

public class Vegetarian extends Diner {
    public Vegetarian(String name) {
        super(name);
    }

    @Override
    protected Meal makeMeal() {
        return new VegetarianMeal();
    }
}
