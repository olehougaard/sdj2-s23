package dk.via.traffic.trafficlight;

public class YellowRed implements TrafficLightState {
    @Override
    public LightColor getColor() {
        return LightColor.RED_YELLOW;
    }

    @Override
    public void next(TrafficLight trafficLight) {
        trafficLight.turnOff(Lights.RED, Lights.YELLOW);
        trafficLight.turnOn(Lights.GREEN);
        trafficLight.setState(new Green());
    }
}
