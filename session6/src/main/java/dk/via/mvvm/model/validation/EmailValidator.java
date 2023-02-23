package dk.via.mvvm.model.validation;

public class EmailValidator {
    private static void illegalArgument(String message) {
        throw new IllegalArgumentException(message);
    }

    public static void validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            illegalArgument("Email cannot be empty");
        }
        String[] parts = email.split("@");
        if (parts.length == 1) {
            illegalArgument("Email must contain @");
        }
        if (parts.length > 2) {
            illegalArgument("Email must not contain more than one @");
        }
        if (!parts[1].contains(".")) {
            illegalArgument("Domain must have several parts");
        }
    }
}
