package servlets;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.SQLException;
import dao.AccountDAO;
import dao.DatabaseConnection;
import beans.Account;


public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("jsp/login.jsp");
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AccountDAO accountDAO = null;
        try {
            accountDAO = new AccountDAO();
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("jsp/login.jsp?error=" + java.net.URLEncoder.encode("Database connection failed", "UTF-8"));
            return;
        }

        try {
            Account account = accountDAO.authenticate(username, password);
            if (account != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", account);

                if ("admin".equals(account.getRole())) {
                    response.sendRedirect("jsp/adminDashboard.jsp");
                } else if ("agent".equals(account.getRole())) {
                    response.sendRedirect("jsp/agentDashboard.jsp");
                }
            } else {
                response.sendRedirect("jsp/login.jsp?error=" + java.net.URLEncoder.encode("Invalid credentials", "UTF-8"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("jsp/login.jsp?error=" + java.net.URLEncoder.encode("Error while logging in", "UTF-8"));
        }
    }
}
