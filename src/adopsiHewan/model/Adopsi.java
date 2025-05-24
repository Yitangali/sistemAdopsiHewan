package adopsiHewan.model;

import java.util.Date;

public class Adopsi {
    private int idAdopsi;
    private int idUser;
    private int idHewan;
    private Date tanggalAjuan;
    private String status;
    private String catatan;

    public Adopsi(int idAdopsi, int idUser, int idHewan, Date tanggalAjuan, String status, String catatan) {
        this.idAdopsi = idAdopsi;
        this.idUser = idUser;
        this.idHewan = idHewan;
        this.tanggalAjuan = tanggalAjuan;
        this.status = status;
        this.catatan = catatan;
    }

    // Getter dan Setter
    public int getIdAdopsi() { return idAdopsi; }
    public void setIdAdopsi(int idAdopsi) { this.idAdopsi = idAdopsi; }

    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }

    public int getIdHewan() { return idHewan; }
    public void setIdHewan(int idHewan) { this.idHewan = idHewan; }

    public Date getTanggalAjuan() { return tanggalAjuan; }
    public void setTanggalAjuan(Date tanggalAjuan) { this.tanggalAjuan = tanggalAjuan; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCatatan() { return catatan; }
    public void setCatatan(String catatan) { this.catatan = catatan; }
}
