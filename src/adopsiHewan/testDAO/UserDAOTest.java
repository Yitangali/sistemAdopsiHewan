package adopsiHewan.testDAO;

import adopsiHewan.dao.UserDAO;
import adopsiHewan.dao.impl.UserDAOImpl;
import adopsiHewan.model.User;

import org.junit.jupiter.api.*;

import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

public class UserDAOTest {
    private UserDAO userDAO;

    @BeforeEach
    void setUp() throws SQLException {
        userDAO = new UserDAOImpl();
    }

    @Test
    void testAddUser() throws SQLException {
        User user = new User(0, "Test User", "test@example.com", "123456", "Jl. Tes", "081234567890", "admin");
        userDAO.addUser(user);
        assertNotNull(userDAO.getUserById(user.getIdUser()), "User harus berhasil ditambahkan!");
    }

    @Test
    void testGetUserById() throws SQLException {
        User user = userDAO.getUserById(1);
        assertNotNull(user, "User dengan ID 1 harus ditemukan!");
        assertEquals(1, user.getIdUser());
    }
}
