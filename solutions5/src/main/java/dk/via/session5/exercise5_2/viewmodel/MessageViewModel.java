package dk.via.session5.exercise5_2.viewmodel;

import dk.via.session5.exercise5_2.model.UserModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MessageViewModel {
    private final UserModel model;
    private final StringProperty message;
    private final StringProperty lastUserInfo;

    public MessageViewModel(UserModel model) {
        this.model = model;
        this.message = new SimpleStringProperty();
        lastUserInfo = new SimpleStringProperty();
    }

    public void reset() {
        message.set("You have created " + model.getUserCount() + " users.");
        lastUserInfo.set("Last user created: " + model.getLastUser());
    }

    public void bindMessage(StringProperty property) {
        property.bind(message);
    }

    public void bindLastUserInfo(StringProperty property) {
        property.bind(lastUserInfo);
    }
}
