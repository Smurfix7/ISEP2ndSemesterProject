package pt.ipp.isep.dei.esoft.project.application.controller;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Property;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreatePurchaseOrderControllerTest {
    CreatePurchaseOrderController controller = new CreatePurchaseOrderController();



    /**
     * Checks if the AnnouncementID exists in the Announcement Repository
     */
    @Test
    void checkAnnouncement() {
        Property property = new Property();
//        Announcements.addPropertyAnnouncement(property);
//        Announcements.addPropertyAnnouncement(property);
//        Announcements.addPropertyAnnouncement(property);

        int test=0;
        if (controller.checkAnnouncement(2)) {
            test=1;
        }
        assertEquals(1,test);
    }

    /**
     * Checks if the Purchase Order Amount already exists in the Purchase Order Repository
     */
    @Test
    void checkPurchaseOrderAmountExists() {
        /*
        PurchaseOrder purchaseOrder1 = new PurchaseOrder("test",1,100);
        PurchaseOrder purchaseOrder2 = new PurchaseOrder("test2",1,100);
        purchaseOrderTBARepository.addPurchaseOrder(purchaseOrder1);

        int test=0;
        if (controller.checkPurchaseOrderAmountExists(purchaseOrder2)){
            test=1;
        }
        assertEquals(1,test);
        */

    }

    /**
     * Checks if it's possible to get a copy of the Announcement Repository
     */
    @Test
    void getCopyAnnouncementsList() {/*
        Property property = new Property();
        //Announcements.addPropertyAnnouncement(property);
        List <Property> test = controller.getCopyAnnouncementsList();
        assertEquals(test.size(), Announcements.getAnnouncements().size());
        assertEquals(test.get(0), Announcements.getAnnouncements().get(0));*/
    }

    /**
     * Checks if it's possible to create a Purchase Order
     */
    @Test
    void createPurchaseOrder() {/*
        PurchaseOrder purchaseOrder1 = new PurchaseOrder("test",1,100);
        controller.createPurchaseOrder("test",1,100);

        int test=0;
        if (purchaseOrder1.equals(purchaseOrderTBARepository.getPurchaseOrder(0))){
            test=1;
        }
        assertEquals(1,test);

        */
    }

    /**
     * Checks if the User already submited a Purchase Order for that propertyID.
     */
    @Test
    void checkUserPurchaseOrderExists() {
        /*
        PurchaseOrder purchaseOrder1 = new PurchaseOrder("test",1,100);
        purchaseOrderTBARepository.addPurchaseOrder(purchaseOrder1);

        int test=0;
        if (controller.checkUserPurchaseOrderExists("test", 1)){
            test=1;
        }
        assertEquals(1,test);

        */
    }

    /**
     * Checks if it's possible to get a purchase order from the repository by the email and ID.
     */
    @Test
    void getPurchaseOrder() {

        /*
        PurchaseOrder purchaseOrder1 = new PurchaseOrder("test",1,100);
        purchaseOrderTBARepository.addPurchaseOrder(purchaseOrder1);

        int test=0;
        if (controller.getPurchaseOrder("test",1).equals(purchaseOrderTBARepository.getPurchaseOrder(0))){
            test=1;
        }
        assertEquals(1,test);
        */

    }
}