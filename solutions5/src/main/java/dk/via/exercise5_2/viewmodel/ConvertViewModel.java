package dk.via.exercise5_2.viewmodel;

import dk.via.exercise5_2.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ConvertViewModel {
    private final Model model;
    private final StringProperty request;
    private final StringProperty reply;
    private final StringProperty error;

    public ConvertViewModel(Model model) {
        this.model = model;
        this.request = new SimpleStringProperty("");
        this.reply = new SimpleStringProperty("");
        this.error = new SimpleStringProperty("");
    }

    public void convert() {
        try {
            reply.set(model.convert(request.get()));
            error.set("");
        } catch (IllegalArgumentException e) {
            reply.set("");
            error.set(e.getMessage());
        }
    }

    public void bindRequest(StringProperty property) {
        property.bindBidirectional(request);
    }

    public void bindReply(StringProperty property) {
        property.bind(reply);
    }
    public void bindError(StringProperty property) {
        property.bind(error);
    }
}
