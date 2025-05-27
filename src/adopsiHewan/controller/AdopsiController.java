package adopsiHewan.controller;

import adopsiHewan.dao.AdopsiDAO;
import adopsiHewan.dao.impl.AdopsiDAOImpl;
import adopsiHewan.model.Adopsi;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdopsiController {
    private AdopsiDAO adopsiDAO;

    // Konstruktor untuk inisialisasi DAO
    public AdopsiController() {
        try {
            adopsiDAO = new AdopsiDAOImpl();
        } catch (SQLException e) {
            System.out.println("Gagal inisialisasi DAO: " + e.getMessage());
        }
    }

    // Tambah Data Adopsi
    public void tambahAdopsi(int idUser, int idHewan, Date tanggalAjuan, String status, String catatan) {
        Adopsi adopsi = new Adopsi(0, idUser, idHewan, tanggalAjuan, status, catatan);
        try {
            adopsiDAO.addAdopsi(adopsi);
            System.out.println("Adopsi berhasil ditambahkan!");
        } catch (SQLException e) {
            System.out.println("Error tambah adopsi: " + e.getMessage());
        }
    }

    // Dapatkan Data Adopsi Berdasarkan ID
    public Adopsi getAdopsiById(int id) {
        try {
            return adopsiDAO.getAdopsiById(id);
        } catch (SQLException e) {
            System.out.println("Error mendapatkan adopsi: " + e.getMessage());
            return null;
        }
    }

    // Dapatkan Semua Data Adopsi
    public List<Adopsi> getAllAdopsi() {
        try {
            return adopsiDAO.getAllAdopsi();
        } catch (SQLException e) {
            System.out.println("Error mendapatkan semua adopsi: " + e.getMessage());
            return null;
        }
    }
    
    public List<Adopsi> getAdopsiByStatus(String status) {
    try {
        return adopsiDAO.getAdopsiByStatus(status);
    } catch (SQLException e) {
        System.out.println("Error mendapatkan adopsi berdasarkan status: " + e.getMessage());
        return new ArrayList<>();
    }
}


    public void ubahStatusAdopsi(int idAdopsi, String newStatus) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void hapusAdopsi(int idAdopsi) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
