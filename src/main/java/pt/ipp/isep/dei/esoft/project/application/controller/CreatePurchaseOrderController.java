package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.List;

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
