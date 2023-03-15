package dk.via.traffic_light;

public class Green implements State {
    @Override
    public void next(TrafficLight trafficLight) {
        trafficLight.turnOff(Lights.GREEN);
        trafficLight.turnOn(Lights.YELLOW);
        trafficLight.setState(new Yellow());
    }
}
