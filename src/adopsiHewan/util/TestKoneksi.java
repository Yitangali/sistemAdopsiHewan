/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.util;

import java.sql.Connection;

/**
 *
 * @author LENOVO
 */
public class TestKoneksi {
    public static void main(String[] args) {
        Connection c = DBConnection.getConnection();
        if (c != null) {
            System.out.println("Tes Koneksi ke database berhasil");
        }
    }
}
