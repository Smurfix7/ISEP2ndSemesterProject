package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;

public class Address implements Serializable {
    // ATTRIBUTES
    private String street;
    private String city;
    private String district;
    private String state;
    private String zipCode;

    private final String STREET_BY_DEFAULT = "[NO STREET]";
    private final String CITY_BY_DEFAULT = "[NO CITY]";
    private final String DISTRICT_BY_DEFAULT = "[NO DISTRICT]";
    private final String STATE_BY_DEFAULT = "[NO STATE]";
    private final String ZIPCODE_BY_DEFAULT = "00000";

    // CONSTRUCTORS

    /**
     * This method creates the Address object with default attributes
     */
    public Address() {
        this.street = STREET_BY_DEFAULT;
        this.city = CITY_BY_DEFAULT;
        this.district = DISTRICT_BY_DEFAULT;
        this.state = STATE_BY_DEFAULT;
        this.zipCode = ZIPCODE_BY_DEFAULT;
    }

    /**
     * This method creates the Address object
     *
     * @param street
     * @param city
     * @param state
     * @param zipCode
     */
    public Address(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.district = DISTRICT_BY_DEFAULT;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Address(String street, String city, String district, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.district = district;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Address(Address address) {
        this.street = address.getStreet();
        this.city = address.getCity();
        this.state = address.getState();
        this.zipCode = address.getZipCode();
    }

    // SETS AND GETS

    /**
     * This method returns the street of the Address
     *
     * @return String
     */
    public String getStreet() {
        return street;
    }

    /**
     * This method changes the street of the Address
     *
     * @param street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * This method returns the city of the Address
     *
     * @return String
     */
    public String getCity() {
        return city;
    }

    /**
     * This method changes the city of the Address
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * This method returns the district of the Address
     *
     * @return String
     */
    public String getDistrict() { return district; }

    /**
     * This method changes the district of the Address
     *
     * @param district
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * This method returns the State of the Address
     *
     * @return String
     */
    public String getState() {
        return state;
    }

    /**
     * This method changes the State of the Address
     *
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * This method returns the Zip Code of the Address
     *
     * @return String
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * This method changes the Zip Code of the Address
     *
     * @param zipCode
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    // TOSTRING

    /**
     * This method returns the characteristics of the Address
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Address: " + street + ", " + city + ", " + state + ", " + zipCode;
    }

    /**
     * Compares the content of two address objects to see if they are equal.
     *
     * @param address2
     * @return boolean
     */
    public boolean equals(Address address2) {
        if (this.getStreet().equalsIgnoreCase(address2.getStreet()) || this.getStreet().equalsIgnoreCase(STREET_BY_DEFAULT)) {
            if (this.getCity().equalsIgnoreCase(address2.getCity()) || this.getCity().equalsIgnoreCase(CITY_BY_DEFAULT)) {
                if (this.getState().equalsIgnoreCase(address2.getState()) || this.getState().equalsIgnoreCase(STATE_BY_DEFAULT)) {
                    if (this.getZipCode().equalsIgnoreCase(address2.getZipCode()) || this.getZipCode() == (ZIPCODE_BY_DEFAULT)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
