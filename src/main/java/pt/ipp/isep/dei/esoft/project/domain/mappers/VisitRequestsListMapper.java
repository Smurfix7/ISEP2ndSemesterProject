package pt.ipp.isep.dei.esoft.project.domain.mappers;

import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;
import pt.ipp.isep.dei.esoft.project.domain.dtos.VisitRequestsListDTO;

import java.util.ArrayList;
import java.util.List;

public class VisitRequestsListMapper {

    /**
     * Create the Visit Requests List DTO
     * @param visitRequestsList
     * @param email
     * @return visitRequestsListDTO
     */
    public static List<VisitRequestsListDTO> createVisitRequestsListDTO(List<VisitRequest> visitRequestsList, String email) {

        List<VisitRequestsListDTO> visitRequestsListDTO = new ArrayList<>();

        for (VisitRequest obj : visitRequestsList) {
            if (obj.getAnnouncement().getRequest().getAgent().getEmailAddress().equalsIgnoreCase(email)) {
                VisitRequestsListDTO objDTO = new VisitRequestsListDTO(obj.getVisitRequestID(), obj.getUser(), obj.getAnnouncement(), obj.getDate(), obj.getTimeFrame());
                visitRequestsListDTO.add(objDTO);
            }
        }
        return visitRequestsListDTO;
    }
}
