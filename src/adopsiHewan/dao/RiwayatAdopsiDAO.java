/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package adopsiHewan.dao;

import adopsiHewan.model.RiwayatAdopsi;

import java.util.List;

/**
 *
 * @author M Tiyas F Akbar
 */
public interface RiwayatAdopsiDAO {
    void tambahRiwayat(int idAdopsi, String status);
    List<RiwayatAdopsi> getRiwayatList();
    RiwayatAdopsi getRiwayatById(int idRiwayat);
}
