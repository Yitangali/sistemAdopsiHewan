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
public class Adopsi {
    private int idAdopsi;
    private int idUser;
    private int idHewan;
    private Date tanggalAjuan;
    private String status;
    private String catatan;
    
    public Adopsi(int idAdopsi,int idUser, int idHewan, Date tanggalAjuan, String status, String catatan) {
        this.idAdopsi = idAdopsi;
        this.idUser = idUser;
        this.idHewan = idHewan;
        this.tanggalAjuan = tanggalAjuan;
        this.status = status;
        this.catatan = catatan;
    }
    
    // Getter dan Setter
    public int getIdAdopsi() { return idAdopsi; }
    public int getIdUser() { return idUser; }
    public int getIdHewan() { return idHewan; }
    public Date getTanggalAjuan() { return tanggalAjuan; }
    public String getStatus() { return status; }
    public String getCatatan() { return catatan; }

    public void setStatus(String status) { this.status = status; }
    public void setCatatan(String catatan) { this.catatan = catatan; }
}