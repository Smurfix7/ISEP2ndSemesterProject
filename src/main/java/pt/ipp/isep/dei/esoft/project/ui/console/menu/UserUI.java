package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.ui.console.*;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class UserUI implements Runnable{
    @Override
    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();

        options.add(new MenuItem("List Properties (US001)", new DisplayPropertyListUI()));
        options.add(new MenuItem("Create Listing (US004)", new CreateListingUI()));
        options.add(new MenuItem("Request a Visit to a Property (US009)", new VisitRequestUI()));
        options.add(new MenuItem("Create a Purchase Order (US010)", new CreatePurchaseOrderUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nUser Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}
