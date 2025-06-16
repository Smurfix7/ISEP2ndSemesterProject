package pt.ipp.isep.dei.esoft.project.ui.console.menu;


import pt.ipp.isep.dei.esoft.project.ui.console.CreateTaskUI;
import pt.ipp.isep.dei.esoft.project.ui.console.ImportLegacyFileUI;
import pt.ipp.isep.dei.esoft.project.ui.console.RegisterEmployeeUI;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Maio pam@isep.ipp.pt
 */

public class AdminUI implements Runnable {
    public AdminUI() {
    }

    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Register Employee (US003)", new RegisterEmployeeUI()));
        options.add(new MenuItem("Import Legacy File (US012)", new ImportLegacyFileUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nAdmin Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}
