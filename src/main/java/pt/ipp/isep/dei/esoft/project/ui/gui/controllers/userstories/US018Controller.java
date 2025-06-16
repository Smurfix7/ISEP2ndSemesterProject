package pt.ipp.isep.dei.esoft.project.ui.gui.controllers.userstories;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import pt.ipp.isep.dei.esoft.project.application.controller.DealsAnalysisController;
import pt.ipp.isep.dei.esoft.project.domain.dtos.RegressionDTO;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;
import pt.ipp.isep.dei.esoft.project.ui.gui.JavaFXInformationDisplay;
import pt.ipp.isep.dei.esoft.project.ui.gui.StoreManagerGUI;
import pt.ipp.isep.dei.esoft.project.ui.gui.userstories.US018GUI;

import java.net.URL;
import java.util.*;

public class US018Controller implements Initializable {
    @FXML
    private TextField areaTextField = new TextField();
    @FXML
    private TextField distanceTextField = new TextField();
    @FXML
    private TextField bedroomsTextField = new TextField();
    @FXML
    private TextField bathroomsTextField = new TextField();
    @FXML
    private TextField parkingTextField = new TextField();
    @FXML
    private TextField significanceTextField = new TextField();

    @FXML
    private Button regressionRunButton = new Button();
    @FXML
    private Button globalResetButton = new Button();
    @FXML
    private Button predictedRunButton = new Button();
    @FXML
    private Button predictedResetButton = new Button();

    @FXML
    private TextArea regressionReportTextArea = new TextArea();
    @FXML
    private TextArea displayPredictedValuesTextArea = new TextArea();

    @FXML
    private ChoiceBox regressionChoiceBox = new ChoiceBox();
    @FXML
    private ChoiceBox parameterChoiceBox = new ChoiceBox();

    JavaFXInformationDisplay informationDisplay = new JavaFXInformationDisplay();
    DealsAnalysisController controller = new DealsAnalysisController();

    RegressionDTO regression = new RegressionDTO();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initRegressionBox();
        initParameterBox();
    }

    private void initRegressionBox() {
        List<String> regressionModelTypes = new ArrayList<>();
        regressionModelTypes.add("SimpleLinearRegression");
        regressionModelTypes.add("MultiLinearRegression");
        ObservableList<String> options = FXCollections.observableList(regressionModelTypes);
        regressionChoiceBox.setItems(options);
    }

    private void initParameterBox() {
        List<String> parameters = new ArrayList<>();
        parameters.add("Property Area");
        parameters.add("Distance from Centre");
        parameters.add("Number of Bedrooms");
        parameters.add("Number of Bathrooms");
        parameters.add("Number of Parking Spaces");
        ObservableList<String> options = FXCollections.observableList(parameters);
        parameterChoiceBox.setItems(options);
    }

    @FXML
    protected void onReturnButtonClick() {
        if (StoreManagerGUI.stage!=null) {
            StoreManagerGUI.stage.show();
        }
        US018GUI.stage.close();
    }

    @FXML
    protected void parametersUpdate() {
        if (regressionChoiceBox.getValue() != null) {
            if (regressionChoiceBox.getValue().toString().equalsIgnoreCase("SimpleLinearRegression")) {
                parameterChoiceBox.setDisable(false);
            }
            if (regressionChoiceBox.getValue().toString().equalsIgnoreCase("MultiLinearRegression")) {
                parameterChoiceBox.setDisable(true);
            }
        }
    }

    @FXML
    protected int getOption() {
        if (regressionChoiceBox.getValue().toString().equalsIgnoreCase("SimpleLinearRegression")) {
            return 1;
        } else {
            return 2;
        }
    }

    @FXML
    protected void onRegressionRunButtonClick() {
        informationDisplay.reset();
        int option = getOption();
        double significanceLevel = Double.parseDouble(significanceTextField.getText());
        int regressionParameter = 0;

        informationDisplay.addSentence("|-=-=-=-=-=-=-=-=-=-=-=-=-=-|");
        informationDisplay.addSentence("|  ANALYSE PROPERTY DEALS   |");
        informationDisplay.addSentence("|-=-=-=-=-=-=-=-=-=-=-=-=-=-|");
        informationDisplay.addSentence("");


        if (option == 1) {
            regressionParameter = getParameter();
            if (regressionParameter != 0) {
                regression = controller.getRegressionModelStats("SimpleRegression", regressionParameter, significanceLevel);
                informationDisplay.addSentence(regression.getReport());
            }

        } else if (option == 2) {
            regression = controller.getRegressionModelStats("OLSMultipleLinearRegression", 0, significanceLevel);
            informationDisplay.addSentence(regression.getReport());
        }
        regressionReportTextArea.setText(informationDisplay.toString());
        predictedRunButton.setDisable(false);
        predictedResetButton.setDisable(false);
        activateRightParameter();
    }

    @FXML
    protected void activateRightParameter() {
        if (getOption() == 1) {
            switch (getParameter()) {
                case 1:
                    areaTextField.setDisable(false);
                    break;
                case 2:
                    distanceTextField.setDisable(false);
                    break;
                case 3:
                    bedroomsTextField.setDisable(false);
                    break;
                case 4:
                    bathroomsTextField.setDisable(false);
                    break;
                case 5:
                    parkingTextField.setDisable(false);
                    break;
            }
        } else {
            areaTextField.setDisable(false);
            distanceTextField.setDisable(false);
            bedroomsTextField.setDisable(false);
            bathroomsTextField.setDisable(false);
            parkingTextField.setDisable(false);
        }
    }

    @FXML
    protected void onPredictedRunButtonClick() {
        informationDisplay.reset();
        if (getOption() == 1) {
            double parameter = getParameterValue();
            informationDisplay.addSentence(controller.predictSimple(regression.getSimple(), parameter));
            displayPredictedValuesTextArea.setText(informationDisplay.toString());
            displayPredictedValuesTextArea.setDisable(false);
        } else {
            double[] parameters = RequestPredictionParametersMulti();
            informationDisplay.addSentence(controller.predictMulti(regression.getMulti(), parameters));
            displayPredictedValuesTextArea.setText(informationDisplay.toString());
            displayPredictedValuesTextArea.setDisable(false);
        }
    }

    private double[] RequestPredictionParametersMulti() {
        double propertyArea = Double.parseDouble(areaTextField.getText());
        double distanceFromCentre = Double.parseDouble(distanceTextField.getText());
        double bedrooms = Double.parseDouble(bedroomsTextField.getText());
        double bathrooms = Double.parseDouble(bathroomsTextField.getText());
        double parkingSpaces = Double.parseDouble(parkingTextField.getText());

        double[] parametersMulti = new double[5];
        parametersMulti[0] = (propertyArea);
        parametersMulti[1] = (distanceFromCentre);
        parametersMulti[2] = (bedrooms);
        parametersMulti[3] = (bathrooms);
        parametersMulti[4] = (parkingSpaces);
        return parametersMulti;
    }

    @FXML
    protected void onPredictedResetButton() {

        areaTextField.setText("");

        distanceTextField.setText("");

        bedroomsTextField.setText("");

        bathroomsTextField.setText("");

        parkingTextField.setText("");

        displayPredictedValuesTextArea.setText("");
        displayPredictedValuesTextArea.setDisable(true);
    }

    @FXML
    protected void onGlobalResetButtonClick(){
        areaTextField.setText("");
        areaTextField.setDisable(true);
        distanceTextField.setText("");
        distanceTextField.setDisable(true);
        bedroomsTextField.setText("");
        bedroomsTextField.setDisable(true);
        bathroomsTextField.setText("");
        bathroomsTextField.setDisable(true);
        parkingTextField.setText("");
        parkingTextField.setDisable(true);

        significanceTextField.setText("");
        regressionReportTextArea.setText("");
        displayPredictedValuesTextArea.setText("");
        displayPredictedValuesTextArea.setDisable(true);
    }

    @FXML
    protected double getParameterValue() {
        switch (getParameter()) {
            case 1:
                return Double.parseDouble(areaTextField.getText());
            case 2:
                return Double.parseDouble(distanceTextField.getText());
            case 3:
                return Double.parseDouble(bedroomsTextField.getText());
            case 4:
                return Double.parseDouble(bathroomsTextField.getText());
            default:
                return Double.parseDouble(parkingTextField.getText());
        }
    }

    @FXML
    protected int getParameter() {
        if (parameterChoiceBox.getValue().toString().equalsIgnoreCase("Property Area")) {
            return 1;
        } else if (parameterChoiceBox.getValue().toString().equalsIgnoreCase("Distance from Centre")) {
            return 2;
        } else if (parameterChoiceBox.getValue().toString().equalsIgnoreCase("Number of Bedrooms")) {
            return 3;
        } else if (parameterChoiceBox.getValue().toString().equalsIgnoreCase("Number of Bathrooms")) {
            return 4;
        } else {
            return 5;
        }
    }

}
