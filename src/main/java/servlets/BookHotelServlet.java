package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.DatabaseConnection;

public class BookHotelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String fromDate = request.getParameter("fromDate");
        String toDate = request.getParameter("toDate");

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO bookings (first_name, last_name, email, phone, from_date, to_date) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, phone);
            preparedStatement.setString(5, fromDate);
            preparedStatement.setString(6, toDate);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                response.getWriter().write("Booking successful!");
            } else {
                response.getWriter().write("Failed to book. Please try again.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("An error occurred while processing your booking.");
        }
    }
}
