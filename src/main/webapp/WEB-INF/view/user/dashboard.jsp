<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard - ShopSmart</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: #f0f4f8;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 900px;
            margin: 2rem auto;
            padding: 2rem;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1);
        }

        h1 {
            color: #2c3e50;
        }

        h2 {
            color: #34495e;
            margin-bottom: 1rem;
        }

        .product-list {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
            gap: 1rem;
        }

        .product-item {
            background-color: #fff;
            padding: 1rem;
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
            transition: transform 0.2s;
        }

        .product-item:hover {
            transform: translateY(-5px);
        }

        .product-item h3 {
            margin: 0;
            font-size: 1.2rem;
            color: #2c3e50;
        }

        .product-item p {
            color: #7f8c8d;
        }

        .product-item span {
            font-weight: bold;
            color: #27ae60;
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>Welcome, ${user.name}</h1>
        <h2>Your Recommended Products</h2>

        <div class="product-list">
            <c:forEach var="product" items="${recommendedProducts}">
                <div class="product-item">
                    <h3>${product.name}</h3>
                    <p>${product.description}</p>
                    <span>${product.price}</span>
                </div>
            </c:forEach>
        </div>
    </div>

</body>
</html>
