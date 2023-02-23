package dk.via.mvvm.model;

import dk.via.mvvm.model.validation.PasswordValidator;
import dk.via.mvvm.model.validation.UsernameValidator;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class UserModelManager implements UserModel {
    private final List<User> users;
    private final PropertyChangeSupport support;

    public UserModelManager() {
        this.users = new ArrayList<>();
        this.support = new PropertyChangeSupport(this);
    }

    public void addUser(String username, String password, String emailString) {
        UsernameValidator.validateUsername(username);
        PasswordValidator.validatePassword(password);
        Email email = EmailFactory.createEmail(emailString);
        if (getUser(username) != null) {
            throw new IllegalStateException("User already exists.");
        }
        User user = new User(username, password, email);
        users.add(user);
        // Using null ensures that it will always fire.
        // It does mean that you can't use evt.getOldValue()
        support.firePropertyChange("users", null, users);
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

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}
