package dk.via.exercise16_1_2;

public class CarrotPeeler implements Runnable {
    private final CarrotBucket queue;

    public CarrotPeeler(CarrotBucket queue) {
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
