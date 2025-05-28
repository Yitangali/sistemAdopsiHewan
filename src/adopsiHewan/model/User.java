package adopsiHewan.model;

public class User {
    private int idUser;
    private String nama;
    private String email;
    private String alamat;
    private String password;
    private String noHp;
    private String role;

    public User(int idUser, String nama, String email, String alamat,String password, String noHp, String role) {
        this.idUser = idUser;
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.alamat = alamat;
        this.noHp = noHp;
        this.role = role;
    }

    public User() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }

    public String getNoHp() { return noHp; }
    public void setNoHp(String noHp) { this.noHp = noHp; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
