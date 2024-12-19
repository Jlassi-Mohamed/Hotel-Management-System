<html>
<head>
    <title>Add Hotel</title>
</head>
<body>
    <h2>Add Hotel</h2>
    <form action="${pageContext.request.contextPath}/HotelManagementServlet" method="post">
        <input type="hidden" name="action" value="add">
        Name: <input type="text" name="name" required><br>
        City: <input type="text" name="city" required><br>
        Stars: <input type="number" name="stars" min="1" max="5" required><br>
        Description: <textarea name="description"></textarea><br>
        Image URL: <input type="text" name="image"><br>
        <input type="submit" value="Add Hotel">
    </form>
</body>
</html>
