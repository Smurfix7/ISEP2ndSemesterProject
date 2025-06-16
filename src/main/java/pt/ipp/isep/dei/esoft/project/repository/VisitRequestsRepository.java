package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Serialization;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;
import pt.ipp.isep.dei.esoft.project.domain.dtos.VisitRequestsListDTO;

import java.util.ArrayList;
import java.util.List;

public class VisitRequestsRepository {
    private static final String FILE_PATH = "VisitRequestRepository.ser";

    private static final String FILE_PATH1 = "AcceptedVisitRequestRepository.ser";
    Serialization serialization = new Serialization();

    /**
     * List of visit requests that were accepted.
     */
    static List<VisitRequest> visitRequestsAccepted = new ArrayList<>();

    /**
     * List of visit requests.
     */
    static List<VisitRequest> visitRequestList = new ArrayList<>();


    public static List<VisitRequest> getVisitRequests() {
        return visitRequestList;
    }

    public static List<VisitRequest> getVisitRequestsAccepted() {
        return visitRequestsAccepted;
    }

    /**
     * Gets a visit request from the repository.
     *
     * @param visitRequest the visit request to get
     * @return the visitRequest if it exists in the repository, null otherwise
     */
    public VisitRequest getVisitRequested(VisitRequest visitRequest) {
        if (visitRequestList.contains(visitRequest)) {
            return visitRequest;
        } else {
            return null;
        }
    }


    public static VisitRequest getVisitRequestedByID(String visitRequestID) {
        VisitRequest visitRequest = null;
        if (checkIfVisitRequestIDExists(visitRequestID)) {
            for (int pos = 0; pos < visitRequestList.size(); pos++) {
                if (visitRequestList.get(pos).getVisitRequestID() == visitRequestID) {
                    visitRequest = visitRequestList.get(pos);
                }
            }
        }
        return visitRequest;
    }

    /**
     * Adds a visit request to the repository.
     *
     * @param visitRequest the visit request to add
     */
    public static void addVisitRequested(VisitRequest visitRequest) {
        visitRequestList.add(visitRequest);
    }

    /**
     * Removes a visit request to the repository.
     *
     * @param visitRequest the visit request to remove
     */
    public static void removeVisitRequest(VisitRequest visitRequest) {
        visitRequestList.remove(visitRequest);
    }

    public static VisitRequest getVisitRequest(int n) {
        return visitRequestList.get(n);
    }

    /**
     * Gets a visit request that was accepted from the repository.
     *
     * @param visitRequest the visit accepted to get
     * @return the visitRequest if it exists in the repository, null otherwise
     */
    public VisitRequest getVisitRequestAccepted(VisitRequest visitRequest) {
        if (visitRequestsAccepted.contains(visitRequest)) {
            return visitRequest;
        } else {
            return null;
        }
    }

    /**
     * Adds a visit request that was accepted to the repository.
     *
     * @param visitRequest the visit request that was accepted to add
     */
    public static void addVisitRequestAccepted(VisitRequest visitRequest) {
        visitRequestsAccepted.add(visitRequest);
    }

    /**
     * Removes a visit request that was accepted to the repository.
     *
     * @param visitRequest the visit request that was accepted to remove
     */
    public static void removeVisitRequestAccepted(VisitRequest visitRequest) {
        visitRequestsAccepted.remove(visitRequest);
    }

    /**
     * Check if the visit request id exists
     * @param visitRequestID
     * @return boolean
     */
    public static boolean checkIfVisitRequestIDExists(String visitRequestID) {
        boolean exists = false;
        for (int pos = 0; pos < visitRequestList.size(); pos++) {
            if (visitRequestList.get(pos).getVisitRequestID() == visitRequestID) {
                exists = true;
            }
        }
        return exists;
    }

    /**
     * Filter de Visit Requests List DTO with the begin and end date
     * @param beginDate
     * @param endDate
     * @param visitRequestsListDTO
     * @return
     */
    public static List<VisitRequestsListDTO> filterVisitRequestsListDTO(String beginDate, String endDate, List<VisitRequestsListDTO> visitRequestsListDTO) {
        String[] date = endDate.split("-");
        int endDay = Integer.parseInt(date[0]);
        int endMonth = Integer.parseInt(date[1]);
        int endYear = Integer.parseInt(date[2]);

        date = beginDate.split("-");
        int beginDay = Integer.parseInt(date[0]);
        int beginMonth = Integer.parseInt(date[1]);
        int beginYear = Integer.parseInt(date[2]);

        List<VisitRequestsListDTO> filteredList = new ArrayList<>();


        for (int position = 0; position < visitRequestsListDTO.size(); position++) {
            date = visitRequestsListDTO.get(position).getDate().split("-");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);

            if (year > endYear || year < beginYear){
                continue;
            }

            if (year == beginYear) {
                if (month < beginMonth) {
                    continue;
                }
            }

            if (year == endYear) {
                if (month > endMonth) {
                    continue;
                }
            }

            if (year == endYear){
                if (month == endMonth){
                    if (day > endDay){
                        continue;
                    }
                }
            }

            if (year == beginYear){
                if (month == beginMonth){
                    if (day < beginDay){
                        continue;
                    }
                }
            }

            filteredList.add(visitRequestsListDTO.get(position));
        }
        return filteredList ;
    }


    @SuppressWarnings("unchecked")
    public void saveVisitRequestRepository() {
        serialization.toWrite((List<Object>) (List<?>) visitRequestList, FILE_PATH);
    }

    @SuppressWarnings("unchecked")
    public void loadVisitRequestRepository() {
        this.visitRequestList = (List<VisitRequest>) (List<?>) serialization.toRead(FILE_PATH);
    }

    @SuppressWarnings("unchecked")
    public void saveVisitRequestAcceptedRepository() {
        serialization.toWrite((List<Object>) (List<?>) visitRequestsAccepted, FILE_PATH1);
    }

    @SuppressWarnings("unchecked")
    public void loadVisitRequestAcceptedRepository() {
        this.visitRequestsAccepted = (List<VisitRequest>) (List<?>) serialization.toRead(FILE_PATH1);
        VisitRequest.setCont(visitRequestList.size());
    }

}
