package com.example.shopsmart.dao;

import com.example.shopsmart.model.User;
import com.example.shopsmart.util.DBConnection;

import java.sql.*;

public class UserDAO {

    public static void addUser(User user) throws SQLException {
        String sql = "INSERT INTO Users (name, email, phone_number, password, role) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPhoneNumber());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getRole());
            stmt.executeUpdate();
        }
    }

    public static User getUserByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM Users WHERE email = ?";
        User user = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        rs.getString("password"),
                        rs.getString("role")
                );
            }
        }

        return user;
    }

    public static void deleteUser(int userId) throws SQLException {
        String sql = "DELETE FROM Users WHERE user_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            stmt.executeUpdate();
        }
    }

    public static void updateUser(User user) throws SQLException {
        String sql = "UPDATE Users SET name = ?, email = ?, phone_number = ?, password = ?, role = ? WHERE user_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPhoneNumber());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getRole());
            stmt.setInt(6, user.getUserId());
            stmt.executeUpdate();
        }
    }

    public static User getUserById(int userId) throws SQLException {
        String sql = "SELECT * FROM Users WHERE user_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        rs.getString("password"),
                        rs.getString("role")
                );
            }
        }
        return null;
    }

    public static int getTotalUsers() throws SQLException {
        String sql = "SELECT COUNT(*) FROM Users";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                return rs.getInt(1); // Return the count of users
            }
        }
        return 0; // Return 0 if there are no users
    }

}
