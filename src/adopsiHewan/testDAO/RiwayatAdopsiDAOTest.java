package adopsiHewan.testDAO;

import adopsiHewan.dao.RiwayatAdopsiDAO;
import adopsiHewan.dao.impl.RiwayatAdopsiDAOImpl;
import adopsiHewan.model.RiwayatAdopsi;

import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class RiwayatAdopsiDAOTest {
    private RiwayatAdopsiDAO riwayatAdopsiDAO;

    @BeforeEach
    void setUp() throws SQLException {
        riwayatAdopsiDAO = new RiwayatAdopsiDAOImpl();
    }

    @Test
    void testAddRiwayat() throws SQLException {
        RiwayatAdopsi riwayat = new RiwayatAdopsi(0, 1, new Date(), "Disetujui");
        riwayatAdopsiDAO.addRiwayat(riwayat);
        assertFalse(riwayatAdopsiDAO.getRiwayatByAdopsiId(1).isEmpty(), "Riwayat adopsi harus berhasil ditambahkan!");
    }
}
