package com.example.shopsmart.controller.admin;

import com.example.shopsmart.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.example.shopsmart.service.ProductService;
import com.example.shopsmart.service.UserService;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdminDashboardServlet", value = "/admin/dashboard")
public class AdminDashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get logged-in admin from session
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null && user.isAdmin()) {
            // Fetch admin-relevant data like product stats or user management info
            try {
                // Fetch total number of products
                int totalProducts = ProductService.getTotalProducts();
                request.setAttribute("totalProducts", totalProducts);
            } catch (SQLException e) {
                // Log error and redirect to error page
                log("Error fetching total products", e);
                request.setAttribute("errorMessage", "Unable to retrieve product data. Please try again later.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/error.jsp");
                dispatcher.forward(request, response);
                return;
            }

            try {
                // Fetch total number of users
                int totalUsers = UserService.getTotalUsers();
                request.setAttribute("totalUsers", totalUsers);
            } catch (SQLException e) {
                // Log error and redirect to error page
                log("Error fetching total users", e);
                request.setAttribute("errorMessage", "Unable to retrieve user data. Please try again later.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/error.jsp");
                dispatcher.forward(request, response);
                return;
            }

            // Forward to admin dashboard page
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/admin/dashboard.jsp");
            dispatcher.forward(request, response);
        } else {
            // If no admin or invalid session, redirect to login page
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}
