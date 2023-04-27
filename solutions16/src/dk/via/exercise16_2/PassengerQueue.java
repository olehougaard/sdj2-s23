package dk.via.exercise16_2;

public interface PassengerQueue {
    void putPassengerInQueue(Passenger p);
    Passenger getNextPassenger() throws InterruptedException;
}
