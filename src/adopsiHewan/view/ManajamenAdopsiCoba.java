package adopsiHewan.view;

import adopsiHewan.model.Adopsi;
import adopsiHewan.controller.AdopsiController;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author ASUS (dengan perbaikan oleh AI)
 */
public class ManajemenAdopsiView extends javax.swing.JFrame {

    private AdopsiController adopsiController;
    private DefaultTableModel tableModel;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Sesuaikan format tanggal

    // Variabel-variabel ini akan diinisialisasi oleh NetBeans initComponents()
    // Pastikan nama di initComponents() sesuai dengan yang digunakan di sini.
    // Jika berbeda, sesuaikan nama di sini atau di NetBeans designer.
    // private javax.swing.JTextField txtid_adopsi; // Akan digunakan dari initComponents
    // private javax.swing.JTextField txtid_user;   // Akan digunakan dari initComponents
    // private javax.swing.JTextField txtid_hewan;  // Akan digunakan dari initComponents
    // private javax.swing.JTextField txttanggal_ajuan; // Akan digunakan dari initComponents
    // private javax.swing.JTextField txtCatatan;     // Akan digunakan dari initComponents
    // private javax.swing.JComboBox<String> cmbStatusAdopsi; // INI PERLU DIGANTI DI INITCOMPONENTS

    /**
     * Creates new form ManajemenAdopsiView
     */
    public ManajemenAdopsiView() throws SQLException {
        adopsiController = new AdopsiController(); // Inisialisasi controller dulu
        initComponents(); // Kemudian inisialisasi komponen UI
        initCustomComponents(); // Inisialisasi tambahan seperti tabel model dan combo box
        loadAdopsiData();
        setupListeners();
        clearFields(); // Bersihkan field saat pertama kali muncul
        this.setTitle("Manajemen Adopsi Hewan");
        this.setLocationRelativeTo(null); // Tampilkan window di tengah layar
    }

    private void initCustomComponents() {
        // Setup Table Model
        tableModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID Adopsi", "ID User", "ID Hewan", "Tgl Ajuan", "Status", "Catatan"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Membuat sel tabel tidak bisa diedit langsung
            }
        };
        jTable1.setModel(tableModel);

        // Populate JComboBox untuk Status Adopsi
        // Pastikan Adopsi.Status adalah enum
        cmbStatusAdopsi.removeAllItems(); // Bersihkan item default jika ada dari designer
        for (Adopsi.Status status : Adopsi.Status.values()) {
            cmbStatusAdopsi.addItem(status.name());
        }
    }

    private void loadAdopsiData() {
        try {
            tableModel.setRowCount(0); // Kosongkan tabel sebelum memuat data baru
            List<Adopsi> adopsiList = adopsiController.getAllAdopsi();
            if (adopsiList != null) {
                for (Adopsi adopsi : adopsiList) {
                    tableModel.addRow(new Object[]{
                        adopsi.getIdAdopsi(),
                        adopsi.getIdUser(),
                        adopsi.getIdHewan(),
                        dateFormat.format(adopsi.getTanggalAjuan()),
                        adopsi.getStatus().name(),
                        adopsi.getCatatan()
                    });
                }
            }
             if (tableModel.getRowCount() > 0) {
                jTable1.setRowSelectionInterval(0, 0); // Pilih baris pertama secara default
                populateFieldsFromSelectedTable(); // Isi field dari baris pertama
            } else {
                clearFields(); // Jika tidak ada data, kosongkan fields
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal mengambil data adopsi: " + e.getMessage(), "Error Database", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void populateFieldsFromSelectedTable() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            txtid_adopsi.setText(tableModel.getValueAt(selectedRow, 0).toString());
            txtid_user.setText(tableModel.getValueAt(selectedRow, 1).toString());
            txtid_hewan.setText(tableModel.getValueAt(selectedRow, 2).toString());
            txttanggal_ajuan.setText(tableModel.getValueAt(selectedRow, 3).toString());
            cmbStatusAdopsi.setSelectedItem(tableModel.getValueAt(selectedRow, 4).toString());
            txtCatatan.setText(tableModel.getValueAt(selectedRow, 5) != null ? tableModel.getValueAt(selectedRow, 5).toString() : "");
            
            // Membuat field ID tidak bisa diubah setelah dipilih dari tabel
            txtid_adopsi.setEditable(false);
            txtid_user.setEditable(false);
            txtid_hewan.setEditable(false);
            txttanggal_ajuan.setEditable(false);

        }
    }
    
    private void clearFields() {
        txtid_adopsi.setText("");
        txtid_user.setText("");
        txtid_hewan.setText("");
        txttanggal_ajuan.setText("");
        if (cmbStatusAdopsi.getItemCount() > 0) {
             cmbStatusAdopsi.setSelectedIndex(0); // Set ke status default (misal PENDING) jika ada
        }
        txtCatatan.setText("");
        txtCari.setText("");

        txtid_adopsi.setEditable(true); // ID Adopsi bisa diisi untuk pencarian atau penambahan baru (jika ada)
        txtid_user.setEditable(true); 
        txtid_hewan.setEditable(true);
        txttanggal_ajuan.setEditable(true);
        jTable1.clearSelection();
    }


    private void setupListeners() {
        btnUbah.addActionListener(e -> ubahDataAdopsi());
        btnHapus.addActionListener(e -> hapusDataAdopsi());
        btnRefresh.addActionListener(e -> {
            loadAdopsiData();
            clearFields(); // Opsional, agar field kembali bersih setelah refresh
        });
        btnCari.addActionListener(e -> cariDataAdopsi());

        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting() && jTable1.getSelectedRow() != -1) {
                    populateFieldsFromSelectedTable();
                }
            }
        });
    }

    private void ubahDataAdopsi() {
        if (jTable1.getSelectedRow() == -1 && txtid_adopsi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data dari tabel atau masukkan ID Adopsi yang akan diubah.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int idAdopsi;
            // Prioritaskan ID dari field jika diisi, berguna jika pengguna mengetik ID
            if (!txtid_adopsi.getText().trim().isEmpty()){
                 idAdopsi = Integer.parseInt(txtid_adopsi.getText());
            } else {
                 idAdopsi = (int) tableModel.getValueAt(jTable1.getSelectedRow(), 0);
            }

            Adopsi adopsi = adopsiController.getAdopsiById(idAdopsi); // Ambil data terbaru

            if (adopsi != null) {
                // Ambil data dari field form
                // ID User, ID Hewan, dan Tanggal Ajuan biasanya tidak diubah lewat form ini,
                // tapi jika boleh, ambil dari txtid_user, txtid_hewan, txttanggal_ajuan
                // Contoh: adopsi.setIdUser(Integer.parseInt(txtid_user.getText()));
                // Contoh: adopsi.setIdHewan(Integer.parseInt(txtid_hewan.getText()));
                // try {
                //    Date tanggal = dateFormat.parse(txttanggal_ajuan.getText());
                //    adopsi.setTanggalAjuan(new java.sql.Date(tanggal.getTime()));
                // } catch (ParseException ex) {
                //    JOptionPane.showMessageDialog(this, "Format tanggal salah (yyyy-MM-dd).", "Error Input", JOptionPane.ERROR_MESSAGE);
                //    return;
                // }

                adopsi.setStatus(Adopsi.Status.valueOf(cmbStatusAdopsi.getSelectedItem().toString()));
                adopsi.setCatatan(txtCatatan.getText());

                adopsiController.updateAdopsi(adopsi);
                JOptionPane.showMessageDialog(this, "Data adopsi berhasil diperbarui!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                loadAdopsiData(); // Muat ulang data untuk menampilkan perubahan
                clearFields();
            } else {
                 JOptionPane.showMessageDialog(this, "Data adopsi dengan ID " + idAdopsi + " tidak ditemukan.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID Adopsi, ID User, atau ID Hewan harus berupa angka.", "Error Input", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Kesalahan SQL saat memperbarui data: " + e.getMessage(), "Error Database", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void hapusDataAdopsi() {
         if (jTable1.getSelectedRow() == -1 && txtid_adopsi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data dari tabel atau masukkan ID Adopsi yang akan dihapus.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            int idAdopsi;
            if (!txtid_adopsi.getText().trim().isEmpty()){
                 idAdopsi = Integer.parseInt(txtid_adopsi.getText());
            } else {
                 idAdopsi = (int) tableModel.getValueAt(jTable1.getSelectedRow(), 0);
            }

            int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus data adopsi dengan ID " + idAdopsi + "?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                adopsiController.deleteAdopsi(idAdopsi);
                JOptionPane.showMessageDialog(this, "Data adopsi berhasil dihapus!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                loadAdopsiData(); // Muat ulang data untuk menampilkan perubahan
                clearFields();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID Adopsi harus berupa angka.", "Error Input", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Kesalahan SQL saat menghapus data: " + e.getMessage(), "Error Database", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cariDataAdopsi() {
        String idCariText = txtCari.getText().trim();
        if (idCariText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Masukkan ID Adopsi yang ingin dicari.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int idCari = Integer.parseInt(idCariText);
            // Cari di tabel dulu untuk efisiensi jika data sudah termuat semua
            boolean foundInTable = false;
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                if ((Integer)tableModel.getValueAt(i, 0) == idCari) {
                    jTable1.setRowSelectionInterval(i, i);
                    jTable1.scrollRectToVisible(jTable1.getCellRect(i, 0, true)); // Auto-scroll ke baris yang ditemukan
                    populateFieldsFromSelectedTable();
                    foundInTable = true;
                    break;
                }
            }

            if (!foundInTable) {
                // Jika tidak ketemu di tabel (misal data banyak dan ada paginasi, atau hanya ingin konfirmasi dari DB)
                Adopsi adopsi = adopsiController.getAdopsiById(idCari);
                if (adopsi != null) {
                    // Tampilkan di field, atau bisa juga tambahkan ke tabel jika belum ada dan pilih
                    txtid_adopsi.setText(String.valueOf(adopsi.getIdAdopsi()));
                    txtid_user.setText(String.valueOf(adopsi.getIdUser()));
                    txtid_hewan.setText(String.valueOf(adopsi.getIdHewan()));
                    txttanggal_ajuan.setText(dateFormat.format(adopsi.getTanggalAjuan()));
                    cmbStatusAdopsi.setSelectedItem(adopsi.getStatus().name());
                    txtCatatan.setText(adopsi.getCatatan());
                    JOptionPane.showMessageDialog(this, "Data ditemukan dan ditampilkan di form.", "Info", JOptionPane.INFORMATION_MESSAGE);
                    jTable1.clearSelection(); // Hapus seleksi tabel jika data dari pencarian DB langsung
                } else {
                    JOptionPane.showMessageDialog(this, "Data adopsi dengan ID " + idCari + " tidak ditemukan.", "Info", JOptionPane.INFORMATION_MESSAGE);
                    clearFields();
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID Adopsi untuk pencarian harus berupa angka.", "Error Input", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Kesalahan SQL saat mencari data: " + e.getMessage(), "Error Database", JOptionPane.ERROR_MESSAGE);
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtid_adopsi = new javax.swing.JTextField();
        txtid_user = new javax.swing.JTextField();
        txtid_hewan = new javax.swing.JTextField();
        txttanggal_ajuan = new javax.swing.JTextField();
        txtCatatan = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        cmbStatusAdopsi = new javax.swing.JComboBox<>(); // GANTI txtStatus MENJADI cmbStatusAdopsi

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Dashboard");

        jButton2.setText("Manajemen Hewan");

        jButton3.setText("Manajemen Adopsi");
        jButton3.setEnabled(false); // Nonaktifkan tombol menu saat ini

        jButton4.setText("Riwayat");

        jLabel1.setText("ID adopsi");

        jLabel2.setText("ID user");

        jLabel3.setText("ID hewan");

        jLabel4.setText("Tanggal ajuan");

        jLabel5.setText("Status");

        jLabel6.setText("Catatan");

        jLabel7.setText(":");

        jLabel8.setText(":");

        jLabel9.setText(":");

        jLabel10.setText(":");

        jLabel11.setText(":");

        jLabel12.setText(":");

        txtid_adopsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtid_adopsiActionPerformed(evt);
            }
        });

        txtid_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtid_userActionPerformed(evt);
            }
        });

        txttanggal_ajuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttanggal_ajuanActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("MANAJEMEN ADOPSI");

        jLabel14.setText("Cari (ID adopsi)");

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnUbah.setText("Ubah");

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnRefresh.setText("Perbarui Tabel");

        // cmbStatusAdopsi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        // Model untuk cmbStatusAdopsi di-set di initCustomComponents()

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 167, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING