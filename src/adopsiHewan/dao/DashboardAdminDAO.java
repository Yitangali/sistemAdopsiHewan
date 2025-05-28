/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.dao;

//import mvc.Koneksi.Koneksi;
//import mvc.Model.Mahasiswa;
import adopsiHewan.dao.Interface.InDashbAdmin;
import adopsiHewan.config.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.io.File;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ASUS
 */
public class DashboardAdminDAO implements InDashbAdmin{
    
    private Connection connection;
    private final String imagesFolder = "src/assets/";

    public DashboardAdminDAO() {
        connection = DBConnection.getConnection();
    }
    
    @Override
    public int getAmountOfPets() {
        return getAnimalCount();
    }

    @Override
    public int getAmountOfUsers() {
        return getUserCount();
    }

    @Override
    public int getAmountOfAdopteds() {
        return getAdoptedAnimalCount();
    }

    @Override
    public String getLatestPetNameIn() {
        return getLatestAnimalName();
    }

    @Override
    public String getLatestPetNameAdopted() {
        return getLatestAdopted();
    }

    @Override
    public String getLatestPetImagePathIn() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getLatestPetImagePathAdopted() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private int getUserCount() {
        String sql = "SELECT COUNT(*) FROM user WHERE role = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "user");
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    
    private int getAdoptedAnimalCount() {
        String sql = "SELECT COUNT(*) FROM hewan WHERE status = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "sudah diadopsi"); // jika status adalah VARCHAR/ENUM
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    
    private int getAnimalCount() {
        String sql = "SELECT COUNT(*) FROM hewan"; // Menghitung jumlah baris dalam tabel
        try (PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1); // Mengambil hasil COUNT(*)
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public String getLatestAnimalName() {
        String latestPetName = null;
        String sql = "SELECT nama FROM hewan ORDER BY id_hewan DESC LIMIT 1"; // Ambil yang paling baru berdasarkan id_hewan

        try (PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                latestPetName = rs.getString("nama"); // Ambil nama hewan terbaru sesuai kolom 'nama'
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return latestPetName; // Return nama hewan paling baru
    }

    
    public String getLatestAdopted() {
        String latestPetName = null;
        String sql = "SELECT h.nama " +
                    "FROM hewan h " +
                    "JOIN adopsi a ON h.id_hewan = a.id_hewan " +
                    "JOIN riwayat_adopsi r ON a.id_adopsi = r.id_adopsi " +
                    "ORDER BY r.tanggal_update DESC LIMIT 1";

        try (PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                latestPetName = rs.getString("nama"); // Ambil nama hewan sesuai alias h.nama
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return latestPetName;
    }
    
}
    
