package pt.ipp.isep.dei.esoft.project.ui.console.utils;


import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.OwnerRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Paulo Maio pam@isep.ipp.pt
 */
public class Utils {
    private static Scanner read = new Scanner(System.in);

    static public boolean applicationIsLaunched = false;

    static public boolean getApplicationIsLaunched() {
        return applicationIsLaunched;
    }

    static public void setApplicationIsLaunched(boolean b) {
        applicationIsLaunched = b;
    }

    static public String readLineFromConsole(String prompt) {
        try {
            System.out.println("\n" + prompt);

            InputStreamReader converter = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(converter);

            return in.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static public int readIntegerFromConsole(String prompt) {
        do {
            try {
                String input = readLineFromConsole(prompt);

                int value = Integer.parseInt(input);

                return value;
            } catch (NumberFormatException ex) {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
    }

    static public double readDoubleFromConsole(String prompt) {
        do {
            try {
                String input = readLineFromConsole(prompt);

                double value = Double.parseDouble(input);

                return value;
            } catch (NumberFormatException ex) {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
    }

    static public Date readDateFromConsole(String prompt) {
        do {
            try {
                String strDate = readLineFromConsole(prompt);

                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

                Date date = df.parse(strDate);

                return date;
            } catch (ParseException ex) {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
    }

    static public boolean confirm(String message) {
        String input;
        do {
            input = Utils.readLineFromConsole(message);
        } while (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n"));

        return input.equalsIgnoreCase("y");
    }

    static public Object showAndSelectOne(List list, String header) {
        showList(list, header);
        return selectsObject(list);
    }

    static public int showAndSelectIndex(List list, String header) {
        showList(list, header);
        return selectsIndex(list);
    }

    static public void showList(List list, String header) {
        System.out.println(header);

        int index = 0;
        for (Object o : list) {
            index++;

            System.out.println(index + ". " + o.toString());
        }
        System.out.println();
        System.out.println("0 - Cancel");
    }

    static public Object selectsObject(List list) {
        String input;
        Integer value;
        do {
            input = Utils.readLineFromConsole("Type your option: ");
            value = Integer.valueOf(input);
        } while (value < 0 || value > list.size());

        if (value == 0) {
            return null;
        } else {
            return list.get(value - 1);
        }
    }

    public static String generatePassword() {
        String password = "";
        Random random = new Random();

        // Generate three capital letters
        for (int i = 0; i < 3; i++) {
            char uppercaseLetter = (char) (random.nextInt(26) + 'A');
            password += uppercaseLetter;
        }

        // Generate two digits
        for (int i = 0; i < 2; i++) {
            int digit = random.nextInt(10);
            password += digit;
        }

        // Generate two alphanumeric characters (lowercase letters or digits)
        for (int i = 0; i < 2; i++) {
            // Generates a number between 0 and 35 to represent lowercase letters (26 possibilities) and digits (10 possibilities)
            int alphanumericIndex = random.nextInt(36);
            char alphanumericChar;

            if (alphanumericIndex < 26) {
                // Generate capital letter
                alphanumericChar = (char) (alphanumericIndex + 'a');
            } else {
                // Generate digit
                alphanumericChar = (char) (alphanumericIndex - 26 + '0');
            }

            password += alphanumericChar;
        }
        return password;
    }


    public static boolean validateFile(String filePath) {
        File file = new File(filePath);
        return file.exists() && file.length() > 0;
    }

    static public int selectsIndex(List list) {
        String input;
        Integer value;
        do {
            input = Utils.readLineFromConsole("Type your option: ");
            try {
                value = Integer.valueOf(input);
            } catch (NumberFormatException ex) {
                value = -1;
            }
        } while (value < 0 || value > list.size());

        return value - 1;
    }

    /**
     * Requests the TaxNumber
     *
     * @return the input
     */
    public static boolean validateTaxNumber(String answer) {
        String pattern = "\\d{3}-\\d{2}-\\d{4}"; // Tax Number "###-##-####" format
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(answer);

        return matcher.matches();
    }

    /**
     * Requests the TaxNumber
     *
     * @return the input
     */
    public static String requestTaxNumber() {
        System.out.println("Write the Tax Number (###-##-####):");
        String answer = read.next();
        while (!Utils.validateTaxNumber(answer)) {
            System.out.println("Invalid Tax Number, try again:");
            answer = read.next();
        }
        return answer;
    }

    /**
     * Validates the EmailAddress
     *
     * @return boolean value
     */
    public static boolean validateEmailAddress(String answer) {
        if (answer.contains("@")) { // Email Address "x@x" format
            return true;
        }
        return false;
    }

    /**
     * Requests the EmailAddress
     *
     * @return the input
     */
    public static String requestEmailAddress() {
        System.out.println("Write the Email Address:");
        String answer = read.next();
        while (!Utils.validateEmailAddress(answer)) {
            System.out.println("Invalid Email Address, try again:");
            answer = read.next();
        }
        return answer;
    }

    /**
     * Validate the ContactTelephoneNumber
     *
     * @return boolean value
     */
    public static boolean validateContactTelephoneNumber(String answer) {
        String pattern = "\\d{3}-\\d{3}-\\d{4}"; // Contact Telephone Number "###-###-####" format
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(answer);

        return matcher.matches();
    }

    /**
     * Requests the ContactTelephoneNumber
     *
     * @return boolean value
     */
    public static String requestContactTelephoneNumber() {
        System.out.println("Write the Contact Telephone Number (###-###-####):");
        String answer = read.next();
        while (!Utils.validateContactTelephoneNumber(answer)) {
            System.out.println("Invalid Contact Telephone Number, try again:");
            answer = read.next();
        }
        return answer;
    }

    /**
     * Validate the PassportNumber
     *
     * @return boolean value
     */
    public static boolean validatePassportNumber(PassportCard answer) {
        String passportNumber = answer.getPassportNumber();
        String pattern1 = "\\d{9}"; // Passport Card Number "#########" format
        String pattern2 = "C\\d{8}"; // Passport Card Number "C########" format
        Pattern regex1 = Pattern.compile(pattern1);
        Pattern regex2 = Pattern.compile(pattern2);
        Matcher matcher1 = regex1.matcher(passportNumber);
        Matcher matcher2 = regex2.matcher(passportNumber);

        return (matcher1.matches() || matcher2.matches());
    }

    /**
     * Requests the PassportCardNumber
     *
     * @return boolean value
     */
    public static PassportCard requestPassportNumber() {
        System.out.println("Write the Passport Number (######### / C########):");
        String passportNumber = read.next();
        PassportCard answer = new PassportCard(passportNumber);
        while (!validatePassportNumber(answer)) {
            System.out.println("Invalid Passport Number, try again:");
            passportNumber = read.next();
            answer.setPassportNumber(passportNumber);
        }
        return answer;
    }

    /**
     * Requests the TaxNumber
     *
     * @return the input
     */
    public static boolean validateZipCode(String answer) {
        String pattern = "\\d{5}"; // Tax Number "#####" format
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(answer);

        return matcher.matches();
    }

    /**
     * Requests the Zip Code
     *
     * @return the input
     */
    public static String requestZipCode() {

        System.out.println("Write the Zip Code (#####):");
        String answer = read.next();
        while (!Utils.validateZipCode(answer)) {
            System.out.println("Invalid Zip Code, try again:");
            answer = read.next();
        }
        return answer;
    }

    /**
     * Requests the Name
     *
     * @return the input
     */
    public static String requestName() {
        System.out.println("Write the Name:");
        return read.next();
    }

    /**
     * Requests the Street
     *
     * @return the input
     */
    public static String requestStreet() {
        System.out.println("Write the Street: ");
        read.nextLine();
        return read.nextLine();
    }

    /**
     * Requests the City
     *
     * @return the input
     */
    public static String requestCity() {
        System.out.println("Write the City: ");
        return read.nextLine();

    }

    /**
     * Requests the District
     *
     * @return the input
     */
    public static String requestDistrict() {
        System.out.println("Write the District (Optional): ");
        System.out.println("Write ´n´ if you want to skip this step!");
        return read.nextLine();

    }

    /**
     * Requests the State
     *
     * @return the input
     */
    public static String requestState() {
        System.out.println("Write the State: ");
        return read.nextLine();

    }

    // Property attribute methods

    public static int requestPropertyType() {
        System.out.println("Select Property Type \n" +
                "1- Land\n" +
                "2- Apartment\n" +
                "3- House\n" +
                ">");
        int type = read.nextInt();
        while (!validatePropertyType(type)) {
            System.out.println("Invalid type, select a correct Property Type:");
            type = read.nextInt();
        }
        return type;
    }

    private static boolean validatePropertyType(Integer type) {
        return (type == 1 || type == 2 || type == 3);
    }


    public static Double requestAreaOfProperty() {
        System.out.println("Property Size (Square meters): ");
        Double answer = read.nextDouble();
        while (!(validatePositiveDouble(answer))) {
            System.out.println("Invalid, type again: ");
            answer = read.nextDouble();
        }
        return answer;
    }

    private static boolean validatePositiveDouble(Double value) {
        return (value > 0);
    }

    private static boolean validatePositiveInt(Integer value) {
        return (value > 0);
    }

    private static boolean validateBasementLoft(Integer value) {
        return (value == 1 || value == 0);
    }

    public static Double requestDistanceFromCentre() {
        System.out.println("Distance From Centre (miles): ");
        Double answer = read.nextDouble();
        while (!validatePositiveDouble(answer)) {
            System.out.println("Invalid, type again: ");
            answer = read.nextDouble();
        }
        return answer;

    }

    private static String requestRequestDate() {
        return java.time.LocalDate.now().toString();
    }

    private static String requestAcceptanceDate() {
        return java.time.LocalDate.now().toString();
    }

    public static ArrayList<Photo> requestPhotoList() {
        ArrayList<Photo> photos = new ArrayList<Photo>();

        for (int i = 0; i < 30; i++) {
            String uri = requestPhotoURI();
            Photo photo = new Photo(uri);
            if (!uri.equals("-1")) {
                photos.add(photo);
            } else {
                break;
            }
        }

        return photos;
    }

    public static String requestPhotoURI() {
        read.nextLine();
        System.out.println("photoURI (-1 to exit): ");
        return read.next();

    }

    public static int requestBedrooms() {
        System.out.println("Number of Bedrooms: ");
        int answer = read.nextInt();
        while (!validatePositiveInt(answer)) {
            System.out.println("Invalid, type again: ");
            answer = read.nextInt();
        }
        return answer;
    }

    public static int requestBathrooms() {
        System.out.println("Number of Bathrooms: ");
        int answer = read.nextInt();
        while (!validatePositiveInt(answer)) {
            System.out.println("Invalid, type again: ");
            answer = read.nextInt();
        }
        return answer;

    }

    public static int requestParkingSpaces() {
        System.out.println("Number of Parking Spaces: ");
        int answer = read.nextInt();
        while (!validatePositiveInt(answer)) {
            System.out.println("Invalid, type again: ");
            answer = read.nextInt();
        }
        return answer;

    }

    public static String requestCurrentDate() {
        return java.time.LocalDate.now().toString();
    }

    public static String requestBasement() {
        System.out.println("Basement (Y/N): ");
        String val = read.next();
        boolean flag = false;
        while (!validateYNQuestion(val)) {
            System.out.println("Incompatible value please type again:");
        }

        return val;
    }

    public static String requestLoft() {
        read.nextLine();
        System.out.println("Loft (Y/N): ");
        String val = read.next();
        while (!validateYNQuestion(val)) {
            System.out.println("Incompatible value please type again:");
        }

        return val;
    }

    public static String requestSunExposure() {
        read.nextLine();
        System.out.println("Sun Exposure (N/S/W/E): ");
        String answer = read.next();
        while (!validateSunExposure(answer)) {
            System.out.println("Invalid, type again: ");
            answer = read.next();
        }
        return answer.toUpperCase();
    }

    private static boolean validateSunExposure(String sunExposure) {
        return (Objects.equals(sunExposure.toUpperCase(), "S") || Objects.equals(sunExposure.toUpperCase(), "N") || Objects.equals(sunExposure.toUpperCase(), "W") || Objects.equals(sunExposure.toUpperCase(), "E"));
    }

    public static String requestTransactionType() {
        read.nextLine();
        System.out.println("Transaction Type ('Wholesale'/'Lease-(number of months)-months') : ");
        String answer = read.nextLine();
        while (!validateTransactionType(answer)) {
            System.out.println("Invalid response, type again:");
            answer = read.nextLine();
        }
        return answer.toUpperCase();
    }

    private static boolean validateTransactionType(String transactionType) {
        return (transactionType.toUpperCase().contains("LEASE") && transactionType.toUpperCase().contains("MONTHS")) || transactionType.toUpperCase().equals("WHOLESALE");

    }

    public static Double requestMonetaryValue() {
        System.out.println("Amount Paid (Wholesale Value/ monthly Lease): ");
        Double answer = read.nextDouble();
        while (!validatePositiveDouble(answer)) {
            System.out.println("Invalid, type again: ");
            answer = read.nextDouble();
        }
        return answer;

    }

    public static Commission requestCommission() {
        System.out.println("-| Commission |-");
        String commissionType = requestCommissionType();
        Double commissionValue = requestCommissionValue(commissionType);

        Commission commission = new Commission(commissionType, commissionValue);

        return commission;
    }

    public static String requestCommissionType() {
        System.out.println("Select a commission type (FLAT / PERCENTAGE)");
        String commissionType;
        commissionType = read.next();
        while (!validateCommissionType(commissionType)) {
            System.out.println("Invalid, type again:");
            commissionType = read.next();
        }

        return commissionType.toUpperCase();
    }

    private static boolean validateCommissionType(String commissionType) {
        return (commissionType.toUpperCase().equals("FLAT") || commissionType.toUpperCase().equals("PERCENTAGE"));
    }

    public static Double requestCommissionValue(String commissionType) {
        read.nextLine();
        System.out.println("Type the value of the commission: ");
        Double commissionValue = read.nextDouble();

        while (!validateCommissionValue(commissionType, commissionValue)) {
            System.out.println("Invalid, type again: ");
            commissionValue = read.nextDouble();
        }

        return commissionValue;
    }

    private static boolean validateCommissionValue(String commissionType, Double commissionValue) {
        boolean check = false;
        if (commissionType.toUpperCase().equals("PERCENTAGE")) {
            check = (commissionValue > 0 && commissionValue < 100);
        } else {
            check = (commissionValue > 0);
        }

        return check;
    }

    public static Equipment requestEquipment() {
        read.nextLine();
        ArrayList<String> equipments = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            System.out.println("Type Equipment in Property (0 to exit):");
            String equipment = read.nextLine();
            if (!equipment.equals("0")) {
                equipments.add(equipment);
            } else {
                break;
            }
        }

        return new Equipment(equipments);
    }

    public static String requestCentralHeating() {
        read.nextLine();
        System.out.println("Does the Property come with Central Heating (Y/N): ");
        String answer = read.next();
        while (!validateYNQuestion(answer)) {
            System.out.println("Invalid, type again:");
            answer = read.next();
        }
        return answer.toUpperCase();
    }


    public static String requestAirConditioning() {
        read.nextLine();
        System.out.println("Does the Property come with Air Conditioning (Y/N): ");
        String answer = read.next();
        while (!validateYNQuestion(answer)) {
            System.out.println("Invalid, type again:");
            answer = read.next();
        }
        return answer.toUpperCase();
    }

    public static boolean validateYNQuestion(String answer) {
        return (answer.toUpperCase().equals("Y") || answer.toUpperCase().equals("N"));
    }

    public static void displayCommissionOptions() {
        System.out.println("Choose from one of these commission options:");
    }

    public static Person requestOwner() {
        System.out.println("Select the owner:");
        OwnerRepository.displayOwners();
        int answer = read.nextInt();

        while (!validateRequestOwner(answer)) {
            System.out.println("Invalid, select an owner:");
            answer = read.nextInt();
        }
        return OwnerRepository.getOwner(answer - 1);
    }

    public static boolean validateRequestOwner(int n) {
        return (n > 0 || n <= OwnerRepository.getNumberOfOwners());
    }
}
