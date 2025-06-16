package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.AcceptPurchaseOrderController;

import java.util.Scanner;

public class AcceptPurchaseOrderUI implements Runnable {


    private Scanner read = new Scanner(System.in);
    private AcceptPurchaseOrderController controller = new AcceptPurchaseOrderController();
    private boolean answerValidation = false;

    /**
     * UI Run method.
     */

    @Override
    public void run() {
            System.out.println("===== Accept a Purchase Order =====");
            displayAnnouncements();
            System.out.println("===== / =====");
            do {
                int propertyID = requestPropertyID();
                if (controller.checkPropertyID(propertyID)){
                    answerValidation=true;
                    displayPurchaseOrders(propertyID);
                    controller.acceptPurchaseOrder(controller.getPurchaseOrderByPurchaseID(requestPurchaseOrder()));
                    System.out.println("Succefully accepted the purchase order.");
                } else if (propertyID == 0) {
                    answerValidation=true;
                } else {
                    System.out.println("Invalid ID. Try a valid Property ID.");
                }
            }while(!answerValidation);

    }

    public void displayAnnouncements () {
        for (int i = 0; i < controller.getCopyAnnouncementsList().size(); i++) {

                System.out.println(controller.getCopyAnnouncementsList().get(i));

        }
    }

    /**
     * Requests the PropertyID
     * @return int
     */
    private int requestPropertyID() {
        System.out.println("\nSelect the property ID number (#___) you wish to see the list of purchase orders (0 -> cancel):");
        return read.nextInt();
    }


    public void displayPurchaseOrders(int answer){
        System.out.println("PROPERTY CHOOSEN:");
        System.out.println(controller.getAnnouncementWithID(answer));
        System.out.println();
        System.out.println("Purchase Orders:");
        for (int i = 0; i < controller.getCopyPurchaseOrderList().size(); i++) {
            if(controller.getCopyPurchaseOrderList().get(i).getAnnouncement().getAnnouncementID() == answer){
                System.out.println(controller.getCopyPurchaseOrderList().get(i));
            }
        }
    }

    private int requestPurchaseOrder(){
        System.out.println("\nSelect the the purchase ID number (#___):");
        int answer = read.nextInt();
        return answer;
    }


}
