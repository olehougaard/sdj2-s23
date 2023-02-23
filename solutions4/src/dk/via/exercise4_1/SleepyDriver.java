package dk.via.exercise4_1;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SleepyDriver implements PropertyChangeListener {
    private final Car car;

    public SleepyDriver(Car car) {
        this.car = car;
    }

    public void onLightChange(LightColor color) {
        switch(color) {
            case GREEN -> {
                car.start();
                car.accelerate();
            }
            case YELLOW -> {
                car.decelerate();
            }
            case RED -> {
                car.stop();
            }
            case RED_YELLOW -> {
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        onLightChange((LightColor) evt.getNewValue());
    }
}
