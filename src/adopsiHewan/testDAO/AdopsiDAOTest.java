package adopsiHewan.testDAO;

import adopsiHewan.dao.AdopsiDAO;
import adopsiHewan.dao.impl.AdopsiDAOImpl;
import adopsiHewan.model.Adopsi;

import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AdopsiDAOTest {
    private AdopsiDAO adopsiDAO;

    @BeforeEach
    void setUp() throws SQLException {
        adopsiDAO = new AdopsiDAOImpl();
    }

    @Test
    void testAddAdopsi() throws SQLException {
        Adopsi adopsi = new Adopsi(0, 1, 2, new Date(), "Diajukan", "Menunggu konfirmasi");
        adopsiDAO.addAdopsi(adopsi);
        assertNotNull(adopsiDAO.getAdopsiById(adopsi.getIdAdopsi()), "Adopsi harus berhasil ditambahkan!");
    }

    @Test
    void testGetAdopsiById() throws SQLException {
        Adopsi adopsi = adopsiDAO.getAdopsiById(1);
        assertNotNull(adopsi, "Adopsi dengan ID 1 harus ditemukan!");
        assertEquals(1, adopsi.getIdAdopsi());
    }
}
