package dk.via.exercise5_2.view;

import dk.via.exercise5_2.viewmodel.LogViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;

public class LogViewController {
    @FXML
    private ListView<String> logs;
    private Region root;
    private ViewHandler viewHandler;

    @FXML
    public void onBack() {
        viewHandler.openView(ViewHandler.CONVERT);
    }

    public void init(ViewHandler viewHandler, LogViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.root = root;

        viewModel.bindLogs(logs.itemsProperty());
    }

    public void reset() {
    }

    public Region getRoot() {
        return root;
    }
}
