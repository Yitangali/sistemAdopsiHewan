/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.controller;

import adopsiHewan.dao.DashboardAdminDAO;

/**
 *
 * @author ASUS
 */
public class DashboardAdminController {
    private DashboardAdminDAO dba;

    public DashboardAdminController(DashboardAdminDAO dao) {
        this.dba = dao;
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

