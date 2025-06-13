/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.dao;

import adopsiHewan.model.Adopsi;
import java.util.List;

public interface IAdopsi {
    public void insert(Adopsi adopsi);
    public void update(Adopsi adopsi);
    public void delete(int id);
    public List<Adopsi> getAll();
    public List<Adopsi> getByStatus(String status);
}