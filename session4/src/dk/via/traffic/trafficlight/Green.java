package dk.via.traffic.trafficlight;

public class Green implements TrafficLightState {
    @Override
    public LightColor getColor() {
        return LightColor.GREEN;
    }

    @Override
    public void next(TrafficLight trafficLight) {
        trafficLight.turnOff(Lights.GREEN);
        trafficLight.turnOn(Lights.YELLOW);
        trafficLight.setState(new Yellow());
    }
}
