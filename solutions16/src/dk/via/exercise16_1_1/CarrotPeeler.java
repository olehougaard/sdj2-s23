package dk.via.exercise16_1_1;

import java.util.concurrent.BlockingQueue;

public class CarrotPeeler implements Runnable {
    private final BlockingQueue<Carrot> queue;

    public CarrotPeeler(BlockingQueue<Carrot> queue) {
        this.queue = queue;
    }

    public void run() {
        while(true) {
            try {
                Carrot carrot = new Carrot();
                System.out.println("Peeled " + carrot);
                queue.put(carrot);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
