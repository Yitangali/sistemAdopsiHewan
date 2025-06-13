/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adopsiHewan.dao.Interface;

import java.util.List;
import adopsiHewan.model.DashboardAdmin;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;

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

    ImageIcon getLatestPetImageIn();
    ImageIcon getLatestPetImageAdopted();
}

