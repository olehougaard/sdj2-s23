package dk.via.mvvm.model;

import dk.via.mvvm.model.validation.UserValidator;

import java.util.ArrayList;
import java.util.List;

public class UserModelManager implements UserModel {
    private final List<User> users;
    private final UserValidator validator;
    private final EmailFactory emailFactory;

    public UserModelManager(UserValidator validator, EmailFactory emailFactory) {
        this.validator = validator;
        this.emailFactory = emailFactory;
        this.users = new ArrayList<>();
    }

    public void addUser(String username, String password, String emailString) {
        validator.validateUsername(username);
        validator.validatePassword(password);
        Email email = emailFactory.createEmail(emailString);
        if (getUser(username) != null) {
            throw new IllegalStateException("User already exists.");
        }
        User user = new User(username, password, email);
        users.add(user);
    }

    public User getUser(String username) {
        for(User user: users) {
            if (username.equals(user.getUsername())) {
                return user;
            }
        }
        return null;
    }

    public User getLastUser() {
        if (users.isEmpty())
            return null;
        else
            return users.get(users.size() - 1);
    }

    public int getUserCount() {
        return users.size();
    }
}
