package dk.via.accounts.view;

import dk.via.accounts.viewmodel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;

public class GoodbyeViewLoader extends ViewLoader {
    private final ViewHandler viewHandler;
    private final ViewModelFactory viewModelFactory;

    public GoodbyeViewLoader(String fxml, ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        super(fxml);
        this.viewHandler = viewHandler;
        this.viewModelFactory = viewModelFactory;
    }

    @Override
    protected ViewController createController(FXMLLoader loader, Region root) {
        GoodbyeViewController viewController = loader.getController();
        viewController.init(viewHandler, viewModelFactory.getGoodbyeViewModel(), root);
        return viewController;
    }
}
