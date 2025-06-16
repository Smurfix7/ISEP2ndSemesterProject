package pt.ipp.isep.dei.esoft.project.ui.gui.controllers.userstories;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import pt.ipp.isep.dei.esoft.project.application.controller.NetworkManagingController;
import pt.ipp.isep.dei.esoft.project.ui.gui.JavaFXInformationDisplay;
import pt.ipp.isep.dei.esoft.project.ui.gui.NetworkManagerGUI;
import pt.ipp.isep.dei.esoft.project.ui.gui.userstories.US019GUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class US019Controller implements Initializable {
    @FXML
    private TextArea subset1TextArea = new TextArea();
    @FXML
    private TextArea subset2TextArea = new TextArea();
    @FXML
    private Label agencyLabel = new Label();
    @FXML
    private Label differenceLabel = new Label();

    NetworkManagingController controller = new NetworkManagingController();
    JavaFXInformationDisplay informationDisplay = new JavaFXInformationDisplay();
    public List<Integer> l1 = new ArrayList<>(controller.agenciesAndPurchaseDeals.size());
    public List<Integer> l2 = new ArrayList<>(controller.agenciesAndPurchaseDeals.size());

    public List<String> answers = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        printSubsetRecipt1();
        printSubsetRecipt2();

    }

    private void printSubsetRecipt1() {
        informationDisplay.reset();
        informationDisplay.addSentence("|-------------------------------|");
        informationDisplay.addSentence("|        Real Estate USA        |");
        informationDisplay.addSentence("|-------------------------------|");
        controller.getAllAgenciesPurchaseDeals();
        if (controller.agenciesAndPurchaseDeals.isEmpty()) {
            informationDisplay.addSentence("|       No Purchase Order       |");
            informationDisplay.addSentence("|-------------------------------|");
            differenceLabel.setText("");
        } else {
            controller.copyAllcontents(controller.agenciesAndPurchaseDeals, l1);
            controller.copyAllcontents(controller.agenciesAndPurchaseDeals, l2);
            controller.testForEveryNumber(l1, l2, controller.agenciesAndPurchaseDeals, answers);
            controller.organizeList(l1, l2, answers.get(0));
            informationDisplay.addSentence("|            Subset 1           |");
            informationDisplay.addSentence("|-------------------------------|");
            for (int i = 0; i < controller.agenciesAndPurchaseDeals.size(); i++) {
                if (l1.get(i) != 0) {
                    if (l1.get(i) >= 100) {
                        informationDisplay.addSentence("| Agency - " + (i+1) + " | Deals Made - " + l1.get(i) + " |");
                    } else if (l1.get(i) >= 10) {
                        informationDisplay.addSentence("| Agency - " + (i+1) + " | Deals Made - " + l1.get(i) + "  |");
                    } else {
                        informationDisplay.addSentence("| Agency - " + (i+1) + " | Deals Made - " + l1.get(i) + "   |");
                    }
                }
            }
            informationDisplay.addSentence("|-------------------------------|");
            differenceLabel.setText("Difference: " + answers.get(1));
        }
        subset1TextArea.setText(informationDisplay.toString());
    }

    private void printSubsetRecipt2() {
        informationDisplay.reset();
        informationDisplay.addSentence("|-------------------------------|");
        informationDisplay.addSentence("|        Real Estate USA        |");
        informationDisplay.addSentence("|-------------------------------|");
        if (controller.agenciesAndPurchaseDeals.isEmpty()) {
            informationDisplay.addSentence("|       No Purchase Order       |");
            informationDisplay.addSentence("|-------------------------------|");
        } else {
            informationDisplay.addSentence("|            Subset 2           |");
            informationDisplay.addSentence("|-------------------------------|");
            for (int i = 0; i < controller.agenciesAndPurchaseDeals.size(); i++) {
                if (l2.get(i) != 0) {
                    if (l2.get(i) >= 100) {
                        informationDisplay.addSentence("| Agency - " + (i+1) + " | Deals Made - " + l2.get(i) + " |");
                    } else if (l2.get(i) >= 10) {
                        informationDisplay.addSentence("| Agency - " + (i+1) + " | Deals Made - " + l2.get(i) + "  |");
                    } else {
                        informationDisplay.addSentence("| Agency - " + (i+1) + " | Deals Made - " + l2.get(i) + "   |");
                    }                }
            }
            informationDisplay.addSentence("|-------------------------------|");
        }

        subset2TextArea.setText(informationDisplay.toString());
    }

    @FXML
    protected void onReturnButtonClick() {
        if (NetworkManagerGUI.stage!=null){
            NetworkManagerGUI.stage.show();
        }
        US019GUI.stage.close();
    }

}
