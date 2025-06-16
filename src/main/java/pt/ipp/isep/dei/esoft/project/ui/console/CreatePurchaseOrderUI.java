package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.CreatePurchaseOrderController;
import pt.ipp.isep.dei.esoft.project.domain.PurchaseOrder;

import java.util.Scanner;

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
                int announcementID = requestAnnouncementID();
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
    private int requestAnnouncementID() {
        System.out.println("\nSelect the the Announcement ID number (#___) you wish to create a purchase order (0 -> cancel):");
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
