package dk.via.mvvm.viewmodel;

import dk.via.mvvm.model.UserModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MessageViewModel implements PropertyChangeListener {
    private final UserModel model;
    private final StringProperty message;

    public MessageViewModel(UserModel model) {
        this.model = model;
        this.message = new SimpleStringProperty();
        model.addPropertyChangeListener(this);
    }

    public void bindMessage(StringProperty property) {
        property.bind(message);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        message.set("You have created " + model.getUserCount() + " users.");
    }
}
