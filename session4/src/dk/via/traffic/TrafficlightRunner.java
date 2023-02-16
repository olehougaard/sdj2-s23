package dk.via.traffic;

import dk.via.traffic.trafficlight.TrafficLight;

public class TrafficlightRunner implements Runnable {
    private TrafficLight trafficLight;

    public TrafficlightRunner(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    @Override
    public void run() {
        try {
            while(true) {
                Thread.sleep(1000);
                trafficLight.next();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
