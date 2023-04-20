package dk.via.login.dao;

import dk.via.login.shared.User;

import java.sql.SQLException;

public interface UserDao {
    User create(String username, String password, String name) throws SQLException;

    User read(String username) throws SQLException;

    void update(User user) throws SQLException;
}
