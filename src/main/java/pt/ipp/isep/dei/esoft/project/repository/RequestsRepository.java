package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.domain.Request;
import pt.ipp.isep.dei.esoft.project.domain.Serialization;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;

import java.util.ArrayList;
import java.util.List;

public class RequestsRepository {

    private static final String FILE_PATH = "RequestRepository.ser";
    Serialization serialization = new Serialization();

    List<Request> listingRequests = new ArrayList<>();

    /**
     * Get the list of all property requests made
     *
     * @return List<Request> purchaseOrders
     */
    public ArrayList<Request> getListingRequests() {
        return (ArrayList<Request>) listingRequests;
    }

    public boolean validateRequest(Request request){
        return (!listingRequests.contains(request));
    }
    /**
     * Gets a announcement from the arrayList by their number in the list.
     * @param n position in the list
     * @return the announcement
     */
    public Request getRequestWithID(int n) {
        Request requestInQuestion = null;
        for (int i = 0; i < listingRequests.size(); i++) {
            if(listingRequests.get(i).getRequestID()==n){
                requestInQuestion = listingRequests.get(i);
                return requestInQuestion;
            }
        }
        throw new IllegalArgumentException("No request found with that ID");
    }

    public int getNumberOfRequests(){return listingRequests.size();}

    public boolean containsProperty(Property property){return listingRequests.contains(property);}

    public boolean checkRequestExists (int propertyID){
        for (Request request : listingRequests) {
            if (request.getProperty().getPropertyID() == propertyID) {
                return true;
            }
        }
        return false;
    }

    public boolean sortRequestList(){
        if(listingRequests.size()>1){
            for (int i = 0; i < getNumberOfRequests(); i++) {
                String date1 = listingRequests.get(i).getRequestDate();


                for (int j = i; j < getNumberOfRequests(); j++) {
                    String date2 = listingRequests.get(j).getRequestDate();
                    if(date1.compareTo(date2) >0){
                        swapRequests(i, j);
                        date1= date2;

                    }
                }
            }
        }
        return true;
    }

    public void swapRequests(int n1, int n2){
        Request temp = listingRequests.get(n1);
        listingRequests.set(n1, listingRequests.get(n2));
        listingRequests.set(n2, temp);
    }

    public ArrayList<Request> getRequestListByEmail(String email){
        ArrayList<Request> requests = new ArrayList<>();
        for (int i = 0; i < getNumberOfRequests(); i++) {
            if(email.equals(listingRequests.get(i).getAgent().getEmailAddress()))
                requests.add(listingRequests.get(i));

        }
        return requests;
    }

    public void deleteRequest(Request request) {
        listingRequests.remove(request);
    }

    /**
     * Gets a listing request from the repository.
     *
     * @param request the listing request to get
     * @return the listing request if it exists in the repository, null otherwise
     */
    public Request getRequest(Request request) {
        if (listingRequests.contains(request)) {
            return request;
        } else {
            return null;
        }
    }

    /**
     * Adds a property request to the list of all property requests.
     *
     * @param request the request to add
     */
    public boolean addRequest(Request request) {
        if(validateRequest(request)){
            listingRequests.add(request);
            return  true;
        }else {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public void saveRepository() {
        serialization.toWrite((List<Object>) (List<?>) listingRequests, FILE_PATH);
    }

    @SuppressWarnings("unchecked")
    public void loadRepository() {
        this.listingRequests = (List<Request>) (List<?>) serialization.toRead(FILE_PATH);
        Request.setCont(listingRequests.size());
    }
}
