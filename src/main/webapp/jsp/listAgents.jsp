<%@ page language="java" import="java.util.List, beans.Account" %>
<jsp:useBean id="agentList" scope="request" class="java.util.ArrayList" />
<html>
<head>
    <title>List Agents</title>
</head>
<body>
    <h2>Agents</h2>
    <table border="1">
        <tr>
            <th>Username</th>
            <th>Email</th>
        </tr>
        <% for (Account agent : (List<Account>) agentList) { %>
        <tr>
            <td><%= agent.getUsername() %></td>
            <td><%= agent.getEmail() %></td>
        </tr>
        <% } %>
    </table>
    <a href="addAgent.jsp">Add New Agent</a>
</body>
</html>
