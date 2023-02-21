package dk.via.mvvm.model;

public interface UserModel {
    void addUser(String username, String password, String email) throws IllegalArgumentException, IllegalStateException;

    User getUser(String username);

    User getLastUser();

    int getUserCount();
}
