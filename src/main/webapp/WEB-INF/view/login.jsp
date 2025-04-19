<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - ShopSmart Gallery</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">

    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(135deg, #f0f4f8, #d9e2ec);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background: white;
            padding: 3rem 2rem;
            border-radius: 16px;
            box-shadow: 0 10px 40px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 90%;
            text-align: center;
        }

        h1 {
            font-size: 2rem;
            color: #2c3e50;
            margin-bottom: 0.5rem;
        }

        h2 {
            font-size: 1.2rem;
            color: #7f8c8d;
            margin-bottom: 2rem;
        }

        .message {
            padding: 1rem;
            border-radius: 8px;
            margin-bottom: 1.5rem;
            font-size: 0.95rem;
        }

        .success {
            background-color: #e0f8ec;
            color: #2e7d32;
            border-left: 5px solid #2e7d32;
        }

        .error {
            background-color: #fbeaea;
            color: #c0392b;
            border-left: 5px solid #c0392b;
        }

        form {
            text-align: left;
        }

        label {
            display: block;
            margin-bottom: 1rem;
            font-weight: 600;
            color: #34495e;
        }

        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 0.75rem;
            margin-top: 0.25rem;
            border: 1px solid #ccc;
            border-radius: 8px;
            box-sizing: border-box;
            font-size: 1rem;
        }

        input[type="submit"] {
            margin-top: 1.5rem;
            width: 100%;
            padding: 0.75rem;
            background-color: #3498db;
            border: none;
            border-radius: 8px;
            color: white;
            font-size: 1rem;
            font-weight: bold;
            cursor: pointer;
            transition: background 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #2980b9;
        }

        .nav-links {
            margin-top: 1rem;
            text-align: center;
        }

        .nav-links a {
            color: #3498db;
            text-decoration: none;
            font-weight: 500;
        }

        .nav-links a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>ShopSmart Gallery</h1>
    <h2>Welcome back! Please log in</h2>

    <%-- Display messages based on registration or login error --%>
    <%
        String regerror = request.getParameter("regerror");
        if ("false".equals(regerror)) {
    %>
        <div class="message success">Registration successful. You can now sign in!</div>
    <%
        }

        Boolean loginError = (Boolean) request.getAttribute("loginError");
        if (loginError != null && loginError) {
    %>
        <div class="message error">Invalid email or password. Please try again.</div>
    <%
        }

        // Prefill email if "Remember Me" cookie exists
        String savedEmail = (String) request.getAttribute("savedEmail");
    %>

    <form action="${pageContext.request.contextPath}/login" method="post">
        <label for="email">Email Address
            <input type="email" id="email" name="email" required placeholder="you@example.com" value="<%= savedEmail != null ? savedEmail : "" %>" aria-label="Email Address">
        </label>
        <label for="password">Password
            <input type="password" id="password" name="password" required placeholder="Enter your password" aria-label="Password">
        </label>
        <label>
            <input type="checkbox" name="rememberMe" id="rememberMe">
            Remember me
        </label>
        <input type="submit" value="Login">
    </form>

    <div class="nav-links">
        <p>Don't have an account?
            <a href="${pageContext.request.contextPath}/register">Register here</a>
        </p>
    </div>
</div>
</body>
</html>
