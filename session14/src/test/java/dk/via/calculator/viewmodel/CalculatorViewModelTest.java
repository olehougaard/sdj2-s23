package dk.via.calculator.viewmodel;

import dk.via.calculator.model.Model;
import javafx.beans.property.SimpleStringProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorViewModelTest {
    private Model model;
    private CalculatorViewModel viewModel;
    private SimpleStringProperty first;
    private SimpleStringProperty second;
    private SimpleStringProperty result;
    private SimpleStringProperty error;

    @BeforeEach
    void setUp() {
        model = Mockito.mock(Model.class);
        viewModel = new CalculatorViewModel(model);
        first = new SimpleStringProperty("0");
        second = new SimpleStringProperty("0");
        result = new SimpleStringProperty("");
        error = new SimpleStringProperty("");
        viewModel.bindFirst(first);
        viewModel.bindSecond(second);
        viewModel.bindResult(result);
        viewModel.bindError(error);
    }

    @Test
    void successful_division_sets_result() throws IOException {
        Mockito.when(model.divide(3, 2)).thenReturn(1.5);
        first.set("3");
        second.set("2");
        viewModel.divide();
        assertEquals("3.0 / 2.0 = 1.5", result.get());
    }

    @Test
    void division_by_zero_clears_result() throws IOException {
        Mockito.when(model.divide(3, 0)).thenReturn(Double.POSITIVE_INFINITY);
        first.set("3");
        second.set("0");
        viewModel.divide();
        assertEquals("", result.get());
    }

    @Test
    void division_by_zero_sets_error() throws IOException {
        Mockito.when(model.divide(3, 0)).thenReturn(3.0 / 0);
        first.set("3");
        second.set("0");
        viewModel.divide();
        assertEquals("Division by zero", error.get());
    }

    @Test
    void server_error_sets_error() throws IOException {
        Mockito.when(model.divide(3, 2)).thenThrow(new IOException());
        first.set("3");
        second.set("2");
        viewModel.divide();
        assertEquals("Server communication error", error.get());
    }
}
