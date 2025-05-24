package adopsiHewan.dao;

import adopsiHewan.model.RiwayatAdopsi;
import java.sql.SQLException;
import java.util.List;

public interface RiwayatAdopsiDAO {
    void addRiwayat(RiwayatAdopsi riwayatAdopsi) throws SQLException;
    List<RiwayatAdopsi> getRiwayatByAdopsiId(int adopsiId) throws SQLException;
}
