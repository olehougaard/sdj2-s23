package dk.via.traffic;

import dk.via.traffic.trafficlight.TrafficLight;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        TrafficLight light = new TrafficLight();
        TrafficlightRunner runner = new TrafficlightRunner(light);
        Thread lightThread = new Thread(runner);
        lightThread.start();
        Car carA = new Car("A");
        Car carB = new Car("B");
        Car carC = new Car("C");
        Driver driverA = new Driver(carA);
        Driver driverB = new Driver(carB);
        Driver driverC = new Driver(carC);
        carA.start();
        carB.start();
        carC.start();
        Thread.sleep(1000);
        light.addPropertyChangeListener(driverA);
        light.addPropertyChangeListener(driverB);
        Thread.sleep(2000);
        light.addPropertyChangeListener(driverC);
    }
}
