# US 019 - Dividing sets of all stores

# 4. Tests 
**Test 1: PurchaseOrderRepositoryTest**

```java
    package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseOrderRepositoryTest {

    @Test
    void getPurchaseOrder() {
    }

    @Test
    void addPurchaseOrder() {
    }

    @Test
    void removePurchaseOrder() {
    }

    @Test
    void testGetPurchaseOrder() {
    }

    @Test
    void getPurchaseOrders() {
    }

    @Test
    void numberOfPurchaseOrders() {
    }

    @Test
    void getPurchaseOrderFromList() {
    }

    @Test
    void testGetPurchaseOrders() {
    }

    @Test
    void getPurchaseOrdersAccepted() {
    }

    @Test
    void getPurchaseOrdersRequested() {
    }

    @Test
    void sortDealsListBubble() {
    }

    @Test
    void sortDealsListSelection() {
    }

    @Test
    void testAddPurchaseOrder() {
    }

    @Test
    void addAcceptedPurchaseOrder() {
    }

    @Test
    void acceptPurchaseOrder() {
    }

    @Test
    void removeAllPurchaseOrdersByPropertyID() {
    }

    @Test
    void testGetPurchaseOrder1() {
    }

    @Test
    void testNumberOfPurchaseOrders() {
    }

    @Test
    void countAllPurchaseDealsFromAgency() {
    }

    @Test
    void checkPurchaseOrderExists() {
    }

    @Test
    void checkUserPurchaseOrderExists() {
    }

    @Test
    void getPurchaseOrderAccepted() {
    }

    @Test
    void getPurchaseOrderRequested() {
    }

    @Test
    void getParameters() {
    }

    @Test
    void getPriceList() {
    }

    @Test
    void getAreaOfPropertyList() {
    }

    @Test
    void getDistanceFromCentreList() {
    }

    @Test
    void getNumberOfBedroomsList() {
    }

    @Test
    void getNumberOfBathroomsList() {
    }

    @Test
    void getNumberOfParkingSpacesList() {
    }

    @Test
    void sortByDescingOrderOfValue() {
    }

    @Test
    void checkPurchaseOrderAmountExists() {
    }

    @Test
    void saveOrdersRepository() {
    }

    @Test
    void loadOrdersRepository() {
    }

    @Test
    void saveOrdersAcceptedRepository() {
    }

    @Test
    void loadOrdersAcceptedRepository() {
    }

    @Test
    void saveOrdersRequestedRepository() {
    }

    @Test
    void loadOrdersRequestedRepository() {
    }
}
```

**Test 2: PurchaseOrderTest**

```java
package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

class PurchaseOrderTest{
  @Test
  void getOrderAmount() {
  }

  @Test
  void getAnnouncement() {
  }

  @Test
  void getUserEmail() {
  }

  @Test
  void getAcceptance() {
  }

  @Test
  void setAcceptance() {
  }

  @Test
  void setOrderAmount() {
  }

  @Test
  void setAnnouncement() {
  }

  @Test
  void setUserEmail() {
  }

  @Test
  void getPurchaseOrderID() {
  }

  @Test
  void getAreaOfProperty() {
  }

  @Test
  void getPurchaseOrderFromList() {
  }

  @Test
  void testEquals1() {
  }

  @Test
  void testGetOrderAmount() {
  }

  @Test
  void testGetAnnouncement() {
  }

  @Test
  void testGetUserEmail() {
  }

  @Test
  void testGetAcceptance() {
  }

  @Test
  void testSetAcceptance() {
  }

  @Test
  void testSetOrderAmount() {
  }

  @Test
  void testSetAnnouncement() {
  }

  @Test
  void testSetUserEmail() {
  }

  @Test
  void testGetPurchaseOrderID() {
  }

  @Test
  void testGetAreaOfProperty() {
  }

  @Test
  void testGetPurchaseOrderFromList() {
  }

  @Test
  void testToString() {
  }

  @Test
  void testEquals() {
  }
}
```

**Test 3: NetworkManagingControllerTest**

```java
package pt.ipp.isep.dei.esoft.project.application.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NetworkManagingControllerTest {

    @Test
    void getAllAgenciesPurchaseDeals() {
    }

    @Test
    void getAgenciesPurchaseDeal() {
    }

    @Test
    void copyAllcontents() {
    }

    @Test
    void decimalToBinary() {
    }

    @Test
    void countAllPurchaseDeals() {
    }

    @Test
    void test1() {
    }

    @Test
    void testForEveryNumber() {
    }

    @Test
    void organizeList() {
    }

    @Test
    void getPowerOfTwo() {
    }
}
```

# 5. Construction (Implementation)

## Class PurchaseOrder

```java
package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.io.Serializable;
import java.util.List;

public class PurchaseOrder implements Serializable {
    private static int cont = 0;
    private Announcement announcement;
    private String userEmail;
    private double orderAmount;
    private int acceptance;
    private int purchaseOrderID;

    private final String USER_EMAIL_DEFAULT = "[NO EMAIL]";

    private final double ORDER_AMOUNT_DEFAULT = 0;

    /**
     * Purchase Order Constructors with the default settings
     */
    public PurchaseOrder() {
        this.userEmail = USER_EMAIL_DEFAULT;
        this.announcement = new Announcement();
        this.orderAmount = ORDER_AMOUNT_DEFAULT;
        this.acceptance = 0;
        cont++;
        this.purchaseOrderID = cont;
    }

    /**
     * Purchase Order Constructors with chosen atributes
     *
     * @param userEmail   String
     * @param announcement Announcement
     * @param orderAmount double
     */
    public PurchaseOrder(String userEmail, Announcement announcement, double orderAmount) {
        this.userEmail = userEmail;
        this.announcement = announcement;
        this.orderAmount = orderAmount;
        this.acceptance = 0;
        cont++;
        this.purchaseOrderID = cont;
    }

    /**
     * Purchase Order Constructors with chosen atributes
     *
     * @param announcement Announcement
     * @param orderAmount double
     */
    public PurchaseOrder(Announcement announcement, double orderAmount) {
        this.userEmail = USER_EMAIL_DEFAULT;
        this.announcement = announcement;
        this.orderAmount = orderAmount;
        this.acceptance = 0;
        cont++;
        this.purchaseOrderID = cont;
    }


    /**
     * Get the Purchase Order Amount
     *
     * @return double
     */
    public double getOrderAmount() {
        return orderAmount;
    }

    /**
     * Get the Purchase Order PropertyID
     *
     * @return int
     */
    public Announcement getAnnouncement() {
        return announcement;
    }

    /**
     * Get the Purchase Order User Email
     *
     * @return String
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Get the Purchase Order Acceptance State
     *
     * @return int
     */
    public int getAcceptance() {
        return acceptance;
    }

    /**
     * Change the acceptance state
     *
     * @param acceptance int: Declined (-1), To be reviewed (0), Accepted (1).
     */
    public void setAcceptance(int acceptance) {
        this.acceptance = acceptance;
    }

    /**
     * Change the order amount
     *
     * @param orderAmount double
     */
    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * Change the property ID
     *
     * @param announcement int
     */
    public void setAnnouncement(Announcement announcement) {
        this.announcement = announcement;
    }

    /**
     * Change the User Email
     *
     * @param userEmail String
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * Gets the PurchaseOrderID
     *
     * @return int
     */
    public int getPurchaseOrderID() {
        return purchaseOrderID;
    }

    /**
     * Gets the AreaOfProperty from the propertyID of the PurchaseOrder
     *
     * @return double
     */
    public double getAreaOfProperty() {
        return this.announcement.getRequest().getProperty().getAreaOfProperty();
    }

    /**
     * Gets a purchase order from the purchase order repository.
     *
     * @param purchaseOrder the purchase order to get
     * @param purchaseOrderList the type of list that was selected
     * @return the purchase order if it exists in the repository, null otherwise
     */
    public PurchaseOrder getPurchaseOrderFromList (PurchaseOrder purchaseOrder, List<PurchaseOrder> purchaseOrderList) {
        if (purchaseOrderList.contains(purchaseOrder)) {
            return purchaseOrder;
        } else {
            return null;
        }
    }

    /**
     * Purchase Order information
     *
     * @return String
     */
    @Override
    public String toString() {
        if (acceptance == -1) {
            return "#" + purchaseOrderID + " Purchase Order: " + "\n  | User/Email: " + userEmail + " | Order Amount: " + orderAmount + " | Acceptance State: Denied" +
                    "\n"+ announcement;
        } else if (acceptance == 0) {
            return "#" + purchaseOrderID + " Purchase Order: " + "\n  | User/Email: " + userEmail + " | Order Amount: " + orderAmount + " | Acceptance State: To be review."+
                    "\n"+ announcement;
        } else {
            return "#" + purchaseOrderID + " Purchase Order: " + "\n  | User/Email: " + userEmail + " | Order Amount: " + orderAmount + " | Acceptance State: Accepted."+
                    "\n"+ announcement;
        }
    }

    /**
     * Compares if the contents of the PurchaseOrder Object is the same as another PurchaseOrder Object
     *
     * @param obj PurchaseOrder
     * @return boolean
     */
    public boolean equals(PurchaseOrder obj) {
        if (this.getUserEmail().equalsIgnoreCase(obj.getUserEmail())) {
            if (this.getOrderAmount() == obj.getOrderAmount()) {
                if (this.getAnnouncement() == obj.getAnnouncement()) {
                    return true;
                }
            }
        }
        return false;
    }
}
```

## Class PurchaseOrder

```java
package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Building;
import pt.ipp.isep.dei.esoft.project.domain.PurchaseOrder;
import pt.ipp.isep.dei.esoft.project.domain.Serialization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PurchaseOrderRepository {

    private static final String FILE_PATH_ACCEPTED = "PurchaseOrderAcceptedRepository.ser";
    private static final String FILE_PATH = "PurchaseOrderRepository.ser";

    private static final String FILE_PATH_REQUESTED = "PurchaseOrderRepositoryRequested.ser";
    Serialization serialization = new Serialization();

    /**
     * List of all purchase orders created
     */
    public static List<PurchaseOrder> purchaseOrders = new ArrayList<>();

    /**
     * List of all purchase orders that were accepted
     */
    public static List<PurchaseOrder> purchaseOrdersAccepted = new ArrayList<>();

    /**
     * List of all purchase orders requested
     */
    public static List<PurchaseOrder> purchaseOrdersRequested = new ArrayList<>();

    /**
     * Gets a purchase order from the purchase order repository.
     *
     * @param purchaseOrder     the purchase order to get
     * @param purchaseOrderList the type of list that was selected
     * @return the purchase order if it exists in the repository, null otherwise
     */
    public PurchaseOrder getPurchaseOrderFromList(PurchaseOrder purchaseOrder, List<PurchaseOrder> purchaseOrderList) {
        if (purchaseOrderList.contains(purchaseOrder)) {
            return purchaseOrder;
        } else {
            return null;
        }
    }

    /**
     * Get the list of all purchase orders created
     *
     * @return List<PurchaseOrder> purchaseOrders
     */
    public static List<PurchaseOrder> getPurchaseOrders() {
        return new ArrayList<>(purchaseOrders);
    }

    /**
     * Get the list of all purchase orders accepted
     *
     * @return List<PurchaseOrder> purchaseOrdersAccepted
     */
    public List<PurchaseOrder> getPurchaseOrdersAccepted() {
        return new ArrayList<>(purchaseOrdersAccepted);
    }

    /**
     * Get the list of all purchase orders requested
     *
     * @return List<PurchaseOrder> purchaseOrdersRequested
     */
    public static List<PurchaseOrder> getPurchaseOrdersRequested() {
        return new ArrayList<>(purchaseOrdersRequested);
    }

    /**
     * Sorts a copy of the Purchase Order List by the Bubble Algorithm
     *
     * @param sortingDirection int
     * @return List<PurchaseOrder></PurchaseOrder>
     */
    public List<PurchaseOrder> sortDealsListBubble(int sortingDirection) {
        PurchaseOrder temporary;
        List<PurchaseOrder> purchaseOrdersAcceptedSorted = new ArrayList<>(purchaseOrdersAccepted);
        int size = purchaseOrdersAcceptedSorted.size();
        if (sortingDirection == 1) {
            // Ascending
            for (int i = 0; i <= size - 1; i++) {
                for (int j = size - 1; j >= size - i; j--) {
                    if (purchaseOrdersAcceptedSorted.get(j - 1).getAreaOfProperty() > purchaseOrdersAcceptedSorted.get(j).getAreaOfProperty()) {
                        temporary = purchaseOrdersAcceptedSorted.get(j);
                        purchaseOrdersAcceptedSorted.set(j, purchaseOrdersAcceptedSorted.get(j - 1));
                        purchaseOrdersAcceptedSorted.set(j - 1, temporary);
                    }
                }
            }
        } else {
            //Descending
            for (int i = 1; i < size; i++) {
                for (int j = 0; j < size - i; j++) {
                    if (purchaseOrdersAcceptedSorted.get(j + 1).getAreaOfProperty() > purchaseOrdersAcceptedSorted.get(j).getAreaOfProperty()) {
                        temporary = purchaseOrdersAcceptedSorted.get(j);
                        purchaseOrdersAcceptedSorted.set(j, purchaseOrdersAcceptedSorted.get(j + 1));
                        purchaseOrdersAcceptedSorted.set(j + 1, temporary);
                    }
                }
            }
        }
        return purchaseOrdersAcceptedSorted;
    }

    /**
     * Sorts a copy of the Purchase Order List by the Selection Algorithm
     *
     * @param sortingDirection int
     * @return List<PurchaseOrder></PurchaseOrder>
     */
    public List<PurchaseOrder> sortDealsListSelection(int sortingDirection) {
        double min;
        double max;
        int min_position;
        int max_position;
        int initialPosition = 0;
        int finalPosition = purchaseOrdersAccepted.size()-1;
        PurchaseOrder temporaryMin;
        PurchaseOrder temporaryMax;
        List<PurchaseOrder> purchaseOrdersAcceptedRepSorted = new ArrayList<>(purchaseOrdersAccepted);

        if (sortingDirection == 1) {
            // Ascending
            do {
                min = purchaseOrdersAcceptedRepSorted.get(initialPosition).getAreaOfProperty();
                min_position = initialPosition;
                max = purchaseOrdersAcceptedRepSorted.get(initialPosition).getAreaOfProperty();
                max_position = initialPosition;

                for (int j = initialPosition; j <= finalPosition; j++) {
                    if (purchaseOrdersAcceptedRepSorted.get(j).getAreaOfProperty() > max) {
                        max = purchaseOrdersAcceptedRepSorted.get(j).getAreaOfProperty();
                        max_position = j;
                    }
                    if (purchaseOrdersAcceptedRepSorted.get(j).getAreaOfProperty() < min) {
                        min = purchaseOrdersAcceptedRepSorted.get(j).getAreaOfProperty();
                        min_position = j;
                    }
                }

                temporaryMin = purchaseOrdersAcceptedRepSorted.get(min_position);
                temporaryMax = purchaseOrdersAcceptedRepSorted.get(max_position);
                purchaseOrdersAcceptedRepSorted.set(min_position, purchaseOrdersAcceptedRepSorted.get(initialPosition));
                purchaseOrdersAcceptedRepSorted.set(max_position, purchaseOrdersAcceptedRepSorted.get(finalPosition));
                purchaseOrdersAcceptedRepSorted.set(initialPosition, temporaryMin);
                purchaseOrdersAcceptedRepSorted.set(finalPosition, temporaryMax);

                initialPosition++;
                finalPosition--;
            } while (initialPosition < finalPosition);
        } else {
            // Descending
            do {
                min = purchaseOrdersAcceptedRepSorted.get(initialPosition).getAreaOfProperty();
                min_position = initialPosition;
                max = purchaseOrdersAcceptedRepSorted.get(initialPosition).getAreaOfProperty();
                max_position = initialPosition;

                for (int j = initialPosition; j <= finalPosition; j++) {
                    if (purchaseOrdersAcceptedRepSorted.get(j).getAreaOfProperty() > max) {
                        max = purchaseOrdersAcceptedRepSorted.get(j).getAreaOfProperty();
                        max_position = j;
                    }
                    if (purchaseOrdersAcceptedRepSorted.get(j).getAreaOfProperty() < min) {
                        min = purchaseOrdersAcceptedRepSorted.get(j).getAreaOfProperty();
                        min_position = j;
                    }
                }

                temporaryMin = purchaseOrdersAcceptedRepSorted.get(min_position);
                temporaryMax = purchaseOrdersAcceptedRepSorted.get(max_position);
                purchaseOrdersAcceptedRepSorted.set(max_position, purchaseOrdersAcceptedRepSorted.get(initialPosition));
                purchaseOrdersAcceptedRepSorted.set(min_position, purchaseOrdersAcceptedRepSorted.get(finalPosition));
                purchaseOrdersAcceptedRepSorted.set(finalPosition, temporaryMin);
                purchaseOrdersAcceptedRepSorted.set(initialPosition, temporaryMax);


                initialPosition++;
                finalPosition--;
            } while (initialPosition < finalPosition);
        }
        return purchaseOrdersAcceptedRepSorted;
    }

    /**
     * Adds a purchase order to the list of all purchase orders.
     *
     * @param purchaseOrder the purchase order to add
     */
    public void addPurchaseOrder(PurchaseOrder purchaseOrder) {
        purchaseOrders.add(purchaseOrder);
        purchaseOrdersRequested.add(purchaseOrder);
    }

    public void addAcceptedPurchaseOrder(PurchaseOrder purchaseOrder){
        purchaseOrdersAccepted.add(purchaseOrder);
    }


    /**
     * Adds a purchase order to the list of accepted purchased orders
     *
     * @param purchaseOrder the purchase order to add
     */
    public void acceptPurchaseOrder(PurchaseOrder purchaseOrder) {
        purchaseOrder.setAcceptance(1);
        purchaseOrdersAccepted.add(purchaseOrder);
    }

    /**
     * Removes all purchase orders that have a certain property from the list of purchase orders that were requested
     *
     * @param propertyId the id of the property
     */
    public void removeAllPurchaseOrdersByPropertyID(int propertyId) {
        for (int i = 0; i < purchaseOrdersRequested.size(); i++) {
            if (purchaseOrdersRequested.get(i).getAnnouncement().getAnnouncementID() == propertyId) {
                purchaseOrdersRequested.get(i).setAcceptance(-1);
                purchaseOrdersRequested.remove(i);
            }
        }
    }

    /**
     * Returns the purchase order using its list id and the selected list
     *
     * @param n                 the list id of the property
     * @param purchaseOrderList the type of list that was selected
     * @return purchaseOrder the purchase order that was required
     */
    public PurchaseOrder getPurchaseOrder(int n, List<PurchaseOrder> purchaseOrderList) {
        return purchaseOrderList.get(n);
    }

    /**
     * Returns the amount of purchase orders a certain list has
     *
     * @param purchaseOrderList the type of list that was selected
     */
    public int numberOfPurchaseOrders(List<PurchaseOrder> purchaseOrderList) {
        return purchaseOrderList.size();
    }


    public int countAllPurchaseDealsFromAgency(Agency agency) {
        int cont = 0;
        for (int i = 0; i < PurchaseOrderRepository.purchaseOrdersAccepted.size(); i++) {
            if (PurchaseOrderRepository.purchaseOrdersAccepted.get(i).getAnnouncement().getRequest().getAgent().getAgency() == agency) {
                cont++;
            }
        }
        return cont;
    }

    /**
     * Checks if another Purchase Order already exists with the same Order amount
     *
     * @param purchaseOrder Purchase Order
     * @return boolean
     */
    public boolean checkPurchaseOrderExists(PurchaseOrder purchaseOrder) {
        for (PurchaseOrder order : purchaseOrdersAccepted) {
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
     *
     * @param email String
     * @param id    int
     * @return boolean
     */
    public boolean checkUserPurchaseOrderExists(String email, int id) {
        for (PurchaseOrder order : purchaseOrdersRequested) {
            if (order.getUserEmail().equalsIgnoreCase(email)) {
                if (order.getAnnouncement().getAnnouncementID() == (id)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Get a PurchaseOrder by the email and ID
     *
     * @param email String
     * @param id    int
     * @return PurchaseOrder
     */
    public PurchaseOrder getPurchaseOrderAccepted(String email, int id) {
        for (PurchaseOrder order : purchaseOrdersAccepted) {
            if (order.getUserEmail().equalsIgnoreCase(email)) {
                if (order.getAnnouncement().getAnnouncementID() == (id)) {
                    return order;
                }
            }
        }
        return null;
    }

    public PurchaseOrder getPurchaseOrderRequested(String email, int id) {
        for (PurchaseOrder order : purchaseOrdersRequested) {
            if (order.getUserEmail().equalsIgnoreCase(email)) {
                if (order.getAnnouncement().getAnnouncementID() == (id)) {
                    return order;
                }
            }
        }
        return null;
    }

    public Double[][] getParameters(int parameterOption) {


        ArrayList<ArrayList<Double>> output= new ArrayList<>();
        switch (parameterOption) {
            case 0:
                output.add(getAreaOfPropertyList());
                output.add(getDistanceFromCentreList());
                output.add(getNumberOfBedroomsList());
                output.add(getNumberOfBathroomsList());
                output.add(getNumberOfParkingSpacesList());
                break;
            case 1:
                output.add(getAreaOfPropertyList());
                break;
            case 2:
                output.add(getDistanceFromCentreList());
                break;
            case 3:
                output.add(getNumberOfBedroomsList());
                break;
            case 4:
                output.add(getNumberOfBathroomsList());
                break;
            case 5:
                output.add(getNumberOfParkingSpacesList());
                break;
        }
        output.add(getPriceList());

        Double[][] parameters = new Double[output.size()][];
        for (int i = 0; i < output.size(); i++) {
            ArrayList<Double> parameterList = output.get(i);
            Double[] currentArray = new Double[parameterList.size()];
            for (int j = 0; j < parameterList.size(); j++) {
                currentArray[j] = parameterList.get(j);
            }
            parameters[i] = currentArray;
        }
        return parameters;

    }

    public ArrayList<Double> getPriceList(){
        ArrayList<Double> info = new ArrayList<>();
        for (int i = 0; i < purchaseOrdersAccepted.size(); i++) {
            if(purchaseOrdersAccepted.get(i).getAnnouncement().getRequest().getProperty().getPropertyType().toUpperCase().equals("HOUSE") || purchaseOrdersAccepted.get(i).getAnnouncement().getRequest().getProperty().getPropertyType().toUpperCase().equals("APARTMENT")){
                info.add(purchaseOrdersAccepted.get(i).getOrderAmount());
            }
        }
        return info;
    }
    public ArrayList<Double> getAreaOfPropertyList(){
        ArrayList<Double> info = new ArrayList<>();
        for (int i = 0; i < purchaseOrdersAccepted.size(); i++) {
            if(purchaseOrdersAccepted.get(i).getAnnouncement().getRequest().getProperty().getPropertyType().toUpperCase().equals("HOUSE") || purchaseOrdersAccepted.get(i).getAnnouncement().getRequest().getProperty().getPropertyType().toUpperCase().equals("APARTMENT")){
                info.add(purchaseOrdersAccepted.get(i).getAnnouncement().getRequest().getProperty().getAreaOfProperty());
            }
        }
        return info;
    }

    public ArrayList<Double> getDistanceFromCentreList(){
        ArrayList<Double> info = new ArrayList<>();
        for (int i = 0; i < purchaseOrdersAccepted.size(); i++) {
            if(purchaseOrdersAccepted.get(i).getAnnouncement().getRequest().getProperty().getPropertyType().toUpperCase().equals("HOUSE") || purchaseOrdersAccepted.get(i).getAnnouncement().getRequest().getProperty().getPropertyType().toUpperCase().equals("APARTMENT")){
                info.add(purchaseOrdersAccepted.get(i).getAnnouncement().getRequest().getProperty().getDistanceFromCentre());
            }
        }
        return info;
    }

    public ArrayList<Double> getNumberOfBedroomsList(){
        ArrayList<Double> info = new ArrayList<>();
        for (int i = 0; i < purchaseOrdersAccepted.size(); i++) {
            if(purchaseOrdersAccepted.get(i).getAnnouncement().getRequest().getProperty().getPropertyType().toUpperCase().equals("HOUSE") || purchaseOrdersAccepted.get(i).getAnnouncement().getRequest().getProperty().getPropertyType().toUpperCase().equals("APARTMENT")){
                Building building = (Building) purchaseOrdersAccepted.get(i).getAnnouncement().getRequest().getProperty();
                info.add((double) building.getBedrooms());
            }
        }
        return info;
    }

    public ArrayList<Double> getNumberOfBathroomsList(){
        ArrayList<Double> info = new ArrayList<>();
        for (int i = 0; i < purchaseOrdersAccepted.size(); i++) {
            if(purchaseOrdersAccepted.get(i).getAnnouncement().getRequest().getProperty().getPropertyType().toUpperCase().equals("HOUSE") || purchaseOrdersAccepted.get(i).getAnnouncement().getRequest().getProperty().getPropertyType().toUpperCase().equals("APARTMENT")){
                Building building = (Building) purchaseOrdersAccepted.get(i).getAnnouncement().getRequest().getProperty();
                info.add((double) building.getBathrooms());
            }
        }
        return info;
    }

    public ArrayList<Double> getNumberOfParkingSpacesList(){
        ArrayList<Double> info = new ArrayList<>();
        for (int i = 0; i < purchaseOrdersAccepted.size(); i++) {
            if(purchaseOrdersAccepted.get(i).getAnnouncement().getRequest().getProperty().getPropertyType().toUpperCase().equals("HOUSE") || purchaseOrdersAccepted.get(i).getAnnouncement().getRequest().getProperty().getPropertyType().toUpperCase().equals("APARTMENT")){
                Building building = (Building) purchaseOrdersAccepted.get(i).getAnnouncement().getRequest().getProperty();
                info.add((double) building.getParkingSpaces());
            }
        }
        return info;
    }

    /**
     * Sort the list by value descending
     *
     * @param purchaseOrdersRequested
     * @return PurchaseOrder
     */
    public void sortByDescingOrderOfValue(List<PurchaseOrder> purchaseOrdersRequested) {
        Collections.sort(purchaseOrdersRequested, Comparator.comparing(PurchaseOrder::getOrderAmount).reversed());

    }

    /**
     * Checks if another Purchase Order already exists with the same Order amount
     *
     * @param purchaseOrder Purchase Order
     * @return boolean
     */
    public boolean checkPurchaseOrderAmountExists(PurchaseOrder purchaseOrder) {
        for (PurchaseOrder order : purchaseOrdersRequested) {
            if (purchaseOrder.getAnnouncement() == order.getAnnouncement()) {
                if (purchaseOrder.getOrderAmount() == order.getOrderAmount()) {
                    if (!purchaseOrder.getUserEmail().equalsIgnoreCase(order.getUserEmail())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public void saveOrdersRepository() {
        serialization.toWrite((List<Object>) (List<?>) purchaseOrders, FILE_PATH);
    }

    @SuppressWarnings("unchecked")
    public void loadOrdersRepository() {
        this.purchaseOrders = (List<PurchaseOrder>) (List<?>) serialization.toRead(FILE_PATH);
    }

    @SuppressWarnings("unchecked")
    public void saveOrdersAcceptedRepository() {
        serialization.toWrite((List<Object>) (List<?>) purchaseOrdersAccepted, FILE_PATH_ACCEPTED);
    }

    @SuppressWarnings("unchecked")
    public void loadOrdersAcceptedRepository() {
        this.purchaseOrdersAccepted = (List<PurchaseOrder>) (List<?>) serialization.toRead(FILE_PATH_ACCEPTED);
    }

    @SuppressWarnings("unchecked")
    public void saveOrdersRequestedRepository() {
        serialization.toWrite((List<Object>) (List<?>) purchaseOrders, FILE_PATH_ACCEPTED);
    }

    @SuppressWarnings("unchecked")
    public void loadOrdersRequestedRepository() {
        this.purchaseOrdersRequested = (List<PurchaseOrder>) (List<?>) serialization.toRead(FILE_PATH_ACCEPTED);
    }
}
```

## Class PurchaseOrderRepository
```java
package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Network;
import pt.ipp.isep.dei.esoft.project.repository.PurchaseOrderRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.ArrayList;
import java.util.List;

public class NetworkManagingController {

    public Agency agency = new Agency();

    public Network network = new Network();
    Repositories repositories = Repositories.getInstance();
    public List<Integer> agenciesAndPurchaseDeals = new ArrayList<>();

    PurchaseOrderRepository purchaseOrderRepository = repositories.getPurchaseOrderRepository();

    public List<Integer> getAllAgenciesPurchaseDeals(){

        for (int i = 0; i < network.getAgencies().size(); i++) {
           agenciesAndPurchaseDeals.add(purchaseOrderRepository.countAllPurchaseDealsFromAgency(purchaseOrderRepository.getPurchaseOrdersAccepted().get(i).getAnnouncement().getRequest().getAgent().getAgency()));
        }
        return agenciesAndPurchaseDeals;

    }

    public int getAgenciesPurchaseDeal(int n){
        return agenciesAndPurchaseDeals.get(n);
    }

    public static void copyAllcontents(List<Integer> list1, List<Integer> list2) {
        if(list2.size()==0){
            list2.addAll(list1);
        }else {
            for (int i = 0; i < list1.size(); i++) {
                list2.set(i, list1.get(i));
            }
        }
    }

    public static String decimalToBinary(int decimal, int listSize) {
        String binary = Integer.toBinaryString(decimal);
        return padZeros(binary, listSize);
    }

    private static String padZeros(String binary, int listSize) {
        if (binary.length() >= listSize) {
            return binary;
        }

        int zeroCount = listSize - binary.length();
        StringBuilder paddedBuilder = new StringBuilder();
        paddedBuilder.append("0".repeat(zeroCount));
        paddedBuilder.append(binary);

        return paddedBuilder.toString();
    }

    public static int countAllPurchaseDeals(List<Integer> list){
        int cont = 0;
        for (int i = 0; i < list.size(); i++) {
            cont = cont + list.get(i);
        }
        return cont;
    }

    public static int test(List<Integer> list1, List<Integer> list2, String binaryNumber) {
        for (int i = 0; i < binaryNumber.length(); i++) {
            char digit = binaryNumber.charAt(i);
            if (digit == '0') {
                list2.set(i, 0);
            } else {
                list1.set(i, 0);
            }
        }
        int difference = countAllPurchaseDeals(list1) - countAllPurchaseDeals(list2);
        if (difference < 0) {
            return -difference;
        } else {
            return difference;
        }
    }

    public static void testForEveryNumber(List<Integer> list1, List<Integer> list2, List<Integer> agenciesPurchaseDeals, List<String> answers) {
        int difference = test(list1, list2, decimalToBinary(0, agenciesPurchaseDeals.size()));
        String binaryOrganization = null;
        int limite = getPowerOfTwo(agenciesPurchaseDeals.size());
        for (int i = 0; i < limite; i++) {
            if (test(list1, list2, decimalToBinary(i, agenciesPurchaseDeals.size())) < difference) {
                difference = test(list1, list2, decimalToBinary(i, agenciesPurchaseDeals.size()));
                binaryOrganization = decimalToBinary(i, agenciesPurchaseDeals.size());
            }
            copyAllcontents(agenciesPurchaseDeals, list1);
            copyAllcontents(agenciesPurchaseDeals, list2);
        }
        copyAllcontents(agenciesPurchaseDeals, list1);
        copyAllcontents(agenciesPurchaseDeals, list2);
        answers.add(binaryOrganization);
        answers.add(Integer.toString(difference));
    }

    public static void organizeList(List<Integer> list1, List<Integer> list2, String binaryOrganization) {
        for (int i = 0; i < binaryOrganization.length(); i++) {
            char digit = binaryOrganization.charAt(i);
            if (digit == '0') {
                list2.set(i, 0);
            } else {
                list1.set(i, 0);
            }
        }
    }

    public static int getPowerOfTwo(int listSize) {
        int n = 2;
        if (listSize == 0) {
            return 0;
        } else if (listSize == 1) {
            return 2;
        } else {
            for (int i = 0; i < listSize-1; i++) {
                n = n * 2;
            }
            return n;
        }
    }
}
```

# 6. Integration and Demo 

* None at the moment


# 7. Observations







