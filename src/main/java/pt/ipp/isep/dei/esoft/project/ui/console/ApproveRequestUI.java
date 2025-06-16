package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.ApproveRequestController;
import pt.ipp.isep.dei.esoft.project.domain.dtos.RequestDto;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;
import java.util.ArrayList;
import java.util.Scanner;

public class ApproveRequestUI implements Runnable {

    private String commissionType;

    private double commissionValue;

    private String justification;
    Scanner read = new Scanner(System.in);


    private final ApproveRequestController controller = new ApproveRequestController();

    @Override
    public void run() {

        String email = controller.getLoggedUser();


        int option = 0;
        do {
            System.out.println();
            System.out.println("|------------------------------|");
            System.out.println("|  Approve a Property Request  |");
            System.out.println("|------------------------------|");


            ArrayList<RequestDto> announcementRequestListDto = controller.sortRequests(email);

            for (int i = 0; i < announcementRequestListDto.size(); i++) {
                System.out.println(announcementRequestListDto.get(i).toString());
            }

            System.out.println("To Approve a request type the '#' to the left of the request information (0 to exit): ");
            System.out.println();
            System.out.println(">");
            option = read.nextInt();

            if(validatePropertyOption(option, announcementRequestListDto)){

                System.out.println("Approve or rejected the property:");
                System.out.println("(Y (approve)/N (reject))");
                System.out.println(">");
                read.nextLine();
                String acceptance = read.next();
                System.out.println();


                do {
                    if(Utils.validateYNQuestion(acceptance)){
                        if (acceptance.toUpperCase().equals("Y")) {
                            commissionType = Utils.requestCommissionType();
                            commissionValue = Utils.requestCommissionValue(commissionType);

                        } else if (acceptance.toUpperCase().equals("N")) {
                            justification = requestJustification();

                        }
                    }else {
                        System.out.println("Invalid, type again: ");
                        System.out.println();
                        break;
                    }

                    String message = controller.judgePropertyRequest(option,acceptance, commissionType, commissionValue, justification);
                    System.out.println(message);
                }while(!Utils.validateYNQuestion(acceptance));


            }


        } while (option != 0);
    }

    /**
     * Requests the input for the justification email
     *
     * @return
     */
    private String requestJustification(){
        read.nextLine();
        System.out.println("Justification for refusal:");
        return read.nextLine();
    }

    /**
     * Displays the available requests that the agent can accept or deny
     *
     * @param displayList
     */
    public void getDisplayRequestsList(String displayList){
        System.out.println(displayList);}

    public boolean validatePropertyOption(int ID, ArrayList<RequestDto> list){
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID() == ID){
                flag = true;
            }
        }

        return flag;
    }

}

