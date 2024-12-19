package dao;

import beans.Account;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    private Connection connection;

    public AccountDAO() throws SQLException {
        this.connection = DatabaseConnection.getConnection();
    }

    public void addAccount(Account account) throws SQLException {
        String query = "INSERT INTO Account (username, password, email, role) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ps.setString(3, account.getEmail());
            ps.setString(4, account.getRole());
            ps.executeUpdate();
        }
    }

    public List<Account> getAllAccounts() throws SQLException {
        List<Account> accounts = new ArrayList<>();
        String query = "SELECT * FROM Account";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setEmail(rs.getString("email"));
                account.setRole(rs.getString("role"));
                accounts.add(account);
            }
        }
        return accounts;
    }

    public Account getAccountById(int id) throws SQLException {
        String query = "SELECT * FROM Account WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Account account = new Account();
                    account.setId(rs.getInt("id"));
                    account.setUsername(rs.getString("username"));
                    account.setPassword(rs.getString("password"));
                    account.setEmail(rs.getString("email"));
                    account.setRole(rs.getString("role"));
                    return account;
                }
            }
        }
        return null;
    }

    public void updateAccount(Account account) throws SQLException {
        String query = "UPDATE Account SET username = ?, password = ?, email = ?, role = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ps.setString(3, account.getEmail());
            ps.setString(4, account.getRole());
            ps.setInt(5, account.getId());
            ps.executeUpdate();
        }
    }

    public void deleteAccount(int id) throws SQLException {
        String query = "DELETE FROM Account WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public Account authenticate(String username, String password) throws SQLException {
        String query = "SELECT * FROM Account WHERE username = ? AND password = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Account account = new Account();
                    account.setId(rs.getInt("id"));
                    account.setUsername(rs.getString("username"));
                    account.setPassword(rs.getString("password"));
                    account.setEmail(rs.getString("email"));
                    account.setRole(rs.getString("role"));
                    return account;
                }
            }
        }
        return null;
    }
}
