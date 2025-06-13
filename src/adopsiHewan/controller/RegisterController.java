/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.controller;

import adopsiHewan.dao.impl.UserDAO;
import adopsiHewan.dao.impl.UserDAOImpl;
import adopsiHewan.model.User;
import adopsiHewan.util.PasswordUtils;
import adopsiHewan.util.Validator;
import adopsiHewan.view.RegisterView;
import adopsiHewan.view.LoginView;

import javax.swing.*;

/**
 *
 * @author LENOVO
 */
public class RegisterController {
    private RegisterView view;
    private UserDAO userDAO;
    
    public RegisterController(RegisterView view) {
        this.view = view;
        this.userDAO = new UserDAOImpl();
    }
    
    public void createUser() {
        String nama = view.getNama();
        String email = view.getEmail();
        String alamat = view.getAlamat();
        String noHp = view.getNoHp();
        String password = view.getPassword();
        String confirmPassword = view.getConfirmPassword();
        
        if (!Validator.isNotEmpty(nama) || !Validator.isNotEmpty(email) || !Validator.isNotEmpty(password)) {
            JOptionPane.showMessageDialog(view, "Semua field wajib diisi.");
            return;
        }
        
        if (!Validator.isEmailValid(email)) {
            JOptionPane.showMessageDialog(view, "Format email tidak valid.");
            return;
        }
        
        if (!Validator.isPasswordStrong(password)) {
            JOptionPane.showMessageDialog(view, "Password terlalu lemah (min 6 karakter)");
            return;
        }
        
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(view, "Password tidak cocok.");
            return;
        }
        
        if (userDAO.isEmailExist(email)) {
            JOptionPane.showMessageDialog(view, "Email sudah terdaftar.");
            return;
        }
        
        String hashed = PasswordUtils.hashPassword(password);
        User user = new User();
        user.setNama(nama);
        user.setEmail(email);
        user.setAlamat(alamat);
        user.setNoHp(noHp);
        user.setPassword(hashed);
        user.setRole("user");
        
        if (userDAO.registerUser(user)) {
            JOptionPane.showMessageDialog(view, "Registrasi berhasil.");
        } else {
            JOptionPane.showMessageDialog(view, "Gagal mendaftar.");
        }
    }
}
