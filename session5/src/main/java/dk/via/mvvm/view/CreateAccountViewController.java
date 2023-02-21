package dk.via.mvvm.view;

import dk.via.mvvm.viewmodel.CreateAccountViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class CreateAccountViewController {
    @FXML private TextField username;
    @FXML private TextField password;
    @FXML private TextField email;
    @FXML private Label errorLabel;
    private ViewHandler viewHandler;
    private CreateAccountViewModel viewModel;
    private Region root;

    @FXML
    protected void createButtonPressed() {
        boolean success = viewModel.createUser();
        if (success) {
            viewHandler.openView(ViewFactory.MESSAGE);
        }
    }

    @FXML
    protected void cancelButtonPressed() {
        viewHandler.closeView();
    }

    @FXML
    public void submitUsername() {
        password.requestFocus();
    }

    @FXML
    public void submitPassword() {
        email.requestFocus();
    }

    @FXML
    public void submitEmail() {
        createButtonPressed();
    }

    public void init(ViewHandler viewHandler, CreateAccountViewModel createAccountViewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = createAccountViewModel;
        this.root = root;

        createAccountViewModel.bindUsername(username.textProperty());
        createAccountViewModel.bindPassword(password.textProperty());
        createAccountViewModel.bindEmail(email.textProperty());
        createAccountViewModel.bindError(errorLabel.textProperty());
    }

    public Region getRoot() {
        return root;
    }

    public void reset() {
        viewModel.reset();
    }
}