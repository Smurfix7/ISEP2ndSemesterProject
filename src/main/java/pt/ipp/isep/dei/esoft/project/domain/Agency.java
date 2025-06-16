package pt.ipp.isep.dei.esoft.project.domain;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// teste
public class Agency implements Serializable {
    private static int cont =0;
    // ATTRIBUTES
    private static Network network;
    private String agencyID;
    private String agencyName;
    private String emailAddress;
    private String contactTelephoneNumber;
    private Address address;
    private static final Network NETWORK_BY_DEFAULT = new Network("Real Estate USA");
    private final String AGENCYID_BY_DEFAULT = "[NO DATA]";
    private final String AGENCY_NAME_BY_DEFAULT = "[NO DATA]";
    private final String EMAIL_ADDRESS_BY_DEFAULT = "[NO DATA]";
    private final String CONTACT_TELEPHONE_NUMBER_BY_DEFAULT = "[NO DATA]";
    private final Address ADDRESS_BY_DEFAULT = null;

    // CONSTRUCTORS

    /**
     * This method creates the Agency object with default attributes
     */
    public Agency() {
        this.network = NETWORK_BY_DEFAULT;
        this.agencyID = "0";
        this.agencyName = AGENCY_NAME_BY_DEFAULT;
        this.emailAddress = EMAIL_ADDRESS_BY_DEFAULT;
        this.contactTelephoneNumber = CONTACT_TELEPHONE_NUMBER_BY_DEFAULT;
        this.address = ADDRESS_BY_DEFAULT;
    }

    /**
     * This method creates the Agency object
     *
     * @param agencyName
     * @param emailAddress
     * @param contactTelephoneNumber
     * @param adress
     */
    public Agency(String agencyName, String emailAddress, String contactTelephoneNumber, Address adress) {
        this.network = NETWORK_BY_DEFAULT;
        cont++;
        this.agencyID = String.valueOf(cont);
        this.agencyName = agencyName;
        this.emailAddress = emailAddress;
        this.contactTelephoneNumber = contactTelephoneNumber;
        this.address = adress;
    }

    /**
     * This method creates the Agency object
     *
     * @param agencyName
     * @param emailAddress
     * @param contactTelephoneNumber
     * @param adress
     */
    public Agency(String agencyID, String agencyName, String emailAddress, String contactTelephoneNumber, Address adress) {
        this.network = NETWORK_BY_DEFAULT;
        this.agencyID = agencyID;
        this.agencyName = agencyName;
        this.emailAddress = emailAddress;
        this.contactTelephoneNumber = contactTelephoneNumber;
        this.address = adress;
    }

    public static Request createRequest(String propertyType, ArrayList<Photo> photos, Person owner,
                                        Equipment equipment, Employee agent, double areaOfProperty, double distanceFromCentre,
                                        String requestDate, String acceptanceDate, String street, String city,
                                        String state, String zipCode, int bedrooms, int bathrooms, int parkingSpaces,
                                        String basement, String loft, String sunExposure, String transactionType,
                                        double monetaryValue) {

        Repositories repositories = Repositories.getInstance();
        RequestsRepository requestsRepository = repositories.getRequestsRepository();
        PropertyRepository propertyRepository = repositories.getPropertyRepository();
        String message = "";
        Address address = new Address(street, city, state, zipCode);
        Transaction transaction = new Transaction(transactionType, monetaryValue);
        Request request = new Request(agent,owner,null, transaction);
        Property property = null;
        switch (propertyType.toUpperCase()){
            case "HOUSE":
                property = new House(propertyType, areaOfProperty, distanceFromCentre, address, photos, bedrooms, bathrooms, parkingSpaces, basement, loft, sunExposure, equipment);
                request.setProperty(property);

                if(requestsRepository.addRequest(request)){
                    message = "Request added!";
                }else{
                    message = "Request already exists!";
                }

                break;

            case "LAND":
                property = new Property(propertyType,areaOfProperty, distanceFromCentre, address, photos);
                request.setProperty(property);
                if(requestsRepository.addRequest(request)){
                    message = "Request added!";
                }else{
                    message = "Request already exists!";
                }
                break;
            case "APARTMENT":
                property = new Building(propertyType, areaOfProperty, distanceFromCentre, address, photos, bedrooms, bathrooms, parkingSpaces, equipment);
                request.setProperty(property);
                if(requestsRepository.addRequest(request)){
                    message = "Request added!";
                }else{
                    message = "Request already exists!";
                }

                break;
        }
        propertyRepository.addProperty(property);
        return request;
    }


    // SETS AND GETS



    /**
     * This method returns the network of the Agency
     *
     * @return
     */
    public Network getNetwork() {
        return network;
    }

    /**
     * This method returns the id of the Agency
     *
     * @return
     */
    public String getAgencyID() {
        return agencyID;
    }

    /**
     * This method changes the id of the Agency
     *
     * @param agencyID
     */
    public void setAgencyID(String agencyID) {
        this.agencyID = agencyID;
    }

    /**
     * This method returns the name of the Agency
     *
     * @return
     */
    public String getAgencyName() {
        return agencyName;
    }

    /**
     * This method changes the name of the Agency
     *
     * @param agencyName
     */
    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    /**
     * This method returns the emailAddress of the Agency
     *
     * @return
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * This method changes the emailAddress of the Agency
     *
     * @param emailAddress
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * This method returns the contactTelephoneNumber of the Agency
     *
     * @return
     */
    public String getContactTelephoneNumber() {
        return contactTelephoneNumber;
    }

    /**
     * This method changes the contactTelephoneNumber of the Agency
     *
     * @param
     */
    public void setContactTelephoneNumber(String contactTelephoneNumber) {
        this.contactTelephoneNumber = contactTelephoneNumber;
    }

    /**
     * This method returns the address of the Agency
     *
     * @return
     */

    public Address getAddress() {
        return address;
    }

    /**
     * This method changes the address of the Agency
     *
     * @param address
     */
    public void setAddress(Address address) {
        this.address = address;
    }


    // TOSTRING

    /**
     * This method returns the characteristics of the Agency
     *
     * @return
     */
    @Override
    public String toString() {
        return "Agency ID: " + agencyID + " | Agency Name: " + agencyName + " | Email Address: " + emailAddress + " | Telephone Number: " + contactTelephoneNumber + " | " + address.toString();
    }

    // OTHER METHODS



    public static Announcement createAnnouncement(Request request, String commissionType, double commissionValue) {
        Announcement announcement = new Announcement(request, commissionType, commissionValue);
        Repositories repositories = Repositories.getInstance();
        AnnouncementRepository announcementRepository = repositories.getAnnouncementRepository();
        RequestsRepository requestsRepository = repositories.getRequestsRepository();
        announcementRepository.addAnnouncement(announcement);
        requestsRepository.deleteRequest(request);
        return announcement;
    }

    public static void setCont(int cont) {
        Agency.cont = cont;
    }
}