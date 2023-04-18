package dk.via.exercise5_1.viewmodel;

import dk.via.exercise5_1.model.UserModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MessageViewModel implements PropertyChangeListener {
    public static final String INPUT_USER = "inputUser";
    public static final String VIEW_GOODBYE = "exitMessage";

    private final UserModel model;
    private final StringProperty message;
    private final StringProperty lastUserInfo;
    private final PropertyChangeSupport support;

    public MessageViewModel(UserModel model) {
        this.model = model;
        this.message = new SimpleStringProperty();
        this.support = new PropertyChangeSupport(this);
        lastUserInfo = new SimpleStringProperty();
        model.addPropertyChangeListener(this);
    }

    public void nextUser() {
        support.firePropertyChange(INPUT_USER, false, true);
    }

    public void cancel() {
        support.firePropertyChange(VIEW_GOODBYE, false, true);
    }

    public void reset() {
    }

    public void bindMessage(StringProperty property) {
        property.bind(message);
    }

    public void bindLastUserInfo(StringProperty property) {
        property.bind(lastUserInfo);
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(propertyName, listener);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        message.set("You have created " + model.getUserCount() + " users.");
        lastUserInfo.set("Last user created: " + model.getLastUser());
    }
}
