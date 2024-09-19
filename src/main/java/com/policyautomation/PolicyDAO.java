package com.policyautomation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PolicyDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/policy_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1408620Anki@";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public List<Policy> getAllPolicies() throws SQLException {
        List<Policy> policies = new ArrayList<>();
        String query = "SELECT * FROM policies";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Policy policy = new Policy();
                policy.setId(resultSet.getInt("id"));
                policy.setName(resultSet.getString("name"));
                policy.setDescription(resultSet.getString("description"));
                policies.add(policy);
            }
        }
        return policies;
    }

    public void addPolicy(Policy policy) throws SQLException {
        String query = "INSERT INTO policies (name, description) VALUES (?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, policy.getName());
            statement.setString(2, policy.getDescription());
            statement.executeUpdate();
        }
    }

    public void updatePolicy(Policy policy) throws SQLException {
        String query = "UPDATE policies SET name = ?, description = ? WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, policy.getName());
            statement.setString(2, policy.getDescription());
            statement.setInt(3, policy.getId());
            statement.executeUpdate();
        }
    }

    public void deletePolicy(int policyId) throws SQLException {
        String query = "DELETE FROM policies WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, policyId);
            statement.executeUpdate();
        }
    }
}
