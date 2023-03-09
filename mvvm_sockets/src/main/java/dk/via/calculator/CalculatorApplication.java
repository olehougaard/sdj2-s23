package dk.via.calculator;

import dk.via.calculator.client.MathClient;
import dk.via.calculator.client.MathClientImplementation;
import dk.via.calculator.model.Model;
import dk.via.calculator.model.ModelManager;
import dk.via.calculator.view.ViewHandler;
import dk.via.calculator.viewmodel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculatorApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        MathClient client = new MathClientImplementation("localhost", 8888);
        Model model = new ModelManager(client);
        ViewModelFactory viewModelFactory = new ViewModelFactory(model);
        ViewHandler viewHandler = new ViewHandler(viewModelFactory);
        viewHandler.start(primaryStage);
    }

    public static void main(String[] args) {
        launch();
    }
}