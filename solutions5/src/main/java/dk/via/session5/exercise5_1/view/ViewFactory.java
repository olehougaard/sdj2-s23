package dk.via.session5.exercise5_1.view;

import dk.via.session5.exercise5_1.viewmodel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;

import java.io.IOError;
import java.io.IOException;

public class ViewFactory {
    public static final String CONVERT = "convert";

    private final ViewHandler viewHandler;
    private final ViewModelFactory viewModelFactory;
    private ConvertViewController convertViewController;

    public ViewFactory(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        this.viewHandler = viewHandler;
        this.viewModelFactory = viewModelFactory;
        this.convertViewController = null;
    }

    public Region loadConvertView() {
        if (convertViewController == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ConvertView.fxml"));
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

    public Region loadView(String id) {
        return switch (id) {
            case CONVERT -> loadConvertView();
            default -> throw new IllegalArgumentException("Unknown view: " + id);
        };
    }
}
