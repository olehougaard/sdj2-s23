package solutions2_6;

public class Customer implements Runnable {
    private final Bar bar;

    public Customer(Bar bar) {
        this.bar = bar;
    }

    public void run() {
        while(bar.isOpen()) {
            System.out.println("Waiting...");
            Beer beer = bar.takeBeer();
            if (beer == null) break;
            System.out.println("Drinking " + beer);
            try {
                //noinspection BusyWait
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Beer finished");
        }
        System.out.println("Customer going home");
    }
}
