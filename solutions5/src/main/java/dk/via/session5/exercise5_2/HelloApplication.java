package dk.via.session5.exercise5_2;

import dk.via.session5.exercise5_2.model.UserModel;
import dk.via.session5.exercise5_2.model.UserModelManager;
import dk.via.session5.exercise5_2.view.ViewHandler;
import dk.via.session5.exercise5_2.viewmodel.ViewModelFactory;
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