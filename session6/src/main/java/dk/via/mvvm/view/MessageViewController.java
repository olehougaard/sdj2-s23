package dk.via.mvvm.view;

import dk.via.mvvm.viewmodel.MessageViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

public class MessageViewController {
    @FXML public Label userCount;
    private ViewHandler viewHandler;
    private MessageViewModel messageViewModel;
    private Region root;

    @FXML
    public void okButtonPressed() {
        viewHandler.closeView();
    }

    @FXML
    public void continueButtonPressed() {
        viewHandler.openView(ViewFactory.CREATE);
    }

    public void init(ViewHandler viewHandler, MessageViewModel messageViewModel, Region root) {
        this.viewHandler = viewHandler;
        this.messageViewModel = messageViewModel;
        this.root = root;

        messageViewModel.bindMessage(userCount.textProperty());
    }

    public Region getRoot() {
        return root;
    }

    public void reset() {
    }
}
