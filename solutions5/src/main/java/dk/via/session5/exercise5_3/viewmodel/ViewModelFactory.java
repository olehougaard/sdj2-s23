package dk.via.session5.exercise5_3.viewmodel;

import dk.via.session5.exercise5_3.model.Model;

public class ViewModelFactory {
    private final CalculatorViewModel convertViewModel;

    public ViewModelFactory(Model model) {
        this.convertViewModel = new CalculatorViewModel(model);
    }

    public CalculatorViewModel getConvertViewModel() {
        return convertViewModel;
    }
}
