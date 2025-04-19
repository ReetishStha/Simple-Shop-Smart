package com.example.shopsmart.controller.user;

import com.example.shopsmart.model.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.example.shopsmart.model.User;
import com.example.shopsmart.service.ProductService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserDashboardServlet", value = "/user/dashboard")
public class UserDashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch logged-in user from session
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            try {
                // Example category for recommended products (you can customize this logic)
                String recommendedCategory = "electronics"; // Replace with a dynamic category if needed
                List<Product> recommendedProducts = ProductService.getRecommendedProducts(recommendedCategory);

                // Set attributes for the JSP page
                request.setAttribute("recommendedProducts", recommendedProducts);
                request.setAttribute("user", user);

                // Forward to the user dashboard page
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/user/dashboard.jsp");
                dispatcher.forward(request, response);
            } catch (SQLException e) {
                // Handle SQL exception if something goes wrong with DB queries
                throw new ServletException("Error fetching recommended products", e);
            }
        } else {
            // If no user is logged in, redirect to login page
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}
