/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.controller;

import adopsiHewan.dao.UserDAO;
import adopsiHewan.dao.impl.UserDAOImpl;
import adopsiHewan.model.User;
import adopsiHewan.util.Validator;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class LoginController {
    private final UserDAO userDAO;

    public LoginController() throws SQLException {
        this.userDAO = new UserDAOImpl();
    }
    
    public User login(String email, String password) throws Exception {
        if (!Validator.isNotEmpty(email) || !Validator.isNotEmpty(password)) {
            throw new Exception("Email dan password harus diisi.");
        }
        
        User user = userDAO.loginUser(email, password);
        if (user == null) {
            throw new Exception("Email atau Password salah.");
        }
        
        return user;
    }

}
