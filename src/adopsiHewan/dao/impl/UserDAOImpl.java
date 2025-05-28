package adopsiHewan.dao.impl;

import adopsiHewan.config.DBConnection;
import adopsiHewan.dao.UserDAO;
import adopsiHewan.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private final Connection conn;

    public UserDAOImpl() throws SQLException {
        this.conn = DBConnection.getConnection();
    }

    @Override
    public void addUser(User user) throws SQLException {
        String query = "INSERT INTO user (nama, email, password, alamat, no_hp, role) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, user.getNama());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getAlamat());
            stmt.setString(5, user.getNoHp());
            stmt.setString(6, user.getRole());
            stmt.executeUpdate();
        }
    }

    @Override
    public User getUserById(int id) throws SQLException {
        String query = "SELECT * FROM user WHERE id_user = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(rs.getInt("id_user"), rs.getString("nama"), rs.getString("email"), rs.getString("alamat"),
                            rs.getString("password"), rs.getString("no_hp"), rs.getString("role"));
                }
            }
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM user";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                users.add(new User(rs.getInt("id_user"), rs.getString("nama"), rs.getString("email"), rs.getString("password"),
                        rs.getString("alamat"), rs.getString("no_hp"), rs.getString("role")));
            }
        }
        return users;
    }

    @Override
    public User loginUser(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isUsernameExist(String username) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isEmailExist(String email) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean registerUser(User user) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
