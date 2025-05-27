/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adopsiHewan.model;

/**
 *
 * @author ASUS
 */
public class DashboardAdmin {

    /**
     * @return the userCount
     */
    public int getUserCount() {
        return userCount;
    }

    /**
     * @param userCount the userCount to set
     */
    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    /**
     * @return the adoptedCount
     */
    public int getAdoptedCount() {
        return adoptedCount;
    }

    /**
     * @param adoptedCount the adoptedCount to set
     */
    public void setAdoptedCount(int adoptedCount) {
        this.adoptedCount = adoptedCount;
    }

    /**
     * @return the animalCount
     */
    public int getAnimalCount() {
        return animalCount;
    }

    /**
     * @param animalCount the animalCount to set
     */
    public void setAnimalCount(int animalCount) {
        this.animalCount = animalCount;
    }

    /**
     * @return the latestAdopted
     */
    public String getLatestAdopted() {
        return latestAdopted;
    }

    /**
     * @param latestAdopted the latestAdopted to set
     */
    public void setLatestAdopted(String latestAdopted) {
        this.latestAdopted = latestAdopted;
    }

    /**
     * @return the latestIn
     */
    public String getLatestIn() {
        return latestIn;
    }

    /**
     * @param latestIn the latestIn to set
     */
    public void setLatestIn(String latestIn) {
        this.latestIn = latestIn;
    }
    private int userCount;
    private int adoptedCount;
    private int animalCount;
    private String latestAdopted;
    private String latestIn;
}
