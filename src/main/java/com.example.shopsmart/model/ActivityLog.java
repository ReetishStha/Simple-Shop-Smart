package com.example.shopsmart.model;

import java.sql.Timestamp;

/**
 * Model class to represent an activity log in the system.
 */
public class ActivityLog {

    private int logId;  // Primary key for the log
    private String activity;  // Description of the activity (e.g., "User logged in", "Image uploaded")
    private String activityType;  // Type of activity (e.g., "login", "upload", "delete")
    private int userId;  // ID of the user who performed the activity
    private Timestamp timestamp;  // Timestamp when the activity occurred

    // Constructor for creating ActivityLog object from database result
    public ActivityLog(int logId, String activity, String activityType, int userId, Timestamp timestamp) {
        this.logId = logId;
        this.activity = activity;
        this.activityType = activityType;
        this.userId = userId;
        this.timestamp = timestamp;
    }

    // Constructor for creating ActivityLog object for logging new activity
    public ActivityLog(String activity, String activityType, int userId) {
        this.activity = activity;
        this.activityType = activityType;
        this.userId = userId;
        this.timestamp = new Timestamp(System.currentTimeMillis());  // Set current time as default timestamp
    }

    // Getter and Setter methods
    public int getLogId() {
        return logId;
    }
    public void setLogId(int logId) {
        this.logId = logId;
    }

    public String getActivity() {
        return activity;
    }
    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getActivityType() {
        return activityType;
    }
    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ActivityLog{" +
                "logId=" + logId +
                ", activity='" + activity + '\'' +
                ", activityType='" + activityType + '\'' +
                ", userId=" + userId +
                ", timestamp=" + timestamp +
                '}';
    }
}
