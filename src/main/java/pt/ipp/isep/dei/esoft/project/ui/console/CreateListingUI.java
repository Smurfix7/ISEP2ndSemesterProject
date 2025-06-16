package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.CreateListingController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateListingUI implements Runnable {
    Scanner read = new Scanner(System.in);
    private String propertyType;
    private ArrayList<Photo> photos;
    private Owner owner;
    private Equipment equipment;
    private Employee agent;
    private double areaOfProperty;
    private double distanceFromCentre;
    private String requestDate;
    private String acceptanceDate;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private int bedrooms;
    private int bathrooms;
    private int parkingSpaces;
    private String basement;
    private String loft;
    private String sunExposure;
    private String transactionType;
    private double monetaryValue;
    private final CreateListingController controller = new CreateListingController();
    List<Employee> agentsCopyList = new ArrayList<>(controller.getCopyAgentList());

    @Override
    public void run() {
        System.out.println("Select a Property Type to create a Listing Request:");

        String[] list = controller.getPropertyTypeList();
        System.out.println();
        displayList(list);

        propertyType = read.nextLine();

        switch (propertyType.toUpperCase()) {
            default:
                System.out.println("Invalid Property Type, try again...");
                System.out.println("Select a Property Type (In Writing) to create a Listing Request");
                propertyType = read.nextLine();
            case "LAND":
                requestDataLand();
                break;
            case "APARTMENT":
                requestDataApartment();
                break;
            case "HOUSE":
                requestDataHouse();
                break;
        }
        Request request = controller.CreateRequest(propertyType, agent, owner, areaOfProperty, distanceFromCentre, acceptanceDate, requestDate, street, city, state, zipCode, photos, transactionType, monetaryValue, bedrooms, bathrooms, parkingSpaces, basement, loft, sunExposure, equipment);
        System.out.println(request.toString());
        controller.addRequestToList(request);
    }

    /**
     * Requests the data for option creation
     *
     */
    public void requestDataLand() {
        agent = (Employee) Utils.showAndSelectOne(EmployeeRepository.agents, "Choose an agent:");
        areaOfProperty = Utils.requestAreaOfProperty();
        distanceFromCentre = Utils.requestDistanceFromCentre();
        requestAddress();
        requestDate = Utils.requestCurrentDate();
        acceptanceDate = Utils.requestCurrentDate();
        photos = Utils.requestPhotoList();
        transactionType = Utils.requestTransactionType();
        monetaryValue = Utils.requestMonetaryValue();
        owner = controller.getOwnerWithEmail(controller.getLoggedUser());
    }

    /**
     * Requests the data for option creation
     *
     */
    public void requestDataApartment() {
        agent = (Employee) Utils.showAndSelectOne(EmployeeRepository.agents, "Choose an agent:");
        areaOfProperty = Utils.requestAreaOfProperty();
        distanceFromCentre = Utils.requestDistanceFromCentre();
        requestAddress();
        requestDate = Utils.requestCurrentDate();
        acceptanceDate = Utils.requestCurrentDate();
        photos = Utils.requestPhotoList();
        bedrooms = Utils.requestBedrooms();
        bathrooms = Utils.requestBathrooms();
        parkingSpaces = Utils.requestParkingSpaces();
        equipment = Utils.requestEquipment();
        transactionType = Utils.requestTransactionType();
        monetaryValue = Utils.requestMonetaryValue();
        owner = controller.getOwnerWithEmail(controller.getLoggedUser());
    }

    /**
     * Requests the data for option creation
     *
     */
    public void requestDataHouse() {
        agent = (Employee) Utils.showAndSelectOne(EmployeeRepository.agents, "Choose an agent:");
        areaOfProperty = Utils.requestAreaOfProperty();
        distanceFromCentre = Utils.requestDistanceFromCentre();
        requestAddress();
        requestDate = Utils.requestCurrentDate();
        acceptanceDate = Utils.requestCurrentDate();
        photos = Utils.requestPhotoList();
        bedrooms = Utils.requestBedrooms();
        bathrooms = Utils.requestBathrooms();
        parkingSpaces = Utils.requestParkingSpaces();
        equipment = Utils.requestEquipment();
        basement = Utils.requestBasement();
        loft = Utils.requestLoft();
        sunExposure = Utils.requestSunExposure();
        transactionType = Utils.requestTransactionType();
        monetaryValue = Utils.requestMonetaryValue();
        owner = controller.getOwnerWithEmail(controller.getLoggedUser());

    }

    /**
     * Requests the data for address object
     *
     */
    public Address requestAddress(){
        street = Utils.requestStreet();
        city = Utils.requestCity();
        state = Utils.requestState();
        zipCode = Utils.requestZipCode();

        return new Address(street, city, state, zipCode);
    }

    public void displayList(String[] list){
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }
}

