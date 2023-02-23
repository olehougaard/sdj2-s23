package dk.via.mvvm.view;

import dk.via.mvvm.viewmodel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;

import java.io.IOError;
import java.io.IOException;

public class ViewFactory {
    public static final String CREATE = "create";
    public static final String MESSAGE = "message";

    private final ViewHandler viewHandler;
    private final ViewModelFactory viewModelFactory;

    private CreateAccountViewController createAccountViewController;
    private MessageViewController messageViewController;

    public ViewFactory(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        this.viewHandler = viewHandler;
        this.viewModelFactory = viewModelFactory;
        this.createAccountViewController = null;
        this.messageViewController = null;
    }

    public Region loadCreateAccountView() {
        if (createAccountViewController == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("CreateAccountView.fxml"));
            try {
                Region root = loader.load();
                createAccountViewController = loader.getController();
                createAccountViewController.init(viewHandler, viewModelFactory.getCreateAccountViewModel(), root);
            } catch (IOException e) {
                throw new IOError(e);
            }
        }
        createAccountViewController.reset();
        return createAccountViewController.getRoot();
    }

    public Region loadMessageView() {
        if (messageViewController == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("MessageView.fxml"));
            try {
                Region root = loader.load();
                messageViewController = loader.getController();
                messageViewController.init(viewHandler, viewModelFactory.getMessageViewModel(), root);
            } catch (IOException e) {
                throw new IOError(e);
            }
        }
        messageViewController.reset();
        return messageViewController.getRoot();
    }

    public Region load(String id) {
        return switch (id) {
            case CREATE -> loadCreateAccountView();
            case MESSAGE -> loadMessageView();
            default -> throw new IllegalArgumentException("Unknown view: " + id);
        };
    }
}
