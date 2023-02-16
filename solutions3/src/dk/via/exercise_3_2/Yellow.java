package dk.via.exercise_3_2;

public class Yellow implements State{
    @Override
    public void next(TrafficLight trafficLight) {
        trafficLight.turnOff(Lights.YELLOW);
        trafficLight.turnOn(Lights.RED);
        trafficLight.setState(new Red());
    }
}
