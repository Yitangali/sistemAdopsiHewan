/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package adopsiHewan.view;

import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class RegisterView extends javax.swing.JFrame {

    /**
     * Creates new form RegisterView
     */
    public RegisterView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNamaRegister = new javax.swing.JTextField();
        buttonRegister = new javax.swing.JButton();
        passwordRegister = new javax.swing.JPasswordField();
        passwordRegister2 = new javax.swing.JPasswordField();
        Nama = new javax.swing.JLabel();
        Password = new javax.swing.JLabel();
        UlangiPassword = new javax.swing.JLabel();
        txtEmailRegister = new javax.swing.JTextField();
        Email = new javax.swing.JLabel();
        Alamat = new javax.swing.JLabel();
        txtNoHPRegister = new javax.swing.JTextField();
        NoHP = new javax.swing.JLabel();
        txtAlamatRegister = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtNamaRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaRegisterActionPerformed(evt);
            }
        });

        buttonRegister.setText("Register");
        buttonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegisterActionPerformed(evt);
            }
        });

        passwordRegister.setText("jPasswordField1");
        passwordRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordRegisterActionPerformed(evt);
            }
        });

        passwordRegister2.setText("jPasswordField1");
        passwordRegister2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordRegister2ActionPerformed(evt);
            }
        });

        Nama.setText("Nama");

        Password.setText("Password");

        UlangiPassword.setText("Ulangi Password");

        txtEmailRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailRegisterActionPerformed(evt);
            }
        });

        Email.setText("Email");

        Alamat.setText("Alamat");

        txtNoHPRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoHPRegisterActionPerformed(evt);
            }
        });

        NoHP.setText("No Hp");

        txtAlamatRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlamatRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(281, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtEmailRegister, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNamaRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNoHPRegister, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAlamatRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Nama)
                        .addGap(72, 72, 72))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Email)
                        .addGap(76, 76, 76))
                    .addComponent(passwordRegister2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Password)
                        .addGap(65, 65, 65))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonRegister)
                        .addGap(53, 53, 53))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(UlangiPassword)
                        .addGap(46, 46, 46))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Alamat)
                        .addGap(72, 72, 72))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NoHP)
                        .addGap(76, 76, 76)))
                .addGap(289, 289, 289))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Nama)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNamaRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Email)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmailRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Alamat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtAlamatRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NoHP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNoHPRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(Password)
                .addGap(1, 1, 1)
                .addComponent(passwordRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(UlangiPassword)
                .addGap(2, 2, 2)
                .addComponent(passwordRegister2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonRegister)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNamaRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaRegisterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaRegisterActionPerformed

    private void passwordRegister2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordRegister2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordRegister2ActionPerformed

    private void txtEmailRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailRegisterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailRegisterActionPerformed

    private void txtNoHPRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoHPRegisterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoHPRegisterActionPerformed

    private void txtAlamatRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlamatRegisterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlamatRegisterActionPerformed
    
    private void passwordRegisterActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }
    
    private void buttonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegisterActionPerformed
        try {
            boolean berhasil = controller.createUser(txtNamaRegister.getText(),
                txtEmailRegister.getText(),
                txtAlamatRegister.getText(),
                new String(passwordRegister.getPassword(),
                new String(passwordRegister2.getPassword(),
                txtNoHPRegister.getText(),
                comboRole.getSelectedItem().toString());
                
            if (berhasil) {
                JOptionPane.showMessageDialog(this, "Registrasi berhasil!");
            } else {
                JOptionPane.showMessageDialog(this, "Registrasi gagal.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }  
    }//GEN-LAST:event_buttonRegisterActionPerformed

    private void passwordRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordRegisterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordRegisterActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Alamat;
    private javax.swing.JLabel Email;
    private javax.swing.JLabel Nama;
    private javax.swing.JLabel NoHP;
    private javax.swing.JLabel Password;
    private javax.swing.JLabel UlangiPassword;
    private javax.swing.JButton buttonRegister;
    private javax.swing.JPasswordField passwordRegister;
    private javax.swing.JPasswordField passwordRegister2;
    private javax.swing.JTextField txtAlamatRegister;
    private javax.swing.JTextField txtEmailRegister;
    private javax.swing.JTextField txtNamaRegister;
    private javax.swing.JTextField txtNoHPRegister;
    // End of variables declaration//GEN-END:variables
}
