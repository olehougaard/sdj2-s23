package dk.via.session5.exercise5_2.model;

public interface UserModel {
    void addUser(String username, String password, String email) throws IllegalArgumentException, IllegalStateException;

    User getUser(String username);

    User getLastUser();

    int getUserCount();
}
