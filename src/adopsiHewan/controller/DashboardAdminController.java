/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.controller;

import adopsiHewan.dao.DashboardAdminDAO;
import adopsiHewan.dao.Interface.InDashbAdmin;
import adopsiHewan.model.DashboardAdmin;
import adopsiHewan.view.DashboardAdminView;


import java.util.List;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.io.File;
import javax.swing.*;
/**
 *
 * @author ASUS
 */
public class DashboardAdminController {
    //DashboardAdminDAO dba;
    DashboardAdminView frame;
    InDashbAdmin in;
    //List<Mahasiswa> lb;


    public DashboardAdminController(DashboardAdminView form) {
        this.frame = form;
        in = new DashboardAdminDAO();
    }
    
    
    public void tampilkanData() {
        String jmlUser, jmlHewan, jmlDiadopsi, namaMasuk, namaDiadopsi;
        
        jmlUser = Integer.toString(in.getAmountOfUsers());
        frame.getTxtJmlUser().setText(jmlUser);
        
        jmlHewan = Integer.toString(in.getAmountOfPets());
        frame.getTxtJmlHewan().setText(jmlHewan);
        
        jmlDiadopsi = Integer.toString(in.getAmountOfAdopteds());
        frame.getTxtJmlDiadopsi().setText(jmlDiadopsi);
        
        namaMasuk = in.getLatestPetNameIn();
        frame.getTxtNamaMasuk().setText(namaMasuk);
        
        namaDiadopsi = in.getLatestPetNameAdopted();
        frame.getTxtNamaDiadopsi().setText(namaDiadopsi);
    }
    
    public void tampilkanGambar1() {
        ImageIcon icon = in.getLatestPetImageIn();
        if (icon != null) {
            // Resize image jika perlu
            Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            frame.getGambar1().setIcon(new ImageIcon(img));
            frame.getGambar1().setText("");
        } else {
            frame.getGambar1().setText(in.getLatestPetNameIn());
        }
    }
    
        public void tampilkanGambar2() {
        ImageIcon icon = in.getLatestPetImageAdopted();
        if (icon != null) {
            // Resize image jika perlu
            Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            frame.getGambar2().setIcon(new ImageIcon(img));
            frame.getGambar2().setText("");
        } else {
            frame.getGambar2().setText(in.getLatestPetNameAdopted());
        }
    }
}

