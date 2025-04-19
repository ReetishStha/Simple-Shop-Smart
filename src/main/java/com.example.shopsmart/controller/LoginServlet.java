package com.example.shopsmart.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

import com.example.shopsmart.model.User;
import com.example.shopsmart.service.AuthService;
import com.example.shopsmart.service.ActivityLogService;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check for saved email cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("savedEmail".equals(cookie.getName())) {
                    request.setAttribute("savedEmail", cookie.getValue());
                    break;
                }
            }
        }

        // Forward to login page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            User user = AuthService.validateUser(email, password);

            if (user != null) {
                // Set user in session
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                session.setAttribute("isLoggedIn", true);

                // Log login activity
                String userType = user.isAdmin() ? "Admin" : "User";
                ActivityLogService.logActivity(
                        userType + " login: " + user.getEmail(),
                        "login",
                        user.getUserId()
                );

                // Handle "Remember Me" cookie
                String rememberMe = request.getParameter("rememberMe");
                Cookie emailCookie;
                if ("on".equals(rememberMe)) {
                    emailCookie = new Cookie("savedEmail", email);
                    emailCookie.setMaxAge(60 * 60 * 24 * 7); // 7 days
                } else {
                    emailCookie = new Cookie("savedEmail", "");
                    emailCookie.setMaxAge(0); // Delete cookie
                }
                response.addCookie(emailCookie);

                // Redirect based on role
                if (user.isUser()) {
                    response.sendRedirect(request.getContextPath() + "/user/dashboard?loginerror=false");
                } else if (user.isAdmin()) {
                    response.sendRedirect(request.getContextPath() + "/admin/dashboard?loginerror=false");
                }

            } else {
                // Login failed, forward to login page with error
                forwardToLoginWithError(request, response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            forwardToLoginWithError(request, response);
        }
    }

    private void forwardToLoginWithError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("loginError", true);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
        dispatcher.forward(request, response);
    }
}
