package dk.via.accounts.view;

import dk.via.accounts.viewmodel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;

public class CreateAccountViewLoader extends ViewLoader {
    private final ViewHandler viewHandler;
    private final ViewModelFactory viewModelFactory;

    public CreateAccountViewLoader(String fxmlFile, ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        super(fxmlFile);
        this.viewHandler = viewHandler;
        this.viewModelFactory = viewModelFactory;
    }

    @Override
    protected ViewController createViewController(FXMLLoader loader, Region root) {
        CreateAccountViewController createAccountViewController = loader.getController();
        createAccountViewController.init(viewHandler, viewModelFactory.getCreateAccountViewModel(), root);
        return createAccountViewController;
    }
}
