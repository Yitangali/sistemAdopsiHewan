/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.controller;

import adopsiHewan.dao.UserDAO;
import adopsiHewan.dao.impl.UserDAOImpl;
import adopsiHewan.model.User;
import adopsiHewan.util.Validator;

/**
 *
 * @author LENOVO
 */
public class UserController {
    private UserDAO userDAO = new UserDAOImpl();
    
    public boolean register(String username, String email, String password, String confirmPassword) throws Exception {
        if (!Validator.isNotEmpty(username) || !Validator.isNotEmpty(email) || !Validator.isNotEmpty(Password) || !Validator.isNotEmpty(confirmPassword)) {
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
        
        if (userDAO.isUsernameExist(username)) {
            throw new Exception("Username sudah digunakan, coba yang lain.");
        }
        
        if (userDAO.isEmailExist(email)) {
            throw new Exception("Email sudah digunakan, coba yang lain.");
        }
        
        User user = new User();
        user.setIdUser(iduser);
        user.setEmail(email);
        user.setAlamat(alamat);
        user.setPassword(password);
        user.setNoHp(nohp);
        user.setRole(role);
        
        return userDAO.registerUser(user);
    }
    
    public user login(String email, String password) throws Exception {
        if (!Validator.isNotEmpty(email) || !Validator.isNotEmpty(password)) {
            throw new Exception("Email dan password haru diisi.");
        }
        
        User user = UserDAO.loginUser(email, password);
        if (user == null) {
            throw new Exception("Email atau Password salah.");
        }
        
        return user;
    }
}
