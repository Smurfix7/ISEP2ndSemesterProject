package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.NetworkManagingController;

import java.util.ArrayList;
import java.util.List;

public class NetworkManagingUI implements Runnable{

    NetworkManagingController controller = new NetworkManagingController();
    public List<String> answers = new ArrayList<>();
    public List<Integer> l1 = new ArrayList<>(controller.agenciesAndPurchaseDeals.size());
    public List<Integer> l2 = new ArrayList<>(controller.agenciesAndPurchaseDeals.size());

    /**
     * UI Run method.
     */
    @Override
    public void run() {
        System.out.println("Agencies under this network and their deals:");
        System.out.println();
        System.out.println("|-------------------------------|");
        System.out.println("|        Real Estate USA        |");
        System.out.println("|-------------------------------|");
        controller.getAllAgenciesPurchaseDeals();
        if(controller.agenciesAndPurchaseDeals.isEmpty()){
            System.out.println("|       No Purchase Order       |");
            System.out.println("|-------------------------------|");
        }else{
            controller.copyAllcontents(controller.agenciesAndPurchaseDeals, l1);
            controller.copyAllcontents(controller.agenciesAndPurchaseDeals, l2);
            controller.testForEveryNumber(l1, l2, controller.agenciesAndPurchaseDeals, answers);
            controller.organizeList(l1, l2, answers.get(0));
            for (int j = 0; j < 2; j++) {
                System.out.println("|            Subset "+(j+1)+"           |");
                System.out.println("|-------------------------------|");
                if (j == 0) {
                    for (int i = 0; i < controller.agenciesAndPurchaseDeals.size(); i++) {
                        if (l1.get(i) != 0) {
                            System.out.format("|%7s - %2d | Deals Made - %2d |\n", "Agency", i+1, l1.get(i));
                        }
                    }
                    System.out.println("|-------------------------------|");
                } else {
                    for (int i = 0; i < controller.agenciesAndPurchaseDeals.size(); i++) {
                        if (l2.get(i) != 0) {
                            System.out.format("|%7s - %2d | Deals Made - %2d |\n", "Agency", i+1, l2.get(i));
                        }
                    }
                    System.out.println("|-------------------------------|");
                }
            }
            String difference = "Difference: " + answers.get(1);
            int totalWidth = 31; // Total width of the column

            int differenceWidth = difference.length();
            int paddingWidth = totalWidth - differenceWidth;
            int leftPaddingWidth = paddingWidth / 2;
            int rightPaddingWidth = paddingWidth - leftPaddingWidth;

            String formattedDifference = String.format("|%" + leftPaddingWidth + "s%s%" + rightPaddingWidth + "s|", "", difference, "");

            System.out.println(formattedDifference);
            System.out.println("|-------------------------------|");
        }



    }
}
