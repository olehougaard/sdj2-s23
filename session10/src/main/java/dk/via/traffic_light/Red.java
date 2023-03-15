package dk.via.traffic_light;

public class Red implements State {
    @Override
    public void next(TrafficLight trafficLight) {
        trafficLight.turnOn(Lights.YELLOW);
        trafficLight.setState(new YellowRed());
    }
}
