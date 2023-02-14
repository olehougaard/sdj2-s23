package solutions2_4;

public class BurgerBarEmployee implements Runnable {
    private String name;
    private BurgerBar burgerBar;

    public BurgerBarEmployee(String name, BurgerBar burgerBar) {
        this.name = name;
        this.burgerBar = burgerBar;
    }

    public void run() {
        while(true) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            burgerBar.makeBurger(name);
        }
    }
}
