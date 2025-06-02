/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.dao;

//import mvc.Koneksi.Koneksi;
//import mvc.Model.Mahasiswa;
import adopsiHewan.config.DBConnection;
import adopsiHewan.model.DashboardAdmin;
import adopsiHewan.dao.Interface.InDashbAdmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ASUS
 */
public class DashboardAdminDAO implements InDashbAdmin{
    
    Connection connection;
    //private final String imagesFolder = "src/assets/";

    public DashboardAdminDAO() {
        connection = DBConnection.getConnection();
    }
    
    @Override
    public int getAmountOfPets() {
        int banyakHewan = 0;
        String sql = "SELECT COUNT(*) FROM hewan"; // Menghitung jumlah baris dalam tabel
        try (PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                banyakHewan = rs.getInt(1); // Mengambil hasil COUNT(*)
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return banyakHewan;
    }

    @Override
    public int getAmountOfUsers() {
        int banyakUser = 0;
        String sql = "SELECT COUNT(*) FROM user WHERE role = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "user");
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    banyakUser = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return banyakUser;
    }

    @Override
    public int getAmountOfAdopteds() {
        int banyakHewanDiAdopsi = 0;
        String sql = "SELECT COUNT(*) FROM hewan WHERE status = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "sudah diadopsi"); // jika status adalah VARCHAR/ENUM
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    banyakHewanDiAdopsi = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return banyakHewanDiAdopsi;
    }

    @Override
    public String getLatestPetNameIn() {
        String namaHewan = null;
        String sql = "SELECT nama_hewan FROM hewan WHERE status != ? ORDER BY id_hewan DESC LIMIT 1";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "sudah diadopsi"); // Menyesuaikan dengan format penyimpanan status di database
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    namaHewan = rs.getString("nama_hewan");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return namaHewan;
    }

    @Override
    public String getLatestPetNameAdopted() {
        String namaHewan = null;
        String sql = "SELECT h.nama_hewan " +
                    "FROM hewan h " +
                    "JOIN adopsi a ON h.id_hewan = a.id_hewan " +
                    "WHERE h.status = ? " +
                    "ORDER BY a.tanggal_ajuan DESC " +
                    "LIMIT 1";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "sudah diadopsi");
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    namaHewan = rs.getString("nama_hewan");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return namaHewan;
    }

    @Override
    public ImageIcon getLatestPetImageIn() {
        ImageIcon icon = null;
        String sql = "SELECT foto FROM hewan WHERE status = ? ORDER BY id_hewan DESC LIMIT 1";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "belum diadopsi");
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    byte[] imgBytes = rs.getBytes("foto");
                    if (imgBytes != null) {
                        InputStream in = new ByteArrayInputStream(imgBytes);
                        BufferedImage bImage = ImageIO.read(in);
                        icon = new ImageIcon(bImage);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return icon;
    }

    
    /*public String () {
        return "not implemented yet";
    }*/

    @Override
    public ImageIcon getLatestPetImageAdopted() {
        ImageIcon icon = null;
        String sql = "SELECT h.foto " +
                 "FROM hewan h " +
                 "JOIN adopsi a ON h.id_hewan = a.id_hewan " +
                 "WHERE h.status = ? " +
                 "ORDER BY a.tanggal_ajuan DESC " +
                 "LIMIT 1";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "sudah diadopsi");
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    byte[] imgBytes = rs.getBytes("foto");
                    if (imgBytes != null) {
                        InputStream in = new ByteArrayInputStream(imgBytes);
                        BufferedImage bImage = ImageIO.read(in);
                        icon = new ImageIcon(bImage);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return icon;
    }
    
}
    
