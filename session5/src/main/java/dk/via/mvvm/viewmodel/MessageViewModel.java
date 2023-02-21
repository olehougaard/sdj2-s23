package dk.via.mvvm.viewmodel;

import dk.via.mvvm.model.UserModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MessageViewModel {
    private final UserModel model;
    private final StringProperty message;

    public MessageViewModel(UserModel model) {
        this.model = model;
        this.message = new SimpleStringProperty();
    }

    public void reset() {
        message.set("You have create " + model.getUserCount() + " users.");
    }

    public void bindMessage(StringProperty property) {
        property.bind(message);
    }
}
