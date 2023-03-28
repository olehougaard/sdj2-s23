package dk.via.calculator;

import dk.via.calculator.model.Model;
import dk.via.calculator.model.ModelManager;
import dk.via.calculator.shared.Calculator;
import dk.via.calculator.view.ViewHandler;
import dk.via.calculator.viewmodel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(1099);
        Calculator calculator = (Calculator) registry.lookup("calculator");
        Model model = new ModelManager(calculator);
        ViewModelFactory viewModelFactory = new ViewModelFactory(model);
        ViewHandler viewHandler = new ViewHandler(viewModelFactory);
        viewHandler.start(primaryStage);
    }

    public static void main(String[] args) {
        launch();
    }
}