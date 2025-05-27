package adopsiHewan.controller;

import adopsiHewan.dao.AdopsiDAO;
import adopsiHewan.dao.impl.AdopsiDAOImpl;
import adopsiHewan.model.Adopsi;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import adopsiHewan.model.AdopsiModel;
import adopsiHewan.view.AdopsiView;
import adopsiHewan.dao.AdopsiDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class AdopsiController {
    private AdopsiModel model;
    private AdopsiView view;
    private AdopsiDAO dao;
    private String currentUser;
    private Date currentTimestamp;
    private AdopsiDAO adopsiDAO;

    // Konstruktor untuk inisialisasi DAO
    public AdopsiController(AdopsiModel model, AdopsiView view, String currentUser, Date currentTimestamp) {
        try {
            adopsiDAO = new AdopsiDAOImpl();
        } catch (SQLException e) {
            System.out.println("Gagal inisialisasi DAO: " + e.getMessage());
        }
        
        this.model = model;
        this.view = view;
        this.dao = new AdopsiDAO();
        this.currentUser = currentUser;
        this.currentTimestamp = currentTimestamp;
        
        initView();
        this.view.addSubmitListener(new SubmitListener());
        this.view.addBatalListener(e -> view.dispose());
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
    
    private void initView() {
        try {
            List<String> hewanList = dao.getAvailableHewan();
            view.addHewan("- Pilih Hewan -");
            for (String hewan : hewanList) {
                view.addHewan(hewan);
            }
        } catch (SQLException e) {
            view.showError("Error loading hewan: " + e.getMessage());
        }
    }
    
    class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (validateForm()) {
                try {
                    String selectedHewan = view.getSelectedHewanText();
                    int hewanId = Integer.parseInt(selectedHewan.split(" - ")[0]);
                    
                    model.setUserId(currentUser);
                    model.setIdHewan(hewanId);
                    model.setTanggalAjuan(currentTimestamp);
                    model.setCatatan(view.getAlasanAdopsi());
                    
                    dao.save(model);
                    dao.updateHewanStatus(hewanId, "proses");
                    
                    view.showSuccess("Form adopsi berhasil disubmit!");
                    view.dispose();
                    
                } catch (Exception ex) {
                    view.showError("Error menyimpan data: " + ex.getMessage());
                }
            }
        }
    }
    
    private boolean validateForm() {
        if (view.getSelectedHewan() == 0) {
            view.showError("Silakan pilih hewan!");
            return false;
        }
        if (view.getAlasanAdopsi().trim().isEmpty()) {
            view.showError("Alasan adopsi harus diisi!");
            return false;
        }
        return true;
    }
}