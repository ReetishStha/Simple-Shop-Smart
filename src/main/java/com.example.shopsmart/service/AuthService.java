package com.example.shopsmart.service;

import com.example.shopsmart.dao.UserDAO;
import com.example.shopsmart.model.User;
import com.example.shopsmart.util.PasswordHashUtil;

import java.sql.SQLException;

public class AuthService {

    // Create a new user (registration)
    public static int createUser(String name, String email, String phoneNumber, String password, String role) throws SQLException {
        // Check if user already exists
        if (UserDAO.getUserByEmail(email) != null) {
            return -1; // User already exists
        }

        // Hash the password before storing it
        String hashedPassword = PasswordHashUtil.hashPassword(password);

        // Create a new User object
        User newUser = new User(name, email, phoneNumber, hashedPassword, role);

        // Save the user to the database
        UserDAO.addUser(newUser);
        return 1; // Return success code
    }

    // Validate the user's login credentials
    public static User validateUser(String email, String password) throws SQLException {
        // Retrieve user from the database by email
        User user = UserDAO.getUserByEmail(email);

        if (user != null && PasswordHashUtil.verifyPassword(password, user.getPassword())) {
            return user; // Successful login
        }

        return null; // Invalid credentials
    }

}
