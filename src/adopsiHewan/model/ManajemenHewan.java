/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.model;

/**
 *
 * @author ASUS
 */
public class ManajemenHewan {

    /**
     * @return the id_hewan
     */
    public Integer getId_hewan() {
        return id_hewan;
    }

    /**
     * @param id_hewan the id_hewan to set
     */
    public void setId_hewan(Integer id_hewan) {
        this.id_hewan = id_hewan;
    }

    /**
     * @return the nama_hewan
     */
    public String getNama_hewan() {
        return nama_hewan;
    }

    /**
     * @param nama_hewan the nama_hewan to set
     */
    public void setNama_hewan(String nama_hewan) {
        this.nama_hewan = nama_hewan;
    }

    /**
     * @return the jenis
     */
    public String getJenis() {
        return jenis;
    }

    /**
     * @param jenis the jenis to set
     */
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    /**
     * @return the umur
     */
    public Integer getUmur() {
        return umur;
    }

    /**
     * @param umur the umur to set
     */
    public void setUmur(Integer umur) {
        this.umur = umur;
    }

    /**
     * @return the kelamin
     */
    public String getKelamin() {
        return kelamin;
    }

    /**
     * @param kelamin the kelamin to set
     */
    public void setKelamin(String kelamin) {
        this.kelamin = kelamin;
    }

    /**
     * @return the deskripsi
     */
    public String getDeskripsi() {
        return deskripsi;
    }

    /**
     * @param deskripsi the deskripsi to set
     */
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    /**
     * @return the foto
     */
    public byte[] getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    private Integer id_hewan;
    private String nama_hewan;
    private String jenis;
    private Integer umur;
    private String kelamin;
    private String deskripsi;
    private byte[] foto;
    private String status;
    
}
