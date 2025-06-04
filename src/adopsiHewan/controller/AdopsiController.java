/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistem_adopsi.controller;

import sistem_adopsi.dao.AdopsiDAO;
import sistem_adopsi.dao.impl.AdopsiDAOImpl;
import sistem_adopsi.model.Adopsi;
import java.util.List;
import java.util.Date;
/**
 *
 * @author M Tiyas F Akbar
 */

public class AdopsiController {
    
    private AdopsiDAO adopsiDAO = new AdopsiDAOImpl();
    
    public void tambahAdopsi(int idUser, int idHewan, String catatan) {
        Adopsi adopsi = new Adopsi(0, idUser, idHewan, new Date(), "Sedang diproses..", catatan);
        adopsiDAO.tambahAdopsi(adopsi);
    }
    
    public List<Adopsi> getAdopsiList() {
        return adopsiDAO.getAllAdopsi();
    }
    
    public List<Adopsi> cariAdopsi(int idAdopsi) {
        return adopsiDAO.getAdopsiById(idAdopsi);
    }
    
    public void updateStatus(int idAdopsi, String status) {
        adopsiDAO.updateStatus(idAdopsi, status);
    }
    
    public void updateCatatan(int idAdopsi, String catatan) {
        adopsiDAO.updateCatatan(idAdopsi, catatan);
    }

    
    public void hapusAdopsi(int idAdopsi) {
        adopsiDAO.hapusAdopsi(idAdopsi);
    }    
    
}
