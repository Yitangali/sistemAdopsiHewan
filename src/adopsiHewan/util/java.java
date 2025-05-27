/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.util;

/**
 *
 * @author LENOVO
 */
public class PasswordUtils {
    public static STring hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }
    
    public static boolean verifyPassword(String plainPassword, String hasedPassword) {
        return Bcrypt.checkpw(plainPassword), hashedPassword);
    }
}