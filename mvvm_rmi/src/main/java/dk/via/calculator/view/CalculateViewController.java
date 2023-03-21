package dk.via.calculator.view;

import dk.via.calculator.viewmodel.CalculatorViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class CalculateViewController {
    @FXML public TextField firstOperand;
    @FXML public TextField secondOperand;
    @FXML public Label result;
    @FXML private Label error;

    private ViewHandler viewHandler;
    private CalculatorViewModel viewModel;
    private Region root;

    @FXML
    public void add() {
        viewModel.add();
    }

    @FXML
    public void subtract() {
        viewModel.subtract();
    }

    @FXML
    public void multiply() {
        viewModel.multiply();
    }

    @FXML
    public void divide() {
        viewModel.divide();
    }

    public void init(ViewHandler viewHandler, CalculatorViewModel convertViewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = convertViewModel;
        this.root = root;

        convertViewModel.bindFirst(firstOperand.textProperty());
        convertViewModel.bindSecond(secondOperand.textProperty());
        convertViewModel.bindResult(result.textProperty());
        convertViewModel.bindError(error.textProperty());
    }

    public Region getRoot() {
        return root;
    }

    public void reset() {
    }
}