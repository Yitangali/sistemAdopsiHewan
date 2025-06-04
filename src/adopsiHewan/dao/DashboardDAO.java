/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.dao;

/**
 *
 * @author LENOVO
 */
import adopsiHewan.config.DBConnection;
import adopsiHewan.model.Hewan;
import adopsiHewan.dao.Interface.DasbUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DashboardDAO implements DasbUser {

    @Override
    public List<Hewan> getAvailablePets() {
        List<Hewan> availablePets = new ArrayList<>();
        String sql = "SELECT id_hewan, nama_hewan, jenis, umur, kelamin, deskripsi, foto, status " +
                     "FROM hewan";

        // Mendapatkan koneksi
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                // Mapping tiap kolom ke atribut DashboardUser
                int id = rs.getInt ("id_hewan");
                String nama = rs.getString("nama_hewan");
                String jenis = rs.getString("jenis");
                int umur = rs.getInt("umur");
                String kelamin = rs.getString("kelamin");
                String deskripsi = rs.getString("deskripsi");
                byte[] foto = rs.getBytes("foto");
                String status = rs.getString("status");

                // Membuat objek DashboardUser
                Hewan pet = new Hewan();
                pet.setIdHewan(id);
                pet.setNamaHewan(nama);
                pet.setJenis(jenis);
                pet.setUmur(umur);
                pet.setKelamin(kelamin);
                pet.setDeskripsi(deskripsi);
                pet.setFoto(foto);
                pet.setStatus(status);

                availablePets.add(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Bisa juga lempar exception atau logging tergantung kebutuhan
        }
        return availablePets;
    }
    
}
