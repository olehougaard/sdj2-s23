package dk.via.accounts;

import dk.via.accounts.view.ViewHandler;
import dk.via.accounts.viewmodel.ViewModelFactory;
import dk.via.accounts.model.UserModel;
import dk.via.accounts.model.UserModelManager;
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