package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.time.LocalDate;

public class Announcement implements Serializable {
    private static int cont = 0;
    private Request request;
    private int announcementID;
    private String acceptanceDate;
    private Commission commission;

    // Default constructor
    public Announcement() {
    }

    // Constructor with all attributes
    public Announcement(Request request, String commissionType, double commissionValue) {
        this.request = request;
        cont++;
        this.announcementID = cont;
        this.acceptanceDate = String.valueOf(LocalDate.now());
        this.commission = new Commission(commissionType, commissionValue);
    }

    public Announcement(Request request, String commissionType,String acceptanceDate, double commissionValue) {
        this.request = request;
        cont++;
        this.announcementID = cont;
        this.acceptanceDate = acceptanceDate;
        this.commission = new Commission(commissionType, commissionValue);
    }

    // Getter and Setter for Request
    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    // Getter and Setter for announcementID
    public int getAnnouncementID() {
        return announcementID;
    }

    public void setAnnouncementID(int announcementID) {
        this.announcementID = announcementID;
    }

    // Getter and Setter for acceptanceDate
    public String getAcceptanceDate() {
        return acceptanceDate;
    }

    public void setAcceptanceDate(String acceptanceDate) {
        this.acceptanceDate = acceptanceDate;
    }

    // Getter and Setter for CommissionDetails
    public Commission getCommission() {
        return commission;
    }

    public void setCommission(Commission commission) {
        this.commission = commission;
    }

    public static void setCont(int n) {
        cont = n;
    }
    @Override
    public String toString() {
        return "  | Announcement: #" + announcementID
                + "| Announcement of request: " + request +
                ", acceptanceDate:'" + acceptanceDate + '\'' +
                ", commission:" + commission.toString();
    }
}

