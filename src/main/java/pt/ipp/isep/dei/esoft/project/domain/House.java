package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class House extends Building implements Serializable {

    // ATTRIBUTES

    private String basement;
    private String loft;
    private String sunExposure;

    private final String BASEMENT_BY_DEFAULT = "No Value Provided";
    private final String LOFT_BY_DEFAULT = "No Value Provided";
    private final String SUN_EXPOSURE_BY_DEFAULT = "[NO DATA]";

    // CONSTRUCTORS

    /**
     * This method creates the House object with default attributes
     */
    public House() {
        super();
        this.basement = BASEMENT_BY_DEFAULT;
        this.loft = LOFT_BY_DEFAULT;
        this.sunExposure = SUN_EXPOSURE_BY_DEFAULT;
    }

    /**
     * This method creates the House object with the attributes given in the parameters
     *
     * @param basement
     * @param loft
     * @param sunExposure
     */
    public House(String propertyType, double areaOfProperty, double distanceFromCentre, Address address, ArrayList<Photo> photos, int bedrooms, int bathrooms, int parkingSpaces, String basement, String loft, String sunExposure, Equipment equipment) {
        super(propertyType,areaOfProperty, distanceFromCentre, address, photos, bedrooms, bathrooms, parkingSpaces, equipment);
        this.basement = basement;
        this.loft = loft;
        this.sunExposure = sunExposure;
    }

    public House(String propertyType, double areaOfProperty, double distanceFromCentre, Address address, int bedrooms, int bathrooms, int parkingSpaces, String basement, String loft, String sunExposure, Equipment equipment) {
        super(propertyType, areaOfProperty, distanceFromCentre, address, bedrooms, bathrooms, parkingSpaces, equipment);
        this.basement = basement;
        this.loft = loft;
        this.sunExposure = sunExposure;
    }

    // SETS AND GETS

    /**
     * This method changes the existence of the Basement
     *
     * @param basement
     */
    public void setBasement(String basement) {
        this.basement = basement;
    }

    /**
     * This method returns the existence of the Basement
     *
     * @return
     */
    public String getBasement() {
        return this.basement;
    }

    /**
     * This method changes the existence of the Loft
     *
     * @param loft
     */
    public void setLoft(String loft) {
        this.loft = loft;
    }

    /**
     * This method returns the existence of the Loft
     *
     * @return
     */
    public String getLoft() {
        return this.loft;
    }

    /**
     * This method returns the Sun Exposure
     *
     * @return
     */
    public String getSunExposure() {
        return sunExposure;
    }

    /**
     * This method changes the Sun Exposure
     *
     * @param sunExposure
     */
    public void setSunExposure(String sunExposure) {
        this.sunExposure = sunExposure;
    }

    // TOSTRING

    /**
     * This method returns the characteristics of the House
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + " | Basement: " + basement + " | Loft: " + loft + " | Sun Exposure: " + sunExposure;
    }
}
