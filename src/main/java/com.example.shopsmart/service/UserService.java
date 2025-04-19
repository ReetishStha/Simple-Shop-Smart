package com.example.shopsmart.service;

import com.example.shopsmart.dao.UserDAO;

import java.sql.SQLException;

public class UserService {
    // Get total number of users
    public static int getTotalUsers() throws SQLException {
        return UserDAO.getTotalUsers();
    }
}
