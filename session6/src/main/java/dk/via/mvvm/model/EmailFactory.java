package dk.via.mvvm.model;

import dk.via.mvvm.model.validation.EmailValidator;

public class EmailFactory {
    public static Email createEmail(String email) {
        EmailValidator.validateEmail(email);
        String[] parts = email.split("@");
        return new Email(parts[0], parts[1]);
    }
}
