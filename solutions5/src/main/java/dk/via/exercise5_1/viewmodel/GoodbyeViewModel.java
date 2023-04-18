package dk.via.exercise5_1.viewmodel;

import dk.via.exercise5_1.model.UserModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GoodbyeViewModel implements PropertyChangeListener {
    private final UserModel model;
    private final StringProperty userCount;

    public GoodbyeViewModel(UserModel model) {
        this.model = model;
        this.userCount = new SimpleStringProperty();
        model.addPropertyChangeListener(this);
    }

    public void reset() {
    }

    public void bindUserCount(StringProperty property) {
        property.bind(userCount);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        userCount.set(String.format("Created %d users", model.getUserCount()));
    }
}
