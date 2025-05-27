/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan;

import adopsiHewan.model.AdopsiModel;
import adopsiHewan.view.AdopsiView;
import adopsiHewan.controller.AdopsiController;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) {
        try {
            // Parse the current timestamp
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
            Date currentTimestamp = sdf.parse("2025-05-27 09:19:13");
            
            // Current user
            String currentUser = "YusufPandu";
            
            // Create MVC components
            AdopsiModel model = new AdopsiModel();
            AdopsiView view = new AdopsiView();
            AdopsiController controller = new AdopsiController(model, view, currentUser, currentTimestamp);
            
            // Show view
            view.setVisible(true);
            
        } catch (ParseException e) {
            System.err.println("Error parsing timestamp: " + e.getMessage());
        }
    }
}