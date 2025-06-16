package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.ui.Bootstrap;

import java.io.IOException;

public class AgentGUI extends Application {
    public static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AgentGUI.class.getResource("agent-stage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        AgentGUI.stage=stage;
        stage.setResizable(false);
        stage.setTitle("TechSupport Scammers - Agent");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}