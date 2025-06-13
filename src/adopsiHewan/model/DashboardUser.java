package adopsiHewan.model;

public class DashboardUser {
    private int idHewan;
    private String namaHewan;
    private String jenis;
    private int umur;
    private String kelamin;
    private String deskripsi;
    private byte[] foto;    
    private String status;
    
    
    
    
    public int getIdHewan() { return idHewan; }
    public void setIdHewan(int idHewan) { this.idHewan = idHewan; }

    public String getNamaHewan() { return namaHewan; }
    public void setNamaHewan(String namaHewan) { this.namaHewan = namaHewan; }

    public String getJenis() { return jenis; }
    public void setJenis(String jenis) { this.jenis = jenis; }

    public int getUmur() { return umur; }
    public void setUmur(int umur) { this.umur = umur; }

    public String getKelamin() { return kelamin; }
    public void setKelamin(String kelamin) { this.kelamin = kelamin; }

    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }

    public byte[] getFoto() { return foto; } 
    public void setFoto(byte[] foto) { this.foto = foto; } 

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}