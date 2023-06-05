package dk.via.mvvm.model;

import dk.via.mvvm.model.validation.UserValidator;

public class EmailFactory {
    private final UserValidator validator;

    public EmailFactory(UserValidator validator) {
        this.validator = validator;
    }

    public Email createEmail(String email) {
        validator.validateEmail(email);
        String[] parts = email.split("@");
        return new Email(parts[0], parts[1]);
    }
}
