package servlets;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.SQLException;
import dao.HotelDAO;
import dao.RoomTypeDAO;
import beans.Hotel;
import beans.RoomType;
import java.util.List;

public class AgentDashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HotelDAO hotelDAO = null;
		try {
			hotelDAO = new HotelDAO();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        RoomTypeDAO roomTypeDAO = null;
		try {
			roomTypeDAO = new RoomTypeDAO();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        try {
            List<Hotel> hotels = hotelDAO.getAllHotels();
            List<RoomType> roomTypes = roomTypeDAO.getAllRoomTypes();
            
            request.setAttribute("hotels", hotels);
            request.setAttribute("roomTypes", roomTypes);
            RequestDispatcher dispatcher = request.getRequestDispatcher("agentDashboard.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("agentDashboard.jsp?error=Error fetching hotels and room types");
        }
    }
}
