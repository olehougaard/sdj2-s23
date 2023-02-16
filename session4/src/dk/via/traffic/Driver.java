package dk.via.traffic;

import dk.via.traffic.trafficlight.Lights;
import dk.via.traffic.trafficlight.TrafficLight;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Driver implements PropertyChangeListener {
    private final Car car;

    public Driver(Car car) {
        this.car = car;
    }

    public void onLightChange(TrafficLight trafficLight) {
        if (trafficLight.isTurnedOn(Lights.GREEN)) {
            if (!car.isRunning()) car.start();
            car.accelerate();
            trafficLight.removePropertyChangeListener(this);
        } else if (trafficLight.isTurnedOn(Lights.RED) && trafficLight.isTurnedOn(Lights.YELLOW)) {
            car.start();
        } else if (trafficLight.isTurnedOn(Lights.YELLOW)) {
            car.decelerate();
        } else {
            car.stop();
        }
    }

    public Car getCar() {
        return car;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        TrafficLight light = (TrafficLight) evt.getSource();
        onLightChange(light);
    }
}
