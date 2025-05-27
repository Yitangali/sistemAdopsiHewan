/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adopsiHewan.dao.Interface;

import java.util.List;

/**
 *
 * @author ASUS
 */
public interface InDashbAdmin {
    int getAmountOfPets();
    int getAmountOfUsers();
    int getAmountOfAdopteds();

    String getLatestPetNameIn();
    String getLatestPetNameAdopted();

    String getLatestPetImagePathIn();
    String getLatestPetImagePathAdopted();
}

