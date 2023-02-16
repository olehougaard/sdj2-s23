package dk.via.exercise_3_2;

public class YellowRed implements State {
    @Override
    public void next(TrafficLight trafficLight) {
        trafficLight.turnOff(Lights.YELLOW, Lights.RED);
        trafficLight.turnOn(Lights.GREEN);
        trafficLight.setState(new Green());
    }
}
