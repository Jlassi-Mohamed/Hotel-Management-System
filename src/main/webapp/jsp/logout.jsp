<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Logout</title>
</head>
<body>
    <h2>Are you sure you want to logout?</h2>
    <form action="${pageContext.request.contextPath}/LogoutServlet" method="post">
        <input type="submit" value="Logout">
    </form>
</body>
</html>
