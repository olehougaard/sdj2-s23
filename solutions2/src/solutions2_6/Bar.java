package solutions2_6;

import java.util.ArrayList;

public class Bar {
    private final ArrayList<Beer> beers;
    private final int capacity;
    private boolean isOpen;

    public Bar(int capacity) {
        this.beers = new ArrayList<>();
        this.capacity = capacity;
        this.isOpen = true;
    }

    public synchronized void placeBeer(Beer beer) {
        while(isOpen && beers.size() == capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (isOpen) {
            beers.add(beer);
            notifyAll();
        }
    }

    public synchronized Beer takeBeer() {
        while(isOpen && beers.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (isOpen) {
            Beer beer = beers.remove(0);
            notifyAll();
            return beer;
        }
        return null;
    }

    public synchronized void close() {
        isOpen = false;
        notifyAll();
    }

    public boolean isOpen() {
        return isOpen;
    }
}
