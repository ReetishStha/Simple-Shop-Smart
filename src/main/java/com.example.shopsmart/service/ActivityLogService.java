package com.example.shopsmart.service;

import com.example.shopsmart.dao.ActivityLogDAO;

public class ActivityLogService {
    public static void logActivity(String activity, String activityType, int userId) {
        try {
            ActivityLogDAO.logActivity(activity, activityType, userId);
        } catch (Exception e) {
            System.err.println("Error in logActivity: " + e.getMessage());
        }
    }
}
