/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.util;

/**s
 *
 * @author LENOVO
 */
public class Validator {
    public static boolean isEmailValid(String email) {
        String regex = "^[A-Za-z0-0+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(regex);
    }
    
    public static boolean isPasswordStrong(String password) {
        return password.length() >= 6;
    }
    
    public static boolean isNotEmpty(String s) {
        return s != null & !s.trim().isEmpty();
    }
}
