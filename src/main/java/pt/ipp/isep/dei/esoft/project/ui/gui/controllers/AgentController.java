package pt.ipp.isep.dei.esoft.project.ui.gui.controllers;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.ui.gui.AgentGUI;
import pt.ipp.isep.dei.esoft.project.ui.gui.MainGUI;
import pt.ipp.isep.dei.esoft.project.ui.gui.userstories.US015_US016GUI;

public class AgentController {
    Application us015Stage = new US015_US016GUI();

    @FXML
    protected void onUs15ButtonButtonClick() throws Exception {
        us015Stage.start(new Stage());
        AgentGUI.stage.close();
    }

    @FXML
    protected void onReturnButtonClick() {
        MainGUI.stage.show();
        AgentGUI.stage.close();
    }
}
