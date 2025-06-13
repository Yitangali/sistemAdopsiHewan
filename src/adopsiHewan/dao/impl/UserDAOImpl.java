/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.dao.impl;

import adopsiHewan.dao.impl.UserDAO;
import adopsiHewan.model.User;
import adopsiHewan.config.DBConnection;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class UserDAOImpl implements UserDAO {
    private Connection conn;
    private Object users;
    private Object controller;
    
    public UserDAOImpl() {
        conn = DBConnection.getConnection();
    }
    
    @Override
    public boolean registerUser(User user) {
        String sql = "INSERT INTO User (nama, email, alamat, password, no_hp, role) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getNama());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getAlamat());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getNoHp());
            stmt.setString(6, user.getRole());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }
    
    @Override
    public boolean isEmailExist(String email) {
        String sql = "SELECT id_user FROM User WHERE email = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            return true;
        }
    }

    @Override
    public User getUserByEmail(String email) {
        User user = null;
        String sql = "SELECT * FROM user WHERE email = ?";
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                user = new User();
                user.setidUser(rs.getInt("id_user"));
                user.setNama(rs.getString("nama"));
                user.setEmail(rs.getString("email"));
                user.setAlamat(rs.getString("alamat"));
                user.setPassword(rs.getString("password"));
                user.setNoHp(rs.getString("no_hp"));
                user.setRole(rs.getString("role"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return user;
    }

    @Override
    public void insertUser(User user) {
        String sql = "INSERT INTO user (nama, email, alamat, password, no_hp) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getNama());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getAlamat());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getNoHp());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserById(int idUser) {
        User user = null;
        String sql = "SELECT * FROM user WHERE id_user=?";
        try {PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idUser);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setidUser(rs.getInt("id_user"));
                user.setNama(rs.getString("nama"));
                user.setEmail(rs.getString("email"));
                user.setAlamat(rs.getString("alamat"));
                user.setPassword(rs.getString("password"));
                user.setNoHp(rs.getString("no_hp"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE user Set nama=?, email=?, alamat=?, password=?, no_hp=? WHERE id_user=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getNama());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getAlamat());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getNoHp());
            ps.setInt(6, user.getIdUser());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int idUser) {
        String sql = "DELETE FROM user WHERE id_user=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idUser);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                User user = new User();
                user.setidUser(rs.getInt("id_user"));
                user.setNama(rs.getString("nama"));
                user.setEmail(rs.getString("email"));
                user.setAlamat(rs.getString("alamat"));
                user.setPassword(rs.getString("password"));
                user.setNoHp(rs.getString("no_hp"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void addUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        User user = null;
        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
        
        try (PreparedStatement ps  = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                user = new User();
                user.setidUser(rs.getInt("id_user"));
                user.setidUser(rs.getInt("id_user"));
                user.setNama(rs.getString("nama"));
                user.setEmail(rs.getString("email"));
                user.setAlamat(rs.getString("alamat"));
                user.setPassword(rs.getString("password"));
                user.setNoHp(rs.getString("no_hp"));
            }        
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}

