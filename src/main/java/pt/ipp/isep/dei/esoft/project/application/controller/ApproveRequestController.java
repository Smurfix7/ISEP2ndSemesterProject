package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Notification;
import pt.ipp.isep.dei.esoft.project.domain.Request;
import pt.ipp.isep.dei.esoft.project.domain.dtos.RequestDto;
import pt.ipp.isep.dei.esoft.project.domain.mappers.RequestMapper;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.RequestsRepository;

import java.util.ArrayList;

public class ApproveRequestController {

    /**
     * returns the email of the user currently logged in
     *
     * @return
     */

    public static String getLoggedUser(){

        Repositories repositories = Repositories.getInstance();
        AuthenticationRepository authenticationRepository = repositories.getAuthenticationRepository();
        return authenticationRepository.getCurrentUserSession().getUserId().getEmail();
    }

    /**
     * sorts the request list
     */

    public ArrayList<RequestDto> sortRequests(String email){
        Repositories repositories = Repositories.getInstance();
        RequestsRepository requestsRepository = repositories.getRequestsRepository();
        boolean flag = requestsRepository.sortRequestList();
        if(flag){
            return RequestMapper.toDto(requestsRepository.getRequestListByEmail(email));
        }else{
            return null;
        }

    }

    /**
     * converts the list of requests to display to a Dto
     *
     * @param email
     * @return
     */


    /**
     * Accepts or rejects the property requests depending on the user input
     *
     * @param propertyID
     * @param acceptance
     * @param commissionType
     * @param commissionValue
     * @param justificationMessage
     * @return
     */

    public String judgePropertyRequest(int propertyID, String acceptance, String commissionType, double commissionValue, String justificationMessage) {
        Repositories repositories = Repositories.getInstance();
        RequestsRepository requestsRepository = repositories.getRequestsRepository();
        Request request = requestsRepository.getRequestWithID(propertyID);
        String message = null;
        if(acceptance.toUpperCase().equals("N")){
            Notification notification = new Notification();
            justificationMessage = "To: " + requestsRepository.getRequestWithID(propertyID).getOwner().getTelephoneNumber() + "\n" +justificationMessage;
            notification.sendMessage(justificationMessage);
            requestsRepository.deleteRequest(request);
            message = "Request Rejected!";
        } else if (acceptance.toUpperCase().equals("Y")) {
            Agency.createAnnouncement(request, commissionType, commissionValue);
            message = "Request Accepted!";

        }
        return message;
    }
}
