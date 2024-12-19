<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.ZonedDateTime" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Agent Dashboard</title>
</head>
<body>
    <h2>Welcome, Agent!</h2>
    <p>Current Time: <%= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) %></p>
    <ul>
        <li><a href="bookHotel.jsp">Book Hotel</a></li>
        <li><a href="searchHotels.jsp">Search Hotels</a></li>
        <li><a href="logout.jsp">Logout</a></li>
    </ul>
</body>
</html>