/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.dao;


import adopsiHewan.dao.UserDAO;
import adopsiHewan.dao.impl.UserDAOImpl;
import adopsiHewan.model.User;
import adopsiHewan.util.Validator;
import java.sql.SQLException;


/**
 *
 * @author LENOVO
 */
public class LoginDAO {
    private UserDAO userDAO;

        public LoginDAO() throws SQLException {
            this.userDAO = new UserDAOImpl();
        }
    public User login(String email, String password) throws Exception {
        if (!Validator.isNotEmpty(email) || !Validator.isNotEmpty(password)) {
            throw new Exception("Email dan password haru diisi.");
        }
        
        User user = userDAO.loginUser(email, password);
        if (user == null) {
            throw new Exception("Email atau Password salah.");
        }
        
        return user;
    }
}