package dk.via.exercise6_1;

import dk.via.exercise6_1.view.ViewHandler;
import dk.via.exercise6_1.viewmodel.ViewModelFactory;
import dk.via.exercise6_1.model.UserModel;
import dk.via.exercise6_1.model.UserModelManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Start extends Application {
    @Override
    public void start(Stage primaryStage) {
        UserModel model = new UserModelManager();
        ViewModelFactory viewModelFactory = new ViewModelFactory(model);
        ViewHandler viewHandler = new ViewHandler(viewModelFactory);
        viewHandler.start(primaryStage);
    }

    public static void main(String[] args) {
        launch();
    }
}