package dk.via.exercise16_1_1;

import java.util.concurrent.BlockingQueue;

public class CarrotEater implements Runnable {
    private final BlockingQueue<Carrot> queue;

    public CarrotEater(BlockingQueue<Carrot> queue) {
        this.queue = queue;
    }

    public void run() {
        while(true) {
            try {
                Carrot carrot = queue.take();
                System.out.println("Eating " + carrot);
                //noinspection BusyWait
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
