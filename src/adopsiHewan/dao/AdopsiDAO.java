/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistem_adopsi.dao;

import sistem_adopsi.model.Adopsi;
import java.util.List;
import sistem_adopsi.view.RiwayatAdopsiView;
/**
 *
 * @author M Tiyas F Akbar
 */
public interface AdopsiDAO {
    void tambahAdopsi(Adopsi adopsi);
    List<Adopsi> getAllAdopsi();
    List<Adopsi> getAdopsiById(int idAdopsi);
    void updateStatus(int idAdopsi, String status);
    void updateCatatan(int idAdopsi, String catatan);
    void hapusAdopsi(int idAdopsi);
    
}
