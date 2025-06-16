package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.repository.PropertyTypeRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.ArrayList;
import java.util.List;

public class CreateAnnouncementController {
    private Agency agency = new Agency();
    Repositories repositories = Repositories.getInstance();

    PropertyTypeRepository type = repositories.getPropertyTypeRepository();
    private String message;

    public Announcement CreateAnnouncement(String propertyType, Employee agent, Person owner, double areaOfProperty, double distanceFromCentre, String acceptanceDate, String requestDate, String street,String city,String state,String zipCode, ArrayList<Photo> photos, String transactionType, double monetaryValue, int bedrooms, int bathrooms, int parkingSpaces, String basement, String loft, String sunExposure, Equipment equipment, String commissionType, double commissionValue){
        Request request = agency.createRequest(propertyType, photos, owner, equipment, agent,
                areaOfProperty, distanceFromCentre, requestDate, acceptanceDate, street, city, state, zipCode,
                bedrooms, bathrooms, parkingSpaces, basement, loft, sunExposure, transactionType, monetaryValue);
        Announcement announcement = agency.createAnnouncement(request, commissionType, commissionValue);

        String ownerPhoneNumber = announcement.getRequest().getOwner().getTelephoneNumber();
        message = "To: " + ownerPhoneNumber + "\n The announcement for your property was created!";
        Message notif = new Notification();
        notif.sendMessage(message);


        return announcement;
    }


    public List<Employee> getCopyAgentList(){
        return EmployeeRepository.getAgentList();
    }

    public String[] getPropertyTypeList(){
        Repositories repositories = Repositories.getInstance();

        PropertyTypeRepository propertyTypeRepository = repositories.getPropertyTypeRepository();

        return propertyTypeRepository.getPropertyTypeList();

    }

}
