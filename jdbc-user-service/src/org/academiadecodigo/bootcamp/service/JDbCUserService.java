package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.persistence.ConnectionManager;

import java.sql.*;
import java.util.List;

public class JDbCUserService implements UserService {

    private ConnectionManager connectionManager;
    private Connection dbConnection;

    public JDbCUserService() {

        connectionManager = new ConnectionManager();
        dbConnection = connectionManager.getConnection();
    }

    @Override
    public boolean authenticate(String username, String password) {
        return false;
    }

    @Override
    public void add(User user) {

        try {

            String query = "INSERT INTO user(username, password, email, firstname, lastname, phone) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = dbConnection.prepareStatement(query);

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getFirstName());
            statement.setString(5, user.getLastName());
            statement.setString(6, user.getPhone());

            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public User findByName(String username) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public int count() {

        int result = 0;

        try {

            Statement statement = dbConnection.createStatement();
            String query = "SELECT COUNT * FROM user";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                result = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }
}
