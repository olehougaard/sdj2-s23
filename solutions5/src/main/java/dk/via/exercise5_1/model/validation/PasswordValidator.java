package dk.via.exercise5_1.model.validation;

public class PasswordValidator {
    public final static int MINIMAL_LENGTH = 8;

    public static void validatePassword(String password) throws IllegalArgumentException {
        if (password == null || password.length() < MINIMAL_LENGTH) {
            throw new IllegalArgumentException("Password needs " + MINIMAL_LENGTH + " or more characters.");
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
}
