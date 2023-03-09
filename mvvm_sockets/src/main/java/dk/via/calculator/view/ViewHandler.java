package dk.via.calculator.view;

import dk.via.calculator.viewmodel.ViewModelFactory;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class ViewHandler {
    public static final String CALCULATOR = "calculator";

    private final Scene currentScene;
    private Stage primaryStage;
    private final ViewFactory viewFactory;

    public ViewHandler(ViewModelFactory viewModelFactory) {
        this.viewFactory = new ViewFactory(this, viewModelFactory);
        this.currentScene = new Scene(new Region());
    }

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        openView(CALCULATOR);
    }

    public void openView(String id) {
        Region root = switch(id) {
            case CALCULATOR -> viewFactory.loadConvertView();
            default -> throw new IllegalArgumentException("Unknown view: " + id);
        };
        currentScene.setRoot(root);
        if (root.getUserData() == null) {
            primaryStage.setTitle("");
        } else {
            primaryStage.setTitle(root.getUserData().toString());
        }
        primaryStage.setScene(currentScene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    public void closeView() {
        primaryStage.close();
    }
}
