package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.io.Serializable;
import java.util.List;

public class PurchaseOrder implements Serializable {
    private static int cont = 0;
    private Announcement announcement;
    private String userEmail;
    private double orderAmount;
    private int acceptance;
    private int purchaseOrderID;

    private final String USER_EMAIL_DEFAULT = "[NO EMAIL]";

    private final double ORDER_AMOUNT_DEFAULT = 0;

    /**
     * Purchase Order Constructors with the default settings
     */
    public PurchaseOrder() {
        this.userEmail = USER_EMAIL_DEFAULT;
        this.announcement = new Announcement();
        this.orderAmount = ORDER_AMOUNT_DEFAULT;
        this.acceptance = 0;
        cont++;
        this.purchaseOrderID = cont;
    }

    /**
     * Purchase Order Constructors with chosen atributes
     *
     * @param userEmail   String
     * @param announcement Announcement
     * @param orderAmount double
     */
    public PurchaseOrder(String userEmail, Announcement announcement, double orderAmount) {
        this.userEmail = userEmail;
        this.announcement = announcement;
        this.orderAmount = orderAmount;
        this.acceptance = 0;
        cont++;
        this.purchaseOrderID = cont;
    }

    /**
     * Purchase Order Constructors with chosen atributes
     *
     * @param announcement Announcement
     * @param orderAmount double
     */
    public PurchaseOrder(Announcement announcement, double orderAmount) {
        this.userEmail = USER_EMAIL_DEFAULT;
        this.announcement = announcement;
        this.orderAmount = orderAmount;
        this.acceptance = 0;
        cont++;
        this.purchaseOrderID = cont;
    }


    /**
     * Get the Purchase Order Amount
     *
     * @return double
     */
    public double getOrderAmount() {
        return orderAmount;
    }

    /**
     * Get the Purchase Order PropertyID
     *
     * @return int
     */
    public Announcement getAnnouncement() {
        return announcement;
    }

    /**
     * Get the Purchase Order User Email
     *
     * @return String
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Get the Purchase Order Acceptance State
     *
     * @return int
     */
    public int getAcceptance() {
        return acceptance;
    }

    /**
     * Change the acceptance state
     *
     * @param acceptance int: Declined (-1), To be reviewed (0), Accepted (1).
     */
    public void setAcceptance(int acceptance) {
        this.acceptance = acceptance;
    }

    /**
     * Change the order amount
     *
     * @param orderAmount double
     */
    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * Change the property ID
     *
     * @param announcement int
     */
    public void setAnnouncement(Announcement announcement) {
        this.announcement = announcement;
    }

    /**
     * Change the User Email
     *
     * @param userEmail String
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * Gets the PurchaseOrderID
     *
     * @return int
     */
    public int getPurchaseOrderID() {
        return purchaseOrderID;
    }

    /**
     * Gets the AreaOfProperty from the propertyID of the PurchaseOrder
     *
     * @return double
     */
    public double getAreaOfProperty() {
        return this.announcement.getRequest().getProperty().getAreaOfProperty();
    }

    /**
     * Gets a purchase order from the purchase order repository.
     *
     * @param purchaseOrder the purchase order to get
     * @param purchaseOrderList the type of list that was selected
     * @return the purchase order if it exists in the repository, null otherwise
     */
    public PurchaseOrder getPurchaseOrderFromList (PurchaseOrder purchaseOrder, List<PurchaseOrder> purchaseOrderList) {
        if (purchaseOrderList.contains(purchaseOrder)) {
            return purchaseOrder;
        } else {
            return null;
        }
    }

    /**
     * Purchase Order information
     *
     * @return String
     */
    @Override
    public String toString() {
        if (acceptance == -1) {
            return "#" + purchaseOrderID + " Purchase Order: " + "\n  | User/Email: " + userEmail + " | Order Amount: " + orderAmount + " | Acceptance State: Denied" +
                    "\n"+ announcement;
        } else if (acceptance == 0) {
            return "#" + purchaseOrderID + " Purchase Order: " + "\n  | User/Email: " + userEmail + " | Order Amount: " + orderAmount + " | Acceptance State: To be review."+
                    "\n"+ announcement;
        } else {
            return "#" + purchaseOrderID + " Purchase Order: " + "\n  | User/Email: " + userEmail + " | Order Amount: " + orderAmount + " | Acceptance State: Accepted."+
                    "\n"+ announcement;
        }
    }

    /**
     * Compares if the contents of the PurchaseOrder Object is the same as another PurchaseOrder Object
     *
     * @param obj PurchaseOrder
     * @return boolean
     */
    public boolean equals(PurchaseOrder obj) {
        if (this.getUserEmail().equalsIgnoreCase(obj.getUserEmail())) {
            if (this.getOrderAmount() == obj.getOrderAmount()) {
                if (this.getAnnouncement() == obj.getAnnouncement()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void setCont(int n) {
        cont = n;
    }
}

