package pt.ipp.isep.dei.esoft.project.application.controller;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.domain.PurchaseOrder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AcceptPurchaseOrderControllerTest {}

    /** PurchaseOrderTBARepository purchaseOrderTBARepository = new PurchaseOrderTBARepository();
    PurchaseOrderARepository purchaseOrderARepository = new PurchaseOrderARepository();
    AcceptPurchaseOrderController controller = new AcceptPurchaseOrderController();

    /**
     * Checks if it's possible to get a copy of the Announcement Repository
     */
    /** @Test
    /**   void getCopyAnnouncementsList() {
        Property property = new Property();
        //Announcements.addAnnouncement(property);
        List<Property> test = controller.getCopyAnnouncementsList();
        assertEquals(test.size(), Announcements.getAnnouncements().size());
        assertEquals(test.get(0), Announcements.getAnnouncements().get(0));
    }

    /**
     * Checks if it's possible to get a copy of the PurchaseOrder Repository
     */
    /** @Test
    void getCopyPurchaseOrderList() {
            PurchaseOrder purchaseOrder = new PurchaseOrder();
            purchaseOrderTBARepository.addPurchaseOrder(purchaseOrder);
            List <PurchaseOrder> test = controller.getCopyPurchaseOrderList();
            assertEquals(test.size(),purchaseOrderTBARepository.getPurchaseOrders().size());
            assertEquals(test.get(0),purchaseOrderTBARepository.getPurchaseOrders().get(0));
    }
    /**
     * Checks if it's possible to get a purchase order using its index
     */
    /** @Test
    void getCopyPurchaseOrder() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrderTBARepository.addPurchaseOrder(purchaseOrder);
        assertEquals(purchaseOrder, controller.getCopyPurchaseOrder(0));
    }
    /**
     * Checks if it's possible to get a purchase order using its purchaseOrderID
     */
    /**@Test
    void getPurchaseOrderByPurchaseID() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrderTBARepository.addPurchaseOrder(purchaseOrder);
        assertEquals(purchaseOrder, controller.getPurchaseOrderByPurchaseID(1));
    }
    /**
     * Checks if it's possible to accept a purchase order
     */
/** @Test
    void acceptPurchaseOrder() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrderARepository.addPurchaseOrder(purchaseOrder);
        controller.getCopyPurchaseOrderList().contains(purchaseOrder);
    }
}*/