package dk.via.exercise16_2;

import java.util.LinkedList;
import java.util.Queue;

public class AirportQueue implements PassengerQueue {
    private final Queue<Passenger> passengerQueue;

    public AirportQueue() {
        this.passengerQueue = new LinkedList<>();
    }

    public synchronized void putPassengerInQueue(Passenger passenger) {
        passengerQueue.add(passenger);
        notifyAll();
    }

    public synchronized Passenger getNextPassenger() throws InterruptedException {
        while (passengerQueue.isEmpty()) {
            wait();
        }
        return passengerQueue.remove();
    }
}
