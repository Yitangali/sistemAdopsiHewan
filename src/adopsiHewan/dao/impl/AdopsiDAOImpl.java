/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.dao.impl;

import adopsiHewan.dao.AdopsiDAO;
import adopsiHewan.model.Adopsi;
import adopsiHewan.config.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author M Tiyas F Akbar
 */
public class AdopsiDAOImpl implements AdopsiDAO {
    private Connection conn = DBConnection.getConnection();
    
    @Override
    public void tambahAdopsi(Adopsi adopsi) {
        String sql = "INSERT INTO adopsi (id_user, is_hewan, tanggal_ajuan, status, catatan) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, adopsi.getIdUser());
            pstmt.setInt(2, adopsi.getIdHewan());
            pstmt.setDate(3, new java.sql.Date(adopsi.getTanggalAjuan().getTime()));
            pstmt.setString(4, adopsi.getStatus());
            pstmt.setString(5, adopsi.getCatatan());
            pstmt.executeUpdate();
            System.out.println("Adopsi berhasil ditambahkan!");
        } catch (SQLException e) {
            System.out.println("Gagal tambah adopsi: " + e.getMessage());
        }
    }
   
    @Override
    public List<Adopsi> getAllAdopsi() {
        List<Adopsi> list = new ArrayList<>();
        String sql = "SELECT * FROM adopsi";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Adopsi(rs.getInt("id_adopsi"), rs.getInt("id_user"), rs.getInt("id_hewan"), 
                                    rs.getDate("tanggal_ajuan"), rs.getString("status"), rs.getString("catatan")));
            }
        } catch (SQLException e) {
            System.out.println("Gagal ambil data adopsi: " + e.getMessage());
        }
        return list;
    }
    
    @Override
    public List<Adopsi> getAdopsiById(int idAdopsi) {
        List<Adopsi> list = new ArrayList<>();
        String sql = "SELECT * FROM adopsi WHERE id_adopsi = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idAdopsi);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    list.add(new Adopsi(rs.getInt("id_adopsi"), rs.getInt("id_user"), rs.getInt("id_hewan"), rs.getDate("tanggal_ajuan"), rs.getString("status"), rs.getString("catatan")));
                }
            }
        } catch (SQLException e) {
            System.out.println("gagal mencari adopsi : " + e.getMessage());
        } return list;
    }
    
    @Override
    public void updateStatus(int idAdopsi, String status) {
        String sql = "UPDATE adopsi SET status = ? WHERE id_adopsi = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, status);
            pstmt.setInt(2, idAdopsi);
            pstmt.executeUpdate();
            System.out.println("Status adopsi berhasil diperbarui!");
        } catch (SQLException e) {
            System.out.println("Gagal update status adopsi: " + e.getMessage());
        }
    }
    
    @Override
    public void updateCatatan(int idAdopsi, String catatan) {
        String sql = "UPDATE adopsi SET catatan = ? WHERE id_adopsi = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, catatan);
            pstmt.setInt(2, idAdopsi);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal update catatan: " + e.getMessage());
        }
    }
    
    @Override
    public void hapusAdopsi(int idAdopsi) {
        String sql = "DELETE FROM adopsi WHERE id_adopsi = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idAdopsi);
            pstmt.executeUpdate();
            System.out.println("Adopsi berhasil dihapus!");
        } catch (SQLException e) {
            System.out.println("Gagal hapus adopsi: " + e.getMessage());
        }
    }
    
}