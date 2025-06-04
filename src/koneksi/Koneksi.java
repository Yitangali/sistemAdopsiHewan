/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    private static Connection connection;
    
    public static Connection getConnection() {
        if (connection == null) {
            try {
                String url = "jdbc:mysql://localhost/adopsi_hewan";
                String user = "root";
                String password = "";
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                System.out.println("Gagal koneksi: " + ex.getMessage());
            }
        }
        return connection;
    }
}