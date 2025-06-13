/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.controller;

import adopsiHewan.dao.impl.UserDAO;
import adopsiHewan.dao.impl.UserDAOImpl;
import adopsiHewan.model.User;

/**
 *
 * @author LENOVO
 */
public class ProfileController {
    private UserDAO userDAO = new UserDAOImpl();
    
    public User getUserById(int idUser) {
        return userDAO.getUserById(idUser);
    }
    
    public User verifyLogin(String email, String password) {
        return userDAO.getUserByEmailAndPassword(email, password);
    }
    
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }
    
    public void deleteUser(int idUser) {
        userDAO.deleteUser(idUser);
    }
}
