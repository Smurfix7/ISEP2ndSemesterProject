package pt.ipp.isep.dei.esoft.project.ui.gui.userstories;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.ui.Bootstrap;


import java.io.IOException;

public class US015_US016GUI extends Application {
    public static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(US015_US016GUI.class.getResource("us015-us016-stage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        US015_US016GUI.stage=stage;
        stage.setResizable(false);
        stage.setTitle("TechSupport Scammers - US015");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}