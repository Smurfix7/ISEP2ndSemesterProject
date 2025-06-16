package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Building extends Property implements Serializable {

    // ATTRIBUTES

    private int bedrooms;
    private int bathrooms;
    private int parkingSpaces;

    private Equipment equipment;

    private final int BEDROOMS_BY_DEFAULT = 0;
    private final int BATHROOMS_BY_DEFAULT = 0;
    private final int PARKING_SPACES_BY_DEFAULT = 0;

    // CONSTRUCTORS

    /**
     * This method creates the Building object with default values
     */
    public Building() {
        super();
        this.bedrooms = BEDROOMS_BY_DEFAULT;
        this.bathrooms = BATHROOMS_BY_DEFAULT;
        this.parkingSpaces = PARKING_SPACES_BY_DEFAULT;
        this.equipment = new Equipment();
    }

    /**
     * This method creates the Building object with the received parameters
     *
     * @param bedrooms
     * @param bathrooms
     * @param parkingSpaces
     */
    public Building(String propertyType, double areaOfProperty, double distanceFromCentre, Address address, ArrayList<Photo> photos, int bedrooms, int bathrooms, int parkingSpaces, Equipment equipment) {

        super(propertyType, areaOfProperty, distanceFromCentre, address, photos);
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.parkingSpaces = parkingSpaces;
        this.equipment = equipment;
    }

    /**
     * This method creates the Building object with the received parameters
     *
     * @param bedrooms
     * @param bathrooms
     * @param parkingSpaces
     */
    public Building(String propertyType, double areaOfProperty, double distanceFromCentre, Address address, int bedrooms, int bathrooms, int parkingSpaces, Equipment equipment) {

        super(propertyType, areaOfProperty, distanceFromCentre, address);
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.parkingSpaces = parkingSpaces;
        this.equipment = equipment;
    }

    // SETS AND GETS

    /**
     * This method returns the amount of Bathrooms
     *
     * @return
     */

    public int getBathrooms() {
        return bathrooms;
    }

    /**
     * This method changes the amount of Bathrooms
     *
     * @param bathrooms
     */
    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    /**
     * This method returns the amount of Bedrooms
     *
     * @return
     */
    public int getBedrooms() {
        return bedrooms;
    }

    /**
     * This method changes the amount of Bedrooms
     *
     * @param bedrooms
     */
    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    /**
     * This method returns the amount of Parking Spaces
     *
     * @return
     */

    public int getParkingSpaces() {
        return parkingSpaces;
    }

    /**
     * This method changes the amount of Parking Spaces
     *
     * @param parkingSpaces
     */
    public void setParkingSpaces(int parkingSpaces) {
        this.parkingSpaces = parkingSpaces;
    }

    // TOSTRING

    /**
     * This method returns the characteristics of the Building
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + " | Bedrooms: " + bedrooms + " | Bathrooms: " + bathrooms + " | Parking Spaces: " + parkingSpaces + this.equipment.toString();
    }
}
