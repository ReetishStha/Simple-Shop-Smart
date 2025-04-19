<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register - ShopSmart Gallery</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
            max-width: 450px;
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

        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 0.75rem;
            margin-top: 0.25rem;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 1rem;
            box-sizing: border-box;
        }

        input[type="submit"] {
            margin-top: 1.5rem;
            width: 100%;
            padding: 0.75rem;
            background-color: #2ecc71;
            border: none;
            border-radius: 8px;
            color: white;
            font-size: 1rem;
            font-weight: bold;
            cursor: pointer;
            transition: background 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #27ae60;
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
    <h2>Create your account</h2>

    <%-- Error message (from request attribute) --%>
    <%
        Boolean error = (Boolean) request.getAttribute("regerror");
        if (Boolean.TRUE.equals(error)) {
    %>
        <div class="message error">Registration failed. Email may already be in use.</div>
    <%
        }
    %>

    <form action="${pageContext.request.contextPath}/register" method="post">
        <label for="fullname">Full Name
            <input type="text" name="fullname" id="fullname" required placeholder="John Doe" />
        </label>
        <label for="email">Email Address
            <input type="email" name="email" id="email" required placeholder="you@example.com" />
        </label>
        <label for="phoneNumber">Phone Number
            <input type="text" name="phoneNumber" id="phoneNumber" placeholder="Optional" />
        </label>
        <label for="password">Password
            <input type="password" name="password" id="password" required placeholder="Create a password" />
        </label>
        <input type="submit" value="Create Account" />
    </form>

    <div class="nav-links">
        <p>Already have an account? <a href="${pageContext.request.contextPath}/login">Sign In</a></p>
    </div>
</div>
</body>
</html>
