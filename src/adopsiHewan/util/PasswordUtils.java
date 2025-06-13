/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.util;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author LENOVO
 */
public class PasswordUtils {  
    
    public static String hashPassword(String plainPassword) {
        return plainPassword;
    }
    
    public static boolean verifyPassword(String plainPassword, String hashedPassword) {
        return plainPassword.equals(hashedPassword);
    }
    
    public static boolean checkPassword(String plainPassword, String hashedPassword, String hashedPasswordFromDatabase) {
        return plainPassword.equals(hashedPasswordFromDatabase);
    }
}
