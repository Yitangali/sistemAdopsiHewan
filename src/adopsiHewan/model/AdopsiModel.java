/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.model;

import java.util.Date;

public class AdopsiModel {
    private int id;
    private String userId;
    private int idHewan;
    private Date tanggalAjuan;
    private String status;
    private String catatan;
    
    public AdopsiModel() {
        this.status = "proses";
    }
    
    // Getters and Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public int getIdHewan() {
        return idHewan;
    }
    
    public void setIdHewan(int idHewan) {
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