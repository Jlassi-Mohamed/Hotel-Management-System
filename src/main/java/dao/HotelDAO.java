package dao;

import beans.Hotel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO {
    private Connection connection;

    public HotelDAO() throws SQLException {
        this.connection = DatabaseConnection.getConnection();
    }

    public void addHotel(Hotel hotel) throws SQLException {
        String query = "INSERT INTO Hotel (name, city, stars, description, image) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, hotel.getName());
            ps.setString(2, hotel.getCity());
            ps.setInt(3, hotel.getStars());
            ps.setString(4, hotel.getDescription());
            ps.setString(5, hotel.getImage());
            ps.executeUpdate();
        }
    }

    // Retrieve all hotels
    public List<Hotel> getAllHotels() throws SQLException {
        List<Hotel> hotels = new ArrayList<>();
        String query = "SELECT * FROM Hotel";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Hotel hotel = new Hotel();
                hotel.setId(rs.getInt("id"));
                hotel.setName(rs.getString("name"));
                hotel.setCity(rs.getString("city"));
                hotel.setStars(rs.getInt("stars"));
                hotel.setDescription(rs.getString("description"));
                hotel.setImage(rs.getString("image"));
                hotels.add(hotel);
            }
        }
        return hotels;
    }

    // Retrieve a hotel by ID
    public Hotel getHotelById(int id) throws SQLException {
        String query = "SELECT * FROM Hotel WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Hotel hotel = new Hotel();
                    hotel.setId(rs.getInt("id"));
                    hotel.setName(rs.getString("name"));
                    hotel.setCity(rs.getString("city"));
                    hotel.setStars(rs.getInt("stars"));
                    hotel.setDescription(rs.getString("description"));
                    hotel.setImage(rs.getString("image"));
                    return hotel;
                }
            }
        }
        return null;
    }

    // Update a hotel
    public void updateHotel(Hotel hotel) throws SQLException {
        String query = "UPDATE Hotel SET name = ?, city = ?, stars = ?, description = ?, image = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, hotel.getName());
            ps.setString(2, hotel.getCity());
            ps.setInt(3, hotel.getStars());
            ps.setString(4, hotel.getDescription());
            ps.setString(5, hotel.getImage());
            ps.setInt(6, hotel.getId());
            ps.executeUpdate();
        }
    }

    // Delete a hotel by ID
    public void deleteHotel(int id) throws SQLException {
        String query = "DELETE FROM Hotel WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    // Retrieve hotels based on search criteria (city and stars)
    public List<Hotel> searchHotels(String city, int stars) throws SQLException {
        List<Hotel> hotels = new ArrayList<>();
        String query = "SELECT * FROM Hotel WHERE city = ? AND stars = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, city);
            ps.setInt(2, stars);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Hotel hotel = new Hotel();
                    hotel.setId(rs.getInt("id"));
                    hotel.setName(rs.getString("name"));
                    hotel.setCity(rs.getString("city"));
                    hotel.setStars(rs.getInt("stars"));
                    hotel.setDescription(rs.getString("description"));
                    hotel.setImage(rs.getString("image"));
                    hotels.add(hotel);
                }
            }
        }
        return hotels;
    }
}
