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
public class RegisterController {
    private final UserDAO userDAO;

    public RegisterController() throws SQLException {
        this.userDAO = new UserDAOImpl();
    }
    
    public boolean register(int idUser, String nama, String email, String alamat, String password, String confirmPassword, String nohp, String role) throws Exception {
        if (!Validator.isNotEmpty(email) || !Validator.isNotEmpty(password) || !Validator.isNotEmpty(confirmPassword)) {
            throw new Exception("Semua kolom harud diisi.");
        }
        
        if (!Validator.isEmailValid(email)) {
            throw new Exception("Email tidak terdaftar.");
        }
        
        if (!Validator.isPasswordStrong(password)) {
            throw new Exception("Password minimal 6 karakter.");
        }
        
        if (!password.equals(confirmPassword)) {
            throw new Exception("Password konfirmasi berbeda dengan password yang ditulis.");
        }
        
        if (userDAO.isEmailExist(email)) {
            throw new Exception("Email sudah digunakan, coba yang lain.");
        }
        
        User user = new User();
        user.setIdUser(idUser);
        user.setNama(nama);
        user.setEmail(email);
        user.setAlamat(alamat);
        user.setPassword(password);
        user.setNoHp(nohp);
        user.setRole(role);
        
        return userDAO.registerUser(user);
    }
    
    
}
