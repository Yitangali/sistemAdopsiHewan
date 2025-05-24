package adopsiHewan.model;

public class Hewan {
    private int idHewan;
    private String namaHewan;
    private String jenis;
    private int umur;
    private String kelamin;
    private String deskripsi;
    private String foto;
    private String status;

    public Hewan(int idHewan, String namaHewan, String jenis, int umur, String kelamin, String deskripsi, String foto, String status) {
        this.idHewan = idHewan;
        this.namaHewan = namaHewan;
        this.jenis = jenis;
        this.umur = umur;
        this.kelamin = kelamin;
        this.deskripsi = deskripsi;
        this.foto = foto;
        this.status = status;
    }

    // Getter dan Setter
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

    public String getFoto() { return foto; }
    public void setFoto(String foto) { this.foto = foto; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
