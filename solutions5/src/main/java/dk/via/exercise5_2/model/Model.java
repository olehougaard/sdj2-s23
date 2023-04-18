package dk.via.exercise5_2.model;

import java.beans.PropertyChangeListener;

public interface Model {
    String convert(String source);

    String[] getHistory();

    void addPropertyChangeListener(PropertyChangeListener listener);

    void removePropertyChangeListener(PropertyChangeListener listener);
}
