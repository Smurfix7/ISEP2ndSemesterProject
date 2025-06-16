# US 010 - Order to Purchase a Property 

# 4. Tests 

## Class CreatePurchaseOrderController

**Test 1:** Checks if the AnnouncementID exists in the Announcement Repository.

    @Test
    void checkPurchaseOrderExists() {
        Property property = new Property();
        AnnouncementRepository.addProperty(property);
        AnnouncementRepository.addProperty(property);
        AnnouncementRepository.addProperty(property);
        int test=0;
        if (controller.checkAnnouncement(2)) {
            test=1;
        }
        assertEquals(1,test);
    }

**Test 2:** Checks if the Purchase Order Amount already exists in the Purchase Order Repository.

    @Test
    void checkPurchaseOrderAmountExists() {
        PurchaseOrder purchaseOrder1 = new PurchaseOrder("test",1,100);
        PurchaseOrder purchaseOrder2 = new PurchaseOrder("test2",1,100);
        purchaseOrderTBARepository.addPurchaseOrder(purchaseOrder1);

        int test=0;
        if (controller.checkPurchaseOrderAmountExists(purchaseOrder2)){
            test=1;
        }
        assertEquals(1,test);
    }

**Test 3:** Checks if it's possible to get a copy of the Announcement Repository.

    @Test
    void getCopyAnnouncementsList() {
        Property property = new Property();
        AnnouncementRepository.addProperty(property);
        List <Property> test = controller.getCopyAnnouncementsList();
        assertEquals(test.size(),AnnouncementRepository.getAnnouncements().size());
        assertEquals(test.get(0),AnnouncementRepository.getAnnouncements().get(0));
    }

**Test 4:** Checks if it's possible to create a Purchase Order

    @Test
    void createPurchaseOrder() {
        PurchaseOrder purchaseOrder1 = new PurchaseOrder("test",1,100);
        controller.createPurchaseOrder("test",1,100);

        int test=0;
        if (purchaseOrder1.equals(purchaseOrderTBARepository.getPurchaseOrder(0))){
            test=1;
        }
        assertEquals(1,test);
    }

**Test 5:** Checks if the User already submited a Purchase Order for that propertyID.

    @Test
    void checkUserPurchaseOrderExists() {
        PurchaseOrder purchaseOrder1 = new PurchaseOrder("test",1,100);
        purchaseOrderTBARepository.addPurchaseOrder(purchaseOrder1);

        int test=0;
        if (controller.checkUserPurchaseOrderExists("test", 1)){
            test=1;
        }
        assertEquals(1,test);
    }

**Test 6:** Checks if it's possible to get a purchase order from the repository by the email and ID.

    @Test
    void getPurchaseOrder() {
        PurchaseOrder purchaseOrder1 = new PurchaseOrder("test",1,100);
        purchaseOrderTBARepository.addPurchaseOrder(purchaseOrder1);

        int test=0;
        if (controller.getPurchaseOrder("test",1).equals(purchaseOrderTBARepository.getPurchaseOrder(0))){
            test=1;
        }
        assertEquals(1,test);
    }

# 5. Construction (Implementation)


## Class CreatePurchaseOrderController 

```java
public class CreatePurchaseOrderController {
    PurchaseOrderRepository purchaseOrderRepository = new PurchaseOrderRepository();
    PurchaseOrderTBARepository purchaseOrderTBARepository = new PurchaseOrderTBARepository();
    AuthenticationRepository authenticationRepository = new AuthenticationRepository();
    AnnouncementRepository announcementRepository = new AnnouncementRepository();



    /**
     * Check if the announcement exists in the repository
     * @param announcementNumber int
     * @return boolean
     */
    public boolean checkAnnouncement (int announcementNumber){
        return announcementNumber <= AnnouncementRepository.getAnnouncements().size() && announcementNumber>0;
    }

    /**
     * Checks if another Purchase Order already exists with the same Order amount
     * @param purchaseOrder Purchase Order
     * @return boolean
     */
    public boolean checkPurchaseOrderAmountExists(PurchaseOrder purchaseOrder){
        return purchaseOrderTBARepository.checkPurchaseOrderAmountExists(purchaseOrder);
    }

    /**
     * Create an Announcement List Copy
     * @return List<Property></Property>
     */
    public List<Property> getCopyAnnouncementsList(){return AnnouncementRepository.getAnnouncements();}

    /**
     * Create a PurchaseOrder object
     * @param userEmail String
     * @param propertyID int
     * @param orderAmount double
     * @return PurchaseOrder
     */
    public PurchaseOrder createPurchaseOrder(String userEmail, int propertyID, double orderAmount){
        PurchaseOrder purchaseOrder= new PurchaseOrder(userEmail,propertyID,orderAmount);
        purchaseOrderTBARepository.addPurchaseOrder(purchaseOrder);
        purchaseOrderTBARepository.sortByDescingOrderOfValue(purchaseOrderTBARepository.getPurchaseOrders());
        purchaseOrderRepository.addPurchaseOrder(purchaseOrder);
        return purchaseOrder;
    }

    /**
     * Gets the User login Email
     * @return String
     */
    public String getLoggedUser (){
        return authenticationRepository.getCurrentUserSession().getUserId().getEmail();
    }

    /**
     * Checks if the User already submited a PurchaseOrder for the same property
     * @param email String
     * @param id int
     * @return boolean
     */
    public boolean checkUserPurchaseOrderExists (String email, int id){
        return purchaseOrderTBARepository.checkUserPurchaseOrderExists(email,id);
    }

    /**
     * Get a PurchaseOrder by the email and ID
     * @param email String
     * @param id int
     * @return PurchaseOrder
     */
    public PurchaseOrder getPurchaseOrder(String email, int id){
        return purchaseOrderTBARepository.getPurchaseOrder(email,id);
    }
    
}
```

## Class CreatePurchaseOrderUI 

```java
public class CreatePurchaseOrderUI implements Runnable {

    private Scanner read = new Scanner(System.in);
    private CreatePurchaseOrderController controller = new CreatePurchaseOrderController();
    private boolean answerValidation;
    private String answer;

    /**
     * UI Run method.
     */
    @Override
    public void run() {
        do {
            answerValidation=false;
            System.out.println("===== Create a Purchase Order =====");
            System.out.println();
            displayAnnouncements();
            System.out.println("===== / =====");
            do {
                int announcementID = requestPropertyID();
                if (controller.checkAnnouncement(announcementID)) {
                    if (!controller.checkUserPurchaseOrderExists(controller.getLoggedUser(),announcementID)) {
                        answerValidation = true;
                        PurchaseOrder purchaseOrder = controller.createPurchaseOrder(controller.getLoggedUser(), announcementID, requestOrderAmount());
                        if(controller.checkPurchaseOrderAmountExists(purchaseOrder)) {
                            System.out.println("Order Amount already exists, so yours won't have priority.");
                        }
                    } else {
                        System.out.println("You already submited a purchase order for this property." +
                                "\nRemember you can't create another purchase order for a property in which you already submited one. You can only do that when the previous is declined/accepted.");
                        System.out.println("\n== Previous Purchase Order: ==\n"+controller.getPurchaseOrder(controller.getLoggedUser(),announcementID));
                    }
                } else if (announcementID==0) {
                    answerValidation=true;
                } else {
                    System.out.println("Invalid property. Please confirm the announcement ID.");
                }
            } while (!answerValidation);
            System.out.println("\nDo you wish to request another purchase order? (Yes / No)"+
                    "\nRemember you can't create another purchase order for a property in which you already submited one. You can only do that when the previous is declined/accepted.");
            do {
                answer = read.next();
                if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no")) {
                    answerValidation = true;
                } else {
                    answerValidation = false;
                    System.out.println("Invalid Answer." +
                            "\nnDo you wish to request another purchase order? (Yes / No)");
                }
            } while (!answerValidation);
        } while (answer.equalsIgnoreCase("yes"));
    }

    /**
     * Display the list of announcements
     */
    public void displayAnnouncements() {
        for (int i = 0; i < controller.getCopyAnnouncementsList().size(); i++) {
            System.out.println(controller.getCopyAnnouncementsList().get(i));
        }
    }

    /**
     * Requests the PropertyID
     * @return int
     */
    private int requestPropertyID() {
        System.out.println("\nSelect the the property ID number (#___) you wish to create a purchase order (0 -> cancel):");
        return read.nextInt();
    }

    /**
     * Requests the OrderAmount
     * @return double
     */
    private double requestOrderAmount() {
        System.out.println("Write the order amount:");
        return read.nextDouble();
    }
}
```

## Class PurchaseOrderTBARepository

```java
public class PurchaseOrderTBARepository {
    static List<PurchaseOrder> purchaseOrdersRep = new ArrayList<>();

    /**
     * Adds Purchase Order objects to the Repository
     * @param purchaseOrder PurchaseOrder
     */
    public void addPurchaseOrder(PurchaseOrder purchaseOrder){
        purchaseOrdersRep.add(purchaseOrder);

    }

    public void removeAllPurchaseOrdersByID(int id){
        for (int i = 0; i < purchaseOrdersRep.size(); i++) {
            if(purchaseOrdersRep.get(i).getPropertyID() == id) {
                purchaseOrdersRep.remove(i);
            }
        }
    }

    /**
     * Checks if another Purchase Order already exists with the same Order amount
     * @param purchaseOrder Purchase Order
     * @return boolean
     */
    public boolean checkPurchaseOrderAmountExists(PurchaseOrder purchaseOrder) {
        for (PurchaseOrder order : purchaseOrdersRep) {
            if (purchaseOrder.getPropertyID() == order.getPropertyID()) {
                if (purchaseOrder.getOrderAmount() == order.getOrderAmount()) {
                    if (!purchaseOrder.getUserEmail().equalsIgnoreCase(order.getUserEmail())){
                        return true;
                    }
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
    public boolean checkUserPurchaseOrderExists (String email, int id){
        for (PurchaseOrder order : purchaseOrdersRep){
            if (order.getUserEmail().equalsIgnoreCase(email)){
                if (order.getPropertyID()==(id)){
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
        for (PurchaseOrder order : purchaseOrdersRep){
            if (order.getUserEmail().equalsIgnoreCase(email)){
                if (order.getPropertyID()==(id)){
                    return order;
                }
            }
        }
        return null;
    }

    public PurchaseOrder getPurchaseOrder(int i){return purchaseOrdersRep.get(i);}


    public List<PurchaseOrder> getPurchaseOrders(){return purchaseOrdersRep;}


    public int numberOfPurchaseOrders(){return purchaseOrdersRep.size();}

    public void sortByDescingOrderOfValue(List<PurchaseOrder> purchaseOrdersRep){
        Collections.sort(purchaseOrdersRep, Comparator.comparing(PurchaseOrder::getOrderAmount).reversed());

    }

}
```

## Class PurchaseOrder

```java
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
    public boolean equals(PurchaseOrder obj) {
        if (this.getUserEmail().equalsIgnoreCase(obj.getUserEmail())){
            if (this.getOrderAmount()==obj.getOrderAmount()){
                if (this.getPropertyID()== obj.getPropertyID()){
                    return true;
                }
            }
        }
        return false;
    }
}
```


# 6. Integration and Demo 

* None at the moment


# 7. Observations

None at the moment





