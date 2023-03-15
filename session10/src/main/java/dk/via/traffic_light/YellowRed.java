package dk.via.traffic_light;

public class YellowRed implements State {
    @Override
    public void next(TrafficLight trafficLight) {
        trafficLight.turnOff(Lights.YELLOW, Lights.RED);
        trafficLight.turnOn(Lights.GREEN);
        trafficLight.setState(new Green());
    }
}
