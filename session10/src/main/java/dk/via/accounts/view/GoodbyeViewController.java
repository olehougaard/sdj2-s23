package dk.via.accounts.view;

import dk.via.accounts.viewmodel.GoodbyeViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

public class GoodbyeViewController implements ViewController {
    private ViewHandler viewHandler;
    private GoodbyeViewModel goodbyeViewModel;
    private Region root;

    @FXML public Label userCount;

    public void init(ViewHandler viewHandler, GoodbyeViewModel goodbyeViewModel, Region root) {
        this.viewHandler = viewHandler;
        this.goodbyeViewModel = goodbyeViewModel;
        this.root = root;

        goodbyeViewModel.bindUserCount(userCount.textProperty());
    }

    public void okButtonPressed(ActionEvent actionEvent) {
        viewHandler.closeView();
    }

    public void reset() {
        goodbyeViewModel.reset();
    }

    public Region getRoot() {
        return root;
    }
}
