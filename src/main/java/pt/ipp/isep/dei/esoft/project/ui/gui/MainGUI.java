package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.ui.Bootstrap;

import java.io.IOException;

public class MainGUI extends Application {
    public static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.run();
        FXMLLoader fxmlLoader = new FXMLLoader(MainGUI.class.getResource("main-stage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        MainGUI.stage =stage;
        stage.setResizable(false);
        stage.setTitle("TechSupport Scammers - Main");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}