package dk.via.traffic.trafficlight;

public interface TrafficLightState {
    LightColor getColor();
    void next(TrafficLight trafficLight);
}
