package dk.via.restaurant;

public abstract class Diner {
    private final String name;

    public Diner(String name) {
        this.name = name;
    }

    public void eatMeal(Meal meal) {
        System.out.println(name + " ate " + meal);
    }

    protected abstract Meal makeMeal();

    public void makeAndEatMeal() {
        Meal meal = makeMeal();
        eatMeal(meal);
    }
}
