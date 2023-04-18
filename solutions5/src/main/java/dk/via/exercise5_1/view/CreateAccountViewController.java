package dk.via.exercise5_1.view;

import dk.via.exercise5_1.viewmodel.CreateAccountViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class CreateAccountViewController {
    @FXML private TextField username;
    @FXML private TextField password;
    @FXML private TextField email;
    @FXML private Label errorLabel;

    private CreateAccountViewModel viewModel;
    private Region root;

    @FXML
    protected void createButtonPressed() {
        viewModel.createUser();
    }

    @FXML
    protected void cancelButtonPressed() {
        viewModel.cancel();
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
        this.viewModel = createAccountViewModel;
        this.root = root;

        createAccountViewModel.bindUsername(username.textProperty());
        createAccountViewModel.bindPassword(password.textProperty());
        createAccountViewModel.bindEmail(email.textProperty());
        createAccountViewModel.bindError(errorLabel.textProperty());

        viewModel.addPropertyChangeListener(CreateAccountViewModel.VIEW_MESSAGE, evt -> {
            viewHandler.openView(ViewHandler.MESSAGE);
        });

        viewModel.addPropertyChangeListener(CreateAccountViewModel.VIEW_GOODBYE, evt -> {
            viewHandler.openView(ViewHandler.GOODBYE);
        });
    }

    public Region getRoot() {
        return root;
    }

    public void reset() {
        viewModel.reset();
    }
}