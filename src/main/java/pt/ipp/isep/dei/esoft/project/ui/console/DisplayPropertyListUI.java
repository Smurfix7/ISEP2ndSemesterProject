package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.PropertyListController;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.SelectedParameters;

import java.util.*;

public class DisplayPropertyListUI implements Runnable {

    private final PropertyListController controller = new PropertyListController();

    private List<Announcement> announcementListCopy = new ArrayList<>();
    private String answer;
    private boolean answerValidation = false;
    private boolean parametersValidation = false;
    private SelectedParameters selectedParameters = new SelectedParameters();
    private final Scanner read = new Scanner(System.in);
    private PriceSorting ps = new PriceSorting();

    /**
     * UI Run Method.
     */
    @Override
    public void run() {
        announcementListCopy = new ArrayList<>(controller.getCopyAnnouncementList());
        displayAnnouncementList(null);
        displayAnnouncementListWithParameters();

    }

    private void displayAnnouncementListWithParameters() {
        do {
            System.out.println("Do you wish to sort the list by selected parameters? (Yes/No)");
            answer = read.next();
            System.out.println();
            if (answer.equalsIgnoreCase("yes")) {
                String requestedPropertyType = requestPropertyType();
                if (requestedPropertyType.equalsIgnoreCase("land")) {
                    selectedParameters = controller.createSelectedParameters(requestBusinessType(), requestedPropertyType, 0);
                } else {
                    selectedParameters = controller.createSelectedParameters(requestBusinessType(), requestedPropertyType, requestNumberRooms());
                }
                System.out.println(selectedParameters);
                displayAnnouncementList(selectedParameters);

                do {
                    System.out.println("Do you wish to sort by price or address? (Price / Address / No)");
                    answer = read.next();
                    System.out.println();
                    if (answer.equalsIgnoreCase("price")) {
                        answerValidation = true;
                        selectedParameters.setPriceSorting(requestPriceSorting());
                        if (selectedParameters.getPriceSorting().equalsIgnoreCase("ascending")){
                            sortPriceAscending(announcementListCopy);
                        } else {
                            sortPriceDescending(announcementListCopy);
                        }
                        System.out.println(selectedParameters);
                        displayAnnouncementList(selectedParameters);

                    } else if (answer.equalsIgnoreCase("address")) {
                        answerValidation = true;
                        selectedParameters.setState(requestState());
                        selectedParameters.setDistrict(requestDistrict());
                        selectedParameters.setCity(requestCity());
                        System.out.println(selectedParameters);
                        displayAnnouncementList(selectedParameters);

                    } else if (answer.equalsIgnoreCase("no")) {
                        answerValidation = true;

                    } else {
                        System.out.println("Invalid Answer.");
                    }
                } while (!answerValidation);

            } else if (answer.equalsIgnoreCase("no")) {
                answerValidation = true;
            } else {
                System.out.println("Invalid answer.");
            }
        } while (!answerValidation);

        do {
            System.out.println("If you wanna change any (un)selected parameter choose which one you want to change: \n(" +
                    "BusinessType / " +
                    "PropertyType / " +
                    "NumberRooms / " +
                    "PriceSorting / " +
                    "Address / " +
                    "return)");
            answer = read.next();
            System.out.println();
            if (answer.equalsIgnoreCase("businesstype")) {
                selectedParameters.setBusinessType(requestBusinessType());
                System.out.println(selectedParameters);
                displayAnnouncementList(selectedParameters);
            } else if (answer.equalsIgnoreCase("propertytype")) {
                selectedParameters.setPropertyType(requestPropertyType());
                System.out.println(selectedParameters);
                displayAnnouncementList(selectedParameters);
            } else if (answer.equalsIgnoreCase("numberrooms")) {
                selectedParameters.setNumberRooms(requestNumberRooms());
                System.out.println(selectedParameters);
                displayAnnouncementList(selectedParameters);
            } else if (answer.equalsIgnoreCase("pricesorting")) {
                selectedParameters.setPriceSorting(requestPriceSorting());
                System.out.println(selectedParameters);
                displayAnnouncementList(selectedParameters);
            } else if (answer.equalsIgnoreCase("address")) {
                selectedParameters.setState(requestState());
                selectedParameters.setDistrict(requestDistrict());
                selectedParameters.setCity(requestCity());
                System.out.println(selectedParameters);
                displayAnnouncementList(selectedParameters);
            } else {
                System.out.println("Invalid Answer.");
            }

        } while (!answer.equalsIgnoreCase("return"));
    }

    /**
     * Displays the AnnouncementList with the selectedParameters
     *
     * @param selectedParameters
     */
    private void displayAnnouncementList(SelectedParameters selectedParameters) {
        System.out.println("\n====== List of Available Properties: ======");
        if (selectedParameters == null) {
            // Display by most recent
            for (int i = announcementListCopy.size()-1; i >= 0; i--) {
                System.out.println(announcementListCopy.get(i));
                System.out.println("==========================================");
            }

            // =====================================
        } else {
            if (selectedParameters.getPropertyType().equalsIgnoreCase("land")) {
                System.out.println("Listed Lands:");
            }
            if (selectedParameters.getPropertyType().equalsIgnoreCase("house")) {
                System.out.println("Listed Houses:");
            }
            if (selectedParameters.getPropertyType().equalsIgnoreCase("apartment")) {
                System.out.println("Listed Apartments:");
            }

            for (Announcement announcement : announcementListCopy) {
                if (selectedParameters.getPropertyType().equalsIgnoreCase(announcement.getRequest().getProperty().getPropertyType())) {
                    if (((announcement.getRequest().getTypeOfTransaction().getTransactionType()).equalsIgnoreCase(selectedParameters.getBusinessType()) ||
                            (selectedParameters.getBusinessType().equalsIgnoreCase("[NO DATA]")))) {
                        if ((announcement.getRequest().getProperty().getAddress().getState().equalsIgnoreCase(selectedParameters.getState())) ||
                                (selectedParameters.getState().equals("[NO STATE]"))) {
                            if((announcement.getRequest().getProperty().getAddress().getDistrict().equalsIgnoreCase(selectedParameters.getDistrict())) ||
                                    (selectedParameters.getDistrict().equals("[NO DISTRICT]"))) {
                                if ((announcement.getRequest().getProperty().getAddress().getCity().equalsIgnoreCase(selectedParameters.getCity())) ||
                                        (selectedParameters.getCity().equals("[NO CITY]"))) {
                                    System.out.println(announcement);
                                    System.out.println("==========================================");
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println();
    }
    /**
     * Requests the Type of Business (Renting/Buying)
     *
     * @return String
     */
    private String requestBusinessType() {
        parametersValidation = false;
        do {
            System.out.println("Choose the BusinessType (Wholesale / Lease):");
            answer = read.next();
            if (answer.equalsIgnoreCase("wholesale")) {
                parametersValidation = true;
            } else if (answer.equalsIgnoreCase("lease")) {
                parametersValidation = true;
            } else {
                System.out.println("Invalid Answer.");
            }
        } while (!parametersValidation);
        return answer;
    }

    /**
     * Requests Property Type (Land/Appartment/House)
     *
     * @return String
     */
    private String requestPropertyType() {
        parametersValidation = false;
        do {
            System.out.println("Choose the PropertyType (Land / Apartment / House):");
            answer = read.next();
            if (answer.equalsIgnoreCase("land")) {
                parametersValidation = true;
            } else if (answer.equalsIgnoreCase("apartment")) {
                parametersValidation = true;
            } else if (answer.equalsIgnoreCase("house")) {
                parametersValidation = true;
            } else {
                System.out.println("Invalid Answer.");
            }
        } while (!parametersValidation);
        return answer;
    }

    /**
     * Requests Number of Rooms
     *
     * @return int
     */
    private int requestNumberRooms() {
        int answerInt;
        parametersValidation = false;
        do {
            System.out.println("Choose number of Rooms:");
            answerInt = read.nextInt();
            if (answerInt >= 0) {
                parametersValidation = true;
            } else {
                System.out.println("Invalid Answer.");
            }
        } while (!parametersValidation);
        return answerInt;
    }

    /**
     * Requests the Price Sorting (Ascending/Descending)
     *
     * @return String
     */
    private String requestPriceSorting() {
        parametersValidation = false;
        do {
            System.out.println("Choose the PriceSorting (Ascending / Descending):");
            answer = read.next();
            if (answer.equalsIgnoreCase("ascending")) {
                parametersValidation = true;
            } else if (answer.equalsIgnoreCase("descending")) {
                parametersValidation = true;
            } else {
                System.out.println("Invalid Answer.");
            }
        } while (!parametersValidation);
        return answer;
    }


    /**
     * Requests the City
     *
     * @return String
     */
    private String requestCity() {
        System.out.println("Choose the City (if you don't wish to specify the city, write default):");
        answer = read.next();
        if (answer.equalsIgnoreCase("default")) {
            return "[NO CITY]";
        }
        return answer;
    }

    /**
     * Requests the District
     *
     * @return String
     */
    private String requestDistrict() {
        System.out.println("Choose the District (if you don't wish to specify the district, write default):");
        answer = read.next();
        if (answer.equalsIgnoreCase("default")) {
            return "[NO DISTRICT]";
        }
        return answer;
    }

    /**
     * Requests the State
     *
     * @return String
     */
    private String requestState() {
        System.out.println("Choose the State (if you don't wish to specify the state, write default):");
        answer = read.next();
        if (answer.equalsIgnoreCase("default")) {
            return "[NO STATE]";
        }
        return answer;
    }

    /**
     * Sorts all the lists by Price Ascending
     */
    public void sortPriceAscending(List<Announcement> announcements) {
        Collections.sort(announcements, ps);
    }

    /**
     * Sorts all the lists by Price Descending
     */
    public void sortPriceDescending(List<Announcement> announcements) {
        announcements.sort(Collections.reverseOrder(ps));
    }


    /**
     * PriceSorting for the Land
     */
    class PriceSorting implements Comparator<Announcement> {
        public int compare(Announcement o1, Announcement o2) {
            double value1 = o1.getRequest().getTypeOfTransaction().getMonetaryValue();
            double value2 = o2.getRequest().getTypeOfTransaction().getMonetaryValue();
            return Double.compare(value1, value2);
        }
    }

}
