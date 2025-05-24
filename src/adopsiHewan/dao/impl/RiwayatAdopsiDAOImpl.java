package adopsiHewan.dao.impl;

import adopsiHewan.config.DBConnection;
import adopsiHewan.dao.RiwayatAdopsiDAO;
import adopsiHewan.model.RiwayatAdopsi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RiwayatAdopsiDAOImpl implements RiwayatAdopsiDAO {
    private final Connection conn;

    public RiwayatAdopsiDAOImpl() throws SQLException {
        this.conn = DBConnection.getConnection();
    }

    @Override
    public void addRiwayat(RiwayatAdopsi riwayatAdopsi) throws SQLException {
        String query = "INSERT INTO riwayat_adopsi (id_adopsi, tanggal_update, status) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, riwayatAdopsi.getIdAdopsi());
            stmt.setDate(2, new java.sql.Date(riwayatAdopsi.getTanggalUpdate().getTime()));
            stmt.setString(3, riwayatAdopsi.getStatus());
            stmt.executeUpdate();
        }
    }

    @Override
    public List<RiwayatAdopsi> getRiwayatByAdopsiId(int adopsiId) throws SQLException {
        List<RiwayatAdopsi> riwayatList = new ArrayList<>();
        String query = "SELECT * FROM riwayat_adopsi WHERE id_adopsi = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, adopsiId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    riwayatList.add(new RiwayatAdopsi(rs.getInt("id_riwayat"), rs.getInt("id_adopsi"),
                            rs.getDate("tanggal_update"), rs.getString("status")));
                }
            }
        }
        return riwayatList;
    }
}
