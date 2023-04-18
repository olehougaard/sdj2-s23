package app;

import client.Client;
import client.ClientImplementation;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Model;
import model.ModelManager;
import view.ViewHandler;
import viewmodel.ViewModelFactory;

public class UppercaseApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Client client = new ClientImplementation("localhost", 6789);
        Model model = new ModelManager(client);
        ViewModelFactory viewModelFactory = new ViewModelFactory(model);
        ViewHandler viewHandler = new ViewHandler(viewModelFactory);
        viewHandler.start(stage);
    }

    public static void main(String... args) {
        launch();
    }
}
