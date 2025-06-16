package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.ArrayList;
import java.util.List;


public class CreateListingController {
    public Agency agency = new Agency();
    Repositories repositories = Repositories.getInstance();
    AuthenticationRepository authenticationRepository = repositories.getAuthenticationRepository();
    PropertyTypeRepository type = repositories.getPropertyTypeRepository();

    RequestsRepository listingRequestsRepository = repositories.getRequestsRepository();
    private String message;

    public Request CreateRequest(String propertyType, Employee agent, Owner owner, double areaOfProperty, double distanceFromCentre, String acceptanceDate, String requestDate, String street,String city,String state,String zipCode, ArrayList<Photo> photos, String transactionType, double monetaryValue, int bedrooms, int bathrooms, int parkingSpaces, String basement, String loft, String sunExposure, Equipment equipment){

        Request request = agency.createRequest(propertyType, photos, owner,  equipment, agent,
                areaOfProperty, distanceFromCentre, requestDate, acceptanceDate, street, city, state, zipCode,
                bedrooms, bathrooms, parkingSpaces, basement, loft, sunExposure, transactionType, monetaryValue);
        return request;
    }
    public String[] getPropertyTypeList(){
        Repositories repositories = Repositories.getInstance();

        PropertyTypeRepository propertyTypeRepository = repositories.getPropertyTypeRepository();

        return propertyTypeRepository.getPropertyTypeList();

    }

    public void addRequestToList(Request request){
        listingRequestsRepository.addRequest(request);
    }

    public List<Employee> getCopyAgentList(){
        return EmployeeRepository.getAgentList();
    }

    public String getLoggedUser (){
        return authenticationRepository.getCurrentUserSession().getUserId().getEmail();
    }

    public Owner getOwnerWithEmail(String emailAddress){
        for (int i = 0; i < OwnerRepository.size(); i++) {
            if(OwnerRepository.getOwner(i).getEmailAddress().equalsIgnoreCase(emailAddress) ){
                return OwnerRepository.getOwner(i);
            }
        }
        return null;
    }


}
