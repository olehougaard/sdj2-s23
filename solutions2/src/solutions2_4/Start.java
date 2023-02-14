package solutions2_4;

public class Start {
    private static void start(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public static void main(String[] args) throws InterruptedException {
        BurgerBar burgerBar = new BurgerBar(20);
        BurgerBarEmployee joe = new BurgerBarEmployee("Joe", burgerBar);
        BurgerBarEmployee liz = new BurgerBarEmployee("Liz", burgerBar);
        BurgerBarCustomer jack = new BurgerBarCustomer("Jack", burgerBar, 2);
        BurgerBarCustomer jill = new BurgerBarCustomer("Jill", burgerBar, 4);
        BurgerBarCustomer alex = new BurgerBarCustomer("Alex", burgerBar, 1);
        BurgerBarCustomer bobby = new BurgerBarCustomer("Bobby", burgerBar, 3);
        BurgerBarCustomer sarah = new BurgerBarCustomer("Sarah", burgerBar, 1);
        start(joe);
        start(liz);
        start(jack);
        start(jill);
        start(alex);
        start(bobby);
        start(sarah);
    }
}
