/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistem_adopsi.controller;

import sistem_adopsi.dao.RiwayatAdopsiDAO;
import sistem_adopsi.dao.impl.RiwayatAdopsiDAOImpl;
import sistem_adopsi.model.RiwayatAdopsi;
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
