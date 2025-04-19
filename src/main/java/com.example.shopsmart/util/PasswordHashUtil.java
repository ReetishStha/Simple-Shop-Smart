package com.example.shopsmart.util;

import org.mindrot.jbcrypt.BCrypt;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PasswordHashUtil {

    private static final Logger LOGGER = Logger.getLogger(PasswordHashUtil.class.getName());

    private static final int LOG_ROUNDS = 12;

    public static String hashPassword(String plainTextPassword) {
        if (plainTextPassword == null || plainTextPassword.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        if (plainTextPassword.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }

        String salt = BCrypt.gensalt(LOG_ROUNDS);
        String hashedPassword = BCrypt.hashpw(plainTextPassword, salt);

        LOGGER.log(Level.INFO, "Password hashed successfully.");
        return hashedPassword;
    }

    public static boolean verifyPassword(String plainTextPassword, String hashedPassword) {
        if (plainTextPassword == null || plainTextPassword.isEmpty() ||
                hashedPassword == null || hashedPassword.isEmpty()) {
            return false;
        }

        try {

            boolean isValid = BCrypt.checkpw(plainTextPassword, hashedPassword);

            if (isValid) {
                LOGGER.log(Level.INFO, "Password verification successful.");
            } else {
                LOGGER.log(Level.WARNING, "Password verification failed.");
            }

            return isValid;
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.SEVERE, "Error verifying password: " + e.getMessage(), e);
            return false;
        }
    }
}
