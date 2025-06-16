package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.ListingDealsController;
import pt.ipp.isep.dei.esoft.project.domain.PurchaseOrder;

import java.util.List;
import java.util.Scanner;

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
