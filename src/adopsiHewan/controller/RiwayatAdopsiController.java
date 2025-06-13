/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.controller;

import adopsiHewan.dao.RiwayatAdopsiDAO;
import adopsiHewan.dao.impl.RiwayatAdopsiDAOImpl;
import adopsiHewan.model.RiwayatAdopsi;
import java.util.List;

/**
 *
 * @author M Tiyas F Akbar
 */
public class RiwayatAdopsiController {
    private RiwayatAdopsiDAO riwayatDAO = new RiwayatAdopsiDAOImpl();

    public void tambahRiwayat(int idAdopsi, String status) {
        riwayatDAO.tambahRiwayat(idAdopsi, status);
    }

    public List<RiwayatAdopsi> getRiwayatList() {
        return riwayatDAO.getRiwayatList();
    }
    
    public RiwayatAdopsi getRiwayatById(int idRiwayat) {
        return riwayatDAO.getRiwayatById(idRiwayat);
    }

}
