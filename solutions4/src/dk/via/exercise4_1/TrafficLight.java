package dk.via.exercise4_1;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TrafficLight implements Runnable {
    private final PropertyChangeSupport support;
    private LightColor color;

    public TrafficLight() {
        support = new PropertyChangeSupport(this);
        color = LightColor.GREEN;

    }

    public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                LightColor oldValue = color;
                color = color.next();
                synchronized (this) {
                    support.firePropertyChange("color", oldValue, color);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
