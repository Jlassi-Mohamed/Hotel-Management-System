<%@ page language="java" import="java.util.List, beans.Hotel" %>
<jsp:useBean id="hotelList" scope="request" class="java.util.ArrayList" />
<html>
<head>
    <title>Hotels</title>
</head>
<body>
    <h2>Hotels</h2>
    <form action="ListHotelsServlet" method="get">
        Filter by City: <input type="text" name="city">
        Stars: <input type="number" name="stars" min="1" max="5">
        <input type="submit" value="Search">
    </form>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>City</th>
            <th>Stars</th>
            <th>Description</th>
        </tr>
        <% for (Hotel hotel : (List<Hotel>) hotelList) { %>
        <tr>
            <td><%= hotel.getName() %></td>
            <td><%= hotel.getCity() %></td>
            <td><%= hotel.getStars() %></td>
            <td><%= hotel.getDescription() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
