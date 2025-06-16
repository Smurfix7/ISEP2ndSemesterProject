package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.PropertyRepository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Property implements Serializable {

    static List<Property> properties = new ArrayList<>();
    private static int cont = 0;

    // ATTRIBUTES
    private String propertyType;
    private double areaOfProperty;
    private double distanceFromCentre;
    private Address address;
    private ArrayList<Photo> photos;
    private Photo photo;


    private int propertyID;

    private final ArrayList<Photo> PHOTOS_BY_DEFAULT = new ArrayList<Photo>();
    private final String PROPERTY_TYPE_BY_DEFAULT = "Land";
    private final double AREA_OF_PROPERTY_BY_DEFAULT = 0;
    private final double DISTANCE_FROM_CENTRE_BY_DEFAULT = 0;
    private final Address ADDRESS_BY_DEFAULT = null;
    private final Photo PHOTO_BY_DEFAULT = null;



    // CONSTRUCTORS

    /**
     * This method creates the Property object with default attributes
     */
    public Property() {
        this.propertyType = PROPERTY_TYPE_BY_DEFAULT;
        this.areaOfProperty = AREA_OF_PROPERTY_BY_DEFAULT;
        this.distanceFromCentre = DISTANCE_FROM_CENTRE_BY_DEFAULT;
        this.address = ADDRESS_BY_DEFAULT;
        this.photos = PHOTOS_BY_DEFAULT;
        cont++;
        this.propertyID = cont;
    }

    /**
     * This method creates the Property object
     * @param propertyType
     * @param areaOfProperty
     * @param distanceFromCentre
     * @param address
     * @param photos
     */
    public Property(String propertyType, double areaOfProperty, double distanceFromCentre, Address address, ArrayList<Photo> photos) {
        this.propertyType = propertyType;
        this.areaOfProperty = areaOfProperty;
        this.distanceFromCentre = distanceFromCentre;
        this.address = address;
        this.photos = photos;
        cont++;
        this.propertyID = cont;

        if (!validateProperty(this)) {
            properties.add(this);
        }
    }

    public Property(String propertyType, double areaOfProperty, double distanceFromCentre, Address address) {
        this.propertyType = propertyType;
        this.photos = PHOTOS_BY_DEFAULT;
        this.areaOfProperty = areaOfProperty;
        this.distanceFromCentre = distanceFromCentre;
        this.address = address;
        cont++;
        this.propertyID = cont;

        if (validateProperty(this)) {
            properties.add(this);
        }
    }




    public boolean validateProperty(Property property){return !properties.contains(property);}
    // SETS AND GETS

    public static void setCont(int n) {
        cont = n;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }



    /**
     * This method returns the distanceFromCentre of the Property
     *
     * @return String
     */

    public double getDistanceFromCentre() {
        return distanceFromCentre;
    }

    /**
     * This method changes the distanceFromCentre of the Property
     *
     * @param distanceFromCentre
     */
    public void setDistanceFromCentre(double distanceFromCentre) {
        this.distanceFromCentre = distanceFromCentre;
    }

    /**
     * This method returns the areaOfProperty of the Property
     *
     * @return String
     */
    public double getAreaOfProperty() {
        return areaOfProperty;
    }

    /**
     * This method changes the areaOfProperty of the Property
     *
     * @param areaOfProperty
     */
    public void setAreaOfProperty(double areaOfProperty) {
        this.areaOfProperty = areaOfProperty;
    }




    /**
     * This method returns the address of the Property
     *
     * @return Address
     */
    public Address getAddress() {
        return address;
    }

    public int getPropertyID() {
        return propertyID;
    }

    public String getPropertyType() {
        return propertyType;
    }


    /**
     * This method changes the address of the Property
     *
     * @param address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * This method returns the photo of the Property
     *
     * @return Photo
     */
    public Photo getPhoto() {
        return photo;
    }

    /**
     * This method changes the photo of the Property
     *
     * @param photoURI
     */
    public void setPhoto(String photoURI) {
        this.photo = new Photo(photoURI);
    }



    // TOSTRING

    /**
     * This method returns true or false if the Property was listed
     *
     * @param property
     * @return boolean
     */
    public static boolean IsListed(Property property) {
        return (property instanceof Property);
    }


    @Override
    public String toString() {
        return "#" + propertyID +  " |\n  | Property type: " + propertyType + " | Area Of The Property: " + areaOfProperty + " | Distance From The Centre: " + distanceFromCentre ;

    }

    public void setAddres(Address address) {
        this.address = address;
    }
}