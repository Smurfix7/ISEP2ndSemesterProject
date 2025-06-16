package pt.ipp.isep.dei.esoft.project.domain.dtos;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.User;

public class VisitRequestsListDTO {
    private String id;
    private User user;
    private Announcement announcement;
    private String date;
    private String timeFrame;

    /**
     * This method creates the Visit Requests List DTO object
     * @param id
     * @param user
     * @param announcement
     * @param date
     * @param timeFrame
     */
    public VisitRequestsListDTO(String id, User user, Announcement announcement, String date, String timeFrame) {
        this.id = id;
        this.user = user;
        this.announcement = announcement;
        this.date = date;
        this.timeFrame = timeFrame;
    }

    /**
     * This method returns the date of Visit Requests List DTO
     *
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * This method returns the property id of Visit Requests List DTO
     *
     * @return propertyID
     */
    public int getPropertyID() {
        return announcement.getRequest().getProperty().getPropertyID();
    }

    /**
     * This method returns the id of Visit Requests List DTO
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return  "\n"
                + "--> Visit Request #" + id + " <--"
                + "\n| Property: #" + getPropertyID()
                + "\n| Client: " + user.getName()
                + "\n| Telephone Number : " + user.getTelephoneNumber()
                + "\n| Date: " + date
                + "\n| Time Frame: " + timeFrame
                + "\n";
    }
}
