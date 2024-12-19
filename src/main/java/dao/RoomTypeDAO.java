package dao;

import beans.RoomType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomTypeDAO {
    private Connection connection;

    public RoomTypeDAO() throws SQLException {
        this.connection = DatabaseConnection.getConnection();
    }

    public void addRoomType(RoomType roomType) throws SQLException {
        String query = "INSERT INTO RoomType (label, capacity, price) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, roomType.getLabel());
            ps.setInt(2, roomType.getCapacity());
            ps.setInt(3, roomType.getPrice());
            ps.executeUpdate();
        }
    }

    public List<RoomType> getAllRoomTypes() throws SQLException {
        List<RoomType> roomTypes = new ArrayList<>();
        String query = "SELECT * FROM RoomType";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                RoomType roomType = new RoomType();
                roomType.setId(rs.getInt("id"));
                roomType.setLabel(rs.getString("label"));
                roomType.setCapacity(rs.getInt("capacity"));
                roomType.setPrice(rs.getInt("prix"));
                roomTypes.add(roomType);
            }
        }
        return roomTypes;
    }

    public RoomType getRoomTypeById(int id) throws SQLException {
        String query = "SELECT * FROM RoomType WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    RoomType roomType = new RoomType();
                    roomType.setId(rs.getInt("id"));
                    roomType.setLabel(rs.getString("label"));
                    roomType.setCapacity(rs.getInt("capacity"));
                    roomType.setPrice(rs.getInt("prix"));
                    return roomType;
                }
            }
        }
        return null;
    }

    // Update a room type
    public void updateRoomType(RoomType roomType) throws SQLException {
        String query = "UPDATE RoomType SET label = ?, capacity = ?, prix = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, roomType.getLabel());
            ps.setInt(2, roomType.getCapacity());
            ps.setInt(3, roomType.getPrice());
            ps.setInt(4, roomType.getId());
            ps.executeUpdate();
        }
    }

    public void deleteRoomType(int id) throws SQLException {
        String query = "DELETE FROM RoomType WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<RoomType> searchRoomTypes(int minCapacity, int maxPrice) throws SQLException {
        List<RoomType> roomTypes = new ArrayList<>();
        String query = "SELECT * FROM RoomType WHERE capacity >= ? AND prix <= ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, minCapacity);
            ps.setInt(2, maxPrice);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    RoomType roomType = new RoomType();
                    roomType.setId(rs.getInt("id"));
                    roomType.setLabel(rs.getString("label"));
                    roomType.setCapacity(rs.getInt("capacity"));
                    roomType.setPrice(rs.getInt("prix"));
                    roomTypes.add(roomType);
                }
            }
        }
        return roomTypes;
    }
}
