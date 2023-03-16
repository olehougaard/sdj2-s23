package dk.via.accounts.view;

import dk.via.accounts.viewmodel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;

import java.io.IOError;
import java.io.IOException;

public abstract class ViewLoader {
    private final String fxmlFile;
    private ViewController viewController;

    public ViewLoader(String fxmlFile) {
        this.fxmlFile = fxmlFile;
    }

    public Region loadView() {
        if (viewController == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFile));
            try {
                Region root = loader.load();
                viewController = createViewController(loader, root);
            } catch (IOException e) {
                throw new IOError(e);
            }
        }
        viewController.reset();
        return viewController.getRoot();
    }

    protected abstract ViewController createViewController(FXMLLoader loader, Region root);
}
