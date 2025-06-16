package pt.ipp.isep.dei.esoft.project.ui.console.menu;


import javafx.application.Application;
import pt.ipp.isep.dei.esoft.project.ui.console.*;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;
import pt.ipp.isep.dei.esoft.project.ui.gui.userstories.US017GUI;
import pt.ipp.isep.dei.esoft.project.ui.gui.userstories.US019GUI;

import java.util.ArrayList;
import java.util.List;

public class NetworkManagerUI implements Runnable {
    public NetworkManagerUI() {
    }

    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("List All Deals Made (US017)", new ListingDealsUI()));
        options.add(new MenuItem("Dividing a set of stores into two (US019)", new NetworkManagingUI()));
        options.add(new MenuItem("List All Deals Made [JAVAFX] (US017)", new US017GUI()));
        options.add(new MenuItem("Dividing a set of stores into two [JAVAFX] (US019)", new US019GUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nNetwork Manager Menu:");

            if ((option >= 0) && (option < options.size())) {
                if (options.get(option).getGui()==null) {
                    options.get(option).run();
                } else if (options.get(option).getUi()==null) {
                    try {
                        if (!Utils.getApplicationIsLaunched()){
                            Application.launch(options.get(option).getGui().getClass());
                            Utils.setApplicationIsLaunched(true);
                        } else {
                            System.out.println("The program can't reopen the JavaFX interface. \nPlease restart the program if you want to use this functionality again." +
                                    "\n[JavaFX Issue #1]");
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } while (option != -1);
    }
}
