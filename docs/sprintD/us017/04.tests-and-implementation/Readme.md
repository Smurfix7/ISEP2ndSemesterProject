# US 007 - To Register in the System 

# 4. Tests 

## ListingDealsController

**Test 1:** Tests if its possible to get a copy of the PurchaseOrderAccepted Repository and the content is the same.

    @Test
    void getPurchaseOrdersAccepted() {
    }

**Test 2:** Tests if the controller can ask to sort the List and get the copy created.

    @Test
    void sortListBubble() {
    }

**Test 3:** Tests if the controller can ask to sort the List and get the copy created.

    @Test
    void sortListSelection() {
    }

**Test 4:** Tests if its possible to get a specific Announcement by only their ID.

    @Test
    void getAnnouncementWithID() {
    }

# 5. Construction (Implementation)


## Class ListingDealsUI 

```java
public class ListingDealsUI implements Runnable {

    private ListingDealsController controller = new ListingDealsController();
    private Scanner read = new Scanner(System.in);
    private int selectedAlgorithm = 3;

    /**
     * UI Run Method.
     */
    @Override
    public void run() {
        displayDealsList(controller.getPurchaseOrdersAccepted(), selectedAlgorithm);
        do {
            selectedAlgorithm = requestSortingAlg();
            if (selectedAlgorithm == 1) {
                displayDealsList(controller.sortListBubble(requestSortingDirection()), selectedAlgorithm);
            } else if (selectedAlgorithm == 2) {
                displayDealsList(controller.sortListSelection(requestSortingDirection()), selectedAlgorithm);
            }
        } while (selectedAlgorithm != 0);
    }

    /**
     * Displays the Deals List
     *
     * @param purchaseOrdersAccepted List<PurchaseOrder></PurchaseOrder>
     * @param selectedAlgorithm        int
     */
    private void displayDealsList(List<PurchaseOrder> purchaseOrdersAccepted, int selectedAlgorithm) {
        System.out.println("\n======= List of all the deals =======\n");
        if (selectedAlgorithm == 3) {
            //Sorted by Most Recent
            if (purchaseOrdersAccepted.size() != 0) {
                for (int i = purchaseOrdersAccepted.size() - 1; i >= 0; i--) {
                    System.out.println(purchaseOrdersAccepted.get(i));
                }
            } else {
                System.out.println("No Deals Made.");
            }
        } else {
            //Sorted by an Algorithm
            if (purchaseOrdersAccepted.size() != 0) {
                for (int i = 0; i < purchaseOrdersAccepted.size(); i++) {
                    System.out.println(purchaseOrdersAccepted.get(i));
                }
            } else {
                System.out.println("No Deals Made.");
            }
        }
        System.out.println("\n=====================================\n");
    }

    /**
     * Requests the Sorting Algorithm for the User
     *
     * @return int
     */
    public int requestSortingAlg() {
        System.out.println("Select the sorting algorithm (0|1|2):");
        System.out.println("1. Bubble Sorting");
        System.out.println("2. Selection Sorting");
        System.out.println("0. Return");
        int answer = read.nextInt();
        while (answer != 1 && answer != 2 && answer != 0) {
            System.out.println("Invalid Algorithm Selected. Please try again.");
            answer = read.nextInt();
        }
        return answer;
    }

    /**
     * Requests the Sorting Direction
     *
     * @return int
     */
    public int requestSortingDirection() {
        System.out.println("Select the sorting direction (1|2):");
        System.out.println("1. Ascending");
        System.out.println("2. Descending");
        int answer = read.nextInt();
        while (answer != 1 && answer != 2) {
            System.out.println("Invalid Algorithm Selected. Please try again.");
            answer = read.nextInt();
        }
        return answer;
    }
}

```

## Class ListingDealsController

```java
public class ListingDealsController {
    public Agency agency = new Agency();
    private final Repositories repositories = Repositories.getInstance();
    AnnouncementRepository announcementRepository = repositories.getAnnouncementRepository();

    PurchaseOrderRepository purchaseOrderRepository = repositories.getPurchaseOrderRepository();

    /**
     * Gets the Accepted PurchaseOrder List from the Repository
     * @return List
     */
    public List<PurchaseOrder> getPurchaseOrdersAccepted() {
        return purchaseOrderRepository.getPurchaseOrdersAccepted();
    }

    /**
     * Asks the repository to create a copy of the list sorted by the
     * bubble algorithm
     *
     * @param sortingDirection int
     * @return List
     */
    public List<PurchaseOrder> sortListBubble(int sortingDirection) {
        return purchaseOrderRepository.sortDealsListBubble(sortingDirection);
    }

    /**
     * Asks the repository to create a copy of the list sorted by the
     * selection algorithm
     *
     * @param sortingDirection int
     * @return List
     */
    public List<PurchaseOrder> sortListSelection(int sortingDirection) {
        return purchaseOrderRepository.sortDealsListSelection(sortingDirection);
    }

    /**
     * Gets a property from the Announcements Repository through their ID
     * @param propertyID int
     * @return Property
     */
    public Announcement getAnnouncementWithID(int propertyID) {
        return announcementRepository.getAnnouncementWithID(propertyID);
    }

}
```

# 6. Integration and Demo 

* None at the moment


# 7. Observations





