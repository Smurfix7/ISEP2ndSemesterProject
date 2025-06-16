# US 009 - Messaging for a visit 

# 4. Tests 

**Test 1:** Checks if its possible to get a visitRequest that has been accepted from the repository. 
 
	static List<VisitRequest> visitsAccepted = new ArrayList<>();
    @Test
    void getVisitAccepted() {
        VisitRequest visitRequest = new VisitRequest();
        visitsAccepted.add(visitRequest);
        assertEquals(visitRequest, visitsAccepted.get(0));
    }
**Test 2:** Checks if its possible to add a visitRequest that has been accepted to the repository.

    @Test
    void addVisitAccepted() {

            VisitRequest visitRequest = new VisitRequest();
            visitsAccepted.add(visitRequest);
            assertEquals(visitRequest, visitsAccepted.get(0));

    }

**Test 3:** Checks if its possible to remove a visitRequest that has been accepted from the repository.

    @Test
    void removeVisitAccepted() {
        VisitRequest visitRequest = new VisitRequest();
        visitsAccepted.add(visitRequest);
        visitsAccepted.remove(visitRequest);

            assertTrue(visitsAccepted.contains(visitRequest));

    }

**Test 4:** Checks if its possible to get a visitRequest that has been accepted from the repository using its list index number.

    @Test
    void testGetVisitAccepted() {

        VisitRequest visitRequest = new VisitRequest();
        visitsAccepted.add(visitRequest);
        assertEquals(visitRequest, visitsAccepted.get(0));

    }

**Test 5:** Checks if its possible to get a visitRequest from the repository.

    static List<VisitRequest> visitsRequested = new ArrayList<>();
    
    @Test
    void getVisitAccepted() {
    VisitRequest visitRequest = new VisitRequest();
    visitsRequested.add(visitRequest);
    assertEquals(visitRequest, visitsRequested.get(0));
}

**Test 6:** Checks if its possible to add a visitRequest to the repository.

    @Test
    void addVisitAccepted() {

        VisitRequest visitRequest = new VisitRequest();
        visitsRequested.add(visitRequest);
        assertEquals(visitRequest, visitsRequested.get(0));

    }

**Test 7:** Checks if its possible to remove a visitRequest from the repository.

    @Test
    void removeVisitAccepted() {
        VisitRequest visitRequest = new VisitRequest();
        visitsRequested.add(visitRequest);
        visitsRequested.remove(visitRequest);

        assertTrue(visitsRequested.contains(visitRequest));

    }

**Test 8:** Checks if its possible to get a visitRequest from the repository using its list index number.

    @Test
    void testGetVisitAccepted() {

        VisitRequest visitRequest = new VisitRequest();
        visitsRequested.add(visitRequest);
        assertEquals(visitRequest, visitsRequested.get(0));

    }

*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)

## Class VisitRequest

```java
 package pt.ipp.isep.dei.esoft.project.domain;

public class VisitRequest {

    // ATTRIBUTES
    private User user;
    private Property property;
    private String date;
    private String timeFrame;

    private final User USER_BY_DEFAULT = null;
    private final Property PROPERTY_BY_DEFAULT = null;
    private final String DATE_BY_DEFAULT = "[NO DATA]";
    private final String TIME_FRAME_BY_DEFAULT = "[NO DATA]";

    // CONSTRUCTORS

    public VisitRequest() {
        this.user = USER_BY_DEFAULT;
        this.property = PROPERTY_BY_DEFAULT;
        this.date = DATE_BY_DEFAULT;
        this.timeFrame = TIME_FRAME_BY_DEFAULT;
    }

    public VisitRequest(String name, String emailAddress, String password, String telephoneNumber, Property property, String date, String timeFrame) {
        this.user = new User(name, emailAddress, password, telephoneNumber);
        this.property = property;
        this.date = date;
        this.timeFrame = timeFrame;

    }

    // SETS AND GETS


    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Property getProperty() {
        return property;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setTimeFrame(String timeFrame) {
        this.timeFrame = timeFrame;
    }

    public String getTimeFrame() {
        return timeFrame;
    }

    @Override
    public String toString() {
        return "|Visit Request| Name: " + user.getName() + " | Telephone Number : " + user.getTelephoneNumber() + " | Date: " + date + " | Time Frame: " + timeFrame;
    }
}
```

## Class VisitRepository

```java
package pt.ipp.isep.dei.esoft.project.repository;

public class VisitsRepository {

    private static final VisitsRepository instance = new VisitsRepository();
    VisitsAcceptedRepository visitsAcceptedRepository = new VisitsAcceptedRepository();
    VisitRequestsRepository visitRequestsRepository = new VisitRequestsRepository();

    public static VisitsRepository getInstance() {
        return instance;
    }

    public VisitsAcceptedRepository getVisitsAcceptedRepository() {
        return visitsAcceptedRepository;
    }

    public VisitRequestsRepository getVisitsRequestRepository() {
        return visitsRequestRepository;
    }

}

```

## Class VisitRequestRepository

```java
package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a repository for visit requests.
 */
public class VisitsRequestRepository {

    /**
     * List of visit requests.
     */
    static List<VisitRequest> visitsRequested = new ArrayList<>();

    /**
     * Gets a visit request from the repository.
     *
     * @param visitRequest the visit request to get
     * @return the visitRequest if it exists in the repository, null otherwise
     */
    public VisitRequest getVisitRequested(VisitRequest visitRequest) {
        if (visitsRequested.contains(visitRequest)) {
            return visitRequest;
        } else {
            return null;
        }
    }

    /**
     * Adds a visit request to the repository.
     *
     * @param visitRequest the visit request to add
     */
    public static void addVisitRequested(VisitRequest visitRequest) {
        visitsRequested.add(visitRequest);
    }

    /**
     * Removes a visit request to the repository.
     *
     * @param visitRequest the visit request to remove
     */
    public static void removeVisitRequested(VisitRequest visitRequest) {
        visitsRequested.remove(visitRequest);
    }

    public static VisitRequest getVisitRequested(int n) {
        return visitsRequested.get(n);
    }
}

```

## Class VisitAcceptedRepository

```java
package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a repository for visit requests that were accepted.
 */
public class VisitsAcceptedRepository {

    /**
     * List of visit requests that were accepted.
     */
    static List<VisitRequest> visitsAccepted = new ArrayList<>();

    /**
     * Gets a visit request that was accepted from the repository.
     *
     * @param visitRequest the visit accepted to get
     * @return the visitRequest if it exists in the repository, null otherwise
     */
    public VisitRequest getVisitAccepted(VisitRequest visitRequest) {
        if (visitsAccepted.contains(visitRequest)) {
            return visitRequest;
        } else {
            return null;
        }
    }

    /**
     * Adds a visit request that was accepted to the repository.
     *
     * @param visitRequest the visit request that was accepted to add
     */
    public static void addVisitAccepted(VisitRequest visitRequest) {
        visitsAccepted.add(visitRequest);
    }

    /**
     * Removes a visit request that was accepted to the repository.
     *
     * @param visitRequest the visit request that was accepted to remove
     */
    public static void removeVisitAccepted(VisitRequest visitRequest) {
        visitsAccepted.remove(visitRequest);
    }

    public static VisitRequest getVisitAcceptedInt(int n) {
        return visitsAccepted.get(n);
    }
}

```

## Class VisitRequestUI

```java
package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.CreatePurchaseOrderController;
import pt.ipp.isep.dei.esoft.project.application.controller.VisitRequestController;
import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.domain.SelectedParameters;
import pt.isep.lei.esoft.auth.AuthFacade;

import java.util.Scanner;

public class VisitRequestUI implements Runnable {
    private int propertyNumber;
    private Property property;
    private final VisitRequestController controller1 = new VisitRequestController();
    private final CreatePurchaseOrderController controller2 = new CreatePurchaseOrderController();
    private final Scanner read = new Scanner(System.in);

    private int answer;
    private SelectedParameters parameters = new SelectedParameters();
    private AuthFacade authFacade = new AuthFacade();

    @Override
    public void run() {
        System.out.println("Properties available:");
        displayAnnouncements();
        System.out.println();
        System.out.println("Create a Visit Request:");
        controller1.CreateVisitRequest(requestName(), requestEmailAddress(), requestPassword(), requestTelephoneNumber(), requestProperty(), requestDate(), requestTimeFrame());

    }

    private Property requestProperty() {
        System.out.println("Select The Property (number):");
        propertyNumber = read.nextInt();
        return property = controller2.getCopyAnnouncementsList().get(propertyNumber - 1);
    }

    private String requestName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Name of the User:");
        return input.nextLine();
    }

    private String requestEmailAddress() {
        Scanner input = new Scanner(System.in);
        System.out.println("Email Address:");
        return input.nextLine();
    }

    private String requestPassword() {
        Scanner input = new Scanner(System.in);
        System.out.println("Password:");
        return input.nextLine();
    }

    private String requestTelephoneNumber() {
        Scanner input = new Scanner(System.in);
        System.out.println("Phone Number:");
        return input.nextLine();
    }


    private String requestDate() {
        Scanner input = new Scanner(System.in);
        System.out.println("Input the preffered date (dd/mm/yy):");
        return input.nextLine();
    }

    private String requestTimeFrame() {
        Scanner input = new Scanner(System.in);
        System.out.println("Input the preffered time frame (00AM-00PM):");
        return input.nextLine();
    }

    public void displayAnnouncements() {
        for (int i = 0; i < controller2.getCopyAnnouncementsList().size(); i++) {
            System.out.println(controller2.getCopyAnnouncementsList().get(i));
        }
    }

}

```

## Class VisitRequestController

```java
package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;

public class VisitRequestController {

    public Object CreateVisitRequest(String name, String emailAddress, String password, String telephoneNumber, Property property, String date, String timeFrame) {
        VisitRequest visitRequest1 = new VisitRequest(name, emailAddress, password, telephoneNumber, property, date, timeFrame);
        VisitsRequestRepository.addVisitRequested(visitRequest1);
        return visitRequest1;
    }

}

```

# 6. Integration and Demo 

* None at the moment

# 7. Observations

No observations



