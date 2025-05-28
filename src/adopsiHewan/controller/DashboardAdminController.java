/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.controller;

import adopsiHewan.dao.DashboardAdminDAO;
import java.util.List;
import adopsiHewan.dao.Interface.InDashbAdmin;
import adopsiHewan.model.DashboardAdmin;
import adopsiHewan.view.DashboardAdminView;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class DashboardAdminController {
    DashboardAdminView dbav;
    DashboardAdminDAO dba;
    DashboardAdminView frame;
    InDashbAdmin implDashbAdmin;
    //List<Mahasiswa> lb;

    public DashboardAdminController(DashboardAdminView form) {
        this.dbav = form;
        implDashbAdmin = new DashboardAdminDAO();
    }

    public int getJumlahHewan() {
        return dba.getAmountOfPets();
    }

    public int getJumlahPengguna() {
        return dba.getAmountOfUsers();
    }

    public int getJumlahHewanDiadopsi() {
        return dba.getAmountOfAdopteds();
    }

    public String getNamaHewanTerbaruMasuk() {
        return dba.getLatestPetNameIn();
    }

    public String getNamaHewanTerbaruDiadopsi() {
        return dba.getLatestPetNameAdopted();
    }

    public String getPathGambarHewanTerbaruMasuk() {
        return dba.getLatestPetImagePathIn();
    }

    public String getPathGambarHewanTerbaruDiadopsi() {
        return dba.getLatestPetImagePathAdopted();
    }
}

