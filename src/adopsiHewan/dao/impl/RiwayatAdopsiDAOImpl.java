/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package adopsiHewan.dao.impl;

import adopsiHewan.dao.RiwayatAdopsiDAO;
import adopsiHewan.model.RiwayatAdopsi;
import adopsiHewan.config.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author M Tiyas F Akbar
 */
public class RiwayatAdopsiDAOImpl implements RiwayatAdopsiDAO {
    private Connection conn = DBConnection.getConnection();
    
    @Override
    public void tambahRiwayat(int idAdopsi, String status) {
        String sql = "INSERT INTO riwayat_adopsi (id_adopsi, status, tanggal_update) VALUES (?, ?, NOW())";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idAdopsi);
            pstmt.setString(2, status);
            pstmt.executeUpdate();
            System.out.println("Riwayat berhasil ditambahkan ya");
        } catch (SQLException e) {
            System.out.println("Gagal mencatat riwayat: " + e.getMessage());
        }
    }

    @Override
    public List<RiwayatAdopsi> getRiwayatList() {
        List<RiwayatAdopsi> list = new ArrayList<>();
        String sql = "SELECT * FROM riwayat_adopsi";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                RiwayatAdopsi riwayat = new RiwayatAdopsi(
                    rs.getInt("id_riwayat"), rs.getInt("id_adopsi"),
                    rs.getDate("tanggal_update"), rs.getString("status")
                );
                list.add(riwayat);
            }
        } catch (SQLException e) {
            System.out.println("Gagal mengambil riwayat: " + e.getMessage());
        }
        return list;
    }
    
    @Override
    public RiwayatAdopsi getRiwayatById(int idRiwayat) {
    RiwayatAdopsi riwayat = null;
    String sql = "SELECT * FROM riwayat_adopsi WHERE id_riwayat = ?";

    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, idRiwayat);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            riwayat = new RiwayatAdopsi(
                rs.getInt("id_riwayat"), rs.getInt("id_adopsi"),
                rs.getDate("tanggal_update"), rs.getString("status")
            );
        }
    } catch (SQLException e) {
        System.out.println("Gagal mengambil riwayat: " + e.getMessage());
    }
    return riwayat;
}
}
