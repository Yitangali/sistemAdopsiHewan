package adopsiHewan.dao.impl;

import adopsiHewan.config.DBConnection;
import adopsiHewan.dao.AdopsiDAO;
import adopsiHewan.model.Adopsi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdopsiDAOImpl implements AdopsiDAO {
    private final Connection conn;

    public AdopsiDAOImpl() throws SQLException {
        this.conn = DBConnection.getConnection();
    }

    @Override
    public void addAdopsi(Adopsi adopsi) throws SQLException {
        String query = "INSERT INTO adopsi (id_user, id_hewan, tanggal_ajuan, status, catatan) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, adopsi.getIdUser());
            stmt.setInt(2, adopsi.getIdHewan());
            stmt.setDate(3, new java.sql.Date(adopsi.getTanggalAjuan().getTime()));
            stmt.setString(4, adopsi.getStatus());
            stmt.setString(5, adopsi.getCatatan());
            stmt.executeUpdate();
        }
    }
    
    public void updateAdopsi(Adopsi adopsi) throws SQLException {
        String query = "UPDATE adopsi SET id_user = ?, id_hewan = ?, tanggal_ajuan = ?, status = ?, catatan = ? WHERE id_adopsi = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, adopsi.getIdUser());
            stmt.setInt(2, adopsi.getIdHewan());
            stmt.setDate(3, new java.sql.Date(adopsi.getTanggalAjuan().getTime()));
            stmt.setString(4, adopsi.getStatus());
            stmt.setString(5, adopsi.getCatatan());
            stmt.setInt(6, adopsi.getIdAdopsi());
            stmt.executeUpdate();
        }
    }

    @Override
    public Adopsi getAdopsiById(int id) throws SQLException {
        String query = "SELECT * FROM adopsi WHERE id_adopsi = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Adopsi(rs.getInt("id_adopsi"), rs.getInt("id_user"), rs.getInt("id_hewan"),
                            rs.getDate("tanggal_ajuan"), rs.getString("status"), rs.getString("catatan"));
                }
            }
        }
        return null;
    }

    @Override
    public List<Adopsi> getAllAdopsi() throws SQLException {
        List<Adopsi> adopsiList = new ArrayList<>();
        String query = "SELECT * FROM adopsi";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                adopsiList.add(new Adopsi(rs.getInt("id_adopsi"), rs.getInt("id_user"), rs.getInt("id_hewan"),
                        rs.getDate("tanggal_ajuan"), rs.getString("status"), rs.getString("catatan")));
            }
        }
        return adopsiList;
    }
    
    @Override
    public List<Adopsi> getAdopsiByStatus(String status) throws SQLException {
        List<Adopsi> adopsiList = new ArrayList<>();
        String query = "SELECT * FROM adopsi WHERE status = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, status);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    adopsiList.add(new Adopsi(
                        rs.getInt("id_adopsi"), rs.getInt("id_user"), rs.getInt("id_hewan"),
                        rs.getDate("tanggal_ajuan"), rs.getString("status"), rs.getString("catatan")
                    ));
                }
            }
        }
        return adopsiList;
    }

    @Override
    public void updateAdopsi(int idAdopsi, String field, Object value) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
