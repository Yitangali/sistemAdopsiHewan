/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DashboardUser.DAO;

import DashboardUser.config.DBConnection;
import DashboardUser.model.DashboardUser;
import DashboardUser.DAO.Interface.DasbUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DashboardDAO implements DasbUser {

    @Override
    public List<DashboardUser> getAvailablePets() {
        List<DashboardUser> availablePets = new ArrayList<>();
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
                DashboardUser pet = new DashboardUser();
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



