/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package adopsiHewan.model;


import java.util.Date;
/**
 *
 * @author M Tiyas F Akbar
 */
public class RiwayatAdopsi {
    private int idRiwayat;
    private int idAdopsi;
    private Date tanggalUpdate;
    private String status;
    
    public RiwayatAdopsi(int idRiwayat, int idAdopsi, Date tanggalUpdate, String status) {
        this.idRiwayat = idRiwayat;
        this.idAdopsi = idAdopsi;
        this.tanggalUpdate = tanggalUpdate;
        this.status = status;
        
    }
    
    public int getIdRiwayat() {return idRiwayat;}
    public void setIdRiwayat(int idRiwayat) {this.idRiwayat = idRiwayat;}
    
    public int getIdAdopsi() {return idAdopsi;}
    public void setIdAdopsi(int idAdopsi) {this.idAdopsi = idAdopsi;}
    
    public Date getTanggalUpdate() {return tanggalUpdate;}
    public void setTanggalUpdate(Date tanggalUpdate) {this.tanggalUpdate = tanggalUpdate;}
    
    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}
    
    @Override
    public String toString() {
        return "RiwayatAdopsi{" + 
                "idRiwayat=" + idRiwayat + 
                ", idAdopsi=" + idAdopsi + 
                ", tanggalUpdate=" + tanggalUpdate + 
                ", status='" + status + '\'' + 
                '}';
    }
    
}
