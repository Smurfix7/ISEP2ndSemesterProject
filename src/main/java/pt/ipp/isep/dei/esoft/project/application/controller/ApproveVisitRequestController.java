package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.domain.dtos.VisitRequestsListDTO;
import pt.ipp.isep.dei.esoft.project.domain.mappers.VisitRequestsListMapper;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.VisitRequestsRepository;

import java.util.List;

public class ApproveVisitRequestController {
    private static final Repositories repositories = Repositories.getInstance();
    AuthenticationRepository authenticationRepository = repositories.getAuthenticationRepository();
    VisitRequestsRepository visitRequestsRepository = repositories.getVisitRequestsRepository();
    private List<VisitRequest> visitRequestsList = visitRequestsRepository.getVisitRequests();

    /**
     * Returns the name of the agent currently logged in.
     *
     * @return the name of the logged-in agent
     */
    public String getLoggedAgent() {
        return authenticationRepository.getCurrentUserSession().getUserName();
    }

    /**
     * Converts the visit requests list to a list of VisitRequestsListDTO objects.
     *
     * @return the list of VisitRequestsListDTO objects
     */
    public List<VisitRequestsListDTO> toVisitRequestsListDTO() {
        if (authenticationRepository.getCurrentUserSession().getUserId() == null) {
            return VisitRequestsListMapper.createVisitRequestsListDTO(visitRequestsList, "agent@this.app");
        }
        return VisitRequestsListMapper.createVisitRequestsListDTO(visitRequestsList, authenticationRepository.getCurrentUserSession().getUserId().getEmail());
    }

    /**
     * Filters the visit requests list by dates.
     *
     * @param beginDate            the start date for filtering
     * @param endDate              the end date for filtering
     * @param visitRequestsListDTO the list of VisitRequestsListDTO objects to filter
     * @return the filtered list of VisitRequestsListDTO objects
     */
    public List<VisitRequestsListDTO> sendDates(String beginDate, String endDate, List<VisitRequestsListDTO> visitRequestsListDTO) {
        return VisitRequestsRepository.filterVisitRequestsListDTO(beginDate, endDate, visitRequestsListDTO);
    }

    /**
     * Sends the selected sorting algorithm to the sorting algorithm configuration reader.
     *
     * @param algorithm the name of the sorting algorithm to retrieve
     * @return the sorting algorithm
     */
    public String sendAlgorithm(String algorithm) {
        return ConfigReaderSortingAlgorithms.getSortingAlgorithm("src/main/resources/config.sorting_algorithms", algorithm);
    }

    /**
     * Sorts the visit requests list using the specified sorting algorithm.
     *
     * @param visitRequestsListDTO the list of VisitRequestsListDTO objects to sort
     * @param algorithm            the name of the sorting algorithm to use
     * @return the sorted list of VisitRequestsListDTO objects
     */
    public List<VisitRequestsListDTO> sortVisitRequestsList(List<VisitRequestsListDTO> visitRequestsListDTO, String algorithm) {
        if (sendAlgorithm(algorithm).equalsIgnoreCase("bubble_algorithm")) {
            SortingAlgorithms.bubbleSort(visitRequestsListDTO);
        } else {
            SortingAlgorithms.insertionSort(visitRequestsListDTO);
        }
        return visitRequestsListDTO;
    }

    /**
     * Judges a visit request by an agent.
     *
     * @param agentName     the name of the agent judging the visit request
     * @param visitRequest  the visit request to judge
     * @param acceptance    the acceptance status of the visit request
     * @param justification the justification for the judgment
     * @return the result of the judgment
     */
    public String judgeVisitRequest(String agentName, VisitRequest visitRequest, boolean acceptance, String justification) {
        return JudgeVisitRequest.judgeVisitRequest(agentName, visitRequest, acceptance, justification);
    }

    /**
     * Retrieves a visit request by its ID.
     *
     * @param valueOf the ID of the visit request
     * @return the visit request with the specified ID
     */
    public VisitRequest getVisitRequestedByID(String valueOf) {
        return visitRequestsRepository.getVisitRequestedByID(valueOf);
    }
}