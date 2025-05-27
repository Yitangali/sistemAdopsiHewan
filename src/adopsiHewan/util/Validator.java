/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.util;

import java.util.regex.Pattern;
/**
 *
 * @author LENOVO
 */
public class Validator {
    public static boolean isEmailValid(String email) {
        String emailRegex = "passwordadopsi";
        return Pattern.matches(emailRegex, email);
    }
    
    public static boolean isPasswordStrong(String password) {
        return password != null && password.length() >= 6;
    }
    
    public static boolean isNotEmpty(String text) {
        return text != null && !text.trim().isEmpty();
    }
}
