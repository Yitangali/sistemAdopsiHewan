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

    /**
     * @param idAdopsi the idAdopsi to set
     */
    public void setIdAdopsi(int idAdopsi) {
        this.idAdopsi = idAdopsi;
    }

    /**
     * @param idUser the idUser to set
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     * @param idHewan the idHewan to set
     */
    public void setIdHewan(int idHewan) {
        this.idHewan = idHewan;
    }

    /**
     * @param tanggalAjuan the tanggalAjuan to set
     */
    public void setTanggalAjuan(Date tanggalAjuan) {
        this.tanggalAjuan = tanggalAjuan;
    }
    private Integer idAdopsi;
    private Integer idUser;
    private Integer idHewan;
    private Date tanggalAjuan;
    private String status;
    private String catatan;
    
    public Adopsi() {}
    
    public Adopsi(int idAdopsi,int idUser, int idHewan, Date tanggalAjuan, String status, String catatan) {
        this.idAdopsi = idAdopsi;
        this.idUser = idUser;
        this.idHewan = idHewan;
        this.tanggalAjuan = tanggalAjuan;
        this.status = status;
        this.catatan = catatan;
    }
    
    // Getter dan Setter
    public Integer getIdAdopsi() { return idAdopsi; }
    public Integer getIdUser() { return idUser; }
    public Integer getIdHewan() { return idHewan; }
    public Date getTanggalAjuan() { return tanggalAjuan; }
    public String getStatus() { return status; }
    public String getCatatan() { return catatan; }

    public void setStatus(String status) { this.status = status; }
    public void setCatatan(String catatan) { this.catatan = catatan; }

}