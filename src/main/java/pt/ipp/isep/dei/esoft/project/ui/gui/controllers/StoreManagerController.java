package pt.ipp.isep.dei.esoft.project.ui.gui.controllers;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.ui.gui.MainGUI;
import pt.ipp.isep.dei.esoft.project.ui.gui.StoreManagerGUI;
import pt.ipp.isep.dei.esoft.project.ui.gui.userstories.US018GUI;

public class StoreManagerController {

    Application us18Stage = new US018GUI();
    @FXML
    protected void onUs18ButtonButtonClick() throws Exception {
        us18Stage.start(new Stage());
        StoreManagerGUI.stage.close();
    }

    @FXML
    protected void onReturnButtonClick() {
        MainGUI.stage.show();
        StoreManagerGUI.stage.close();
    }

}
