package pt.ipp.isep.dei.esoft.project.ui.gui.controllers.userstories;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import pt.ipp.isep.dei.esoft.project.application.controller.ListingDealsController;
import pt.ipp.isep.dei.esoft.project.domain.PurchaseOrder;
import pt.ipp.isep.dei.esoft.project.ui.gui.JavaFXInformationDisplay;
import pt.ipp.isep.dei.esoft.project.ui.gui.NetworkManagerGUI;
import pt.ipp.isep.dei.esoft.project.ui.gui.userstories.US017GUI;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class US017Controller implements Initializable {

    @FXML
    private TextArea displayTextArea = new TextArea();
    @FXML
    private CheckBox bubbleCheckBox= new CheckBox();
    @FXML
    private CheckBox selectionCheckBox = new CheckBox();
    @FXML
    private CheckBox ascendingCheckBox = new CheckBox();
    @FXML
    private CheckBox descendingCheckBox = new CheckBox();
    @FXML
    private Label errorTextLabel = new Label();

    JavaFXInformationDisplay informationDisplay = new JavaFXInformationDisplay();
    ListingDealsController listingDealsController = new ListingDealsController();
    private int selectedAlgorithm = 3;
    private int sortingDirection = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        informationDisplay.addSentence("Default Display:");
        displayList(listingDealsController.getPurchaseOrdersAccepted(), selectedAlgorithm);
    }
    @FXML
    protected void displayList(List<PurchaseOrder> purchaseOrdersAccepted, int selectedAlgorithm){
        informationDisplay.addSentence("\n======= List of all the deals =======\n");
        if (selectedAlgorithm == 3) {
            //Sorted by Most Recent
            if (purchaseOrdersAccepted.size() != 0) {
                for (int i = purchaseOrdersAccepted.size() - 1; i >= 0; i--) {
                    informationDisplay.addSentence(purchaseOrdersAccepted.get(i).toString());
                }
            } else {
                informationDisplay.addSentence("No Deals Made.");
            }
        } else {
            //Sorted by an Algorithm
            if (purchaseOrdersAccepted.size() != 0) {
                for (int i = 0; i < purchaseOrdersAccepted.size(); i++) {
                    informationDisplay.addSentence(purchaseOrdersAccepted.get(i).toString());
                }
            } else {
                informationDisplay.addSentence("No Deals Made.");
            }
        }
        informationDisplay.addSentence("\n=====================================\n");
        displayTextArea.setText(informationDisplay.toString());
    }

    @FXML
    protected void onSortButtonClick() {
        if (ascendingCheckBox.isSelected() || descendingCheckBox.isSelected()) {
            if (selectedAlgorithm == 3) {
                informationDisplay.reset();
                informationDisplay.addSentence("Default Display:");
                displayList(listingDealsController.getPurchaseOrdersAccepted(), selectedAlgorithm);
                errorTextLabel.setText("");
            } else if (selectedAlgorithm == 1) {
                informationDisplay.reset();
                informationDisplay.addSentence("Bubble Display:");
                displayList(listingDealsController.sortListBubble(sortingDirection), selectedAlgorithm);
                errorTextLabel.setText("");
            } else if (selectedAlgorithm == 2) {
                informationDisplay.reset();
                informationDisplay.addSentence("Selection Display:");
                displayList(listingDealsController.sortListSelection(sortingDirection), selectedAlgorithm);
                errorTextLabel.setText("");
            }
        } else {
            errorTextLabel.setText("Please select the Sorting Direction.");
        }
    }
    @FXML
    protected void onResetButtonClick(){
        informationDisplay.reset();
        informationDisplay.addSentence("Default Display:");
        selectedAlgorithm=3;
        displayList(listingDealsController.getPurchaseOrdersAccepted(), selectedAlgorithm);
    }

    @FXML
    protected void onReturnButtonClick() {
        if (NetworkManagerGUI.stage!=null){
            NetworkManagerGUI.stage.show();
        }
        US017GUI.stage.close();
    }

    @FXML
    protected void onBubbleCheckBoxClick(){
        if (selectionCheckBox.isSelected()){
            selectionCheckBox.setSelected(false);
        }
        this.selectedAlgorithm =1;
    }

    @FXML
    protected void onSelectionCheckBoxClick(){
        if (bubbleCheckBox.isSelected()){
            bubbleCheckBox.setSelected(false);
        }
        this.selectedAlgorithm =2;
    }

    @FXML
    protected void onAscendingCheckBoxClick(){
        if (descendingCheckBox.isSelected()){
            descendingCheckBox.setSelected(false);
        }
        this.sortingDirection=1;
    }

    @FXML
    protected void onDescendingCheckBoxClick(){
        if (ascendingCheckBox.isSelected()){
            ascendingCheckBox.setSelected(false);
        }
        this.sortingDirection=2;
    }
}
