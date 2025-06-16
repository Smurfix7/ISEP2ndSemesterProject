package pt.ipp.isep.dei.esoft.project.ui.console;

import jdk.jshell.execution.Util;
import pt.ipp.isep.dei.esoft.project.application.controller.RegisterUserController;
import pt.ipp.isep.dei.esoft.project.domain.Address;
import pt.ipp.isep.dei.esoft.project.domain.PassportCard;
import pt.ipp.isep.dei.esoft.project.domain.Role;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.Scanner;

public class RegisterUserUI implements Runnable {

    private final Scanner read = new Scanner(System.in);
    private final RegisterUserController controller = new RegisterUserController();
    private boolean opperationSuccess = false;

    /**
     * UI Run method
     */
    @Override
    public void run() {
        System.out.println("====== Register User: ======");
        do {
            String emailAddress = Utils.requestEmailAddress();
            opperationSuccess = controller.checkUserExists(emailAddress);
            if (!opperationSuccess) {
                String name = Utils.requestName();
                opperationSuccess = controller.createUser(name, emailAddress, requestPassword());
                if (opperationSuccess) {
                    System.out.println("Opperation successful. New User created successfully.");
                    System.out.println("Please add the rest of required information to complete your profile:");
                    do {
                        opperationSuccess = controller.createPerson(name, Utils.requestTaxNumber(), emailAddress, Utils.requestContactTelephoneNumber(), requestAddress(), Utils.requestPassportNumber(), new Role("OWNER", "owner"));
                        if (opperationSuccess) {
                            System.out.println("Registation Completed Successfully!");
                        } else {
                            System.out.println("Registation Failed, please try again.");
                        }
                    } while (!opperationSuccess);
                } else {
                    System.out.println("Opperation Failed, please try again.");
                }
            } else {
                System.out.println("User already exists. Try a different email.");
            }
        } while (!opperationSuccess);
    }

    /**
     * Requests the Password
     *
     * @return the input
     */
    private String requestPassword() {
        // "All those who wish to use the application must be authenticated with a password of seven alphanumeric characters, including three capital letters and two digits".
        System.out.println("Write your Password:");
        return read.nextLine();
    }

    /**
     * Requests the Address (Street/City/District/State/ZipCode)
     *
     * @return the input
     */
    private Address requestAddress() {
        System.out.println("Write your Address:");
        return new Address(Utils.requestStreet(), Utils.requestCity(), Utils.requestDistrict(), Utils.requestState(), Utils.requestZipCode());
    }

}
