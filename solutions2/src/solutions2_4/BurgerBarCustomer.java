package solutions2_4;

public class BurgerBarCustomer implements Runnable {
    private String name;
    private BurgerBar burgerBar;
    private int burgersToEat;

    public BurgerBarCustomer(String name, BurgerBar burgerBar, int burgersToEat) {
        this.name = name;
        this.burgerBar = burgerBar;
        this.burgersToEat = burgersToEat;
    }

    public void run() {
        for(int i = 0; i < burgersToEat; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            burgerBar.eatBurger(name);
        }
    }
}
