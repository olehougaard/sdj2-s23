package dk.via.exercise5_2.view;

import dk.via.exercise5_2.viewmodel.ConvertViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class ConvertViewController {
    @FXML private TextField requestField;
    @FXML private TextField replyField;
    @FXML private Label errorLabel;
    private ViewHandler viewHandler;
    private ConvertViewModel viewModel;
    private Region root;

    @FXML
    protected void onSubmit() {
        viewModel.convert();
    }

    public void onShowLogs() {
        viewHandler.openView(ViewHandler.LOGS);
    }

    @FXML
    public void onEnter() {
        onSubmit();
    }

    public void init(ViewHandler viewHandler, ConvertViewModel convertViewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = convertViewModel;
        this.root = root;

        convertViewModel.bindRequest(requestField.textProperty());
        convertViewModel.bindReply(replyField.textProperty());
        convertViewModel.bindError(errorLabel.textProperty());
    }

    public Region getRoot() {
        return root;
    }

    public void reset() {
    }
}