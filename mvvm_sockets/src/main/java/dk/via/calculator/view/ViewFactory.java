package dk.via.calculator.view;

import dk.via.calculator.viewmodel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;

import java.io.IOError;
import java.io.IOException;

public class ViewFactory {
    private final ViewHandler viewHandler;
    private final ViewModelFactory viewModelFactory;
    private CalculateViewController convertViewController;

    public ViewFactory(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        this.viewHandler = viewHandler;
        this.viewModelFactory = viewModelFactory;
        this.convertViewController = null;
    }

    public Region loadConvertView() {
        if (convertViewController == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("CalculatorView.fxml"));
            try {
                Region root = loader.load();
                convertViewController = loader.getController();
                convertViewController.init(viewHandler, viewModelFactory.getConvertViewModel(), root);
            } catch (IOException e) {
                throw new IOError(e);
            }
        }
        convertViewController.reset();
        return convertViewController.getRoot();
    }
}
