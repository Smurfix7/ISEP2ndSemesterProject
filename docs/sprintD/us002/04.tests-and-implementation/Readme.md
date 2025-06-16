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


## Class CreateAnnouncementUI

````java
package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.CreateAnnouncementController;
import pt.ipp.isep.dei.esoft.project.application.session.domain.*;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateAnnouncementUI implements Runnable {

    Scanner read = new Scanner(System.in);
    private String propertyType;

    private ArrayList<Photo> photos;
    private Person owner;

    private static String commissionType;

    private static Double commissionValue;


    private Equipment equipment;
    private Employee agent;
    private double areaOfProperty;

    private double distanceFromCentre;

    private String requestDate;

    private String acceptanceDate;


    private String street;
    private String city;

    private String state;

    private String zipCode;

    private int bedrooms;

    private int bathrooms;

    private int parkingSpaces;

    private String basement;

    private String loft;

    private String sunExposure;

    private String transactionType;

    private double monetaryValue;


    private final CreateAnnouncementController controller = new CreateAnnouncementController();
    List<Employee> agentsCopyList = new ArrayList<>(controller.getCopyAgentList());

    @Override
    public void run() {
        System.out.println("Create an Announcement:");

        String[] list = controller.getPropertyTypeList();
        displayList(list);
        propertyType = read.nextLine();


        switch (propertyType.toUpperCase()) {
            case "LAND":
                requestDataLand();
                break;
            case "APARTMENT":
                requestDataApartment();
                break;
            case "HOUSE":
                requestDataHouse();
                break;


        }

        Announcement announcement = controller.CreateAnnouncement(propertyType, agent, owner, areaOfProperty, distanceFromCentre, acceptanceDate, requestDate, street, city, state, zipCode, photos, transactionType, monetaryValue, bedrooms, bathrooms, parkingSpaces, basement, loft, sunExposure, equipment, commissionType, commissionValue);
        System.out.println(announcement.toString());
    }


    /**
     * Requests the data for option creation
     *
     */
    public void requestDataLand() {

        agent = (Employee) Utils.showAndSelectOne(EmployeeRepository.agents, "Choose an agent:");
        areaOfProperty = Utils.requestAreaOfProperty();
        distanceFromCentre = Utils.requestDistanceFromCentre();
        requestAddress();
        requestDate = Utils.requestCurrentDate();
        acceptanceDate = Utils.requestCurrentDate();
        photos = Utils.requestPhotoList();
        transactionType = Utils.requestTransactionType();
        monetaryValue = Utils.requestMonetaryValue();
        requestCommission();
        owner = Utils.requestOwner();


    }

    /**
     * Requests the data for option creation
     *
     */

    public void requestDataApartment() {
        agent = (Employee) Utils.showAndSelectOne(EmployeeRepository.agents, "Choose an agent:");
        areaOfProperty = Utils.requestAreaOfProperty();
        distanceFromCentre = Utils.requestDistanceFromCentre();
        requestAddress();
        requestDate = Utils.requestCurrentDate();
        acceptanceDate = Utils.requestCurrentDate();
        photos = Utils.requestPhotoList();
        bedrooms = Utils.requestBedrooms();
        bathrooms = Utils.requestBathrooms();
        parkingSpaces = Utils.requestParkingSpaces();
        equipment = Utils.requestEquipment();
        transactionType = Utils.requestTransactionType();
        monetaryValue = Utils.requestMonetaryValue();
        requestCommission();
        owner = Utils.requestOwner();
    }

    /**
     * Requests the data for option creation
     *
     */

    public void requestDataHouse() {
        agent = (Employee) Utils.showAndSelectOne(EmployeeRepository.agents, "Choose an agent:");
        areaOfProperty = Utils.requestAreaOfProperty();
        distanceFromCentre = Utils.requestDistanceFromCentre();
        requestAddress();
        requestDate = Utils.requestCurrentDate();
        acceptanceDate = Utils.requestCurrentDate();
        photos = Utils.requestPhotoList();
        bedrooms = Utils.requestBedrooms();
        bathrooms = Utils.requestBathrooms();
        parkingSpaces = Utils.requestParkingSpaces();
        equipment = Utils.requestEquipment();
        basement = Utils.requestBasement();
        loft = Utils.requestLoft();
        sunExposure = Utils.requestSunExposure();
        transactionType = Utils.requestTransactionType();
        monetaryValue = Utils.requestMonetaryValue();
        requestCommission();
        owner = Utils.requestOwner();

    }

    /**
     * Requests the data for address object
     *
     */

    public Address requestAddress() {
        street = Utils.requestStreet();
        city = Utils.requestCity();
        state = Utils.requestState();
        zipCode = Utils.requestZipCode();

        return new Address(street, city, state, zipCode);
    }

    public static void requestCommission() {
        System.out.println("-| Commission |-");
        commissionType = Utils.requestCommissionType();
        commissionValue = Utils.requestCommissionValue(commissionType);
    }

    public void displayList(String[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }


}


````

## Class CreateAnnouncementController

```java
package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.application.session.domain.*;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.repository.PropertyTypeRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.ArrayList;
import java.util.List;

public class CreateAnnouncementController {
    private Agency agency = new Agency();
    Repositories repositories = Repositories.getInstance();

    PropertyTypeRepository type = repositories.getPropertyTypeRepository();
    private String message;

    public Announcement CreateAnnouncement(String propertyType, Employee agent, Person owner, double areaOfProperty, double distanceFromCentre, String acceptanceDate, String requestDate, String street, String city, String state, String zipCode, ArrayList<Photo> photos, String transactionType, double monetaryValue, int bedrooms, int bathrooms, int parkingSpaces, String basement, String loft, String sunExposure, Equipment equipment, String commissionType, double commissionValue) {
        Request request = agency.createRequest(propertyType, photos, owner, equipment, agent,
                areaOfProperty, distanceFromCentre, requestDate, acceptanceDate, street, city, state, zipCode,
                bedrooms, bathrooms, parkingSpaces, basement, loft, sunExposure, transactionType, monetaryValue);
        Announcement announcement = agency.createAnnouncement(request, commissionType, commissionValue);


        return announcement;
    }


    public List<Employee> getCopyAgentList() {
        return EmployeeRepository.getAgentList();
    }

    public String[] getPropertyTypeList() {
        Repositories repositories = Repositories.getInstance();

        PropertyTypeRepository propertyTypeRepository = repositories.getPropertyTypeRepository();

        return propertyTypeRepository.getPropertyTypeList();

    }

}

```

# Class Announcement

```java
package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.time.LocalDate;

public class Announcement implements Serializable {
    private static int cont = 0;
    private Request request;
    private int announcementID;
    private String acceptanceDate;
    private Commission commission;

    // Default constructor
    public Announcement() {
    }

    // Constructor with all attributes
    public Announcement(Request request, String commissionType, double commissionValue) {
        this.request = request;
        cont++;
        this.announcementID = cont;
        this.acceptanceDate = String.valueOf(LocalDate.now());
        this.commission = new Commission(commissionType, commissionValue);
    }

    public Announcement(Request request, String commissionType, String acceptanceDate, double commissionValue) {
        this.request = request;
        cont++;
        this.announcementID = cont;
        this.acceptanceDate = acceptanceDate;
        this.commission = new Commission(commissionType, commissionValue);
    }

    // Getter and Setter for Request
    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    // Getter and Setter for announcementID
    public int getAnnouncementID() {
        return announcementID;
    }

    public void setAnnouncementID(int announcementID) {
        this.announcementID = announcementID;
    }

    // Getter and Setter for acceptanceDate
    public String getAcceptanceDate() {
        return acceptanceDate;
    }

    public void setAcceptanceDate(String acceptanceDate) {
        this.acceptanceDate = acceptanceDate;
    }

    // Getter and Setter for CommissionDetails
    public Commission getCommission() {
        return commission;
    }

    public void setCommission(Commission commission) {
        this.commission = commission;
    }

    @Override
    public String toString() {
        return "  | Announcement: " + announcementID
                + "| Announcement of request: " + request +
                ", acceptanceDate:'" + acceptanceDate + '\'' +
                ", commission:" + commission.toString();
    }
}


```

# 6. Integration and Demo 

* A new UI was added, the AgentUI.

* A new option to the AgentUI was added, the "Create Announcement" option

* A new UI was added, the CreateAnnouncementUI

* A new bootstrapping object was created


# 7. Observations

The CreateAnnouncementUI appearance is still very crude.





