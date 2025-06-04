/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DAOAdopsi;
import dao.IAdopsi;
import model.Adopsi;
import model.TableModelAdopsi;
import view.FormAdopsi;
import java.util.List;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class ControllerAdopsi {
    private FormAdopsi frame;
    private IAdopsi implAdopsi;
    private List<Adopsi> list;
    
    public ControllerAdopsi(FormAdopsi frame) {
    if (!(frame instanceof FormAdopsi)) {
        throw new IllegalArgumentException("Parameter must be FormAdopsi");
    }
        this.frame = frame;
        implAdopsi = new DAOAdopsi();
        list = implAdopsi.getAll();
    }
    
    public void reset() {
        frame.getTxtIdAdopsi().setText("");
        frame.getTxtIdUser().setText("");
        frame.getTxtIdHewan().setText("");
        frame.getTxtTanggal().setText("");
        frame.getCmbStatus().setSelectedIndex(0);
        frame.getTxtCatatan().setText("");
    }
    
    public void isiTable() {
        list = implAdopsi.getAll();
        TableModelAdopsi tmb = new TableModelAdopsi(list);
        frame.getTabelData().setModel(tmb);
    }
    
    public void isiField(int row) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        frame.getTxtIdAdopsi().setText(list.get(row).getIdAdopsi().toString());
        frame.getTxtIdUser().setText(list.get(row).getIdUser().toString());
        frame.getTxtIdHewan().setText(list.get(row).getIdHewan().toString());
        frame.getTxtTanggal().setText(sdf.format(list.get(row).getTanggalAjuan()));
        frame.getCmbStatus().setSelectedItem(list.get(row).getStatus());
        frame.getTxtCatatan().setText(list.get(row).getCatatan());
    }
    
    public void insert() {
        try {
            if (!frame.getTxtIdUser().getText().trim().isEmpty()) {
                Adopsi adopsi = new Adopsi();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                
                adopsi.setIdUser(Integer.parseInt(frame.getTxtIdUser().getText()));
                adopsi.setIdHewan(Integer.parseInt(frame.getTxtIdHewan().getText()));
                adopsi.setTanggalAjuan(sdf.parse(frame.getTxtTanggal().getText()));
                adopsi.setStatus(frame.getCmbStatus().getSelectedItem().toString());
                adopsi.setCatatan(frame.getTxtCatatan().getText());
                
                implAdopsi.insert(adopsi);
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            } else {
                JOptionPane.showMessageDialog(frame, "Data tidak boleh kosong");
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(frame, "Format tanggal salah (gunakan YYYY-MM-DD)");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "ID User dan ID Hewan harus berupa angka");
        }
    }
    
    public void update() {
        try {
            if (!frame.getTxtIdAdopsi().getText().trim().isEmpty()) {
                Adopsi adopsi = new Adopsi();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                
                adopsi.setIdAdopsi(Integer.parseInt(frame.getTxtIdAdopsi().getText()));
                adopsi.setIdUser(Integer.parseInt(frame.getTxtIdUser().getText()));
                adopsi.setIdHewan(Integer.parseInt(frame.getTxtIdHewan().getText()));
                adopsi.setTanggalAjuan(sdf.parse(frame.getTxtTanggal().getText()));
                adopsi.setStatus(frame.getCmbStatus().getSelectedItem().toString());
                adopsi.setCatatan(frame.getTxtCatatan().getText());
                
                implAdopsi.update(adopsi);
                JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
            } else {
                JOptionPane.showMessageDialog(frame, "Pilih data yang akan diupdate");
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(frame, "Format tanggal salah (gunakan YYYY-MM-DD)");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "ID User dan ID Hewan harus berupa angka");
        }
    }
    
    public void delete() {
        if (!frame.getTxtIdAdopsi().getText().trim().isEmpty()) {
            int id = Integer.parseInt(frame.getTxtIdAdopsi().getText());
            implAdopsi.delete(id);
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        } else {
            JOptionPane.showMessageDialog(frame, "Pilih data yang akan dihapus");
        }
    }
}