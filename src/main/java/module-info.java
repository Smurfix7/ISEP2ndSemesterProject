module module {

    requires javafx.controls;
    requires javafx.fxml;
    requires AuthLib;
    requires org.apache.commons.lang3;
    requires jdk.jshell;
    requires java.logging;
    requires commons.math3;


    opens pt.ipp.isep.dei.esoft.project.ui.gui to javafx.fxml;
    exports pt.ipp.isep.dei.esoft.project.ui.gui;
    opens pt.ipp.isep.dei.esoft.project.ui.gui.userstories to javafx.fxml;
    exports pt.ipp.isep.dei.esoft.project.ui.gui.userstories;
    opens pt.ipp.isep.dei.esoft.project.ui.gui.controllers.userstories to javafx.fxml;
    exports pt.ipp.isep.dei.esoft.project.ui.gui.controllers.userstories;
    exports pt.ipp.isep.dei.esoft.project.ui.gui.controllers;
    opens pt.ipp.isep.dei.esoft.project.ui.gui.controllers to javafx.fxml;
}