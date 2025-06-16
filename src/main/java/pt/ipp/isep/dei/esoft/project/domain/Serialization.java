package pt.ipp.isep.dei.esoft.project.domain;

import org.apache.commons.math3.distribution.FDistribution;
import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;
import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.apache.commons.math3.distribution.FDistribution;
import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;
import org.apache.commons.math3.stat.regression.RegressionResults;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serialization {
    private static String FOLDER = "serialization/";

    public static void saveData() {
        Repositories repositories= Repositories.getInstance();

        AnnouncementRepository announcementRepository = repositories.getAnnouncementRepository();
        EmployeeRepository employeeRepository = repositories.getAgentRepository();
        OwnerRepository ownerRepository = repositories.getOwnerRepository();
        PersonRepository personRepository = repositories.getPersonRepository();
        PropertyRepository propertyRepository = repositories.getPropertyRepository();
        PurchaseOrderRepository purchaseOrderRepository = repositories.getPurchaseOrderRepository();
        RequestsRepository requestsRepository = repositories.getRequestsRepository();
        VisitRequestsRepository visitRequestsRepository = repositories.getVisitRequestsRepository();
        Network network = new Network();

        announcementRepository.saveRepository();
        employeeRepository.saveAgentRepository();
        employeeRepository.saveNetworkRepository();
        employeeRepository.saveStoreRepository();
        ownerRepository.saveRepository();
        personRepository.saveRepository();
        propertyRepository.saveRepository();
        purchaseOrderRepository.saveOrdersRepository();
        purchaseOrderRepository.saveOrdersAcceptedRepository();
        purchaseOrderRepository.saveOrdersRequestedRepository();
        requestsRepository.saveRepository();
        visitRequestsRepository.saveVisitRequestAcceptedRepository();
        visitRequestsRepository.saveVisitRequestRepository();
        network.saveNetworkAgenciesNames();
        network.saveNetworkAgencies();
    }

    public static void loadData() {
        getAbsolutePath();
        Repositories repositories= Repositories.getInstance();

        AnnouncementRepository announcementRepository = repositories.getAnnouncementRepository();
        EmployeeRepository employeeRepository = repositories.getAgentRepository();
        OwnerRepository ownerRepository = repositories.getOwnerRepository();
        PersonRepository personRepository = repositories.getPersonRepository();
        PropertyRepository propertyRepository = repositories.getPropertyRepository();
        PurchaseOrderRepository purchaseOrderRepository = repositories.getPurchaseOrderRepository();
        RequestsRepository requestsRepository = repositories.getRequestsRepository();
        VisitRequestsRepository visitRequestsRepository = repositories.getVisitRequestsRepository();
        Network network = new Network();

        announcementRepository.loadAnnouncementRepository();
        employeeRepository.loadAgentRepository();
        employeeRepository.loadNetworkRepository();
        employeeRepository.loadStoreRepository();
        ownerRepository.loadRepository();
        personRepository.loadRepository();
        propertyRepository.loadRepository();
        purchaseOrderRepository.loadOrdersRepository();
        purchaseOrderRepository.loadOrdersRequestedRepository();
        purchaseOrderRepository.loadOrdersAcceptedRepository();
        requestsRepository.loadRepository();
        visitRequestsRepository.loadVisitRequestAcceptedRepository();
        visitRequestsRepository.loadVisitRequestRepository();
        network.loadNetworkAgencies();
        network.loadNetworkAgenciesNames();
    }

    public void toWrite(List<Object> list, String file) {
        try {
            File serialFile = new File(FOLDER + file);
            if (!serialFile.exists())
                mkFile(serialFile);
            try {
                PrintWriter pw = new PrintWriter(serialFile);
                pw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FOLDER + file));
            try {
                out.writeObject(list);
            } finally {
                out.close();
            }
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Object> toRead(String file) {
        File serialFile = new File(FOLDER + file);
        if (serialFile.exists()) {
            List<Object> objects;
            try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(FOLDER + file));
                try {
                    objects = (List<Object>) in.readObject();
                } finally {
                    in.close();
                }
                return objects;

            }
            catch (EOFException e){
                return new ArrayList<>();
            }catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return new ArrayList<>();
        } else {
            try {
                mkFile(serialFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return new ArrayList<>();
        }
    }

    private void mkFile(File serialFile) throws IOException {
        File fldr = new File(FOLDER);
        if (fldr.exists())
            serialFile.createNewFile();
        else {
            fldr.mkdir();
            serialFile.createNewFile();
        }
    }

    private static void getAbsolutePath() {
        // Get the absolute path of the JAR file
        String jarPath = Serialization.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        try {
            // Decode the URL-encoded path
            String decodedPath = java.net.URLDecoder.decode(jarPath, "UTF-8");
            // Get the parent directory of the JAR file
            File jarFile = new File(decodedPath);
            String parentPath = jarFile.getParent();
            // Construct and return the absolute file path
            FOLDER = parentPath + File.separator + FOLDER;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}

