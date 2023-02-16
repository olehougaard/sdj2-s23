package dk.via.traffic.trafficlight;

public class Yellow implements TrafficLightState {
    @Override
    public LightColor getColor() {
        return LightColor.YELLOW;
    }

    @Override
    public void next(TrafficLight trafficLight) {
        trafficLight.turnOff(Lights.GREEN);
        trafficLight.turnOn(Lights.RED);
        trafficLight.setState(new Red());
    }
}
