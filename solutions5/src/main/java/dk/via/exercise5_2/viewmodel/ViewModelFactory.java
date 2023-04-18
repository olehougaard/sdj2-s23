package dk.via.exercise5_2.viewmodel;

import dk.via.exercise5_2.model.Model;

public class ViewModelFactory {
    private final ConvertViewModel convertViewModel;
    private final LogViewModel logViewModel;

    public ViewModelFactory(Model model) {
        this.convertViewModel = new ConvertViewModel(model);
        logViewModel = new LogViewModel(model);
    }

    public ConvertViewModel getConvertViewModel() {
        return convertViewModel;
    }

    public LogViewModel getLogViewModel() {
        return logViewModel;
    }
}
