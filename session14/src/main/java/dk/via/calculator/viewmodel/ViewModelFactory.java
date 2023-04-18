package dk.via.calculator.viewmodel;

import dk.via.calculator.model.Model;

public class ViewModelFactory {
    private final CalculatorViewModel convertViewModel;

    public ViewModelFactory(Model model) {
        this.convertViewModel = new CalculatorViewModel(model);
    }

    public CalculatorViewModel getConvertViewModel() {
        return convertViewModel;
    }
}
