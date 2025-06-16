# US 002 - To create an Announcement 

# 4. Tests 

**Test 1:** Test the getDistanceFromCentre() method in the Property class.


    @Test void getDistanceFromCentre() {
    Property property = new Property();
    property.setDistanceFromCentre(1000);

        assertEquals(1000, property.getDistanceFromCentre());
    }

**Test 2:** Test the setDistanceFromCentre() method in the Property class.


    @Test void setDistanceFromCentre() {
    Property property = new Property();
    property.setDistanceFromCentre(1000);

        assertEquals(1000, property.getDistanceFromCentre());
    }


**Test 3:** Test the getAreaOfProperty() method in the Property class.

    @Test void getAreaOfProperty() {
    Property property = new Property();
    property.setAreaOfProperty(1000);

        assertEquals(1000, property.getAreaOfProperty());
    }

**Test 4:** Test the setAreaOfProperty() method in the Property class.


    @Test void setAreaOfProperty() {
    Property property = new Property();
    property.setAreaOfProperty(1000);

        assertEquals(1000, property.getAreaOfProperty());
    }

**Test 5:** Test the getAcceptanceDate() method in the Property class.

    @Test void getAcceptanceDate() {
    Property property = new Property();
    property.setAcceptanceDate("11/21/2023");

        assertEquals("11/21/2023", property.getAcceptanceDate());
    }

**Test 6:** Test the setAcceptanceDate() method in the Property class.


    @Test void setAcceptanceDate() {
    Property property = new Property();
    property.setAcceptanceDate("11/21/2023");

        assertEquals("11/21/2023", property.getAcceptanceDate());
    }

**Test 7:** Test the getRequestDate() method in the Property class.


    @Test void getRequestDate() {
    Property property = new Property();
    property.setRequestDate("11/21/2023");

        assertEquals("11/21/2023", property.getRequestDate());
    }

**Test 8:** Test the setRequestDate() method in the Property class.


    @Test void setRequestDate() {
    Property property = new Property();
    property.setRequestDate("11/21/2023");

        assertEquals("11/21/2023", property.getRequestDate());
    }

**Test 9:** Test the getAddress() method in the Property class.


    @Test void getAddress() {
    Property property = new Property();
    property.setAddress("Lt Jenkins", "Huston", "Texas", "TX", "423-423");
    assertEquals(" | Address: Lt Jenkins, Huston, Texas, TX, 423-423", property.getAddress());
}

**Test 10:** Test the setAddress() method in the Property class.

    @Test void setAddress() {
    Property property = new Property();
    property.setAddress("Lt Jenkins", "Huston", "Texas", "TX", "423-423");
    assertEquals(" | Address: Lt Jenkins, Huston, Texas, TX, 423-423", property.getAddress());
    }

**Test 11:** Test the getPhoto() method in the Property class.

    @Test void getPhoto() {
    Property property = new Property();
    property.setPhoto("./images");
    assertEquals(" | PhotoID: 12345678 | Path To PNG: ./images", property.getPhoto());
    }

**Test 12:** Test the setPhoto() method in the Property class

    @Test void setPhoto() {
    Property property = new Property();
    property.setPhoto("./images");
    assertEquals(" | PhotoID: 1 | Path To PNG: ./images", property.getPhoto());
    }

**Test 13:** Test the getTypeOfTransaction() method in the Property class

    @Test void getTypeOfTransaction() {
    Property property = new Property();
    property.setTypeOfTransaction("Lease", 1000);
    assertEquals(" | Transaction Type: Lease | Value: 1000", property.getTypeOfTransaction());
    }

**Test 14** Test the setTypeOfTransaction() method in the Property class

    @Test void setTypeOfTransaction() {
    Property property = new Property();
    property.setTypeOfTransaction("Lease", 1000);
    assertEquals(" | Transaction Type: Lease | Value: 1000", property.getTypeOfTransaction());
    }

**Test 15** Test the toString() method in the Property class

    @Test void testToString() {
    Property property = new Property(1000, 1000, "11/23/2023", "11/23/2023","Lt Jenkins", "Huston", "Texas", "TX", "423-423", "URIEXAMPLE","Lease", 1000);


        assertEquals("Property type:  | Transaction Type: Lease | Value: 1000 | PhotoID: 1 | Path To PNG: ./images | Address: Lt Jenkins, Huston, Texas, TX, 423-423 | Area Of The Property: 1000 | Distance From The Centre: 1000 | Request Date: 11/23/2023 | Acceptance Date: 11/23/2023", property.toString());
    }

**Test 16** Test the creation of the Land object in the controller


    @Test void createLand() {
    CreateAnnouncementController controller = new CreateAnnouncementController();
    double areaOfProperty = 1000.0;
    double distanceFromCentre = 5.0;
    String acceptanceDate = "2022-05-01";
    String requestDate = "2022-04-15";
    String street = "Main St.";
    String city = "Example City";
    String district = "Example District";
    String state = "Example State";
    String zipCode = "12345-678";
    String photoURI = "example.com/photo.jpg";
    String transactionType = "Sell";
    double monetaryValue = 50000.0;

        controller.CreateLand(areaOfProperty, distanceFromCentre, acceptanceDate, requestDate, street, city, district, state, zipCode, photoURI, transactionType, monetaryValue);

        Land land = new Land(areaOfProperty, distanceFromCentre, acceptanceDate, requestDate, street, city, district, state, zipCode, photoURI, transactionType, monetaryValue);

        assertEquals(PropertyRepository.getProperty(0), land);
    }

**Test 17** Test the creation of the Apartment object in the controller

    @Test void createApartment() {
    CreateAnnouncementController controller = new CreateAnnouncementController();
    double areaOfProperty = 1000.0;
    double distanceFromCentre = 5.0;
    String acceptanceDate = "2022-05-01";
    String requestDate = "2022-04-15";
    String street = "Main St.";
    String city = "Example City";
    String district = "Example District";
    String state = "Example State";
    String zipCode = "12345-678";
    String photoURI = "example.com/photo.jpg";
    String transactionType = "Sell";
    double monetaryValue = 50000.0;
    int bedrooms = 2;
    int bathrooms = 1;
    int parkingSpaces = 1;

        controller.CreateApartment(areaOfProperty, distanceFromCentre, acceptanceDate, requestDate, street, city, district, state, zipCode, photoURI, transactionType, monetaryValue, bedrooms, bathrooms, parkingSpaces);

        Apartment apartment = new Apartment(areaOfProperty, distanceFromCentre, acceptanceDate, requestDate, street, city, district, state, zipCode, photoURI, transactionType, monetaryValue, bedrooms, bathrooms, parkingSpaces);

        assertEquals(PropertyRepository.getProperty(0), apartment);
    }

**Test 18** Test the creation of the House object in the controller


    @Test void createHouse() {
    CreateAnnouncementController controller = new CreateAnnouncementController();
    double areaOfProperty = 1000.0;
    double distanceFromCentre = 5.0;
    String acceptanceDate = "2022-05-01";
    String requestDate = "2022-04-15";
    String street = "Main St.";
    String city = "Example City";
    String district = "Example District";
    String state = "Example State";
    String zipCode = "12345-678";
    String photoURI = "example.com/photo.jpg";
    String transactionType = "Sell";
    double monetaryValue = 50000.0;
    int bedrooms = 3;
    int bathrooms = 2;
    int parkingSpaces = 2;
    boolean basement = true;
    boolean loft = false;
    String sunExposure = "North";

        controller.CreateHouse(areaOfProperty, distanceFromCentre, acceptanceDate, requestDate, street, city, district, state, zipCode, photoURI, transactionType, monetaryValue, bedrooms, bathrooms, parkingSpaces, basement, loft, sunExposure);

        House house = new House(areaOfProperty, distanceFromCentre, acceptanceDate, requestDate, street, city, district, state, zipCode, photoURI, transactionType, monetaryValue, bedrooms, bathrooms, parkingSpaces, basement, loft, sunExposure);

        assertEquals(PropertyRepository.getProperty(0), house);
    }

# 5. Construction (Implementation)


## Class CreateAnnouncementController

```java
public class CreateAnnouncementController{

    public void CreateLand(double areaOfProperty, double distanceFromCentre, String acceptanceDate, String requestDate,String street,String city, String district, String state, String ZipCode, String photoURI, String transactionType, double monetaryValue){
        {
            Land land1 = new Land(areaOfProperty,distanceFromCentre,acceptanceDate, requestDate, street, city, district, state, ZipCode, photoURI, transactionType, monetaryValue);
            PropertyRepository.addProperty(land1);
        }

    }
    public void CreateApartment(double areaOfProperty, double distanceFromCentre, String acceptanceDate, String requestDate,String street,String city, String district, String state, String ZipCode,String photoURI, String transactionType, double monetaryValue,int bedrooms, int bathrooms, int parkingSpaces){
        Apartment apartment1 = new Apartment(areaOfProperty,distanceFromCentre,acceptanceDate, requestDate, street, city, district, state, ZipCode, photoURI, transactionType, monetaryValue, bedrooms, bathrooms, parkingSpaces);
        PropertyRepository.addProperty(apartment1);
    }

    public void CreateHouse(double areaOfProperty, double distanceFromCentre, String acceptanceDate, String requestDate,String street,String city, String district, String state, String ZipCode, String photoURI, String transactionType, double monetaryValue,int bedrooms, int bathrooms, int parkingSpaces, boolean basement, boolean loft, String sunExposure){
        House property1 = new House(areaOfProperty,distanceFromCentre,acceptanceDate, requestDate, street, city, district, state, ZipCode, photoURI, transactionType, monetaryValue, bedrooms, bathrooms, parkingSpaces, basement, loft, sunExposure);
        PropertyRepository.addProperty(property1);
    }
}
```


## Class Property

```java
public class Property {

    // ATTRIBUTES

    private double areaOfProperty;
    private double distanceFromCentre;
    private String acceptanceDate;
    private String requestDate;
    private Address address;
    private Photo photo;
    private TypeOfTransaction transaction;

    private final double AREA_OF_PROPERTY_BY_DEFAULT = 0;
    private final double DISTANCE_FROM_CENTRE_BY_DEFAULT = 0;
    private final String ACCEPTANCE_DATE_BY_DEFAULT = "[NO DATA]";
    private final String REQUEST_DATE_BY_DEFAULT = "[NO DATA]";
    private final Address ADDRESS_BY_DEFAULT = null;
    private final Photo PHOTO_BY_DEFAULT = null;
    private final TypeOfTransaction TYPE_OF_TRANSACTION_BY_DEFAULT = null;


    // CONSTRUCTORS

    /**
     * This method creates the Property object with default attributes
     */
    public Property(){
        this.areaOfProperty = AREA_OF_PROPERTY_BY_DEFAULT;
        this.distanceFromCentre = DISTANCE_FROM_CENTRE_BY_DEFAULT;
        this.acceptanceDate = ACCEPTANCE_DATE_BY_DEFAULT;
        this.requestDate = REQUEST_DATE_BY_DEFAULT;
        this.address = ADDRESS_BY_DEFAULT;
        this.photo = PHOTO_BY_DEFAULT;
        this.transaction = TYPE_OF_TRANSACTION_BY_DEFAULT;
    }

    /**
     *
     * This method creates the Property object
     *
     * @param areaOfProperty
     * @param distanceFromCentre
     * @param acceptanceDate
     * @param requestDate
     * @param street
     * @param city
     * @param district
     * @param state
     * @param zipCode
     * @param photoURI
     * @param transactionType
     * @param monetaryValue
     */
    public Property(double areaOfProperty, double distanceFromCentre, String acceptanceDate, String requestDate,String street,String city, String district, String state, String zipCode,String photoURI, String transactionType, double monetaryValue){

        this.areaOfProperty = areaOfProperty;
        this.distanceFromCentre = distanceFromCentre;
        this.acceptanceDate = acceptanceDate;
        this.requestDate = requestDate;
        this.address = new Address(street, city, district,state, zipCode);
        this.photo = new Photo(photoURI);
        this.transaction = new TypeOfTransaction(transactionType, monetaryValue);
    }

    // SETS AND GETS

    /**
     *  This method returns the distanceFromCentre of the Property
     *
     * @return
     */
    public double getDistanceFromCentre() {
        return distanceFromCentre;
    }

    /**
     *  This method changes the distanceFromCentre of the Property
     * @param distanceFromCentre
     */
    public void setDistanceFromCentre(double distanceFromCentre) {
        this.distanceFromCentre = distanceFromCentre;
    }

    /**
     *  This method returns the areaOfProperty of the Property
     *
     * @return
     */
    public double getAreaOfProperty() {
        return areaOfProperty;
    }

    /**
     *  This method changes the areaOfProperty of the Property
     * @param areaOfProperty
     */
    public void setAreaOfProperty(double areaOfProperty) {
        this.areaOfProperty = areaOfProperty;
    }

    /**
     *  This method returns the acceptanceDate of the Property
     *
     * @return
     */
    public String getAcceptanceDate() {
        return acceptanceDate;
    }

    /**
     *  This method changes the acceptanceDate of the Property
     * @param acceptanceDate
     */
    public void setAcceptanceDate(String acceptanceDate) {
        this.acceptanceDate = acceptanceDate;
    }

    /**
     *  This method returns the requestData of the Property
     *
     * @return
     */
    public String getRequestDate() {
        return requestDate;
    }

    /**
     *  This method changes the requestDate of the Property
     * @param requestDate
     */
    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    /**
     *  This method returns the address of the Property
     *
     * @return
     */
    public Address getAddress() {
        return address;
    }

    /**
     *  This method changes the address of the Property
     *
     * @param street
     * @param city
     * @param district
     * @param state
     * @param zipCode
     */
    public void setAddress(String street, String city, String district, String state, String zipCode) {
        this.address = new Address(street, city, district,state, zipCode);}

    /**
     *  This method returns the photo of the Property
     *
     * @return
     */
    public Photo getPhoto() {
        return photo;
    }

    /**
     *  This method changes the photo of the Property
     *
     * @param photoURI
     */
    public void setPhoto(String photoURI) {
        this.photo = new Photo(photoURI);
    }

    /**
     *  This method returns the transaction of the Property
     *
     * @return
     */
    public TypeOfTransaction getTypeOfTransaction() {
        return this.transaction;
    }

    /**
     *  This method changes the transaction of the Property
     *
     * @param transactionType
     * @param monetaryValue
     */
    public void setTypeOfTransaction( String transactionType, double monetaryValue) {
        this.transaction =  new TypeOfTransaction(transactionType, monetaryValue);
    }
    // TOSTRING

    /**
     *  This method returns true or false if the Property was listed
     *
     * @param property
     * @return
     */
    public static boolean IsListed(Property property){return (property instanceof Property);}

    /**
     * This method returns the characteristics of the Property
     *
     * @return
     */
    @Override
    public String toString() {
        return "Property type: "+transaction+photo+address+" | Area Of The Property: "+areaOfProperty+" | Distance From The Centre: "+distanceFromCentre+" | Request Date: "+requestDate+" | Acceptance Date: "+acceptanceDate;
    }

}
```

# 6. Integration and Demo 

* A new UI was added, the AgentUI.

* A new option to the AgentUI was added, the "Create Announcement" option

* A new UI was added, the CreateAnnouncementUI

* A new bootstrapping object was created


# 7. Observations

The Property class has a lot of attributes making it difficult to maintain

The CreateAnnouncementUI design is still very crude.





