package servlets;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.SQLException;
import dao.HotelDAO;
import beans.Hotel;

public class HotelManagementServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HotelDAO hotelDAO = null;
		try {
			hotelDAO = new HotelDAO();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        try {
            if ("add".equals(action)) {
                String name = request.getParameter("name");
                String city = request.getParameter("city");
                int stars = Integer.parseInt(request.getParameter("stars"));
                String description = request.getParameter("description");
                String image = request.getParameter("image");

                Hotel hotel = new Hotel(name, city, stars, description, image);
                hotelDAO.addHotel(hotel);
                response.sendRedirect("jsp/agentDashboard.jsp");
            } else if ("update".equals(action)) {
            } else if ("delete".equals(action)) {
                int hotelId = Integer.parseInt(request.getParameter("hotelId"));
                hotelDAO.deleteHotel(hotelId);
                response.sendRedirect("jsp/agentDashboard.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("agentDashboard.jsp?error=Error while managing hotel");
        }
    }
}
