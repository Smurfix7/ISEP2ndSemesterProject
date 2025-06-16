package pt.ipp.isep.dei.esoft.project.ui.console.menu;


import javafx.application.Application;
import pt.ipp.isep.dei.esoft.project.ui.console.AcceptPurchaseOrderUI;
import pt.ipp.isep.dei.esoft.project.ui.console.ApproveVisitRequestUI;
import pt.ipp.isep.dei.esoft.project.ui.console.CreateAnnouncementUI;
import pt.ipp.isep.dei.esoft.project.ui.console.ApproveRequestUI;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;
import pt.ipp.isep.dei.esoft.project.ui.gui.userstories.US015_US016GUI;

import java.util.ArrayList;
import java.util.List;

public class AgentUI implements Runnable{

    @Override
    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();

        options.add(new MenuItem("Create Announcement (US002)", new CreateAnnouncementUI()));
        options.add(new MenuItem("Approve a Listing Request (US008)", new ApproveRequestUI()));
        options.add(new MenuItem("Approve a Purchase Order (US011)", new AcceptPurchaseOrderUI()));
        options.add(new MenuItem("Approve a Visit Request (US015/US016)", new ApproveVisitRequestUI()));
        options.add(new MenuItem("Approve a Visit Request [JAVAFX] (US015)", new US015_US016GUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nAgent Menu:");

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
