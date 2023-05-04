package dk.via.exercise16_2;

import java.util.Random;

public class Guide implements Runnable {
    private final AirportQueue domesticQueue;
    private final AirportQueue internationalQueue;

    public Guide(AirportQueue domesticQueue, AirportQueue internationalQueue) {
        this.domesticQueue = domesticQueue;
        this.internationalQueue = internationalQueue;
    }

    public void run() {
        Random random = new Random();
        while(true) {
            try {
                //noinspection BusyWait
                Thread.sleep(random.nextInt(500) + 500);
                Passenger passenger = Passenger.random();
                if ("US".equals(passenger.getNationality())) {
                    domesticQueue.putPassengerInQueue(passenger);
                } else {
                    internationalQueue.putPassengerInQueue(passenger);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
