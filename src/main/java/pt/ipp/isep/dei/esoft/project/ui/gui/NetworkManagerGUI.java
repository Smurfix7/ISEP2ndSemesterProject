package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class NetworkManagerGUI extends Application {
    public static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(NetworkManagerGUI.class.getResource("networkmanager-stage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        NetworkManagerGUI.stage=stage;
        stage.setResizable(false);
        stage.setTitle("TechSupport Scammers - NetworkManager");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}