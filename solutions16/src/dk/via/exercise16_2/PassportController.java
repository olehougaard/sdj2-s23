package dk.via.exercise16_2;

import java.util.Random;

public class PassportController implements Runnable {
    private final AirportQueue passengers;

    public PassportController(AirportQueue passengers) {
        this.passengers = passengers;
    }

    public void run() {
        Random random = new Random();
        while(true) {
            try {
                Passenger passenger = passengers.getNextPassenger();
                System.out.println(passenger.getPassportNumber());
                //noinspection BusyWait
                Thread.sleep(random.nextInt(500) + 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
