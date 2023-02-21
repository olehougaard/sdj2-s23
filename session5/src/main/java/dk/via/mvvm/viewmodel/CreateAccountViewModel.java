package dk.via.mvvm.viewmodel;

import dk.via.mvvm.model.UserModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CreateAccountViewModel {
    private final UserModel model;
    private final StringProperty username;
    private final StringProperty password;
    private final StringProperty email;
    private final StringProperty error;

    public CreateAccountViewModel(UserModel model) {
        this.model = model;
        this.username = new SimpleStringProperty("");
        this.password = new SimpleStringProperty("");
        this.email = new SimpleStringProperty("");
        this.error = new SimpleStringProperty("");
    }

    public boolean createUser() {
        try {
            model.addUser(username.get(), password.get(), email.get());
            error.set("");
            return true;
        } catch (Exception e) {
            error.set(e.getMessage());
            return false;
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
}
