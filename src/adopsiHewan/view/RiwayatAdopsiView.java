/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package adopsiHewan.view;

import adopsiHewan.controller.RiwayatAdopsiController;
import adopsiHewan.model.RiwayatAdopsi;
import adopsiHewan.view.DashboardAdminView;
import adopsiHewan.view.ManajemenHewanView;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author M Tiyas F Akbar
 */
public class RiwayatAdopsiView extends javax.swing.JFrame {
    private RiwayatAdopsiController controller = new RiwayatAdopsiController();
    private DefaultTableModel tableModel = new DefaultTableModel();
    DashboardAdminView dav;
    ManajemenHewanView mhv;
    /**
     * Creates new form RiwayatAdopsi
     */
    public RiwayatAdopsiView() {
        initComponents();
        loadDataRiwayat();
        setVisible(true);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIdAdopsi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTanggalUpdate = new javax.swing.JTextField();
        cmbStatus = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableRiwayat = new javax.swing.JTable(tableModel);
        btnShowAll = new javax.swing.JButton();
        btnRiwayatAdopsi = new javax.swing.JButton();
        btnDashboard = new javax.swing.JButton();
        btnManajemenhewan = new javax.swing.JButton();
        btnManajemenAdopsi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("RIWAYAT ADOPSI");

        jLabel2.setText("ID Adopsi");

        jLabel3.setText("Status");

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dalam Proses", "Selesai" }));

        jLabel4.setText("Tanggal Update");

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        tableRiwayat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Riwayat", "ID Adopsi", "Tanggal Update", "Status"
            }
        ));
        jScrollPane2.setViewportView(tableRiwayat);

        btnShowAll.setText("Show All");
        btnShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllActionPerformed(evt);
            }
        });

        btnRiwayatAdopsi.setText("Riwayat Adopsi");
        btnRiwayatAdopsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRiwayatAdopsiActionPerformed(evt);
            }
        });

        btnDashboard.setText("Dashboard");
        btnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboardActionPerformed(evt);
            }
        });

        btnManajemenhewan.setText("Manajemen Hewan");
        btnManajemenhewan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManajemenhewanActionPerformed(evt);
            }
        });

        btnManajemenAdopsi.setText("Manajemen Adopsi");
        btnManajemenAdopsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManajemenAdopsiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1027, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdAdopsi, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTanggalUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnShowAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24)))
                .addContainerGap(100, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnManajemenAdopsi, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnDashboard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnManajemenhewan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRiwayatAdopsi)
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnRiwayatAdopsi)
                    .addComponent(btnDashboard))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnManajemenhewan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnManajemenAdopsi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(txtTanggalUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtIdAdopsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(5, 5, 5)
                .addComponent(btnShowAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadDataRiwayat() {
        tableModel.setRowCount(0);
        
        List<RiwayatAdopsi> list = controller.getRiwayatList();
        
        for (RiwayatAdopsi riwayat : list) {
            System.out.println("Menambahkan ke tabel: " + riwayat.getIdRiwayat() + " | " + riwayat.getStatus());
            tableModel.addRow(new Object[]{
                riwayat.getIdRiwayat(), 
                riwayat.getIdAdopsi(), 
                riwayat.getTanggalUpdate(),
                riwayat.getStatus()
            });
            System.out.println("Data ditambahkan ke tableModel!");
        }
        tableModel.fireTableDataChanged();
        tableRiwayat.repaint();
    }
    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        int idAdopsi = Integer.parseInt(txtIdAdopsi.getText());
        String status = cmbStatus.getSelectedItem().toString();
        
        controller.tambahRiwayat(idAdopsi,status);
        loadDataRiwayat();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllActionPerformed
        // TODO add your handling code here:
        loadDataRiwayat();
    }//GEN-LAST:event_btnShowAllActionPerformed

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        // TODO add your handling code here:
        this.dispose();
        dav = new DashboardAdminView();
        dav.setVisible(true);
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnManajemenhewanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManajemenhewanActionPerformed
        // TODO add your handling code here:
        this.dispose();
        mhv = new ManajemenHewanView();
        mhv.setVisible(true);
    }//GEN-LAST:event_btnManajemenhewanActionPerformed

    private void btnManajemenAdopsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManajemenAdopsiActionPerformed
        // TODO add your handling code here:
        new ManajemenAdopsi().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnManajemenAdopsiActionPerformed

    private void btnRiwayatAdopsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRiwayatAdopsiActionPerformed
        // TODO add your handling code here:
        new RiwayatAdopsiView().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRiwayatAdopsiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RiwayatAdopsi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RiwayatAdopsi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RiwayatAdopsi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RiwayatAdopsi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RiwayatAdopsiView().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnManajemenAdopsi;
    private javax.swing.JButton btnManajemenhewan;
    private javax.swing.JButton btnRiwayatAdopsi;
    private javax.swing.JButton btnShowAll;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableRiwayat;
    private javax.swing.JTextField txtIdAdopsi;
    private javax.swing.JTextField txtTanggalUpdate;
    // End of variables declaration//GEN-END:variables
}
