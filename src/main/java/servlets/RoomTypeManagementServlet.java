package servlets;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.SQLException;
import dao.RoomTypeDAO;
import beans.RoomType;

public class RoomTypeManagementServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        RoomTypeDAO roomTypeDAO = null;
		try {
			roomTypeDAO = new RoomTypeDAO();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        try {
            if ("add".equals(action)) {
                String label = request.getParameter("label");
                int capacity = Integer.parseInt(request.getParameter("capacity"));
                int price = Integer.parseInt(request.getParameter("price"));

                RoomType roomType = new RoomType(label, capacity, price);
                roomTypeDAO.addRoomType(roomType);
                response.sendRedirect("agentDashboard.jsp");
            } else if ("update".equals(action)) {
            } else if ("delete".equals(action)) {
                int roomTypeId = Integer.parseInt(request.getParameter("roomTypeId"));
                roomTypeDAO.deleteRoomType(roomTypeId);
                response.sendRedirect("agentDashboard.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("agentDashboard.jsp?error=Error while managing room type");
        }
    }
}
