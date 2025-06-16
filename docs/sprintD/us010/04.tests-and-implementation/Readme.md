# US 010 - Order to Purchase a Property 

# 4. Tests 

## Class CreatePurchaseOrderController

**Test 1:** Checks if the AnnouncementID exists in the Announcement Repository.

    @Test
    void checkPurchaseOrderExists() {

    }

**Test 2:** Checks if the Purchase Order Amount already exists in the Purchase Order Repository.

    @Test
    void checkPurchaseOrderAmountExists() {

    }

**Test 3:** Checks if it's possible to get a copy of the Announcement Repository.

    @Test
    void getCopyAnnouncementsList() {
        
    }

**Test 4:** Checks if it's possible to create a Purchase Order

    @Test
    void createPurchaseOrder() {
       
    }

**Test 5:** Checks if the User already submited a Purchase Order for that propertyID.

    @Test
    void checkUserPurchaseOrderExists() {
        
    }

**Test 6:** Checks if it's possible to get a purchase order from the repository by the email and ID.

    @Test
    void getPurchaseOrder() {
        
    }

# 5. Construction (Implementation)


## Class CreatePurchaseOrderController 

```java
public class CreatePurchaseOrderController {
    public Agency agency = new Agency();

    private final Repositories repositories = Repositories.getInstance();
    AnnouncementRepository announcementRepository = repositories.getAnnouncementRepository();

    PurchaseOrderRepository purchaseOrderRepository = repositories.getPurchaseOrderRepository();

    AuthenticationRepository authenticationRepository = repositories.getAuthenticationRepository();



    /**
     * Check if the announcement exists in the repository
     * @param announcementNumber int
     * @return boolean
     */
    public boolean checkAnnouncement (int announcementNumber){
        return announcementRepository.checkAnnouncementExists(announcementNumber);
    }

    /**
     * Checks if another Purchase Order already exists with the same Order amount
     * @param purchaseOrder Purchase Order
     * @return boolean
     */
    public boolean checkPurchaseOrderAmountExists(PurchaseOrder purchaseOrder){
        return purchaseOrderRepository.checkPurchaseOrderAmountExists(purchaseOrder);
    }

    /**
     * Create an Announcement List Copy
     * @return List<Property></Property>
     */

    public List<Announcement> getCopyAnnouncementsList(){
        return announcementRepository.getAnnouncements();
    }

    /**
     * Create a PurchaseOrder object
     * @param userEmail String
     * @param propertyID int
     * @param orderAmount double
     * @return PurchaseOrder
     */
    public PurchaseOrder createPurchaseOrder(String userEmail, int propertyID, double orderAmount){
        PurchaseOrder purchaseOrder= new PurchaseOrder(userEmail,announcementRepository.getAnnouncementWithID(propertyID),orderAmount);
        purchaseOrderRepository.getPurchaseOrdersRequested().add(purchaseOrder);
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
        return purchaseOrderRepository.checkUserPurchaseOrderExists(email,id);
    }

    /**
     * Get a PurchaseOrder by the email and ID
     * @param email String
     * @param id int
     * @return PurchaseOrder
     */
    public PurchaseOrder getPurchaseOrder(String email, int id){
        return purchaseOrderRepository.getPurchaseOrderRequested(email,id);
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
                            System.out.println("The order amount submitted has already been posted for this property. \nPlease contact the agent that is responsible for this property.");
                        }
                    } else {
                        System.out.println("You already submitted a purchase order for this property." +
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


# 6. Integration and Demo 

* None at the moment


# 7. Observations

None at the moment





