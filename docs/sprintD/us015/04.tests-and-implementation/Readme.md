# US 015 - To list all booking requests for properties managed by me

# 4. Tests 

**Test 1:** Tests if it's possible to get the name of the logged agent through the controller.

    @Test
    void getLoggedAgent() {
    }

**Test 2:** Tests if the created DTO Visit Requests List is the same as the Repository, but filtered to the logged agent.

    @Test
    void toVisitRequestsListDTO() {
    }

**Test 3:** Tests if the method filters the DTO list with the dates inputted.

    @Test
    void sendDates() {
    }

**Test 4:** Tests if the algorithm the method gets is correct.

    @Test
    void sendAlgorithm() {
    }

**Test 5:** Tests if the DTO list gets sorted with the algorithm selected.

    @Test
    void sortVisitRequestsList() {
    }

**Test 6:** Tests if the message sent in the email is correct.

    @Test
    void judgeVisitRequest() {
    }

**Test 7:** Tests if it is possible to get a VisitRequest by the ID and if it is the correct one.

    @Test
    void getVisitRequestedByID() {
    }

# 5. Construction (Implementation)


## Class ApproveVisitRequestUI 

```java
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

    /**
     * UI Run method
     */
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
     * Submit the data
     *
     * @return input data
     */
    private void submitData() {
        controller.judgeVisitRequest(agentName, visitRequest, acceptance, justification);
    }

    /**
     * Requests the data
     *
     * @return input data
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
        if (visitRequestFromDTO!=null) {
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
     * Requests the input for the justification email
     *
     * @return
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
     * Requests the input for the justification email
     *
     * @return
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

    public static boolean validateSortingAlgorithms(String answer) {
        if (answer.equalsIgnoreCase("bubble") || answer.equalsIgnoreCase("insertion")) {
            return true;
        } else {
            return false;
        }
    }

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
     * Requests the input for the justification email
     *
     * @return
     */
    private String requestJustification() {
        read.nextLine();
        System.out.println("Justification for refusal: ");
        return read.nextLine();
    }
}
```

## Class ApproveVisitRequestController

```java
public class ApproveVisitRequestController {
    private static final Repositories repositories = Repositories.getInstance();
    AuthenticationRepository authenticationRepository = repositories.getAuthenticationRepository();
    VisitRequestsRepository visitRequestsRepository = repositories.getVisitRequestsRepository();

    private List<VisitRequest> visitRequestsList = visitRequestsRepository.getVisitRequests();

    /**
     * returns the name of the agent currently logged in
     *
     * @return
     */
    public String getLoggedAgent() {
        return authenticationRepository.getCurrentUserSession().getUserName();
    }

    public List<VisitRequestsListDTO> toVisitRequestsListDTO() {
        return VisitRequestsListMapper.createVisitRequestsListDTO(visitRequestsList,authenticationRepository.getCurrentUserSession().getUserId().getEmail());
    }

    public List<VisitRequestsListDTO> sendDates(String beginDate, String endDate, List<VisitRequestsListDTO> visitRequestsListDTO) {
        return VisitRequestsRepository.filterVisitRequestsListDTO(beginDate,endDate, visitRequestsListDTO);
    }


    public String sendAlgorithm(String algorithm) {
        return ConfigReaderSortingAlgorithms.getSortingAlgorithm("src/main/resources/config.sorting_algorithms", algorithm);
    }

    public List<VisitRequestsListDTO> sortVisitRequestsList(List<VisitRequestsListDTO> visitRequestsListDTO, String algorithm) {
        if (sendAlgorithm(algorithm).equalsIgnoreCase("bubble_algorithm")) {
            SortingAlgorithms.bubbleSort(visitRequestsListDTO);
        } else {
            SortingAlgorithms.insertionSort((visitRequestsListDTO));
        }
        return visitRequestsListDTO;
    }


    public String judgeVisitRequest(String agentName, VisitRequest visitRequest, boolean acceptance, String justification) {
        return JudgeVisitRequest.judgeVisitRequest(agentName, visitRequest, acceptance, justification);
    }

    public VisitRequest getVisitRequestedByID(String valueOf) {
        return visitRequestsRepository.getVisitRequestedByID(valueOf);
    }
}
```

# 6. Integration and Demo 

* None at the moment


# 7. Observations

The AuthenticationUI has a similar use as this US, so it's hard to differentiate between them.





