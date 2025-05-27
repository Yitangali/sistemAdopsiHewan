package adopsiHewan.dao;

import adopsiHewan.model.Adopsi;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//public interface AdopsiDAO {
//    void addAdopsi(Adopsi adopsi) throws SQLException;
//    Adopsi getAdopsiById(int id) throws SQLException;
//    List<Adopsi> getAllAdopsi() throws SQLException;
//    List<Adopsi> getAdopsiByStatus(String status) throws SQLException;
//
//}


public class AdopsiDAO {
    private final DatabaseConfig dbConfig;
    
    public AdopsiDAO() {
        this.dbConfig = DatabaseConfig.getInstance();
    }
    
    public void save(AdopsiModel adopsi) throws SQLException {
        String sql = "INSERT INTO adopsi (id_user, id_hewan, tanggal_ajuan, status, catatan) " +
                    "VALUES (?, ?, ?, ?, ?)";
                    
        try (Connection conn = dbConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setInt(1, Integer.parseInt(adopsi.getUserId()));
            stmt.setInt(2, adopsi.getIdHewan());
            stmt.setDate(3, new java.sql.Date(adopsi.getTanggalAjuan().getTime()));
            stmt.setString(4, "proses");
            stmt.setString(5, adopsi.getCatatan());
            
            stmt.executeUpdate();
            
            // Get generated ID
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    adopsi.setId(rs.getInt(1));
                }
            }
            
            // Add to riwayat_adopsi
            addToRiwayat(adopsi.getId(), conn);
        }
    }
    
    private void addToRiwayat(int idAdopsi, Connection conn) throws SQLException {
        String sql = "INSERT INTO riwayat_adopsi (id_adopsi, status) VALUES (?, 'proses')";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idAdopsi);
            stmt.executeUpdate();
        }
    }
    
    public List<String> getAvailableHewan() throws SQLException {
        List<String> hewanList = new ArrayList<>();
        String sql = "SELECT id_hewan, nama_hewan FROM hewan WHERE status = 'tersedia'";
        
        try (Connection conn = dbConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                String hewanInfo = rs.getInt("id_hewan") + " - " + rs.getString("nama_hewan");
                hewanList.add(hewanInfo);
            }
        }
        
        return hewanList;
    }
    
    public void updateHewanStatus(int idHewan, String status) throws SQLException {
        String sql = "UPDATE hewan SET status = ? WHERE id_hewan = ?";
        
        try (Connection conn = dbConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, status);
            stmt.setInt(2, idHewan);
            stmt.executeUpdate();
        }
    }
}