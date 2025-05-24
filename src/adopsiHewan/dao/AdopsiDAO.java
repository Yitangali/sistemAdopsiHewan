package adopsiHewan.dao;

import adopsiHewan.model.Adopsi;
import java.sql.SQLException;
import java.util.List;

public interface AdopsiDAO {
    void addAdopsi(Adopsi adopsi) throws SQLException;
    Adopsi getAdopsiById(int id) throws SQLException;
    List<Adopsi> getAllAdopsi() throws SQLException;
}
