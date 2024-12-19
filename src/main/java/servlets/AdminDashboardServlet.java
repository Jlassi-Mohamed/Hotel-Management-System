package servlets;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.SQLException;
import dao.AccountDAO;
import beans.Account;
import java.util.List;

public class AdminDashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountDAO accountDAO = null;
		try {
			accountDAO = new AccountDAO();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
            List<Account> accounts = accountDAO.getAllAccounts();
            request.setAttribute("accounts", accounts);
            RequestDispatcher dispatcher = request.getRequestDispatcher("adminDashboard.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("adminDashboard.jsp?error=Error fetching accounts");
        }
    }
}
