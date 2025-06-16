package pt.ipp.isep.dei.esoft.project.ui.gui.userstories;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.ui.Bootstrap;


import java.io.IOException;

public class US019GUI extends Application {
    public static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(US019GUI.class.getResource("us019-stage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        US019GUI.stage=stage;
        stage.setResizable(false);
        stage.setTitle("TechSupport Scammers - US019");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}