package adopsiHewan.dao.impl;

import adopsiHewan.config.DBConnection;
import adopsiHewan.dao.HewanDAO;
import adopsiHewan.model.Hewan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HewanDAOImpl implements HewanDAO {
    private final Connection conn;

    public HewanDAOImpl() throws SQLException {
        this.conn = DBConnection.getConnection();
    }

    @Override
    public void addHewan(Hewan hewan) throws SQLException {
        String query = "INSERT INTO hewan (nama_hewan, jenis, umur, kelamin, deskripsi, foto, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, hewan.getNamaHewan());
            stmt.setString(2, hewan.getJenis());
            stmt.setInt(3, hewan.getUmur());
            stmt.setString(4, hewan.getKelamin());
            stmt.setString(5, hewan.getDeskripsi());
            stmt.setString(6, hewan.getFoto());
            stmt.setString(7, hewan.getStatus());
            stmt.executeUpdate();
        }
    }

    @Override
    public Hewan getHewanById(int id) throws SQLException {
        String query = "SELECT * FROM hewan WHERE id_hewan = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Hewan(rs.getInt("id_hewan"), rs.getString("nama_hewan"), rs.getString("jenis"), rs.getInt("umur"),
                            rs.getString("kelamin"), rs.getString("deskripsi"), rs.getString("foto"), rs.getString("status"));
                }
            }
        }
        return null;
    }

    @Override
    public List<Hewan> getAllHewan() throws SQLException {
        List<Hewan> hewanList = new ArrayList<>();
        String query = "SELECT * FROM hewan";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                hewanList.add(new Hewan(rs.getInt("id_hewan"), rs.getString("nama_hewan"), rs.getString("jenis"), rs.getInt("umur"),
                        rs.getString("kelamin"), rs.getString("deskripsi"), rs.getString("foto"), rs.getString("status")));
            }
        }
        return hewanList;
    }
}
