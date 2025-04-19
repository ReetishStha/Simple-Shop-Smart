package com.example.shopsmart.dao;

import com.example.shopsmart.model.ActivityLog;
import com.example.shopsmart.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityLogDAO {

    public static boolean logActivity(String activity, String activityType, int userId) throws SQLException {
        String sql = "INSERT INTO ActivityLogs (activity, activity_type, user_id, timestamp) VALUES (?, ?, ?, NOW())";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, activity);
            stmt.setString(2, activityType);
            stmt.setInt(3, userId);
            stmt.executeUpdate();
            return true;
        }
    }

    public static List<ActivityLog> getRecentActivityLogs(int limit) throws SQLException {
        List<ActivityLog> activityLogs = new ArrayList<>();
        String sql = "SELECT * FROM ActivityLogs ORDER BY timestamp DESC LIMIT ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, limit);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ActivityLog log = new ActivityLog(
                        rs.getInt("log_id"),
                        rs.getString("activity"),
                        rs.getString("activity_type"),
                        rs.getInt("user_id"),
                        rs.getTimestamp("timestamp")
                );
                activityLogs.add(log);
            }
        }

        return activityLogs;
    }

    public static List<ActivityLog> getUserActivityLogs(int userId, int limit) throws SQLException {
        List<ActivityLog> activityLogs = new ArrayList<>();
        String sql = "SELECT * FROM ActivityLogs WHERE user_id = ? ORDER BY timestamp DESC LIMIT ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            stmt.setInt(2, limit);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ActivityLog log = new ActivityLog(
                        rs.getInt("log_id"),
                        rs.getString("activity"),
                        rs.getString("activity_type"),
                        rs.getInt("user_id"),
                        rs.getTimestamp("timestamp")
                );
                activityLogs.add(log);
            }
        }

        return activityLogs;
    }

    public static int getActivityLogCount() throws SQLException {
        String sql = "SELECT COUNT(*) FROM ActivityLogs";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;
    }
}
