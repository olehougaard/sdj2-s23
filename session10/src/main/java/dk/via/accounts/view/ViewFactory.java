package dk.via.accounts.view;

import dk.via.accounts.viewmodel.ViewModelFactory;
import javafx.scene.layout.Region;

public class ViewFactory {
    public static final String CREATE = "create";
    public static final String MESSAGE = "message";
    public static final String GOODBYE = "goodbye";

    private final CreateAccountViewLoader createAccountViewLoader;
    private final MessageViewLoader messageViewLoader;
    private final GoodbyeViewLoader goodbyeViewLoader;

    public ViewFactory(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        createAccountViewLoader = new CreateAccountViewLoader("CreateAccountView.fxml", viewHandler, viewModelFactory);
        messageViewLoader = new MessageViewLoader("MessageView.fxml", viewHandler, viewModelFactory);
        goodbyeViewLoader = new GoodbyeViewLoader("Goodbye.fxml", viewHandler, viewModelFactory);
    }

    public Region load(String id) {
        return switch(id) {
            case CREATE -> createAccountViewLoader.loadView();
            case MESSAGE -> messageViewLoader.loadView();
            case GOODBYE -> goodbyeViewLoader.loadView();
            default -> throw new IllegalArgumentException("Unknown view: " + id);
        };
    }
}
