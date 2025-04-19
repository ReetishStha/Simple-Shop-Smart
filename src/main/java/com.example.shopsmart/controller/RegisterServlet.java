package com.example.shopsmart.controller;

import com.example.shopsmart.service.ActivityLogService;
import com.example.shopsmart.service.AuthService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/register.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fix: match names with HTML form fields
        String name = request.getParameter("fullname");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String password = request.getParameter("password");

        try {
            // Register new user with role "user"
            int userId = AuthService.createUser(name, email, phoneNumber, password, "user");

            if (userId > 0) {
                // Log the registration
                ActivityLogService.logActivity(
                        "New user registered: " + name + " (" + email + ")",
                        "register",
                        userId
                );

                // Redirect to login page with success message
                response.sendRedirect(request.getContextPath() + "/login?regerror=false");
            } else {
                // Registration failed (e.g. email already exists)
                request.setAttribute("regerror", true);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/register.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("regerror", true);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/register.jsp");
            dispatcher.forward(request, response);
        }
    }
}
