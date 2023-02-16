package solutions2_6;

public class Bartender implements Runnable {
    private final Bar bar;

    public Bartender(Bar bar) {
        this.bar = bar;
    }

    public void run() {
        while(bar.isOpen()) {
            System.out.println("Pouring...");
            try {
                //noinspection BusyWait
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Beer beer = new Beer();
            bar.placeBeer(beer);
            System.out.println("Beer ready");
        }
        System.out.println("Bartender going home");
    }
}
