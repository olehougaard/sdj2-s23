package dk.via.traffic.trafficlight;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TrafficLight {
    private final Lights lights;
    private TrafficLightState state;
    private PropertyChangeSupport support;

    public TrafficLight() {
        lights = new Lights();
        lights.turnOn(Lights.RED);
        lights.printLights();
        state = new Red();
        support = new PropertyChangeSupport(this);
    }

    void setState(TrafficLightState state) {
        TrafficLightState oldState = this.state;
        this.state = state;
        lights.printLights();
        support.firePropertyChange("state", oldState, state);
    }

    public LightColor getColor() {
        return state.getColor();
    }

    public void next() {
        state.next(this);
    }

    public boolean isTurnedOn(String light) {
        return lights.isTurnedOn(light);
    }

    public String getStatus() {
        return lights.getStatus();
    }

    void turnOn(String... lights) {
        this.lights.turnOn(lights);
    }

    void turnOff(String... lights) {
        this.lights.turnOff(lights);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(propertyName, listener);
    }
}
