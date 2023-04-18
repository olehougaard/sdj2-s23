package dk.via.exercise5_2.viewmodel;

import dk.via.exercise5_2.model.Model;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LogViewModel implements PropertyChangeListener {
    private final Model model;
    private final SimpleListProperty<String> logs;

    public LogViewModel(Model model) {
        this.model = model;
        this.logs = new SimpleListProperty<>(FXCollections.observableArrayList());
        model.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        logs.setAll(model.getHistory());
    }

    public void bindLogs(ObjectProperty<ObservableList<String>> property) {
        property.bind(logs);
    }
}
