package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.PurchaseOrder;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.PurchaseOrderRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.List;

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
