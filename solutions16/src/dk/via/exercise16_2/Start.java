package dk.via.exercise16_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Start {
    public static void main(String[] args) {
        AirportQueue domesticQueue = new AirportQueue();
        AirportQueue internationalQueue = new AirportQueue();
        Guide guide = new Guide(domesticQueue, internationalQueue);
        PassportController domesticController = new PassportController(domesticQueue);
        PassportController internationalController = new PassportController(internationalQueue);

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.submit(guide);
        executor.submit(domesticController);
        executor.submit(internationalController);
    }
}
