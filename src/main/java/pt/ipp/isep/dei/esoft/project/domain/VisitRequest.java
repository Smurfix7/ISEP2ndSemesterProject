package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;

import pt.ipp.isep.dei.esoft.project.repository.VisitRequestsRepository;

public class VisitRequest implements Serializable {

    // ATTRIBUTES
    private String id;
    private User user;
    private Announcement announcement;
    private String date;
    private String timeFrame;
    private static int cont = 0;
    private final User USER_BY_DEFAULT = null;
    private final Announcement PROPERTY_BY_DEFAULT = null;
    private final String DATE_BY_DEFAULT = "[NO DATA]";
    private final String TIME_FRAME_BY_DEFAULT = "[NO DATA]";

    // CONSTRUCTORS

    /**
     * Create the VisitRequest object with default attributes
     */
    public VisitRequest() {
        this.user = USER_BY_DEFAULT;
        this.announcement = PROPERTY_BY_DEFAULT;
        this.date = DATE_BY_DEFAULT;
        this.timeFrame = TIME_FRAME_BY_DEFAULT;
    }

    /**
     * Create the VisitRequest object
     * @param name
     * @param emailAddress
     * @param password
     * @param telephoneNumber
     * @param announcement
     * @param date
     * @param timeFrame
     */
    public VisitRequest(String name, String emailAddress, String password, String telephoneNumber, Announcement announcement, String date, String timeFrame) {
        cont++;
        this.id = String.valueOf(cont);
        this.user = new User(name, emailAddress, password, telephoneNumber);
        this.announcement = announcement;
        this.date = date;
        this.timeFrame = timeFrame;
    }

    // SETS AND GETS

    /**
     * This method changes the id of the Visit Request
     *
     * @param id
     */
    public void setVisitRequestID(String id) {
        this.id = id;
    }

    /**
     * This method returns the id of the Visit Request
     *
     * @return
     */
    public String getVisitRequestID() {
        return id;
    }

    /**
     * This method changes the user of the Visit Request
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * This method returns the user of the Visit Request
     *
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * This method changes the id of the Agency
     *
     * @param announcement
     */
    public void setAnnouncement(Announcement announcement) {
        this.announcement = announcement;
    }

    /**
     * This method returns the id of the Agency
     *
     * @return announcement
     */
    public Announcement getAnnouncement() {
        return announcement;
    }

    /**
     * This method changes the id of the Agency
     *
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * This method returns the id of the Agency
     *
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * This method changes the id of the Agency
     *
     * @param timeFrame
     */
    public void setTimeFrame(String timeFrame) {
        this.timeFrame = timeFrame;
    }

    /**
     * This method returns the id of the Agency
     *
     * @return timeFrame
     */
    public String getTimeFrame() {
        return timeFrame;
    }

    /**
     * This method changes the ID of the Visit Request
     *
     * @param n
     */
    public static void setCont(int n) {
        cont = n;
    }

    @Override
    public String toString() {
        return "| Visit Request -> Name: " + user.getName() + " | Telephone Number : " + user.getTelephoneNumber() + " | Date: " + date + " | Time Frame: " + timeFrame;
    }
}
