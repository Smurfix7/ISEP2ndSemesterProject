package pt.ipp.isep.dei.esoft.project.ui.gui.controllers;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.ui.gui.MainGUI;
import pt.ipp.isep.dei.esoft.project.ui.gui.NetworkManagerGUI;
import pt.ipp.isep.dei.esoft.project.ui.gui.userstories.US017GUI;
import pt.ipp.isep.dei.esoft.project.ui.gui.userstories.US019GUI;

public class NetworkManagerController {

    Application us17Stage = new US017GUI();

    Application us19Stage = new US019GUI();

    @FXML
    protected void onUs17ButtonButtonClick() throws Exception {
        us17Stage.start(new Stage());
        NetworkManagerGUI.stage.close();
    }

    @FXML
    protected void onUs19ButtonButtonClick() throws Exception {
        us19Stage.start(new Stage());
        NetworkManagerGUI.stage.close();
    }

    @FXML
    protected void onReturnButtonClick() {
        MainGUI.stage.show();
        NetworkManagerGUI.stage.close();
    }

}
