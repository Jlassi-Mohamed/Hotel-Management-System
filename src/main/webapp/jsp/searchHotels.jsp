<html>
<head>
    <title>Search Hotels</title>
</head>
<body>
    <h2>Search Hotels</h2>
    <form action="SearchHotelsServlet" method="get">
        City: <input type="text" name="city"><br>
        Stars: <input type="number" name="stars" min="1" max="5"><br>
        Price Range: 
        Min: <input type="number" name="minPrice">
        Max: <input type="number" name="maxPrice"><br>
        <input type="submit" value="Search">
    </form>
</body>
</html>
