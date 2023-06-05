package dk.via.mvvm.model.validation;

public class UserValidator {
    public final static int MINIMAL_PASSWORD_LENGTH = 8;
    public static final int MINIMAL_USERNAME_LENGTH = 3;

    public void validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        String[] parts = email.split("@");
        if (parts.length == 1) {
            throw new IllegalArgumentException("Email must contain @");
        }
        if (parts.length > 2) {
            throw new IllegalArgumentException("Email must not contain more than one @");
        }
        if (!parts[1].contains(".")) {
            throw new IllegalArgumentException("Domain must have several parts");
        }
    }

    public void validatePassword(String password) {
        if (password == null || password.length() < MINIMAL_PASSWORD_LENGTH) {
            throw new IllegalArgumentException("Password needs " + MINIMAL_PASSWORD_LENGTH + " or more characters.");
        }
        boolean lowercase = false;
        boolean uppercase = false;
        boolean digit = false;
        for(int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            lowercase = lowercase || Character.isLowerCase(ch);
            uppercase = uppercase || Character.isUpperCase(ch);
            digit = digit || Character.isDigit(ch);
        }
        if (!(lowercase && uppercase && digit)) {
            throw new IllegalArgumentException("Password needs both lower case letters, upper case letters and digits.");
        }
    }

    public void validateUsername(String username) {
        if (username == null || username.length() < MINIMAL_USERNAME_LENGTH) {
            throw new IllegalArgumentException("Username needs " + MINIMAL_USERNAME_LENGTH + " or more characters.");
        }
    }
}
