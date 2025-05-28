package adopsiHewan.dao;

import adopsiHewan.model.User;
import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    boolean isUsernameExist(String username) throws SQLException;
    boolean isEmailExist(String email) throws SQLException;
    boolean registerUser(User user) throws SQLException;
    public User loginUser(String email, String password);
    void addUser(User user) throws SQLException;
    User getUserById(int id) throws SQLException;
    List<User> getAllUsers() throws SQLException;
}