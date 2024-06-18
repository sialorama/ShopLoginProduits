<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Produits Page</title>
    <!-- Add your CSS links or styles here -->
    <style>
        /* Example styles */
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 20px;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
        }
        .welcome {
            text-align: center;
            margin-bottom: 20px;
        }
        .logout-btn {
            float: right;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="welcome">Welcome to Produits Page!</h1>

    <div>
        <p>Hello, <strong>${user.email}</strong> (Role: ${user.role})</p>
        <!-- Display additional user information or options based on role -->
    </div>

    <div class="logout-btn">
        <form action="logout" method="post">
            <input type="submit" value="Logout">
        </form>
    </div>

    <!-- Add content specific to the produits page -->
    <div>
        <!-- Example: Displaying products -->
        <h2>Products List</h2>
        <ul>
            <c:forEach var="product" items="${products}">
                <li>${product.name} - ${product.price}</li>
            </c:forEach>
        </ul>
    </div>
</div>
</body>
</html>
