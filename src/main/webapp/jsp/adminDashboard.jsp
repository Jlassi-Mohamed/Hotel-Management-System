<%@ page language="java" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.ZonedDateTime" %>
<html>
<head>
    <title>Admin Dashboard</title>
</head>
<body>
    <h2>Welcome, Admin!</h2>
    <p>Current Time: <%= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) %></p>
    <ul>
        <li><a href="listAgents.jsp">Manage Agents</a></li>
        <li><a href="listHotels.jsp">View Hotels</a></li>
        <li><a href="addHotel.jsp">Manage Hotels</a></li>
        <li><a href="logout">Logout</a></li>
    </ul>
</body>
</html>
