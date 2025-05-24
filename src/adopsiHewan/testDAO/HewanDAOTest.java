package adopsiHewan.testDAO;

import adopsiHewan.dao.HewanDAO;
import adopsiHewan.dao.impl.HewanDAOImpl;
import adopsiHewan.model.Hewan;

import org.junit.jupiter.api.*;

import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

public class HewanDAOTest {
    private HewanDAO hewanDAO;

    @BeforeEach
    void setUp() throws SQLException {
        hewanDAO = new HewanDAOImpl();
    }

    @Test
    void testAddHewan() throws SQLException {
        Hewan hewan = new Hewan(0, "Bobby", "Anjing", 2, "Jantan", "Anjing ramah", "bobby.jpg", "Tersedia");
        hewanDAO.addHewan(hewan);
        assertNotNull(hewanDAO.getHewanById(hewan.getIdHewan()), "Hewan harus berhasil ditambahkan!");
    }

    @Test
    void testGetHewanById() throws SQLException {
        Hewan hewan = hewanDAO.getHewanById(1);
        assertNotNull(hewan, "Hewan dengan ID 1 harus ditemukan!");
        assertEquals(1, hewan.getIdHewan());
    }
}
