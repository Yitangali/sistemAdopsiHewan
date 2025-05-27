/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.dao;

//import mvc.Koneksi.Koneksi;
//import mvc.Model.Mahasiswa;
import adopsiHewan.dao.Interface.InDashbAdmin;

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

    //public DAODashboardAdmin(Connection connection) {
    //    this.connection = connection;
    //}
    
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
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    private int getAdoptedAnimalCount() {
        String sql = "SELECT COUNT(*) FROM hewan WHERE status = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setBoolean(1, true); // Jika kolom status bertipe BOOLEAN
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt(1); // Mengambil jumlah baris
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return 0;
        }
    
    private int getAnimalCount() {
        String sql = "SELECT COUNT(*) FROM hewan"; // Menghitung jumlah baris dalam tabel
        try (PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            if (rs.next()) return rs.getInt(1); // Mengambil hasil COUNT(*)
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String getLatestAnimalName() {
        String latestPetName = null;
        String sql = "SELECT nama FROM hewan ORDER BY id DESC LIMIT 1"; // Ambil yang paling baru berdasarkan ID
    
        try (PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
        
            if (rs.next()) {
            latestPetName = rs.getString("nama"); // Ambil nama hewan terbaru
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return latestPetName; // Return nama hewan paling baru
    }
    
    public String getLatestAdopted() {
        String latestPetName = null;
        String sql = "SELECT h.nama FROM hewan h " +
                 "JOIN adopsi a ON h.id = a.id_hewan " +
                 "ORDER BY a.tanggal_update DESC LIMIT 1"; // Mengurutkan dari terbaru

        try (PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                latestPetName = rs.getString("nama"); // Mengambil nama hewan terbaru yang diadopsi
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return latestPetName; // Return nama hewan paling baru diadopsi
    }
    
}
    
