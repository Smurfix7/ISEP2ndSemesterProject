package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.PropertyRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.RequestsRepository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Network implements Serializable {

    Serialization serialization = new Serialization();

    private static final String FILE_PATH_Agencies = "networkAgencies.ser";

    private static final String FILE_PATH_agency_names = "agencyNames.ser";

    // ATTRIBUTES
    private String networkName = "Real Estate USA";

    /**
     * List of all agencies associated with this network
     */
    public static List<Agency> agencies = new ArrayList<>();

    /**
     * List of agency names
     */
    public static List<String> agencyNames = new ArrayList<>();

    /**
     * Size of the repository
     */
    static int size = 0;


    // CONSTRUCTORS

    /**
     * This method creates the network object
     */
    public Network() {
        this.networkName = networkName;
    }

    public Network(String networkName) {
        this.networkName = networkName;
    }

    /**
     * Gets the last agencyID from the repository
     *
     * @return the role if it exists
     */
    public static int getLastAgencyID() {
        int agencyID = 0;
        for (int position = 0; position < agencies.size(); position++) {
            agencyID = Integer.parseInt(agencies.get(position).getAgencyID());
        }
        return agencyID;
    }

    // SETS AND GETS

    public String getNetworkName() {
        return networkName;
    }


    /**
     * Gets an agency from the repository
     *
     * @param agency to get
     * @return the agency if it exists
     */
    public Agency getAgency(Agency agency) {
        if (agencies.contains(agency)) {
            return agency;
        } else {
            return null;
        }
    }

    /**
     * Gets an agency from the repository
     *
     * @param id the agencyID of the agency to get
     * @return the agency if it exists
     */
    public Agency getAgencyByAgencyID(int id) {
        for (int i = 0; i < agencies.size(); i++) {
            if (agencies.get(i).getAgencyID() == Integer.toString(id)) {
                return agencies.get(i);
            }
        }
        return null;
    }

    /**
     * Gets an agency from the repository using its position
     *
     * @param n the postion of the agency to get
     * @return the agency if it exists
     */
    public Agency getAgency(int n) {
        if (agencies.contains(agencies.get(n))) {
            return agencies.get(n);
        } else {
            return null;
        }
    }

    /**
     * Adds an agency and agency name to the repository
     *
     * @param agency
     */
    public static void addLegacyAgency(Agency agency) {

        agencies.add(agency);

        agencyNames.add(checkIfAgencyNameExists(agency));
    }

    /**
     * Adds an agency and agency name to the repository
     *
     * @param agency
     */
    public static void addAgency(Agency agency) {

        if (checkIfAgencyExists(agency)) {
            agencies.add(agency);
        }
        agencyNames.add(checkIfAgencyNameExists(agency));
    }

    /**
     * Returns the size of the repository.
     *
     * @return size of the repository
     */
    public static int size() {
        return size;
    }

    public static String checkIfAgencyNameExists(Agency agency) {
        boolean exists = false;
        int num = 0;
        for (int position = 0; position < agencies.size(); position++) {
            if (agencies.get(position).getAgencyName() == agency.getAgencyName()) {
                exists = true;
                num = position;
            }
        }
        if (exists == true) {
            String newAgencyName = agencies.get(num).getAgencyName();
            return newAgencyName;
        } else {
            return agency.getAgencyName();
        }
    }

    public static boolean checkIfAgencyExists(Agency agency) {
        for (int position = 0; position < agencies.size(); position++) {
            if (agencies.get(position).equals(agency)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkIfAgencyExistsWithAddress(Address address) {
        for (int position = 0; position < agencies.size(); position++) {
            if (agencies.get(position).getAddress().equals(address)) {
                return true;
            }
        }
        return false;
    }

    public static Agency getAgencyWithAddress(Address address) {
        for (int position = 0; position < agencies.size(); position++) {
            if (agencies.get(position).getAddress().equals(address)) {
                return agencies.get(position);
            }
        }
        return null;
    }

    public List<Agency> getAgencies() {
        return agencies;
    }
    @SuppressWarnings("unchecked")
    public void saveNetworkAgencies() {
        serialization.toWrite((List<Object>) (List<?>) agencies, FILE_PATH_Agencies);
    }

    @SuppressWarnings("unchecked")
    public void loadNetworkAgencies() {
        this.agencies = (List<Agency>) (List<?>) serialization.toRead(FILE_PATH_Agencies);
        Agency.setCont(agencies.size());
    }

    @SuppressWarnings("unchecked")
    public void saveNetworkAgenciesNames() {
        serialization.toWrite((List<Object>) (List<?>) agencyNames, FILE_PATH_agency_names);
    }

    @SuppressWarnings("unchecked")
    public void loadNetworkAgenciesNames() {
        this.agencyNames = (List<String>) (List<?>) serialization.toRead(FILE_PATH_agency_names);
        Agency.setCont(agencies.size());
    }
    // TOSTRING
    @Override
    public String toString() {
        return "|Network : " + networkName + " |";
    }
}