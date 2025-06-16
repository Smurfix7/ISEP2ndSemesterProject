# US 011 - Accepting/Denying a Purchase Order 

# 4. Tests 

**Test 1: AcceptPurchaseOrderControllerTest**

```java
package pt.ipp.isep.dei.esoft.project.application.controller;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.domain.PurchaseOrder;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AcceptPurchaseOrderControllerTest {

    PurchaseOrderTBARepository purchaseOrderTBARepository = new PurchaseOrderTBARepository();
    PurchaseOrderARepository purchaseOrderARepository = new PurchaseOrderARepository();
    AcceptPurchaseOrderController controller = new AcceptPurchaseOrderController();

    /**
     * Checks if it's possible to get a copy of the Announcement Repository
     */
    @Test
    void getCopyAnnouncementsList() {
        Property property = new Property();
        AnnouncementRepository.addProperty(property);
        List<Property> test = controller.getCopyAnnouncementsList();
        assertEquals(test.size(), AnnouncementRepository.getAnnouncements().size());
        assertEquals(test.get(0), AnnouncementRepository.getAnnouncements().get(0));
    }

    /**
     * Checks if it's possible to get a copy of the PurchaseOrder Repository
     */
    @Test
    void getCopyPurchaseOrderList() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrderTBARepository.addPurchaseOrder(purchaseOrder);
        List<PurchaseOrder> test = controller.getCopyPurchaseOrderList();
        assertEquals(test.size(), purchaseOrderTBARepository.getPurchaseOrders().size());
        assertEquals(test.get(0), purchaseOrderTBARepository.getPurchaseOrders().get(0));
    }

    /**
     * Checks if it's possible to get a purchase order using its index
     */
    @Test
    void getCopyPurchaseOrder() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrderTBARepository.addPurchaseOrder(purchaseOrder);
        assertEquals(purchaseOrder, controller.getCopyPurchaseOrder(0));
    }

    /**
     * Checks if it's possible to get a purchase order using its purchaseOrderID
     */
    @Test
    void getPurchaseOrderByPurchaseID() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrderTBARepository.addPurchaseOrder(purchaseOrder);
        assertEquals(purchaseOrder, controller.getPurchaseOrderByPurchaseID(1));
    }

    /**
     * Checks if it's possible to accept a purchase order
     */
    @Test
    void acceptPurchaseOrder() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrderARepository.addPurchaseOrder(purchaseOrder);
        controller.getCopyPurchaseOrderList().contains(purchaseOrder);
    }
}
```
**Test 2: PurchaseOrderTest**

```java
package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

/**
 * Test class for PurchaseOrder.
 */
public class PurchaseOrderTest {

    /**
     * Test case for creating a PurchaseOrder with default settings.
     */
    @Test
    public void testCreatePurchaseOrderWithDefaultSettings() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();

        // Assert the purchase order is created with default settings
        // ...
    }

    /**
     * Test case for creating a PurchaseOrder with chosen attributes.
     */
    @Test
    public void testCreatePurchaseOrderWithChosenAttributes() {
        String userEmail = "example@example.com";
        int propertyID = 123;
        double orderAmount = 100.0;

        PurchaseOrder purchaseOrder = new PurchaseOrder(userEmail, propertyID, orderAmount);

        // Assert the purchase order is created with the chosen attributes
        // ...
    }

    /**
     * Test case for getting the order amount of a PurchaseOrder.
     */
    @Test
    public void testGetOrderAmount() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();

        double orderAmount = purchaseOrder.getOrderAmount();

        // Assert that the returned order amount matches the expected value
        // ...
    }

    /**
     * Test case for getting the property ID of a PurchaseOrder.
     */
    @Test
    public void testGetPropertyID() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();

        int propertyID = purchaseOrder.getAnnouncement();

        // Assert that the returned property ID matches the expected value
        // ...
    }

    /**
     * Test case for getting the user email of a PurchaseOrder.
     */
    @Test
    public void testGetUserEmail() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();

        String userEmail = purchaseOrder.getUserEmail();

        // Assert that the returned user email matches the expected value
        // ...
    }

    /**
     * Test case for getting the acceptance state of a PurchaseOrder.
     */
    @Test
    public void testGetAcceptance() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();

        int acceptance = purchaseOrder.getAcceptance();

        // Assert that the returned acceptance state matches the expected value
        // ...
    }

    /**
     * Test case for setting the acceptance state of a PurchaseOrder.
     */
    @Test
    public void testSetAcceptance() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        int acceptance = 1; // Accepted state

        purchaseOrder.setAcceptance(acceptance);

        // Assert that the acceptance state is set correctly
        // ...
    }

    /**
     * Test case for setting the order amount of a PurchaseOrder.
     */
    @Test
    public void testSetOrderAmount() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        double orderAmount = 200.0;

        purchaseOrder.setOrderAmount(orderAmount);

        // Assert that the order amount is set correctly
        // ...
    }

    /**
     * Test case for setting the property ID of a PurchaseOrder.
     */
    @Test
    public void testSetPropertyID() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        int propertyID = 456;

        purchaseOrder.setAnnouncement(propertyID);

        // Assert that the property ID is set correctly
        // ...
    }

    /**
     * Test case for setting the user email of a PurchaseOrder.
     */
    @Test
    public void testSetUserEmail() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        String userEmail = "newemail@example.com";

        purchaseOrder.setUserEmail(userEmail);

        // Assert that the user email is set correctly
        // ...
    }

    /**
     * Test case for getting the purchase order ID of a PurchaseOrder.
     */
    @Test
    public void testGetPurchaseOrderID() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();

        int purchaseOrderID = purchaseOrder.getPurchaseOrderID();

        // Assert that the returned purchase order ID matches the expected value
        // ...
    }

    /**
     * Test case for getting the string representation of a PurchaseOrder.
     */
    @Test
    public void testToString() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        // Set up the purchase order with specific values
        // ...

        String purchaseOrderString = purchaseOrder.toString();

        // Assert that the returned string matches the expected format
        // ...
    }

    /**
     * Test case for comparing equality between two PurchaseOrder objects.
     */
    @Test
    public void testEquals() {
        PurchaseOrder purchaseOrder1 = new PurchaseOrder();
        // Set up purchaseOrder1 with specific values
        // ...

        PurchaseOrder purchaseOrder2 = new PurchaseOrder();
        // Set up purchaseOrder2 with the same values as purchaseOrder1
        // ...

        boolean isEqual = purchaseOrder1.equals(purchaseOrder2);

        // Assert that isEqual is true, indicating equality between the two purchase orders
        // ...
    }
}

```


*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)


## Class AcceptPurchaseOrderController

```java
package pt.ipp.isep.dei.esoft.project.application.controller;

public class AcceptPurchaseOrderController {
}
```

## Class PurchaseOrder

```java
package pt.ipp.isep.dei.esoft.project.domain;

public class PurchaseOrder {
    private int propertyID;
    private String userEmail;
    private double orderAmount;
    private int acceptance;

    private final String USER_EMAIL_DEFAULT="[NO EMAIL]";
    private final int PROPERTY_ID_DEFAULT=1;
    private final double ORDER_AMOUNT_DEFAULT = 0;

    /**
     * Purchase Order Constructors with the default settings
     */
    public PurchaseOrder(){
        this.userEmail = USER_EMAIL_DEFAULT;
        this.propertyID= PROPERTY_ID_DEFAULT;
        this.orderAmount= ORDER_AMOUNT_DEFAULT;
        this.acceptance=0;
    }

    /**
     * Purchase Order Constructors with chosen atributes
     * @param userEmail String
     * @param propertyID int
     * @param orderAmount double
     */
    public PurchaseOrder(String userEmail, int propertyID, double orderAmount){
        this.userEmail = userEmail;
        this.propertyID = propertyID;
        this.orderAmount = orderAmount;
        this.acceptance=0;
    }

    /**
     * Get the Purchase Order Amount
     * @return double
     */
    public double getOrderAmount() {
        return orderAmount;
    }

    /**
     * Get the Purchase Order PropertyID
     * @return int
     */
    public int getPropertyID() {
        return propertyID;
    }

    /**
     * Get the Purchase Order User Email
     * @return String
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Get the Purchase Order Acceptance State
     * @return int
     */
    public int getAcceptance() {
        return acceptance;
    }

    /**
     * Change the acceptance state
     * @param acceptance int: Declined (-1), To be reviewed (0), Accepted (1).
     */
    public void setAcceptance(int acceptance) {
        this.acceptance = acceptance;
    }

    /**
     * Change the order amount
     * @param orderAmount double
     */
    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * Change the property ID
     * @param propertyID int
     */
    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    /**
     * Change the User Email
     * @param userEmail String
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * Purchase Order information
     * @return String
     */
    @Override
    public String toString() {
        if (acceptance==-1) {
            return "Purchase Order: " + "Property ID: " + propertyID + " | User/Email: " + userEmail + " | Order Amount: " + orderAmount + " | Acceptance State: Denied";
        }else if (acceptance==0) {
            return  "Purchase Order: " + "Property ID: " + propertyID + " | User/Email: " + userEmail + " | Order Amount: " + orderAmount + " | Acceptance State: To be review.";
        } else {
            return  "Purchase Order: " + "Property ID: " + propertyID + " | User/Email: " + userEmail + " | Order Amount: " + orderAmount + " | Acceptance State: Accepted.";
        }
    }
}

```

## Class PurchaseOrderARepository

```java
package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.PurchaseOrder;

import java.util.ArrayList;
import java.util.List;

public class PurchaseOrderARepository {
    private List<PurchaseOrder> purchaseOrdersAcceptedRep = new ArrayList<>();

    /**
     * Adds Purchase Order objects to the Accepted Repository
     * @param purchaseOrder PurchaseOrder
     */
    public void addPurchaseOrder(PurchaseOrder purchaseOrder) {
        purchaseOrdersAcceptedRep.add(purchaseOrder);
    }

    /**
     * Checks if another Purchase Order already exists with the same Order amount
     * @param purchaseOrder Purchase Order
     * @return boolean
     */
    public boolean checkPurchaseOrderExists(PurchaseOrder purchaseOrder) {
        for (PurchaseOrder order : purchaseOrdersAcceptedRep) {
            if (purchaseOrder.getAnnouncement() == order.getAnnouncement()) {
                if (purchaseOrder.getOrderAmount() == order.getOrderAmount()) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * Checks if the User already submited a PurchaseOrder for the same property
     * @param email String
     * @param id int
     * @return boolean
     */
    public boolean checkUserPurchaseOrderExists(String email, int id) {
        for (PurchaseOrder order : purchaseOrdersAcceptedRep) {
            if (order.getUserEmail().equalsIgnoreCase(email)) {
                if (order.getAnnouncement() == (id)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Get a PurchaseOrder by the email and ID
     * @param email String
     * @param id int
     * @return PurchaseOrder
     */
    public PurchaseOrder getPurchaseOrder(String email, int id) {
        for (PurchaseOrder order : purchaseOrdersAcceptedRep) {
            if (order.getUserEmail().equalsIgnoreCase(email)) {
                if (order.getAnnouncement() == (id)) {
                    return order;
                }
            }
        }
        return null;
    }
}

```
## Class PurchaseOrderTBARepository

```java
package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.PurchaseOrder;

import java.util.ArrayList;
import java.util.List;

public class PurchaseOrderTBARepository {
    private List<PurchaseOrder> purchaseOrdersRep = new ArrayList<>();

    /**
     * Adds Purchase Order objects to the Repository
     * @param purchaseOrder PurchaseOrder
     */
    public void addPurchaseOrder(PurchaseOrder purchaseOrder) {
        purchaseOrdersRep.add(purchaseOrder);
    }

    /**
     * Checks if another Purchase Order already exists with the same Order amount
     * @param purchaseOrder Purchase Order
     * @return boolean
     */
    public boolean checkPurchaseOrderExists(PurchaseOrder purchaseOrder) {
        for (PurchaseOrder order : purchaseOrdersRep) {
            if (purchaseOrder.getAnnouncement() == order.getAnnouncement()) {
                if (purchaseOrder.getOrderAmount() == order.getOrderAmount()) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * Checks if the User already submited a PurchaseOrder for the same property
     * @param email String
     * @param id int
     * @return boolean
     */
    public boolean checkUserPurchaseOrderExists(String email, int id) {
        for (PurchaseOrder order : purchaseOrdersRep) {
            if (order.getUserEmail().equalsIgnoreCase(email)) {
                if (order.getAnnouncement() == (id)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Get a PurchaseOrder by the email and ID
     * @param email String
     * @param id int
     * @return PurchaseOrder
     */
    public PurchaseOrder getPurchaseOrder(String email, int id) {
        for (PurchaseOrder order : purchaseOrdersRep) {
            if (order.getUserEmail().equalsIgnoreCase(email)) {
                if (order.getAnnouncement() == (id)) {
                    return order;
                }
            }
        }
        return null;
    }
}

```



# 6. Integration and Demo 

* None at the moment


# 7. Observations

* None.



