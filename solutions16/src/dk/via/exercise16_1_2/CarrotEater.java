package dk.via.exercise16_1_2;

public class CarrotEater implements Runnable {
    private final CarrotBucket queue;

    public CarrotEater(CarrotBucket queue) {
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
