<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><%= request.getAttribute("title") != null ? request.getAttribute("title") : "Default Title" %></title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #333;
            color: white;
            padding: 1em;
            text-align: center;
        }
        nav {
            margin: 0;
            padding: 1em;
            background-color: #f4f4f4;
        }
        nav a {
            margin-right: 10px;
            text-decoration: none;
            color: #333;
        }
        main {
            padding: 2em;
        }
    </style>
</head>
<body>
    <header>
        <h1>Hotel Management System</h1>
    </header>
    <nav>
        <a href="${pageContext.request.contextPath}/home.jsp">Home</a>
        <a href="${pageContext.request.contextPath}/login.jsp">Login</a>
        <a href="${pageContext.request.contextPath}/register.jsp">Register</a>
    </nav>
    <main>
        <h2>Welcome to the Hotel Management System</h2>
        <p>Use this section to display the main content of the page.</p>
    </main>
    <footer>
        <p style="text-align:center; margin-top:20px;">&copy; 2024 Hotel Management System. All Rights Reserved.</p>
    </footer>
</body>
</html>
