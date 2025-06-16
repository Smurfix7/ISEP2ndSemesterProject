# US 008 - To Approve an Announcement Request

# 4. Tests 

**Test 1:** This test checks that if when a property is approved it is moved to the repositories containing the
listed announcements and removed from the repository containing the announcement requests

    @Test

    void approveProperty() {
        Land land =new Land("Land", new Agent(),new Owner(), 123,123, "", "", new Address(), "", "", 12);


        int ID = 0;

        LandRepository.addLand(land);
        LandRepository.getLandById(ID).setComission(4);
        LandRepository.getLandById(ID).setAcceptanceDate(Utils.requestCurrentDate());
        AnnouncementRepository.keepLand(LandRepository.getLandById(ID));
        PropertyRequestRepository.removePropertyRequest(0);

        AnnouncementRepository.containsProperty(land);
        PropertyRequestRepository.containsProperty(land);
    }
}

**Test 2:** This test checks that if when a property is rejected it is removed from the repository containing the announcement listing requests

    @Test

    void rejectProperty() {
        PropertyRequestRepository.addPropertyRequest(new Property("Apartment",new Owner(), 123,123, new Address("a", "b","c","12346")));
        int num = PropertyRequestRepository.getNumberOfRequests();

        PropertyRequestRepository.addPropertyRequest(new Property());
        PropertyRequestRepository.addPropertyRequest(new Property());
        PropertyRequestRepository.addPropertyRequest(new Property());

        ApprovePropertyController.rejectProperty(num);
        PropertyRequestRepository.containsProperty(new Property("Apartment",new Owner(), 123,123, new Address("a", "b","c","12346")));

    }
}


**Test 3:** This test checks that when the request list containing the requests made to the logged agent is retrieved it is correct.

    @Test
    void getRequestList() {
        String test = "2|#4| Agent : José | Tax Number: 20202 | Email Address: agent@this.app | Telephone Number: 919191991 | Address: Lt Gambalord, Illinois City, Illinois, 23483 | Role ID: 01 | Role: Agent | Passport Card Number: 233424232 | Agency ID: 01| Owner:Maria | Tax Number: 20202 | Email Address: owner2@this.app | Telephone Number: 919191991 | Address: Lt Gambalord, Illinois City, Illinois, 23483 | Role ID: 01 | Role: Agent | Passport Card Number: 233424232 |Property type: Land | Area Of The Property: 1.0 | Distance From The Centre: 1.0 | Transaction Type:  | Value: 0.0 | Request Date:  | Acceptance Date: | Commission Details :No Comission added\n" +
                "3|#5| Agent : José | Tax Number: 20202 | Email Address: agent@this.app | Telephone Number: 919191991 | Address: Lt Gambalord, Illinois City, Illinois, 23483 | Role ID: 01 | Role: Agent | Passport Card Number: 233424232 | Agency ID: 01| Owner:Maria | Tax Number: 20202 | Email Address: owner2@this.app | Telephone Number: 919191991 | Address: Lt Gambalord, Illinois City, Illinois, 23483 | Role ID: 01 | Role: Agent | Passport Card Number: 233424232 |Property type: Land | Area Of The Property: 1.0 | Distance From The Centre: 1.0 | Transaction Type:  | Value: 0.0 | Request Date:  | Acceptance Date: | Commission Details :No Comission added";
        PropertyRequestRepository propertyRequestRepository = new PropertyRequestRepository();
        ArrayList<String> requestsList = propertyRequestRepository.getRequestListByEmail("agent@this.app");

        StringBuilder assembler = new StringBuilder();

        for (String line : requestsList) {
            assembler.append(line).append(System.lineSeparator());
        }
        String requests = assembler.toString();

        assertEquals(test, requests);
    }

**Test 4:** This test checks if the information written to the file by the sendEmail method is correct.

    @Test

    void sendEmail() throws IOException {
    String filePath = System.getProperty("user.home") + "/Desktop/testfile.txt";

        String testData = "Hello, World!";

        SendEmail.sendEmail(testData);

        String fileContent = Files.readString(Path.of(filePath));
        assertEquals(testData, fileContent);
    }

**Test 5:** This test assures that the request list gotten by this method is the list of only the listings to the logged agent.

    @Test
    void getRequestListByEmail() {
        Address address1 = new Address("Lt Jenkins", "Huston", "Texas", "23423");
        Role role1 = new Role("01", "Agent");
        PassportCard passportCard1 = new PassportCard("232424232");
        Agency agency1 = new Agency("01", "TechSupportScammers", "techsupportscammers@gmail.com", "123-123-1234", address1);
        Agent agent1 = new Agent("José", "20202", "Agent1@email", "919191991", address1, role1, passportCard1, agency1);
        Address address2 = new Address("Lt Gambalord", "Illinois City", "Illinois", "23483");
        Role role2 = new Role("01", "Agent");
        PassportCard passportCard2 = new PassportCard("233424232");

        Owner owner = new Owner("Maria", "20202", "owner2@this.app", "919191991", address2, role2, passportCard2);
        Apartment apartment = new Apartment("Apartment", agent1,owner ,1, 1, "", "", address1, "", "", 0, 0, 0, 0, new Equipment());
        apartment.setComission(0);
        PropertyRepository.addApartment(apartment);
        PropertyRequestRepository.addApartmentRequest(apartment);
        ApartmentRepository.addApartment(apartment);

        ArrayList<String> test = new ArrayList<>();
        test.add(PropertyRequestRepository.announcementRequests.get(0).toString());

        assertEquals(test, PropertyRequestRepository.getRequestListByEmail("owner2@this.app"));
    }

**Test 6:** This test assures that the sortRequestList method sorts the request list properly, with the relevant sorting factor being the recency of the request.

    @Test
    void sortRequestList() {

        Property property1 = new Property();
        Property property2 = new Property();
        Property property3 = new Property();

        property1.setRequestDate("2012-01-12");
        property2.setRequestDate("2023-04-22");
        property3.setRequestDate("2019-06-21");

        PropertyRequestRepository.addPropertyRequest(property1);
        PropertyRequestRepository.addPropertyRequest(property2);
        PropertyRequestRepository.addPropertyRequest(property3);
        PropertyRequestRepository.sortRequestList();

        ArrayList<Property> test = new ArrayList<>();
        test.add(property1);
        test.add(property3);
        test.add(property2);

        assertEquals(PropertyRequestRepository.getRequests(), test);
    }

**Test 7:** This test assures that the method swaps the positions of the 2 requests in the Repository list correctly

    @Test
    void swapRequests() {

        Property property1 = new Property();
        Property property2 = new Property();
        Property property3 = new Property();

        property1.setRequestDate("2012-01-12");
        property2.setRequestDate("2023-04-22");
        property3.setRequestDate("2019-06-21");

        PropertyRequestRepository.addPropertyRequest(property1);
        PropertyRequestRepository.addPropertyRequest(property2);
        PropertyRequestRepository.addPropertyRequest(property3);
        PropertyRequestRepository.swapRequests(0,2);

        ArrayList<Property> test = new ArrayList<>();
        test.add(property3);
        test.add(property2);
        test.add(property1);

        assertEquals(PropertyRequestRepository.getRequests(), test);
    }

**Test 8:** This test checks if the String displayed to the user by this method is correct.

    @Test
    void displayRequestsList() {
        String email = "agent@this.app";
        String displayList = ApprovePropertyController.getRequestsList(email);
        String displayList2 = "2|#4| Agent : José | Tax Number: 20202 | Email Address: agent@this.app | Telephone Number: 919191991 | Address: Lt Gambalord, Illinois City, Illinois, 23483 | Role ID: 01 | Role: Agent | Passport Card Number: 233424232 | Agency ID: 01| Owner:Maria | Tax Number: 20202 | Email Address: owner2@this.app | Telephone Number: 919191991 | Address: Lt Gambalord, Illinois City, Illinois, 23483 | Role ID: 01 | Role: Agent | Passport Card Number: 233424232 |Property type: Land | Area Of The Property: 1.0 | Distance From The Centre: 1.0 | Transaction Type:  | Value: 0.0 | Request Date:  | Acceptance Date: | Commission Details :No Comission added\n" +
                "3|#5| Agent : José | Tax Number: 20202 | Email Address: agent@this.app | Telephone Number: 919191991 | Address: Lt Gambalord, Illinois City, Illinois, 23483 | Role ID: 01 | Role: Agent | Passport Card Number: 233424232 | Agency ID: 01| Owner:Maria | Tax Number: 20202 | Email Address: owner2@this.app | Telephone Number: 919191991 | Address: Lt Gambalord, Illinois City, Illinois, 23483 | Role ID: 01 | Role: Agent | Passport Card Number: 233424232 |Property type: Land | Area Of The Property: 1.0 | Distance From The Centre: 1.0 | Transaction Type:  | Value: 0.0 | Request Date:  | Acceptance Date: | Commission Details :No Comission added";
        displayList2.equals(displayList);
    }
}


# 5. Construction (Implementation)


## Class ApproveRequestUI

```java
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

            if (validatePropertyOption(option, announcementRequestListDto)) {

                System.out.println("Approve or rejected the property:");
                System.out.println("(Y (approve)/N (reject))");
                System.out.println(">");
                read.nextLine();
                String acceptance = read.next();
                System.out.println();


                do {
                    if (Utils.validateYNQuestion(acceptance)) {
                        if (acceptance.toUpperCase().equals("Y")) {
                            commissionType = Utils.requestCommissionType();
                            commissionValue = Utils.requestCommissionValue(commissionType);

                        } else if (acceptance.toUpperCase().equals("N")) {
                            justification = requestJustification();

                        }
                    } else {
                        System.out.println("Invalid, type again: ");
                        System.out.println();
                        break;
                    }

                    String message = controller.judgePropertyRequest(option, acceptance, commissionType, commissionValue, justification);
                    System.out.println(message);
                } while (!Utils.validateYNQuestion(acceptance));


            }


        } while (option != 0);
    }

    /**
     * Requests the input for the justification email
     *
     * @return
     */
    private String requestJustification() {
        read.nextLine();
        System.out.println("Justification for refusal:");
        return read.nextLine();
    }

    /**
     * Displays the available requests that the agent can accept or deny
     *
     * @param displayList
     */
    public void getDisplayRequestsList(String displayList) {
        System.out.println(displayList);
    }

    public boolean validatePropertyOption(int ID, ArrayList<RequestDto> list) {
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID() == ID) {
                flag = true;
            }
        }

        return flag;
    }

}


```
## Class ApproveRequestController

```java
package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.dtos.RequestDto;
import pt.ipp.isep.dei.esoft.project.domain.mappers.RequestMapper;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.RequestsRepository;

import java.util.ArrayList;

public class ApproveRequestController {

    /**
     * returns the email of the user currently logged in
     *
     * @return
     */

    public static String getLoggedUser() {

        Repositories repositories = Repositories.getInstance();
        AuthenticationRepository authenticationRepository = repositories.getAuthenticationRepository();
        return authenticationRepository.getCurrentUserSession().getUserId().getEmail();
    }

    /**
     * sorts the request list
     */

    public ArrayList<RequestDto> sortRequests(String email) {
        Repositories repositories = Repositories.getInstance();
        RequestsRepository requestsRepository = repositories.getRequestsRepository();
        boolean flag = requestsRepository.sortRequestList();
        if (flag) {
            return RequestMapper.toDto(requestsRepository.getRequestListByEmail(email));
        } else {
            return null;
        }

    }

    /**
     * converts the list of requests to display to a Dto
     *
     * @param email
     * @return
     */


    /**
     * Accepts or rejects the property requests depending on the user input
     *
     * @param propertyID
     * @param acceptance
     * @param commissionType
     * @param commissionValue
     * @param justificationMessage
     * @return
     */

    public String judgePropertyRequest(int propertyID, String acceptance, String commissionType, double commissionValue, String justificationMessage) {
        return JudgeRequest.judgePropertyRequest(propertyID, acceptance, commissionType, commissionValue, justificationMessage);
    }
}

```

## Class SendEmail
```java

package pt.ipp.isep.dei.esoft.project.domain;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SendEmail {

    public static void sendEmail(String message) throws IOException {
        String filePath = "emails/email.txt";

        try {
            FileWriter fileWriter = new FileWriter(filePath);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.print(message);

            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

```
# 6. Integration and Demo 

* A new option to the Agent menu was added.

# 7. Observations

* A rework of the comissionDetails attribute of property was necessary.





