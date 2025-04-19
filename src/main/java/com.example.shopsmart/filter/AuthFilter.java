package com.example.shopsmart.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/admin/*", "/user/*", "/home"})
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);

        boolean loggedIn = session != null && session.getAttribute("user") != null;

        if (loggedIn) {
            filterChain.doFilter(request, response); // Allow access
        } else {
            response.sendRedirect(request.getContextPath() + "/login"); // Redirect to log in
        }
    }
}
