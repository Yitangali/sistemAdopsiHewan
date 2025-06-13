/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.controller;

import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import adopsiHewan.dao.impl.UserDAOImpl;
import adopsiHewan.model.User;
import adopsiHewan.view.LoginView;
import javax.swing.*;
import adopsiHewan.view.ProfileView;
import adopsiHewan.config.DBConnection;

/**
 *
 * @author LENOVO
 */

public class LoginController {
    private final LoginView loginView;
    private final UserDAOImpl userDAO;
    private Object DriverManager;
    DBConnection con;
        
    public LoginController(LoginView loginView) {
        this.loginView = loginView;
        this.userDAO = new UserDAOImpl();
        con = new DBConnection();
    }
        
    public void loginUser() {
        String email = loginView.getEmail();
        String password = loginView.getPassword();
            
        if(email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Email dan Password harus diisi!");
            return;
        }
            
        User user = userDAO.getUserByEmail(email);
            
        if (user != null && password.equals(user.getPassword())) {
            JOptionPane.showMessageDialog(null, "Login Berhasil! Selamat datang, " + user.getNama());
                
            System.out.println("Login Sukses: " + user.getNama());
                
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    ProfileView profileView = new ProfileView(user.getIdUser());
                    profileView.setVisible(true);
                    loginView.setVisible(false); 
                }
            }); 
        } else {
            JOptionPane.showMessageDialog(null, "Email atau Password salah.");
        }
    }
    
    public User verifyLogin(String email, String password) {
        User user = null;
        try {
            Connection connection = con.getConnection();
        
            String query = "SELECT * FROM user WHERE email = ? AND password = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int idUser = rs.getInt("id_user");
                String role = rs.getString("role");  
                user = new User(idUser, email, role);  
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return user;
    }
}