package adopsiHewan.config;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDBConnection {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection()) {
            if (conn != null) {
                System.out.println("Koneksi ke database berhasil!");
            } else {
                System.out.println("Gagal terkoneksi ke database.");
            }
        } catch (SQLException e) {
            System.err.println("Kesalahan koneksi: " + e.getMessage());
        }
    }
}
