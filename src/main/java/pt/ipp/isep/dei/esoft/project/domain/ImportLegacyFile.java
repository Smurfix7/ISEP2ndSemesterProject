package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.application.controller.ImportLegacyFileController;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ImportLegacyFile {
    private static final ImportLegacyFileController controller = new ImportLegacyFileController();
    private static List<String> propertyInfoList = new ArrayList<>();

    /**
     * Import a legacy file
     * @param filePath
     * @throws FileNotFoundException
     */
    public static void importLegacyFile(String filePath) throws FileNotFoundException {
        File legacyFile = new File(filePath);
        readLegacyFile(legacyFile);
    }

    /**
     * Read the legacy file
     * @param legacyFile
     * @throws FileNotFoundException
     */
    public static void readLegacyFile(File legacyFile) throws FileNotFoundException {
        Scanner legacyFileInput = new Scanner(legacyFile);
        legacyFileInput.nextLine();
        String propertyInfo;

        while (legacyFileInput.hasNextLine()) {
            propertyInfo = legacyFileInput.nextLine();
            fillPropertyInfoList(propertyInfo);

            switch (getPropertyType(propertyInfo)) {
                case "house":
                    readHouseInputFromLegacyFile();
                    break;
                case "land":
                    readLandInputFromLegacyFile();
                    break;
                case "apartment":
                    readApartmentInputFromLegacyFile();
                    break;
            }
            propertyInfoList.clear();
        }
    }

    /**
     * Get the property type
     * @param propertyInfo
     * @return
     */
    public static String getPropertyType(String propertyInfo) {
        String type = null;
        if (propertyInfo.contains("house")) {
            type = "house";
        } else if (propertyInfo.contains("land")) {
            type = "land";
        } else if (propertyInfo.contains("apartment")) {
            type = "apartment";
        }

        return type;
    }

    /**
     * Fill the property info list
     * @param propertyInfo
     */
    public static void fillPropertyInfoList(String propertyInfo) {
        propertyInfo = propertyInfo.substring(propertyInfo.indexOf(";") + 1, propertyInfo.length());
        propertyInfoList.addAll(Arrays.asList(propertyInfo.split(";")));
    }

    /**
     * Read the land information from the legacy file
     */
    public static void readLandInputFromLegacyFile() {
        String[] agencyLocation = propertyInfoList.get(26).split(",");
        Address agencyAddress = null;

        if (agencyLocation.length == 4) {
            agencyAddress = new Address(agencyLocation[0], agencyLocation[1], agencyLocation[2], agencyLocation[3]);
        } else if (agencyLocation.length == 5) {
            agencyAddress = new Address(agencyLocation[0], agencyLocation[1], agencyLocation[2], agencyLocation[3], agencyLocation[4]);
        }
        Agency agency = new Agency();
        if (Network.checkIfAgencyExistsWithAddress(agencyAddress) == true) {
            agency = new Agency(propertyInfoList.get(24), propertyInfoList.get(25), propertyInfoList.get(28), propertyInfoList.get(27), agencyAddress);
            Network.addLegacyAgency(agency);
        } else {
            agency = Network.getAgencyWithAddress(agencyAddress);
        }

        Employee agent = new Employee("Legacy Agent", "0000000", "legacy@realstateUSA.com", "0000000", new Address(), new Role("x", "Agent"), new PassportCard("0000000"), agency);
        Owner owner = new Owner(propertyInfoList.get(0), propertyInfoList.get(2), propertyInfoList.get(3), propertyInfoList.get(4), new Role("x", "Owner"), new PassportCard(propertyInfoList.get(1)));

        String[] propertyLocation = propertyInfoList.get(7).split(",");
        Address propertyAddress = null;
        if (propertyLocation.length == 4) {
            propertyAddress = new Address(agencyLocation[0], agencyLocation[1], agencyLocation[2], agencyLocation[3]);
        } else if (agencyLocation.length == 5) {
            propertyAddress = new Address(agencyLocation[0], agencyLocation[1], agencyLocation[2], agencyLocation[3], agencyLocation[4]);
        }

        Property land = new Property(propertyInfoList.get(5), Double.parseDouble(propertyInfoList.get(6)), Double.parseDouble(propertyInfoList.get(8)), propertyAddress);
        Transaction transaction = new Transaction("WHOLESALE", Double.parseDouble(propertyInfoList.get(17)));
        Request request = new Request(agent, owner, land, transaction, String.valueOf(propertyInfoList.get(22)));
        Announcement announcement = new Announcement(request, "PERCENTAGE", String.valueOf(propertyInfoList.get(22)), Double.parseDouble(propertyInfoList.get(19)));
        PurchaseOrder purchaseOrder = new PurchaseOrder(announcement, Double.parseDouble(propertyInfoList.get(18)));

        controller.addPurchaseOrder(purchaseOrder);
        controller.addLand(land);
        controller.addOwner(owner);
    }

    /**
     * Read the house information from the legacy file
     */
    public static void readHouseInputFromLegacyFile() {
        String[] agencyLocation = propertyInfoList.get(26).split(",");
        Address agencyAddress = null;

        if (agencyLocation.length == 4) {
            agencyAddress = new Address(agencyLocation[0], agencyLocation[1], agencyLocation[2], agencyLocation[3]);
        } else if (agencyLocation.length == 5) {
            agencyAddress = new Address(agencyLocation[0], agencyLocation[1], agencyLocation[2], agencyLocation[3], agencyLocation[4]);
        }
        Agency agency = new Agency();
        if (Network.checkIfAgencyExistsWithAddress(agencyAddress) == false) {
            agency = new Agency(propertyInfoList.get(24), propertyInfoList.get(25), propertyInfoList.get(28), propertyInfoList.get(27), agencyAddress);
            Network.addLegacyAgency(agency);
        } else {
            agency = Network.getAgencyWithAddress(agencyAddress);
        }
        Employee agent = new Employee("Legacy Agent", "0000000", "legacy@realstateUSA.com", "0000000", new Address(), new Role("x", "Agent"), new PassportCard("0000000"), agency);
        Owner owner = new Owner(propertyInfoList.get(0), propertyInfoList.get(2), propertyInfoList.get(3), propertyInfoList.get(4), new Role("x", "Owner"), new PassportCard(propertyInfoList.get(1)));

        String[] propertyLocation = propertyInfoList.get(7).split(",");
        Address propertyAddress = null;
        if (propertyLocation.length == 4) {
            propertyAddress = new Address(agencyLocation[0], agencyLocation[1], agencyLocation[2], agencyLocation[3]);
        } else if (agencyLocation.length == 5) {
            propertyAddress = new Address(agencyLocation[0], agencyLocation[1], agencyLocation[2], agencyLocation[3], agencyLocation[4]);
        }

        ArrayList<String> equipments = new ArrayList<>();

        if (propertyInfoList.get(12).toUpperCase().equals("Y")) {
            equipments.add("Central Heating");
        }

        if (propertyInfoList.get(13).toUpperCase().equals("Y")) {
            equipments.add("Air Conditioning");
        }

        House house = new House(propertyInfoList.get(5), Double.parseDouble(propertyInfoList.get(6)), Double.parseDouble(propertyInfoList.get(8)), propertyAddress, Integer.parseInt(propertyInfoList.get(9)), Integer.parseInt(propertyInfoList.get(10)), Integer.parseInt(propertyInfoList.get(11)), String.valueOf(propertyInfoList.get(14)), String.valueOf(propertyInfoList.get(15)), String.valueOf(propertyInfoList.get(16)), new Equipment(equipments));
        Transaction transaction = new Transaction("WHOLESALE", Double.parseDouble(propertyInfoList.get(17)));
        Request request = new Request(agent, owner, house, transaction, String.valueOf(propertyInfoList.get(22)));
        Announcement announcement = new Announcement(request, "PERCENTAGE", String.valueOf(propertyInfoList.get(22)), Double.parseDouble(propertyInfoList.get(19)));
        PurchaseOrder purchaseOrder = new PurchaseOrder(announcement, Double.parseDouble(propertyInfoList.get(18)));

        controller.addPurchaseOrder(purchaseOrder);
        controller.addHouse(house);
        controller.addOwner(owner);
    }

    /**
     * Read the apartment information from the legacy file
     */
    public static void readApartmentInputFromLegacyFile() {
        String[] agencyLocation = propertyInfoList.get(26).split(",");
        Address agencyAddress = null;

        if (agencyLocation.length == 4) {
            agencyAddress = new Address(agencyLocation[0], agencyLocation[1], agencyLocation[2], agencyLocation[3]);
        } else if (agencyLocation.length == 5) {
            agencyAddress = new Address(agencyLocation[0], agencyLocation[1], agencyLocation[2], agencyLocation[3], agencyLocation[4]);
        }

        Agency agency = new Agency();
        if (Network.checkIfAgencyExistsWithAddress(agencyAddress) == true) {
            agency = new Agency(propertyInfoList.get(24), propertyInfoList.get(25), propertyInfoList.get(28), propertyInfoList.get(27), agencyAddress);
            Network.addLegacyAgency(agency);
        } else {
            agency = Network.getAgencyWithAddress(agencyAddress);
        }
        Employee agent = new Employee("Legacy Agent", "0000000", "legacy@realstateUSA.com", "0000000", new Address(), new Role("x", "Agent"), new PassportCard("0000000"), agency);
        Owner owner = new Owner(propertyInfoList.get(0), propertyInfoList.get(2), propertyInfoList.get(3), propertyInfoList.get(4), new Role("x", "Owner"), new PassportCard(propertyInfoList.get(1)));

        String[] propertyLocation = propertyInfoList.get(7).split(",");
        Address propertyAddress = null;
        if (propertyLocation.length == 4) {
            propertyAddress = new Address(agencyLocation[0], agencyLocation[1], agencyLocation[2], agencyLocation[3]);
        } else if (agencyLocation.length == 5) {
            propertyAddress = new Address(agencyLocation[0], agencyLocation[1], agencyLocation[2], agencyLocation[3], agencyLocation[4]);
        }

        ArrayList<String> equipments = new ArrayList<>();

        if (propertyInfoList.get(12).toUpperCase().equals("Y")) {
            equipments.add("Central Heating");
        }

        if (propertyInfoList.get(13).toUpperCase().equals("Y")) {
            equipments.add("Air Conditioning");
        }

        Building apartment = new Building(propertyInfoList.get(5), Double.parseDouble(propertyInfoList.get(6)), Double.parseDouble(propertyInfoList.get(8)), propertyAddress, Integer.parseInt(propertyInfoList.get(9)), Integer.parseInt(propertyInfoList.get(10)), Integer.parseInt(propertyInfoList.get(11)), new Equipment(equipments));
        Transaction transaction = new Transaction("WHOLESALE", Double.parseDouble(propertyInfoList.get(17)));

        Request request = new Request(agent, owner, apartment, transaction, String.valueOf(propertyInfoList.get(22)));
        Announcement announcement = new Announcement(request, "PERCENTAGE", String.valueOf(propertyInfoList.get(22)), Double.parseDouble(propertyInfoList.get(19)));
        PurchaseOrder purchaseOrder = new PurchaseOrder(announcement, Double.parseDouble(propertyInfoList.get(18)));

        controller.addPurchaseOrder(purchaseOrder);
        controller.addApartment(apartment);
        controller.addOwner(owner);
    }
}