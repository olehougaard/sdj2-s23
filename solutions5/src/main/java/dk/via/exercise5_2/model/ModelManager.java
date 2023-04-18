package dk.via.exercise5_2.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelManager implements Model {
    private final Converter converter;
    private final PropertyChangeSupport support;

    public ModelManager() {
        this.converter = new Converter();
        this.support = new PropertyChangeSupport(this);
    }

    @Override
    public String convert(String source) {
        String upperCase = converter.toUpperCase(source);
        support.firePropertyChange("Convert", source, upperCase);
        return upperCase;
    }

    @Override
    public String[] getHistory() {
        return converter.getHistory();
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}
