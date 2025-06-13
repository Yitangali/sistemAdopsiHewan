package adopsiHewan.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {
    static Connection con;
    
    public static Connection getConnection() {
        if (con == null) {
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("adopsi_hewan");
            data.setUser("root");
            data.setPassword("");
            try {
                con = data.getConnection();
                System.out.println("koneksi berhasil!");
            } catch(SQLException e) {
                System.out.println("koneksi gagal");
            }
        }
        return con;
    }
}
