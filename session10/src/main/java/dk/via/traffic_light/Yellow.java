package dk.via.traffic_light;

public class Yellow implements State{
    @Override
    public void next(TrafficLight trafficLight) {
        trafficLight.turnOff(Lights.YELLOW);
        trafficLight.turnOn(Lights.RED);
        trafficLight.setState(new Red());
    }
}
