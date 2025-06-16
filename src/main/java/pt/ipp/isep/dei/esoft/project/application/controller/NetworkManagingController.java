package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Network;
import pt.ipp.isep.dei.esoft.project.repository.PurchaseOrderRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.ArrayList;
import java.util.List;

public class NetworkManagingController {

    public Agency agency = new Agency();

    public Network network = new Network();
    Repositories repositories = Repositories.getInstance();
    public List<Integer> agenciesAndPurchaseDeals = new ArrayList<>();

    PurchaseOrderRepository purchaseOrderRepository = repositories.getPurchaseOrderRepository();

    /**
     * Gets all purchase orders from all agencies
     * @return List<Integer></Integer>
     */
    public List<Integer> getAllAgenciesPurchaseDeals(){

        for (int i = 0; i < network.getAgencies().size(); i++) {
           agenciesAndPurchaseDeals.add(purchaseOrderRepository.countAllPurchaseDealsFromAgency(purchaseOrderRepository.getPurchaseOrdersAccepted().get(i).getAnnouncement().getRequest().getAgent().getAgency()));
        }
        return agenciesAndPurchaseDeals;

    }

    /**
     * Get a specific Agency Purchase Deal
     * @param n int
     * @return int
     */
    public int getAgenciesPurchaseDeal(int n){
        return agenciesAndPurchaseDeals.get(n);
    }

    /**
     * Copies the contents from the list1 to the list2
     * @param list1 List<Integer></Integer>
     * @param list2 List<Integer></Integer>
     */
    public static void copyAllcontents(List<Integer> list1, List<Integer> list2) {
        if(list2.size()==0){
            list2.addAll(list1);
        }else {
            for (int i = 0; i < list1.size(); i++) {
                list2.set(i, list1.get(i));
            }
        }
    }

    /**
     * Transforms the decimal number into binary
     * @param decimal int
     * @param listSize int
     * @return String
     */
    public static String decimalToBinary(int decimal, int listSize) {
        String binary = Integer.toBinaryString(decimal);
        return padZeros(binary, listSize);
    }

    /**
     * Adds the remaining 0s to the binary number
     * @param binary String
     * @param listSize int
     * @return String
     */
    private static String padZeros(String binary, int listSize) {
        if (binary.length() >= listSize) {
            return binary;
        }

        int zeroCount = listSize - binary.length();
        StringBuilder paddedBuilder = new StringBuilder();
        paddedBuilder.append("0".repeat(zeroCount));
        paddedBuilder.append(binary);

        return paddedBuilder.toString();
    }

    /**
     * Count all the Purchase Deals made
     * @param list List<Integer></Integer>
     * @return int
     */
    public static int countAllPurchaseDeals(List<Integer> list){
        int cont = 0;
        for (int i = 0; i < list.size(); i++) {
            cont = cont + list.get(i);
        }
        return cont;
    }

    /**
     * Returns difference based on the binary number given to it
     * @param list1 List<Integer></Integer>
     * @param list2 List<Intenger></Intenger>
     * @param binaryNumber String
     * @return int
     */
    public static int test(List<Integer> list1, List<Integer> list2, String binaryNumber) {
        for (int i = 0; i < binaryNumber.length(); i++) {
            char digit = binaryNumber.charAt(i);
            if (digit == '0') {
                list2.set(i, 0);
            } else {
                list1.set(i, 0);
            }
        }
        int difference = countAllPurchaseDeals(list1) - countAllPurchaseDeals(list2);
        if (difference < 0) {
            return -difference;
        } else {
            return difference;
        }
    }

    /**
     * Returns difference based on the binary number given to it for every number
     * @param list1 List<Intenger></Intenger>
     * @param list2 List<Integer></Integer>
     * @param agenciesPurchaseDeals List<Integer></Integer>
     * @param answers List<String></String>
     */
    public static void testForEveryNumber(List<Integer> list1, List<Integer> list2, List<Integer> agenciesPurchaseDeals, List<String> answers) {
        int difference = test(list1, list2, decimalToBinary(0, agenciesPurchaseDeals.size()));
        String binaryOrganization = null;
        int limite = getPowerOfTwo(agenciesPurchaseDeals.size());
        for (int i = 0; i < limite; i++) {
            if (test(list1, list2, decimalToBinary(i, agenciesPurchaseDeals.size())) < difference) {
                difference = test(list1, list2, decimalToBinary(i, agenciesPurchaseDeals.size()));
                binaryOrganization = decimalToBinary(i, agenciesPurchaseDeals.size());
            }
            copyAllcontents(agenciesPurchaseDeals, list1);
            copyAllcontents(agenciesPurchaseDeals, list2);
        }
        copyAllcontents(agenciesPurchaseDeals, list1);
        copyAllcontents(agenciesPurchaseDeals, list2);
        answers.add(binaryOrganization);
        answers.add(Integer.toString(difference));
    }

    /**
     * Organizes the List
     * @param list1 List<Integer></Integer>
     * @param list2 List<Integer></Integer>
     * @param binaryOrganization String
     */
    public static void organizeList(List<Integer> list1, List<Integer> list2, String binaryOrganization) {
        for (int i = 0; i < binaryOrganization.length(); i++) {
            char digit = binaryOrganization.charAt(i);
            if (digit == '0') {
                list2.set(i, 0);
            } else {
                list1.set(i, 0);
            }
        }
    }

    /**
     * Gets upper limit of the number interval depending on the list size.
     * @param listSize int
     * @return int
     */
    public static int getPowerOfTwo(int listSize) {
        int n = 2;
        if (listSize == 0) {
            return 0;
        } else if (listSize == 1) {
            return 2;
        } else {
            for (int i = 0; i < listSize-1; i++) {
                n = n * 2;
            }
            return n;
        }
    }
}


