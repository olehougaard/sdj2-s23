package dk.via.mvvm.viewmodel;

import dk.via.mvvm.model.UserModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CreateAccountViewModel {
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
    }

    public void createUser() {
        try {
            model.addUser(username.get(), password.get(), email.get());
            error.set("");
            support.firePropertyChange("last user", null, model.getLastUser());
        } catch (Exception e) {
            error.set(e.getMessage());
        }
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

    public void reset() {
        username.set("");
        password.set("");
        email.set("");
        error.set("");
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(propertyName, listener);
    }
}
