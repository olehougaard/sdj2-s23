package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Model;

public class ConvertViewModel {
    private final Model model;

    private final StringProperty request;
    private final StringProperty reply;
    private final StringProperty error;

    public ConvertViewModel(Model model) {
        this.model = model;
        request = new SimpleStringProperty();
        reply = new SimpleStringProperty();
        error = new SimpleStringProperty();
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

    public void reset() {
        request.set("");
        reply.set("");
        error.set("");
    }

    public void convert() {
        try {
            String converted = model.convert(request.get());
            reply.set(converted);
            error.set("");
        } catch (RuntimeException e) {
            error.set(e.getMessage());
        }
    }
}
