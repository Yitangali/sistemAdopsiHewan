/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.controller;

import adopsiHewan.dao.impl.ManajemenHewanDAO;
import adopsiHewan.dao.Interface.InManajemenHewan;
import adopsiHewan.model.ManajemenHewan;
import adopsiHewan.model.TableModelManajemenHewan;
import adopsiHewan.view.ManajemenHewanView;
import adopsiHewan.util.PhotoHandler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.ImageIcon;
import javax.swing.Icon;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class ManajemenHewanController {
    ManajemenHewanView frame;
    InManajemenHewan in;
    List<ManajemenHewan> mh;
    PhotoHandler ph;
    
    public ManajemenHewanController(ManajemenHewanView frame) {
        this.frame = frame;
        in = new ManajemenHewanDAO();
        mh = in.getAll();
        ph = new PhotoHandler();
    }
    
    //kosongkan field
    public void reset() {
        frame.getTxtID().setText("");
        frame.getTxtNama().setText("");
        frame.getTxtJenis().setSelectedItem("");
        frame.getTxtUmur().setText("");
        frame.getTxtKelamin().setSelectedItem("");
        frame.getTxtDeskripsi().setText("");
        frame.getFotoHewan().setIcon(null);
        frame.getTxtStatus().setSelectedItem("");
    }
    
    public void isiTable() {
        mh = in.getAll();
        TableModelManajemenHewan tmmh = new TableModelManajemenHewan(mh);
        frame.getTabelData().setModel(tmmh);
    }
    
    public void refresh() {
        mh = in.getAll();
        TableModelManajemenHewan tmmh = new TableModelManajemenHewan(mh);
        //frame.getTabelData().setVisible(false);
        frame.getTabelData().setModel(tmmh);
    }
    
    public void insert() {
        try {
            if (!frame.getTxtNama().getText().trim().isEmpty() & !frame.getTxtUmur().getText().trim().isEmpty()) {
                int umur = Integer.parseInt(frame.getTxtUmur().getText());
                ManajemenHewan mh2 = new ManajemenHewan();
                mh2.setNama_hewan(frame.getTxtNama().getText());
                mh2.setJenis(frame.getTxtJenis().getSelectedItem().toString());
                mh2.setUmur(umur);
                mh2.setKelamin(frame.getTxtKelamin().getSelectedItem().toString());
                mh2.setDeskripsi(frame.getTxtDeskripsi().getText());

                // Cek apakah ikon yang diambil adalah ImageIcon
                Icon icon = frame.getFotoHewan().getIcon();
                if (icon instanceof ImageIcon) {
                    ImageIcon imageIcon = (ImageIcon) icon;  // Casting ke ImageIcon
                    byte[] foto = ph.iconKeByte(imageIcon);  // Gunakan metode yang sudah ada
                    System.out.println("Ukuran byte array foto: " + foto.length);
                    mh2.setFoto(ph.getFotoBytes());
                } else {
                    JOptionPane.showMessageDialog(frame, "Foto hewan belum dipilih atau format ikon salah!");
                    return;  // Keluar dari method jika foto tidak valid
                }
                
                //mh2.setFoto(ph.getFotoBytes());
                mh2.setStatus(frame.getTxtStatus().getSelectedItem().toString());
                in.insert(mh2);
                JOptionPane.showMessageDialog(null, "Data sukses disimpan!");
            } else {
                JOptionPane.showMessageDialog(frame, "Data tidak boleh kosong!");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error saat mengonversi gambar: " + e.getMessage());
            e.printStackTrace();  // Cetak stack trace untuk debugging
        }
    }
    
    public void update() {
        try {
            if (!frame.getTxtID().getText().trim().isEmpty()) {
                ManajemenHewan mh2 = new ManajemenHewan();
                mh2.setNama_hewan(frame.getTxtNama().getText());
                mh2.setJenis(frame.getTxtJenis().getSelectedItem().toString());
                mh2.setUmur(Integer.parseInt(frame.getTxtUmur().getText()));
                mh2.setKelamin(frame.getTxtKelamin().getSelectedItem().toString());
                mh2.setDeskripsi(frame.getTxtDeskripsi().getText());

                // Cek dan ubah foto jika valid
                Icon icon = frame.getFotoHewan().getIcon();
                if (icon instanceof ImageIcon) {
                    ImageIcon imageIcon = (ImageIcon) icon;  // Casting ke ImageIcon
                    byte[] foto = ph.iconKeByte(imageIcon);  // Konversi ke byte array
                    mh2.setFoto(foto);
                } else {
                    JOptionPane.showMessageDialog(frame, "Foto hewan belum dipilih atau format ikon salah!");
                    return;  // Keluar dari method jika foto tidak valid
                }

                mh2.setStatus(frame.getTxtStatus().getSelectedItem().toString());
                mh2.setId_hewan(Integer.parseInt(frame.getTxtID().getText()));

                // Update data di database
                in.update(mh2);
                JOptionPane.showMessageDialog(null, "Data sukses diupdate!");
            } else {
                JOptionPane.showMessageDialog(frame, "Pilih data yang akan diubah");
            }
        } catch (IOException e) {
            // Menangani IOException yang mungkin terjadi saat konversi gambar
            JOptionPane.showMessageDialog(frame, "Terjadi kesalahan saat mengonversi gambar: " + e.getMessage());
            e.printStackTrace();  // Cetak stack trace untuk debugging lebih lanjut
        } catch (NumberFormatException e) {
            // Menangani kesalahan konversi inputan yang bukan angka (misalnya umur atau ID hewan)
            JOptionPane.showMessageDialog(frame, "Input tidak valid. Pastikan umur dan ID hewan adalah angka.");
        } catch (Exception e) {
            // Menangani exception umum lainnya
            JOptionPane.showMessageDialog(frame, "Terjadi kesalahan: " + e.getMessage());
        }
    }
    
    public void delete() {
        if(!frame.getTxtID().getText().trim().isEmpty()) {
            int id = Integer.parseInt(frame.getTxtID().getText());
            in.delete(id);
            JOptionPane.showMessageDialog(null, "Data sukses dihapus!");
        } else {
            JOptionPane.showMessageDialog(frame, "Pilih data yang akan dihapus");
        }
    }
    
    public void isiTableCariNama() {
        mh = in.getCariNama(frame.getTxtCariNama().getText());
        TableModelManajemenHewan tmmh = new TableModelManajemenHewan(mh);
        frame.getTabelData().setModel(tmmh);
    }
    
    public void cariNama() {
        if(!frame.getTxtCariNama().getText().trim().isEmpty()) {
            in.getCariNama(frame.getTxtCariNama().getText());
            isiTableCariNama();
        } else {
            JOptionPane.showMessageDialog(frame, "SILAHKAN PILIH DATA");
        }
    }
    
}
