<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard - ShopSmart</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: #f0f4f8;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 1000px;
            margin: 2rem auto;
            padding: 2rem;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1);
        }

        h1 {
            color: #2c3e50;
        }

        .dashboard-stats {
            display: flex;
            justify-content: space-between;
            margin-bottom: 2rem;
        }

        .stat-box {
            background-color: #fff;
            padding: 1.5rem;
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
            width: 30%;
            text-align: center;
        }

        .stat-box h3 {
            font-size: 1.5rem;
            color: #2c3e50;
        }

        .stat-box p {
            font-size: 1.1rem;
            color: #7f8c8d;
        }

        .nav-links {
            margin-top: 1.5rem;
        }

        .nav-links a {
            display: inline-block;
            padding: 0.5rem 1rem;
            margin-right: 1rem;
            background-color: #3498db;
            color: white;
            border-radius: 8px;
            text-decoration: none;
            transition: background-color 0.3s;
        }

        .nav-links a:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>Admin Dashboard</h1>

        <div class="dashboard-stats">
            <div class="stat-box">
                <h3>Total Products</h3>
                <p>${totalProducts}</p>
            </div>
            <div class="stat-box">
                <h3>Total Users</h3>
                <p>${totalUsers}</p>
            </div>
            <div class="stat-box">
                <h3>Total Orders</h3>
                <p>150</p>
            </div>
        </div>

        <div class="nav-links">
            <a href="${pageContext.request.contextPath}/admin/manage-products">Manage Products</a>
            <a href="${pageContext.request.contextPath}/admin/manage-users">Manage Users</a>
        </div>
    </div>

</body>
</html>
