package dk.via.session5.exercise5_1.viewmodel;

import dk.via.session5.exercise5_1.model.Model;

public class ViewModelFactory {
    private final ConvertViewModel convertViewModel;

    public ViewModelFactory(Model model) {
        this.convertViewModel = new ConvertViewModel(model);
    }

    public ConvertViewModel getConvertViewModel() {
        return convertViewModel;
    }
}
