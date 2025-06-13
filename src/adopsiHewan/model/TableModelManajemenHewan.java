/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.model;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ASUS
 */
public class TableModelManajemenHewan extends AbstractTableModel {
    List<ManajemenHewan> lmh;
    
    public TableModelManajemenHewan(List<ManajemenHewan> lmh) {
        this.lmh = lmh;
    }

    @Override
    public int getRowCount() {
        return lmh.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }
    
    public String getColumnName(int column) {
        switch(column) {
            case 0:
                return "id_hewan";
            case 1:
                return "nama_hewan";
            case 2:
                return "jenis";
            case 3:
                return "umur";
            case 4:
                return "kelamin";
            case 5:
                return "deskripsi";
            //case 6:
                //return "foto";
            case 6:
                return "status";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column) {
            case 0:
                return lmh.get(row).getId_hewan();
            case 1:
                return lmh.get(row).getNama_hewan();
            case 2:
                return lmh.get(row).getJenis();
            case 3:
                return lmh.get(row).getUmur();
            case 4:
                return lmh.get(row).getKelamin();
            case 5:
                return lmh.get(row).getDeskripsi();
            //case 6:
                //return lmh.get(row).getFoto();
            case 6:
                return lmh.get(row).getStatus();
            default:
                return null;
        }
    }
    
    
}
