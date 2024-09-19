package com.policyautomation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PolicyDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/policy_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1408620Anki@";

    public List<Policy> getAllPolicies() throws SQLException {
        List<Policy> policies = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM policies")) {
            while (rs.next()) {
                policies.add(new Policy(rs.getInt("id"), rs.getString("name"), rs.getString("description")));
            }
        }
        return policies;
    }

    public void addPolicy(Policy policy) throws SQLException {
        String query = "INSERT INTO policies (name, description) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, policy.getName());
            pstmt.setString(2, policy.getDescription());
            pstmt.executeUpdate();
        }
    }
}
