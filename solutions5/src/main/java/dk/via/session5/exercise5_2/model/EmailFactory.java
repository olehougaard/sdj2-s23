package dk.via.session5.exercise5_2.model;

import dk.via.session5.exercise5_2.model.validation.EmailValidator;

public class EmailFactory {
    public static Email createEmail(String email) {
        EmailValidator.validateEmail(email);
        String[] parts = email.split("@");
        return new Email(parts[0], parts[1]);
    }
}
