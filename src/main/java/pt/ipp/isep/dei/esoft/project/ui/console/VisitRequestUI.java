package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.VisitRequestController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.isep.lei.esoft.auth.AuthFacade;

import java.util.Scanner;

public class VisitRequestUI implements Runnable {
    private int announcementNumber;
    private Property property;
    private final VisitRequestController controller = new VisitRequestController();
    private final Scanner read = new Scanner(System.in);

    private int answer;
    private SelectedParameters parameters = new SelectedParameters();
    private AuthFacade authFacade = new AuthFacade();

    @Override
    public void run() {
        System.out.println("Properties available:");
        displayAnnouncements();
        System.out.println();
        System.out.println("Create a Visit Request:");
        controller.CreateVisitRequest(requestName(), requestEmailAddress(), requestPassword(), requestTelephoneNumber(), requestAnnouncement(), requestDate(), requestTimeFrame());

    }

    private Announcement requestAnnouncement() {
        System.out.println("Select The Announcement (ID):");
        announcementNumber = read.nextInt();
        return controller.getAnnouncementWithID(announcementNumber);
    }

    private String requestName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Name of the User:");
        return input.nextLine();
    }

    private String requestEmailAddress() {
        Scanner input = new Scanner(System.in);
        System.out.println("Email Address:");
        return input.nextLine();
    }

    private String requestPassword() {
        Scanner input = new Scanner(System.in);
        System.out.println("Password:");
        return input.nextLine();
    }

    private String requestTelephoneNumber() {
        Scanner input = new Scanner(System.in);
        System.out.println("Phone Number:");
        return input.nextLine();
    }


    private String requestDate() {
        Scanner input = new Scanner(System.in);
        System.out.println("Input the preffered date (dd/mm/yy):");
        return input.nextLine();
    }

    private String requestTimeFrame() {
        Scanner input = new Scanner(System.in);
        System.out.println("Input the preffered time frame (00AM-00PM):");
        return input.nextLine();
    }
    public void displayAnnouncements(){
        for (int i = 0; i < controller.getCopyAnnouncementsList().size(); i++) {
                System.out.println(controller.getCopyAnnouncementsList().get(i));
        }
    }

}
