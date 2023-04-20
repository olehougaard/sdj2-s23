package dk.via.login.dao;

import dk.via.login.shared.User;

import java.sql.*;

public class SqlUserDao implements UserDao {
    private static UserDao instance;

    private SqlUserDao() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    public synchronized static UserDao getInstance() throws SQLException {
        if (instance == null) {
            instance = new SqlUserDao();
        }
        return instance;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=jdbc", "postgres", "admin");
    }

    @Override
    public User create(String username, String password, String name) throws SQLException {
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO User VALUES (?, ?, ?)")) {
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, name);
            statement.executeUpdate();
            return new User(username, password, name);
        }
    }

    @Override
    public User read(String username) throws SQLException {
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users WHERE username = ?")) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                return new User(username, password, name);
            } else {
                return null;
            }
        }
    }

    @Override
    public void update(User user) throws SQLException {
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE User SET password = ?, name = ? WHERE username = ?")) {
            statement.setString(1, user.getPassword());
            statement.setString(2, user.getName());
            statement.setString(3, user.getUserName());
            statement.executeUpdate();
        }
    }
}
