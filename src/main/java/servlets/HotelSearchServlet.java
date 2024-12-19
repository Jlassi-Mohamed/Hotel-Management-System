package servlets;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.SQLException;
import dao.HotelDAO;
import beans.Hotel;
import java.util.List;

public class HotelSearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String city = request.getParameter("City");
        int stars = Integer.parseInt(request.getParameter("Stars"));

        HotelDAO hotelDAO = null;
		try {
			hotelDAO = new HotelDAO();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        try {
            List<Hotel> hotels = hotelDAO.searchHotels(city, stars);
            request.setAttribute("hotels", hotels);
            RequestDispatcher dispatcher = request.getRequestDispatcher("hotelSearchResults.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("hotelSearch.jsp?error=Error while searching for hotels");
        }
    }
}
