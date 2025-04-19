<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            text-align: center;
            padding: 50px;
        }
        h1 {
            color: #dc3545;
        }
        p {
            font-size: 18px;
            color: #333;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            text-decoration: none;
            color: #fff;
            background-color: #007bff;
            padding: 10px 20px;
            border-radius: 5px;
        }
        a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>An error occurred</h1>
    <p>${errorMessage}</p>
    <a href="${pageContext.request.contextPath}/admin/dashboard">Go back to Dashboard</a>
</body>
</html>
