package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.ApproveVisitRequestController;

import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;
import pt.ipp.isep.dei.esoft.project.domain.dtos.VisitRequestsListDTO;
import pt.ipp.isep.dei.esoft.project.repository.VisitRequestsRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;
import pt.isep.lei.esoft.auth.UserSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApproveVisitRequestUI implements Runnable {
    private static Scanner read = new Scanner(System.in);
    private final ApproveVisitRequestController controller = new ApproveVisitRequestController();
    private String agentName = controller.getLoggedAgent();
    private String beginDate;
    private String endDate;
    private VisitRequest visitRequest;
    private VisitRequestsListDTO visitRequestFromDTO;
    private List<VisitRequestsListDTO> visitRequestsListDTO = new ArrayList<>();
    private boolean acceptance;
    private String justification;
    private String algorithm;

    @Override
    public void run() {
        System.out.println();
        System.out.println("|--------------------------|");
        System.out.println(">> Approve Visit Requests <<");
        System.out.println("|--------------------------|");
        visitRequestsListDTO = controller.toVisitRequestsListDTO();
        requestData();
        submitData();
    }

    /**
     * Submits the data for judging the visit request.
     * It calls the controller to judge the visit request based on the user's input.
     */
    private void submitData() {
        controller.judgeVisitRequest(agentName, visitRequest, acceptance, justification);
    }

    /**
     * Requests the necessary data from the user to filter and select visit requests.
     * It displays the visit requests list, filters it based on algorithm, sorts it, and collects user input for selecting a visit request.
     * It also collects user input for setting the date range and confirming the data.
     */
    private void requestData() {
        // Displays the visit requests list from the repository
        Utils.showList(visitRequestsListDTO, ">>  Visit Requests  <<");

        // Request the Algorithm from the console
        algorithm = controller.sendAlgorithm(requestAlgorithm());

        // Displays the visit requests list with filters
        System.out.println();
        visitRequestsListDTO = controller.sortVisitRequestsList(visitRequestsListDTO, algorithm);
        Utils.showList(visitRequestsListDTO, ">> Visit Requests Sorted <<");

        // Request the Begin Date from the console
        beginDate = requestBeginDate();

        // Request the End Date from the console
        endDate = requestEndDate();

        // Sends data to controller
        visitRequestsListDTO = controller.sendDates(beginDate, endDate, visitRequestsListDTO);

        // Displays the visit requests list with date filters
        visitRequestFromDTO = (VisitRequestsListDTO) Utils.showAndSelectOne(visitRequestsListDTO, ">> Select a visit request if you want: <<");
        if (visitRequestFromDTO != null) {
            visitRequest = controller.getVisitRequestedByID(String.valueOf(visitRequestFromDTO.getId()));

            // Request the Acceptance from the console
            System.out.println();
            acceptance = Utils.confirm("Do you want to accept the visit request? (Yes - ´y´ / No - ´n´)");

            // Request the Justification from the console if the visit request was denied
            if (!acceptance) {
                justification = requestJustification();
            } else {
                justification = null;
            }

            Utils.confirm("Do you want to confirm the data? (Yes - ´y´ / No - ´n´)");
        }
    }

    /**
     * Validates the date format.
     *
     * @param answer the input date string
     * @return true if the date format is valid, false otherwise
     */
    public static boolean validateDate(String answer) {
        String pattern = "\\d{2}-\\d{2}-\\d{4}"; // Date Format "##-##-####" format

        String[] date = answer.split("-");
        String day = date[0];
        String month = date[1];
        String year = date[2];

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(answer);

        if (Integer.parseInt(day) < 1 || Integer.parseInt(day) > 31) {
            return false;
        } else if (Integer.parseInt(month) < 1 || Integer.parseInt(month) > 12) {
            return false;
        }
        return matcher.matches();
    }

    /**
     * Requests the input for the begin date of visit requests.
     *
     * @return the user input for the begin date
     */
    private String requestBeginDate() {
        System.out.println();
        System.out.println("Set a Begin and End Date for the Visit Requests you want to analyze!\n");
        System.out.println("Write the Begin Date (##-##-####) -> (day-month-year): ");
        String answer = read.next();
        while (!validateDate(answer)) {
            System.out.println("Invalid Begin Date, try again with the correct format and a valid date: ");
            answer = read.next();
        }
        return answer;
    }

    /**
     * Requests the input for the end date of visit requests.
     *
     * @return the user input for the end date
     */
    private String requestEndDate() {
        System.out.println("Write the End Date (##-##-####):");
        String answer = read.next();
        while (!validateDate(answer)) {
            System.out.println("Invalid End Date, try again with the correct format: ");
            answer = read.next();
        }
        return answer;
    }

    /**
     * Validates the sorting algorithm name.
     *
     * @param answer the input sorting algorithm name
     * @return true if the sorting algorithm name is valid, false otherwise
     */
    public static boolean validateSortingAlgorithms(String answer) {
        if (answer.equalsIgnoreCase("bubble") || answer.equalsIgnoreCase("insertion")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Requests the input for the sorting algorithm name.
     *
     * @return the user input for the sorting algorithm name
     */
    private String requestAlgorithm() {
        System.out.println("Write the Sorting Algorithm (bubble / insertion):");
        String answer = read.next();
        while (!validateSortingAlgorithms(answer)) {
            System.out.println("Invalid Sorting Algorithm, try again: ");
            answer = read.next();
        }
        return answer;
    }

    /**
     * Requests the input for the justification email.
     *
     * @return the user input for the justification
     */
    private String requestJustification() {
        read.nextLine();
        System.out.println("Justification for refusal: ");
        return read.nextLine();
    }
}
