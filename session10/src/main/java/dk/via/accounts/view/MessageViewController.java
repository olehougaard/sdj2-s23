package dk.via.accounts.view;

import dk.via.accounts.viewmodel.MessageViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

public class MessageViewController implements ViewController {
    @FXML public Label userCount;
    @FXML public Label lastUserInfo;
    private MessageViewModel messageViewModel;
    private Region root;

    @FXML
    public void okButtonPressed() {
        messageViewModel.cancel();
    }

    @FXML
    public void continueButtonPressed() {
        messageViewModel.nextUser();
    }

    public void init(ViewHandler viewHandler, MessageViewModel messageViewModel, Region root) {
        this.messageViewModel = messageViewModel;
        this.root = root;

        messageViewModel.bindMessage(userCount.textProperty());
        messageViewModel.bindLastUserInfo(lastUserInfo.textProperty());

        messageViewModel.addPropertyChangeListener(MessageViewModel.INPUT_USER, evt -> {
            viewHandler.openView(ViewHandler.CREATE);
        });

        messageViewModel.addPropertyChangeListener(MessageViewModel.VIEW_GOODBYE, evt -> {
            viewHandler.openView(ViewHandler.GOODBYE);
        });
    }

    public Region getRoot() {
        return root;
    }

    public void reset() {
        messageViewModel.reset();
    }
}
