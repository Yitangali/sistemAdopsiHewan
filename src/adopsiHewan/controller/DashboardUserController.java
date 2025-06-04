/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DashboardUser.controller;

import DashboardUser.DAO.DashboardDAO;
import DashboardUser.DAO.Interface.DasbUser;
import DashboardUser.model.DashboardUser;
import DashboardUser.view.DashboardUserView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.List;

public class DashboardUserController {

    private DasbUser dao;
    private DashboardUserView view;

    public DashboardUserController(DashboardUserView view) {
        this.dao = new DashboardDAO();  // Inisialisasi DAO
        this.view = view;               // Pasang view
    }

    public void loadDashboard() {
        List<DashboardUser> pets = dao.getAvailablePets();

        for (int i = 0; i < 3; i++) {
            if (i < pets.size()) {
                DashboardUser pet = pets.get(i);
                System.out.println("Slot " + (i + 1) + " data:");
            System.out.println("Nama: " + pet.getNamaHewan());
            System.out.println("Jenis: " + pet.getJenis());
            System.out.println("Kelamin: " + pet.getKelamin());
            System.out.println("Umur: " + pet.getUmur());
            System.out.println("Deskripsi: " + pet.getDeskripsi());
            System.out.println("------------------------");
                ImageIcon icon = null;
                try {
                    byte[] fotoBytes = pet.getFoto();
                    if (fotoBytes != null) {
                        BufferedImage img = ImageIO.read(new ByteArrayInputStream(fotoBytes));
                        icon = new ImageIcon(img.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                switch (i) {
                    case 0:
                        view.setFoto1(icon);
                        view.setIdHewan1(String.valueOf(pet.getIdHewan()));
                        view.setNama1(pet.getNamaHewan());
                        view.setJenis1(pet.getJenis());
                        view.setUmur1(String.valueOf(pet.getUmur()));
                        view.setKelamin1(pet.getKelamin());
                        view.setDeskripsi1(pet.getDeskripsi());
                        view.setStatus1(pet.getStatus());
                        break;
                    case 1:
                        view.setFoto2(icon);
                        view.setIdHewan2(String.valueOf(pet.getIdHewan()));
                        view.setNama2(pet.getNamaHewan());
                        view.setJenis2(pet.getJenis());
                        view.setUmur2(String.valueOf(pet.getUmur()));
                        view.setKelamin2(pet.getKelamin());
                        view.setDeskripsi2(pet.getDeskripsi());
                        view.setStatus2(pet.getStatus());
                        break;
                    case 2:
                        view.setFoto3(icon);
                        view.setIdHewan3(String.valueOf(pet.getIdHewan()));
                        view.setNama3(pet.getNamaHewan());
                        view.setJenis3(pet.getJenis());
                        view.setUmur3(String.valueOf(pet.getUmur()));
                        view.setKelamin3(pet.getKelamin());
                        view.setDeskripsi3(pet.getDeskripsi());
                        view.setStatus3(pet.getStatus());
                        break;
                }
            } else {
                // Kosongkan slot jika tidak ada data
                switch (i) {
                    case 0: view.clearSlot1(); break;
                    case 1: view.clearSlot2(); break;
                    case 2: view.clearSlot3(); break;
                }
            }
        }
    }
}



