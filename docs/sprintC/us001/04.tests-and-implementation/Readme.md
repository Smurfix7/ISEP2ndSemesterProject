# US 001 - To Display Listed Properties 

# 4. Tests 

## PropertyListController
**Test 1:** Check that its possible to create SelectedParameters object successfully. (to be done) 

    @Test
    void createSelectedParameters() {
    }

## SelectedParameters

**Test 1:** Check if its possible to get the selected Business Type parameter.

    @Test
    void getBusinessType() {
        SelectedParameters selectedParameters = new SelectedParameters();

        selectedParameters.setBusinessType("test");
        assertEquals("test",selectedParameters.getBusinessType());
    }

**Test 2:** Check if its possible to change the selected Business Type parameter.

    @Test
    void setBusinessType() {
        SelectedParameters selectedParameters = new SelectedParameters();

        selectedParameters.setBusinessType("test");
        assertEquals("test",selectedParameters.getBusinessType());
    }

**Test 3:** Check if its possible to get the selected Property Type parameter.

    @Test
    void getPropertyType() {
        SelectedParameters selectedParameters = new SelectedParameters();

        selectedParameters.setPropertyType("test");
        assertEquals("test",selectedParameters.getPropertyType());
    }

**Test 4:** Check if its possible to change the selected Property Type parameter.

    @Test
    void setPropertyType() {
        SelectedParameters selectedParameters = new SelectedParameters();

        selectedParameters.setPropertyType("test");
        assertEquals("test",selectedParameters.getPropertyType());
    }

**Test 5:** Check if its possible to get the selected Number Rooms parameter.

    @Test
    void getNumberRooms() {
        SelectedParameters selectedParameters = new SelectedParameters();

        selectedParameters.setNumberRooms(20);
        assertEquals(20,selectedParameters.getNumberRooms());
    }

**Test 6:** Check if its possible to change the selected Number Rooms parameter.

    @Test
    void setNumberRooms() {
        SelectedParameters selectedParameters = new SelectedParameters();

        selectedParameters.setNumberRooms(20);
        assertEquals(20,selectedParameters.getNumberRooms());
    }

**Test 7:** Check if its possible to get the selected Price Sorting parameter.

    @Test
    void getPriceSorting() {
        SelectedParameters selectedParameters = new SelectedParameters();

        selectedParameters.setPriceSorting("Ascending");
        assertEquals("Ascending",selectedParameters.getPriceSorting());
    }

**Test 8:** Check if its possible to change the selected Price Sorting parameter.

    @Test
    void setPriceSorting() {
        SelectedParameters selectedParameters = new SelectedParameters();

        selectedParameters.setPriceSorting("Ascending");
        assertEquals("Ascending",selectedParameters.getPriceSorting());
    }

**Test 9:** Check if its possible to get the selected Address parameter.

    @Test
    void getAddress() {
        SelectedParameters selectedParameters = new SelectedParameters();

        Address ad1 = new Address("a","d","r","e","s");
        selectedParameters.setAddress("a","d","r","e","s");
        assertEquals(ad1,selectedParameters.getAddress());
    }

**Test 10:** Check if its possible to change the selected Address parameter.

    @Test
    void setAddress() {
        SelectedParameters selectedParameters = new SelectedParameters();

        Address ad1 = new Address("a","d","r","e","s");
        selectedParameters.setAddress("a","d","r","e","s");
        assertEquals(ad1,selectedParameters.getAddress());
    }

*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)


## Class PropertyListController

```java
public class PropertyListController {
    private List<House> houseList = new ArrayList<>(AnnouncementRepository.getListedHouses());
    private List<Land> landList = new ArrayList<>(AnnouncementRepository.getListedLands());
    private List<Apartment> apartmentList = new ArrayList<>(AnnouncementRepository.getListedApartments());
    private PriceSortingLand psL = new PriceSortingLand();
    private PriceSortingHouse psH = new PriceSortingHouse();
    private PriceSortingApartment psA = new PriceSortingApartment();

    /**
     * This method creates a SelectedParameters object to be displayed
     *
     * @param businessType
     * @param propertyType
     * @param numberRooms
     */
    public SelectedParameters createSelectedParameters(String businessType, String propertyType, int numberRooms) {
        return new SelectedParameters(businessType, propertyType, numberRooms);
    }

    /**
     * Gets the LandList Copy created in the controller
     * @return List<Land>
     */
    public List<Land> getCopyLandList() {
        return landList;
    }

    /**
     * Gets the HouseList Copy created in the controller
     * @return List<House>
     */
    public List<House> getCopyHouseList() {
        return houseList;
    }

    /**
     * Gets the ApartmentList Copy created in the controller
     * @return List<Apartment>
     */
    public List<Apartment> getCopyApartmentList() {
        return apartmentList;
    }


    /**
     * Sorts all the lists by Price Ascending
     */
    public void sortPriceAscending() {
        Collections.sort(landList, psL);
        Collections.sort(houseList, psH);
        Collections.sort(apartmentList, psA);
    }

    /**
     * Sorts all the lists by Price Descending
     */
    public void sortPriceDescending() {
        Collections.sort(landList, Collections.reverseOrder(psL));
        Collections.sort(houseList, Collections.reverseOrder(psH));
        Collections.sort(apartmentList, Collections.reverseOrder(psA));
    }

    /**
     * Gets the cloned LandList
     *
     * @return
     */
    public List<Land> getLandList() {
        return landList;
    }

    /**
     * Gets the cloned HouseList
     *
     * @return
     */
    public List<House> getHouseList() {
        return houseList;
    }

    /**
     * Gets the cloned ApartmentList
     *
     * @return
     */
    public List<Apartment> getApartmentList() {
        return apartmentList;
    }

    /**
     * PriceSorting for the Houses
     */
    class PriceSortingHouse implements Comparator<House> {
        public int compare(House o1, House o2) {
            double value1 = o1.getTypeOfTransaction().getMonetaryValue();
            double value2 = o2.getTypeOfTransaction().getMonetaryValue();

            return Double.compare(value1, value2);
        }
    }

    /**
     * PriceSorting for the Land
     */
    class PriceSortingLand implements Comparator<Land> {
        public int compare(Land o1, Land o2) {
            double value1 = o1.getTypeOfTransaction().getMonetaryValue();
            double value2 = o2.getTypeOfTransaction().getMonetaryValue();
            return Double.compare(value1, value2);
        }
    }

    /**
     * PriceSorting for the Apartment
     */
    class PriceSortingApartment implements Comparator<Apartment> {
        public int compare(Apartment o1, Apartment o2) {
            double value1 = o1.getTypeOfTransaction().getMonetaryValue();
            double value2 = o2.getTypeOfTransaction().getMonetaryValue();
            return Double.compare(value1, value2);
        }
    }
}
```


## Class SelectedParameters

```java
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
    private Address address;

    private final String BUSINESS_TYPE_BY_DEFAULT = "[NO DATA]";
    private final String PROPERTY_TYPE_BY_DEFAULT = "[NO DATA]";
    private final int NUMBER_OF_ROOMS_BY_DEFAULT = 0;
    private final String PROPERTY_PRICE_BY_DEFAULT = "[NOT SPECIFIED]";

    // CONSTRUCTORS

    /**
     * This method creates the SelectedParameters object with default attributes
     */
    public SelectedParameters(){
        this.businessType = BUSINESS_TYPE_BY_DEFAULT;
        this.propertyType = PROPERTY_TYPE_BY_DEFAULT;
        this.numberRooms = NUMBER_OF_ROOMS_BY_DEFAULT;
        this.priceSorting = PROPERTY_PRICE_BY_DEFAULT;
        this.address = new Address();
    }

    /**
     * This method creates the SelectedParameters object
     * @param businessType
     * @param propertyType
     * @param numberRooms
     */
    public SelectedParameters(String businessType,String propertyType, int numberRooms){
        this.businessType=businessType;
        this.propertyType=propertyType;
        this.numberRooms=numberRooms;
        this.priceSorting=PROPERTY_PRICE_BY_DEFAULT;
        this.address= new Address();
    }
    /**
     *
     *  This method creates the SelectedParameters object
     *
     * @param businessType
     * @param priceSorting
     * @param numberRooms
     * @param propertyType
     * @param street
     * @param city
     * @param district
     * @param state
     * @param zipCode
     */
    public SelectedParameters(String businessType, String propertyType, int numberRooms, String priceSorting, String street, String city, String district, String state, String zipCode){
        this.businessType = businessType;
        this.propertyType = propertyType;
        this.numberRooms = numberRooms;
        this.priceSorting = priceSorting;
        this.address = new Address(street, city, district, state, zipCode);
    }

    // SETS AND GETS

    /**
     *  This method returns the businessType of the SelectedParameters
     *
     * @return
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     *  This method changes the businessType of the SelectedParameters
     * @param businessType
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    /**
     *  This method returns the propertyType of the SelectedParameters
     *
     * @return
     */
    public String getPropertyType() {
        return propertyType;
    }

    /**
     *  This method changes the propertyType of the SelectedParameters
     * @param propertyType
     */
    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    /**
     *  This method returns the numberRooms of the SelectedParameters
     *
     * @return
     */
    public int getNumberRooms() {
        return numberRooms;
    }

    /**
     *  This method changes the numberRooms of the SelectedParameters
     * @param numberRooms
     */
    public void setNumberRooms(int numberRooms) {
        this.numberRooms = numberRooms;
    }

    /**
     *  This method returns the priceSorting of the SelectedParameters
     *
     * @return
     */
    public String getPriceSorting() {
        return priceSorting;
    }

    /**
     *  This method changes the priceSorting of the SelectedParameters
     * @param priceSorting
     */
    public void setPriceSorting(String priceSorting) {
        this.priceSorting = priceSorting;
    }

    /**
     *  This method returns the address of the SelectedParameters
     *
     * @return
     */
    public Address getAddress() {
        return address;
    }

    /**
     * This method changes the address of the SelectedParameters
     *
     * @param street
     * @param city
     * @param district
     * @param state
     * @param zipCode
     */
    public void setAddress(String street, String city, String district, String state, String zipCode) {
        this.address = new Address(street,city,district,state,zipCode);
    }

    public void setAddress(Address address) {
        this.address = new Address(address);
    }

    // TOSTRING

    /**
     * This method returns the characteristics of the SelectedParameters
     *
     * @return
     */
    @Override
    public String toString() {
        return "Selected Parameters:"+"\nBusiness Type: "+businessType+"\nProperty Type: "+propertyType+"\nNumber Of Rooms: "+numberRooms+"\nProperty Price: "+ priceSorting +"\n"+ address;
    }
}
```

# 6. Integration and Demo 

* None at the moment

# 7. Observations

The display of the Property List varies depending on the format in which is presented (console / visual (JavaFX)). 






