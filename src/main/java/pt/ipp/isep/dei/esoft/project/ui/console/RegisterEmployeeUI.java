package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.RegisterEmployeeController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.RoleRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.io.IOException;

public class RegisterEmployeeUI implements Runnable {
    private final RegisterEmployeeController controller = new RegisterEmployeeController();
    private String name;
    private String taxNumber;
    private String emailAddress;
    private String contactTelephoneNumber;
    private PassportCard passportCardNumber;
    private String street;
    private String city;
    private String district;
    private String state;
    private String zipCode;
    private Agency agency;
    private Role agencyRole;

    @Override
    public void run() {
        System.out.println();
        System.out.println("|------------------------|");
        System.out.println(">> Register an employee <<");
        System.out.println("|------------------------|");

        requestData();

        boolean userExists = controller.checkIfUserExists(emailAddress);
        while (userExists) {
            System.out.println("Operation Failed! User already exists, try again.");
            System.out.println();
            System.out.println("|------------------------|");
            System.out.println(">> Register an employee <<");
            System.out.println("|------------------------|");
            requestData();
            userExists = controller.checkIfUserExists(emailAddress);
        }
        try {
            submitData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Operation Successful. New Employee registered successfully.");
    }

    /**
     * Submits the employee data to the controller for registration.
     * It generates a password, registers the employee, and sends an email with authentication credentials.
     *
     * @throws IOException if there is an error sending the email
     */
    private void submitData() throws IOException {
        String password = controller.createPassword();
        controller.registerEmployee(name, taxNumber, emailAddress, contactTelephoneNumber, street, city, district, state, zipCode, agencyRole, passportCardNumber, agency, password);
        controller.sendEmail("Here are your authentication credentials to log into our application!" + "\n\n" + "Email: " + emailAddress + "\n" + "Password: " + password);
    }

    /**
     * Requests the employee data from the user.
     * It prompts for employee details such as name, tax number, email address, contact telephone number,
     * passport card number, address, agency, and role.
     */
    private void requestData() {

        // Request the Name from the console
        name = Utils.requestName();

        // Request the Tax Number from the console
        taxNumber = Utils.requestTaxNumber();

        // Request the Email Address from the console
        emailAddress = Utils.requestEmailAddress();

        // Request the Contact Telephone Number from the console
        contactTelephoneNumber = Utils.requestContactTelephoneNumber();

        // Request the Passport Card Number from the console
        passportCardNumber = Utils.requestPassportNumber();

        if (Utils.confirm("Do you want to enter your Address? (Yes - ´y´ / No - ´n´)")) {
            // Request the Street from the console
            street = Utils.requestStreet();

            // Request the City from the console
            city = Utils.requestCity();

            // Request the District from the console
            district = Utils.requestDistrict();

            // Request the State from the console
            state = Utils.requestState();

            // Request the Zip Code from the console
            zipCode = Utils.requestZipCode();
        } else {
            street = null;
            city = null;
            district = null;
            state = null;
            zipCode = null;
        }

        // Request the Agency from the console
        System.out.println();
        agency = (Agency) Utils.showAndSelectOne(Network.agencies, ">> Select the Agency: <<");

        // Request the Role from the console
        System.out.println();
        String agencyRoleName = (String) Utils.showAndSelectOne(RoleRepository.agencyRoleNames, ">> Select the Role: <<");
        agencyRole = new Role(Role.addNewRoleID(agencyRoleName), agencyRoleName);

        Utils.confirm("Do you want to confirm the data? (Yes - ´y´ / No - ´n´)");
    }
}
