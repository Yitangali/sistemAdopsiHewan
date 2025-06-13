/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.dao.impl;

import java.util.List;
import adopsiHewan.model.User;

/**
 *
 * @author LENOVO
 */
public interface UserDAO {
    boolean registerUser(User user);
    boolean isEmailExist(String email);
    
    void addUser(User user);
    User getUserByEmail(String email);
    
    User getUserById(int idUser);
    void insertUser(User user);
    void updateUser(User user);
    void deleteUser(int idUser);
    List<User> getAllUsers();

    public User getUserByEmailAndPassword(String email, String password);
}
