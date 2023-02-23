package dk.via.mvvm.viewmodel;

import dk.via.mvvm.model.UserModel;

public class ViewModelFactory {
    private final CreateAccountViewModel createAccountViewModel;
    private final MessageViewModel messageViewModel;

    public ViewModelFactory(UserModel model) {
        this.createAccountViewModel = new CreateAccountViewModel(model);
        this.messageViewModel = new MessageViewModel(model);
    }

    public CreateAccountViewModel getCreateAccountViewModel() {
        return createAccountViewModel;
    }

    public MessageViewModel getMessageViewModel() {
        return messageViewModel;
    }
}
