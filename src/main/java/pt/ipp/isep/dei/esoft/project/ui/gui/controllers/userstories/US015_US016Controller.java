package pt.ipp.isep.dei.esoft.project.ui.gui.controllers.userstories;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import pt.ipp.isep.dei.esoft.project.application.controller.ApproveVisitRequestController;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;
import pt.ipp.isep.dei.esoft.project.domain.dtos.VisitRequestsListDTO;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;
import pt.ipp.isep.dei.esoft.project.ui.gui.AgentGUI;
import pt.ipp.isep.dei.esoft.project.ui.gui.JavaFXInformationDisplay;
import pt.ipp.isep.dei.esoft.project.ui.gui.userstories.US015_US016GUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class US015_US016Controller implements Initializable {
    @FXML
    private TextArea visitRequestsTextArea = new TextArea();
    @FXML
    private TextField selectVisitTextField = new TextField();
    @FXML
    private TextField justificationTextField = new TextField();
    @FXML
    private TextField beginDateTextField = new TextField();
    @FXML
    private TextField endDateTextField = new TextField();
    @FXML
    private Button acceptButton = new Button();
    @FXML
    private Button refuseButton = new Button();
    @FXML
    private Button bubbleSortingButton = new Button();
    @FXML
    private Button insertionSortingButton = new Button();
    @FXML
    private Button filterButton = new Button();
    @FXML
    private Label selectVisitLabel = new Label();
    @FXML
    private Label acceptLabel = new Label();
    @FXML
    private Label errorLabel = new Label();
    @FXML
    private Label errorBeginDateLabel = new Label();
    @FXML
    private Label errorEndDateLabel = new Label();
    @FXML
    private Label errorJustificationLabel = new Label();


    private final ApproveVisitRequestController controller = new ApproveVisitRequestController();
    private final JavaFXInformationDisplay informationDisplay = new JavaFXInformationDisplay();
    private String agentName = controller.getLoggedAgent();
    private String beginDate;
    private String endDate;
    private VisitRequest visitRequest;
    private VisitRequestsListDTO visitRequestFromDTO;
    private List<VisitRequestsListDTO> visitRequestsListDTO = new ArrayList<>();
    private boolean acceptance;
    private String justification;
    private String algorithm = "";


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        deactivateSelectVisit(true);
        resetList();
    }

    private void resetList() {
        visitRequestsListDTO = controller.toVisitRequestsListDTO();
        showList(visitRequestsListDTO, ">>  Visit Requests  <<");
    }


    private void showList(List list, String header) {
        informationDisplay.reset();
        informationDisplay.addSentence(header);
        int index = 0;
        for (Object o : list) {
            index++;

            informationDisplay.addSentence(index + ". " + o.toString());
        }
        informationDisplay.addSentence("");
        visitRequestsTextArea.setText(informationDisplay.toString());
    }

    private void submitData() {
        controller.judgeVisitRequest(agentName, visitRequest, acceptance, justification);
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

    @FXML
    protected void onResetButton() {
        resetList();
        deactivateSelectVisit(true);
        errorLabel.setText("");
        justificationTextField.setText("");
        selectVisitTextField.setText("");
        beginDateTextField.setText("");
        endDateTextField.setText("");
    }

    @FXML
    protected void deactivateSelectVisit(boolean b) {
        selectVisitLabel.setDisable(b);
        acceptLabel.setDisable(b);
        selectVisitTextField.setDisable(b);
        justificationTextField.setDisable(b);
        acceptButton.setDisable(b);
        refuseButton.setDisable(b);
    }

    @FXML
    protected boolean checkVisitRequest() {
        double visitRequestPosition = Double.parseDouble(selectVisitTextField.getText()) - 1;
        if (visitRequestPosition >= 0 && visitRequestPosition < visitRequestsListDTO.size()) {
            return true;
        }
        return false;
    }

    @FXML
    protected void onBubbleSortingButton() {
        algorithm = controller.sendAlgorithm("bubble");
        visitRequestsListDTO = controller.sortVisitRequestsList(visitRequestsListDTO, algorithm);
        informationDisplay.reset();
        showList(visitRequestsListDTO, ">> Visit Requests Sorted <<");
    }

    @FXML
    protected void onInsertionSortingButton() {
        algorithm = controller.sendAlgorithm("insertion");
        ;
        visitRequestsListDTO = controller.sortVisitRequestsList(visitRequestsListDTO, algorithm);
        informationDisplay.reset();
        showList(visitRequestsListDTO, ">> Visit Requests Sorted <<");
    }

    @FXML
    protected void onFilterButton() {
        beginDate = beginDateTextField.getText();
        endDate = endDateTextField.getText();

        if (!validateDate(beginDate)) {
            errorBeginDateLabel.setText("Invalid Begin Date. (##-##-####)");
        } else if (!validateDate(endDate)) {
            errorEndDateLabel.setText("Invalid End Date. (##-##-####)");
        } else {
            visitRequestsListDTO = controller.sendDates(beginDate, endDate, visitRequestsListDTO);
            showList(visitRequestsListDTO, ">> Select a visit request if you want: <<");
            deactivateSelectVisit(false);
        }

    }

    @FXML
    protected void onAcceptButton() {
        if (checkVisitRequest()) {
            errorLabel.setText("");
            visitRequestFromDTO = visitRequestsListDTO.get(Integer.parseInt(selectVisitTextField.getText()) - 1);
            visitRequest = controller.getVisitRequestedByID(String.valueOf(visitRequestFromDTO.getId()));
            acceptance = true;
            justification = null;
            submitData();
            onResetButton();
        } else {
            errorLabel.setText("Visit Request not Found. Try again.");
        }

    }

    @FXML
    protected void onRefuseButton() {
        if (checkVisitRequest()) {
            if (!justificationTextField.getText().equalsIgnoreCase("")) {
                errorLabel.setText("");
                visitRequestFromDTO = visitRequestsListDTO.get(Integer.parseInt(selectVisitTextField.getText()) - 1);
                visitRequest = controller.getVisitRequestedByID(String.valueOf(visitRequestFromDTO.getId()));
                acceptance = false;
                justification = justificationTextField.getText();
                submitData();
                onResetButton();
            } else {
                errorJustificationLabel.setText("If you wish to decline the visit request, please justify it.");
            }
        } else {
            errorLabel.setText("Visit Request not Found. Try again.");
        }
    }

    @FXML
    protected void onReturnButtonClick() {
        if (AgentGUI.stage != null) {
            AgentGUI.stage.show();
        }
        US015_US016GUI.stage.close();
    }

}
