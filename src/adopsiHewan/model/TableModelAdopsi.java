/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.model;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelAdopsi extends AbstractTableModel {
    private List<Adopsi> list;
    private final String[] columnNames = {"ID Adopsi", "ID User", "ID Hewan", "Tanggal Ajuan", "Status", "Catatan"};
    
    public TableModelAdopsi(List<Adopsi> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }
    
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Adopsi adopsi = list.get(rowIndex);
        
        switch (columnIndex) {
            case 0: return adopsi.getIdAdopsi();
            case 1: return adopsi.getIdUser();
            case 2: return adopsi.getIdHewan();
            case 3: return adopsi.getTanggalAjuan() != null ? sdf.format(adopsi.getTanggalAjuan()) : "";
            case 4: return adopsi.getStatus();
            case 5: return adopsi.getCatatan();
            default: return null;
        }
    }
}