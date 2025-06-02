/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ASUS
 */
public class DashboardAdmin {

    /**
     * @return the jmlUser
     */
    public Integer getJmlUser() {
        return jmlUser;
    }

    /**
     * @param jmlUser the jmlUser to set
     */
    public void setJmlUser(Integer jmlUser) {
        this.jmlUser = jmlUser;
    }

    /**
     * @return the jmlDiadopsi
     */
    public Integer getJmlDiadopsi() {
        return jmlDiadopsi;
    }

    /**
     * @param jmlDiadopsi the jmlDiadopsi to set
     */
    public void setJmlDiadopsi(Integer jmlDiadopsi) {
        this.jmlDiadopsi = jmlDiadopsi;
    }

    /**
     * @return the jmlHewan
     */
    public Integer getJmlHewan() {
        return jmlHewan;
    }

    /**
     * @param jmlHewan the jmlHewan to set
     */
    public void setJmlHewan(Integer jmlHewan) {
        this.jmlHewan = jmlHewan;
    }

    /**
     * @return the baruDiadopsi
     */
    public String getBaruDiadopsi() {
        return baruDiadopsi;
    }

    /**
     * @param baruDiadopsi the baruDiadopsi to set
     */
    public void setBaruDiadopsi(String baruDiadopsi) {
        this.baruDiadopsi = baruDiadopsi;
    }

    /**
     * @return the baruMasuk
     */
    public String getBaruMasuk() {
        return baruMasuk;
    }

    /**
     * @param baruMasuk the baruMasuk to set
     */
    public void setBaruMasuk(String baruMasuk) {
        this.baruMasuk = baruMasuk;
    }

   
    
    private Integer jmlUser;
    private Integer jmlDiadopsi;
    private Integer jmlHewan;
    private String baruDiadopsi;
    private String baruMasuk;
}
