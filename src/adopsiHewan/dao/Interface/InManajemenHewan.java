/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adopsiHewan.dao.Interface;

import java.util.List;
import adopsiHewan.model.ManajemenHewan;

/**
 *
 * @author ASUS
 */
public interface InManajemenHewan {
    public void insert(ManajemenHewan mh);
    public void update(ManajemenHewan mh);
    public void delete(int id);
    public List<ManajemenHewan> getAll();
    public List<ManajemenHewan> getCariNama(String nama);
}
