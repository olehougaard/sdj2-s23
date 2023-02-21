package dk.via.mvvm;

import dk.via.mvvm.model.UserModel;
import dk.via.mvvm.model.UserModelManager;
import dk.via.mvvm.view.ViewHandler;
import dk.via.mvvm.viewmodel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class HelloApplication extends Application {
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