package com.example.shopsmart.controller;

import com.example.shopsmart.model.User;
import com.example.shopsmart.service.ActivityLogService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);

        if (session != null) {
            User user = (User) session.getAttribute("user");

            if (user != null) {
                String userType = user.getRole().equalsIgnoreCase("admin") ? "Admin" : "User";

                // Log the logout activity
                ActivityLogService.logActivity(
                        userType + " logout: " + user.getEmail(),
                        "logout",
                        user.getUserId()
                );
            }

            // Clear session attributes
            session.removeAttribute("user");
            session.removeAttribute("isLoggedIn");
            session.invalidate();
        }

        // Redirect to login page
        response.sendRedirect(request.getContextPath() + "/login");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response); // Treat POST as GET for logout
    }
}
