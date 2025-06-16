package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.PurchaseOrder;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.PurchaseOrderRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.List;

public class AcceptPurchaseOrderController {

    public Agency agency = new Agency();
    Repositories repositories = Repositories.getInstance();
    AuthenticationRepository authenticationRepository = repositories.getAuthenticationRepository();

    PurchaseOrderRepository purchaseOrderRepository = repositories.getPurchaseOrderRepository();

    AnnouncementRepository announcementRepository = repositories.getAnnouncementRepository();



    /**
     * Create an Announcement List Copy
     * @return List<Property></Property>
     */
    public List<Announcement> getCopyAnnouncementsList(){
        AnnouncementRepository announcementRepository = repositories.getAnnouncementRepository();

        return announcementRepository.getAnnouncements();}
    public List<PurchaseOrder> getCopyPurchaseOrderList(){return purchaseOrderRepository.getPurchaseOrdersRequested();}

    public PurchaseOrder getCopyPurchaseOrder(int n){return purchaseOrderRepository.getPurchaseOrdersRequested().get(n);}
    public PurchaseOrder getPurchaseOrderByPurchaseID(int n){
        for (int i = 0; i < purchaseOrderRepository.getPurchaseOrdersRequested().size(); i++) {
            if(purchaseOrderRepository.getPurchaseOrdersRequested().get(i).getPurchaseOrderID()==n){
                return purchaseOrderRepository.getPurchaseOrdersRequested().get(i);
            }
        }
        return null;
    }

    public void acceptPurchaseOrder(PurchaseOrder purchaseOrder){
        purchaseOrderRepository.acceptPurchaseOrder(purchaseOrder);
        purchaseOrderRepository.removeAllPurchaseOrdersByPropertyID(purchaseOrder.getAnnouncement().getAnnouncementID());
        announcementRepository.removeAnnouncement(purchaseOrder.getAnnouncement());
    }

    public String getLoggedUser (){
        return authenticationRepository.getCurrentUserSession().getUserId().getEmail();
    }

    public boolean checkPropertyID(int answer) {
        for (int i = 0; i < getCopyAnnouncementsList().size(); i++) {
            if (getCopyAnnouncementsList().get(i).getRequest().getProperty().getPropertyID() == answer) {

                    return true;

            }
        }

        return false;
    }

    public Announcement getAnnouncementWithID(int n){
        AnnouncementRepository announcementRepository = repositories.getAnnouncementRepository();
        return announcementRepository.getAnnouncementWithID(n);
    }

}
