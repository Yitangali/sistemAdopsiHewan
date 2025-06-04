/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

public class Adopsi {
    private Integer idAdopsi;
    private Integer idUser;
    private Integer idHewan;
    private Date tanggalAjuan;
    private String status;
    private String catatan;
    
    public Integer getIdAdopsi() {
        return idAdopsi;
    }
    
    public void setIdAdopsi(Integer idAdopsi) {
        this.idAdopsi = idAdopsi;
    }
    
    public Integer getIdUser() {
        return idUser;
    }
    
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
    
    public Integer getIdHewan() {
        return idHewan;
    }
    
    public void setIdHewan(Integer idHewan) {
        this.idHewan = idHewan;
    }
    
    public Date getTanggalAjuan() {
        return tanggalAjuan;
    }
    
    public void setTanggalAjuan(Date tanggalAjuan) {
        this.tanggalAjuan = tanggalAjuan;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getCatatan() {
        return catatan;
    }
    
    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }
}