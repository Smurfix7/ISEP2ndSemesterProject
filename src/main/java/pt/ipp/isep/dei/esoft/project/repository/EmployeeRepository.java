package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Serialization;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements Serializable {
    private static final String FILE_PATH_A = "EmployeeRepository.ser";
    private static final String FILE_PATH_N = "NetworkRepository.ser";
    private static final String FILE_PATH_S = "StoreRepository.ser";
    Serialization serialization = new Serialization();

    /**
     * List of agents
     */
    public static List<Employee> agents = new ArrayList<>();

    /**
     * List of store managers
     */
    public static List<Employee> store_managers = new ArrayList<>();

    /**
     * List of network managers
     */
    public static List<Employee> network_managers = new ArrayList<>();

    /**
     * Size of the repository
     */
    static int size = 0;

    /**
     * Gets an agent from the repository
     *
     * @param agent to get
     * @return the agent if it exists
     */
    public Employee getAgent(Employee agent) {
        if (agents.contains(agent)) {
            return agent;
        } else {
            return null;
        }
    }

    /**
     * Adds an agent to the repository
     *
     * @param agent
     */
    public static void addAgent(Employee agent) {
        agents.add(agent);
        size++;
    }

    /**
     * Adds an agent to the repository
     *
     * @param storeManager
     */
    public static void addStoreManager(Employee storeManager) {
        store_managers.add(storeManager);
        size++;
    }

    /**
     * Adds an agent to the repository
     *
     * @param networkManager
     */
    public static void addNetworkManager(Employee networkManager) {
        network_managers.add(networkManager);
        size++;
    }

    public static Employee getAgentByEmail(String email) {
        Employee agent = new Employee();
        for (int i = 0; i < agents.size(); i++) {
            if (agents.get(i).getEmailAddress().equals(email)) {
                agent = agents.get(i);
            }
        }
        return agent;
    }

    /**
     * Returns the size of the repository.
     *
     * @return size of the repository
     */
    public static int size() {
        return size;
    }


    @SuppressWarnings("unchecked")
    public void saveAgentRepository() {
        serialization.toWrite((List<Object>) (List<?>) agents, FILE_PATH_A);
    }

    @SuppressWarnings("unchecked")
    public void loadAgentRepository() {
        this.agents = (List<Employee>) (List<?>) serialization.toRead(FILE_PATH_A);
    }


    @SuppressWarnings("unchecked")
    public void saveNetworkRepository() {
        serialization.toWrite((List<Object>) (List<?>) network_managers, FILE_PATH_N);
    }

    @SuppressWarnings("unchecked")
    public void loadNetworkRepository() {
        this.network_managers = (List<Employee>) (List<?>) serialization.toRead(FILE_PATH_N);
    }

    @SuppressWarnings("unchecked")
    public void saveStoreRepository() {
        serialization.toWrite((List<Object>) (List<?>) store_managers, FILE_PATH_S);
    }

    @SuppressWarnings("unchecked")
    public void loadStoreRepository() {
        this.network_managers = (List<Employee>) (List<?>) serialization.toRead(FILE_PATH_S);
    }


    public static List<Employee> getAgentList() {
        return new ArrayList<Employee>(agents);
    }
}
