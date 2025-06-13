/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import adopsiHewan.model.Adopsi;
import adopsiHewan.config.DBConnection;

public class DAOAdopsi implements IAdopsi {
    Connection connection;
    
    public DAOAdopsi() {
        connection = DBConnection.getConnection();
    }
    
    @Override
    public void insert(Adopsi adopsi) {
        String sql = "INSERT INTO adopsi (id_user, id_hewan, tanggal_ajuan, status, catatan) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, adopsi.getIdUser());
            ps.setInt(2, adopsi.getIdHewan());
            ps.setDate(3, new java.sql.Date(adopsi.getTanggalAjuan().getTime()));
            ps.setString(4, adopsi.getStatus());
            ps.setString(5, adopsi.getCatatan());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Gagal insert: " + ex.getMessage());
        }
    }
    
    @Override
    public void update(Adopsi adopsi) {
        String sql = "UPDATE adopsi SET id_user=?, id_hewan=?, tanggal_ajuan=?, status=?, catatan=? WHERE id_adopsi=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, adopsi.getIdUser());
            ps.setInt(2, adopsi.getIdHewan());
            ps.setDate(3, new java.sql.Date(adopsi.getTanggalAjuan().getTime()));
            ps.setString(4, adopsi.getStatus());
            ps.setString(5, adopsi.getCatatan());
            ps.setInt(6, adopsi.getIdAdopsi());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Gagal update: " + ex.getMessage());
        }
    }
    
    @Override
    public void delete(int id) {
        String sql = "DELETE FROM adopsi WHERE id_adopsi=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Gagal delete: " + ex.getMessage());
        }
    }
    
    @Override
    public List<Adopsi> getAll() {
        List<Adopsi> list = new ArrayList<>();
        String sql = "SELECT * FROM adopsi";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Adopsi adopsi = new Adopsi();
                adopsi.setIdAdopsi(rs.getInt("id_adopsi"));
                adopsi.setIdUser(rs.getInt("id_user"));
                adopsi.setIdHewan(rs.getInt("id_hewan"));
                adopsi.setTanggalAjuan(rs.getDate("tanggal_ajuan"));
                adopsi.setStatus(rs.getString("status"));
                adopsi.setCatatan(rs.getString("catatan"));
                list.add(adopsi);
            }
        } catch (SQLException ex) {
            System.out.println("Gagal getAll: " + ex.getMessage());
        }
        return list;
    }
    
    @Override
    public List<Adopsi> getByStatus(String status) {
        List<Adopsi> list = new ArrayList<>();
        String sql = "SELECT * FROM adopsi WHERE status=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, status);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Adopsi adopsi = new Adopsi();
                adopsi.setIdAdopsi(rs.getInt("id_adopsi"));
                adopsi.setIdUser(rs.getInt("id_user"));
                adopsi.setIdHewan(rs.getInt("id_hewan"));
                adopsi.setTanggalAjuan(rs.getDate("tanggal_ajuan"));
                adopsi.setStatus(rs.getString("status"));
                adopsi.setCatatan(rs.getString("catatan"));
                list.add(adopsi);
            }
        } catch (SQLException ex) {
            System.out.println("Gagal getByStatus: " + ex.getMessage());
        }
        return list;
    }
}