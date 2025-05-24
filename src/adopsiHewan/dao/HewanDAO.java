package adopsiHewan.dao;

import adopsiHewan.model.Hewan;
import java.sql.SQLException;
import java.util.List;

public interface HewanDAO {
    void addHewan(Hewan hewan) throws SQLException;
    Hewan getHewanById(int id) throws SQLException;
    List<Hewan> getAllHewan() throws SQLException;
}
