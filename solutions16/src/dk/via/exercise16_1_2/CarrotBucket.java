package dk.via.exercise16_1_2;

import java.util.LinkedList;
import java.util.Queue;

public class CarrotBucket {
    private final Queue<Carrot> carrots;

    public CarrotBucket() {
        this.carrots = new LinkedList<>();
    }

    public synchronized void put(Carrot carrot) throws InterruptedException {
        if (carrots.size() >= 20) {
            while(carrots.size() >= 4) {
                wait();
            }
        }
        carrots.add(carrot);
        notifyAll();
    }

    public synchronized Carrot take() throws InterruptedException {
        while(carrots.isEmpty()) {
            wait();
        }
        if (carrots.size() <= 4) {
            notifyAll();
        }
        return carrots.remove();
    }
}
