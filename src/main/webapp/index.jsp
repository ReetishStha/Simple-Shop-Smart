<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to ShopSmart</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">

    <style>
        body {
            margin: 0;
            font-family: 'Arial', sans-serif;
            background: linear-gradient(145deg, #f8f9fa, #e9ecef);
            color: #343a40;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }

        header {
            background-color: #007bff;
            color: white;
            padding: 1.5rem 2rem;
            text-align: center;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        header h1 {
            margin: 0;
            font-size: 2.5rem;
            font-weight: 600;
        }

        nav ul {
            list-style: none;
            padding: 0;
            margin-top: 1rem;
            display: flex;
            justify-content: center;
            gap: 2rem;
        }

        nav a {
            color: white;
            text-decoration: none;
            font-weight: 500;
            font-size: 1.1rem;
            padding: 0.5rem 1rem;
            border-radius: 30px;
            transition: background-color 0.3s ease;
        }

        nav a:hover {
            background-color: #0056b3;
            color: #f8f9fa;
        }

        .intro {
            flex: 1;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            text-align: center;
            padding: 5rem 2rem;
        }

        .intro h2 {
            font-size: 2.5rem;
            font-weight: 700;
            margin-bottom: 1.5rem;
            color: #343a40;
        }

        .intro p {
            font-size: 1.2rem;
            color: #6c757d;
            max-width: 700px;
            margin-bottom: 2rem;
        }

        .cta-button {
            background-color: #28a745;
            color: white;
            padding: 0.8rem 2.5rem;
            font-size: 1.2rem;
            border-radius: 50px;
            text-decoration: none;
            font-weight: 600;
            transition: background-color 0.3s ease;
        }

        .cta-button:hover {
            background-color: #218838;
        }

        footer {
            background-color: #343a40;
            color: white;
            text-align: center;
            padding: 1.5rem 0;
            font-size: 0.9rem;
        }

        footer a {
            color: #17a2b8;
            text-decoration: none;
        }

        footer a:hover {
            text-decoration: underline;
        }

        @media (max-width: 600px) {
            nav ul {
                flex-direction: column;
                gap: 1rem;
            }

            .intro h2 {
                font-size: 2rem;
            }

            .cta-button {
                padding: 0.8rem 2rem;
                font-size: 1rem;
            }
        }
    </style>
</head>
<body>

<header>
    <h1>Welcome to ShopSmart</h1>
    <nav>
        <ul>
            <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
            <li><a href="${pageContext.request.contextPath}/register">Register</a></li>
        </ul>
    </nav>
</header>

<section class="intro">
    <h2>Your One-Stop Shop for Everything!</h2>
    <p>Explore a wide range of products, great deals, and seamless shopping experiences. Sign up now to start shopping and enjoy exclusive offers!</p>
    <a href="${pageContext.request.contextPath}/register" class="cta-button">Sign Up Now</a>
</section>

<footer>
    <p>&copy; 2025 ShopSmart. All rights reserved. <a href="#">Privacy Policy</a> | <a href="#">Terms of Service</a></p>
</footer>

</body>
</html>
