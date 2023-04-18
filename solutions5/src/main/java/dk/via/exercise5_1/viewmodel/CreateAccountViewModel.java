package dk.via.exercise5_1.viewmodel;

import dk.via.exercise5_1.model.UserModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CreateAccountViewModel implements PropertyChangeListener {
    public static final String VIEW_MESSAGE = "viewMessage";
    public static final String VIEW_GOODBYE = "exitMessage";
    private final UserModel model;
    private final StringProperty username;
    private final StringProperty password;
    private final StringProperty email;
    private final StringProperty error;
    private final PropertyChangeSupport support;

    public CreateAccountViewModel(UserModel model) {
        this.model = model;
        this.username = new SimpleStringProperty("");
        this.password = new SimpleStringProperty("");
        this.email = new SimpleStringProperty("");
        this.error = new SimpleStringProperty("");
        this.support = new PropertyChangeSupport(this);
        model.addPropertyChangeListener(this);
    }

    public void createUser() {
        try {
            model.addUser(username.get(), password.get(), email.get());
            error.set("");
        } catch (Exception e) {
            error.set(e.getMessage());
        }
    }

    public void cancel() {
        support.firePropertyChange(VIEW_GOODBYE, false, true);
    }

    public void reset() {
        username.set("");
        password.set("");
        email.set("");
        error.set("");
    }

    public void bindUsername(StringProperty property) {
        username.bindBidirectional(property);
    }

    public void bindPassword(StringProperty property) {
        password.bindBidirectional(property);
    }

    public void bindEmail(StringProperty property) {
        email.bindBidirectional(property);
    }

    public void bindError(StringProperty property) {
        property.bind(error);
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(propertyName, listener);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        support.firePropertyChange(VIEW_MESSAGE, false, true);
    }
}
