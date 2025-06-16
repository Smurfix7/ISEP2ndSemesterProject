package pt.ipp.isep.dei.esoft.project.domain;

public class SelectedParameters {

    // ATTRIBUTES
    /**
     * Type of Business ()
     */
    private String businessType;
    /**
     * Property Type (Land, Appartment, House)
     */
    private String propertyType;
    /**
     * Number of Rooms
     */
    private int numberRooms;
    /**
     * Type of Sorting by Price (Ascending or Descending)
     */
    private String priceSorting;

    /**
     * Address (street, city, district, state, zipCode)
     */
    private String state;
    private String district;
    private String city;

    private final String BUSINESS_TYPE_BY_DEFAULT = "[NO DATA]";
    private final String PROPERTY_TYPE_BY_DEFAULT = "[NO DATA]";
    private final int NUMBER_OF_ROOMS_BY_DEFAULT = 0;
    private final String PROPERTY_PRICE_BY_DEFAULT = "[NOT SPECIFIED]";
    private final String CITY_BY_DEFAULT = "[NO CITY]";
    private final String DISTRICT_BY_DEFAULT = "[NO DISTRICT]";
    private final String STATE_BY_DEFAULT = "[NO STATE]";


    // CONSTRUCTORS

    /**
     * This method creates the SelectedParameters object with default attributes
     */
    public SelectedParameters() {
        this.businessType = BUSINESS_TYPE_BY_DEFAULT;
        this.propertyType = PROPERTY_TYPE_BY_DEFAULT;
        this.numberRooms = NUMBER_OF_ROOMS_BY_DEFAULT;
        this.priceSorting = PROPERTY_PRICE_BY_DEFAULT;
        this.state = STATE_BY_DEFAULT;
        this.district = DISTRICT_BY_DEFAULT;
        this.city = CITY_BY_DEFAULT;
    }

    /**
     * This method creates the SelectedParameters object
     *
     * @param businessType
     * @param propertyType
     * @param numberRooms
     */
    public SelectedParameters(String businessType, String propertyType, int numberRooms) {
        this.businessType = businessType;
        this.propertyType = propertyType;
        this.numberRooms = numberRooms;
        this.priceSorting = PROPERTY_PRICE_BY_DEFAULT;
        this.state = STATE_BY_DEFAULT;
        this.district = DISTRICT_BY_DEFAULT;
        this.city = CITY_BY_DEFAULT;
    }

    /**
     * This method creates the SelectedParameters object
     *
     * @param businessType
     * @param propertyType
     * @param numberRooms
     * @param priceSorting
     * @param state
     * @param district
     * @param city
     * @param zipCode
     */
    public SelectedParameters(String businessType, String propertyType, int numberRooms, String priceSorting, String state, String district, String city, String zipCode) {
        this.businessType = businessType;
        this.propertyType = propertyType;
        this.numberRooms = numberRooms;
        this.priceSorting = priceSorting;
        this.state = state;
        this.district = district;
        this.city = city;
    }

    // SETS AND GETS

    /**
     * This method returns the businessType of the SelectedParameters
     *
     * @return
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     * This method changes the businessType of the SelectedParameters
     *
     * @param businessType
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    /**
     * This method returns the propertyType of the SelectedParameters
     *
     * @return
     */
    public String getPropertyType() {
        return propertyType;
    }

    /**
     * This method changes the propertyType of the SelectedParameters
     *
     * @param propertyType
     */
    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    /**
     * This method returns the numberRooms of the SelectedParameters
     *
     * @return
     */
    public int getNumberRooms() {
        return numberRooms;
    }

    /**
     * This method changes the numberRooms of the SelectedParameters
     *
     * @param numberRooms
     */
    public void setNumberRooms(int numberRooms) {
        this.numberRooms = numberRooms;
    }

    /**
     * This method returns the priceSorting of the SelectedParameters
     *
     * @return
     */
    public String getPriceSorting() {
        return priceSorting;
    }

    /**
     * This method changes the priceSorting of the SelectedParameters
     *
     * @param priceSorting
     */
    public void setPriceSorting(String priceSorting) {
        this.priceSorting = priceSorting;
    }

    /**
     * This method gets the city of the SelectedParameters
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     * This method gets the district of the SelectedParameters
     * @return
     */
    public String getDistrict() {
        return district;
    }

    /**
     * This method gets the state of the SelectedParameters
     * @return
     */
    public String getState() {
        return state;
    }

    /**
     * This method sets the city of the SelectedParameters
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * This method sets the district of the SelectedParameters
     * @param district
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * This method sets the state of the SelectedParameters
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    // TOSTRING

    /**
     * This method returns the characteristics of the SelectedParameters
     *
     * @return
     */
    @Override
    public String toString() {
        return "\n=== Selected Parameters: ===" + "\nBusiness Type: " + businessType + "\nProperty Type: " + propertyType +
                "\nNumber Of Rooms: " + numberRooms + "\nProperty Price: " + priceSorting + "\nState: " + state + "\nDistrict: " + district + "\nCity: " + city;
    }
}
