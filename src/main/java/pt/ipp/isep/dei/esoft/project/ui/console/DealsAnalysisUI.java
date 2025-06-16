package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.DealsAnalysisController;
import pt.ipp.isep.dei.esoft.project.domain.dtos.RegressionDTO;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DealsAnalysisUI implements Runnable {

    DealsAnalysisController controller = new DealsAnalysisController();

    /**
     * UI Run method.
     */
    @Override
    public void run() {
        Scanner read = new Scanner(System.in);

        int option = 0;
        double significanceLevel = 0;
        int regressionParameter =0;

        System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-|");
        System.out.println("|  ANALYSE PROPERTY DEALS   |");
        System.out.println("|-=-=-=-=-=-=-=-=-=-=-=-=-=-|");
        System.out.println();

        do{
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Select a regression model for analysis (Type 0 to exit)");
            System.out.println("1 - Simple Linear Regression" +
                    "\n2 - Multi Linear Regression");

            option = read.nextInt();
            System.out.println("Input a Significance Level (]0,1[): ");




            if(option == 1){
                significanceLevel = requestSignificance();
                System.out.println("Select a parameter for the Simple Linear Regression (Type 0 to return)");
                System.out.println("1 - Property Area in m2" +
                        "\n2- Distance from Centre" +
                        "\n3- Number of Bedrooms" +
                        "\n4- Number of Bathrooms" +
                        "\n5- Number of Parking Spaces");

                regressionParameter = read.nextInt();
                while(!(regressionParameter>= 0 && regressionParameter <=5) ){
                    System.out.println("Invalid, type again: ");
                    regressionParameter = read.nextInt();
                }
                if (regressionParameter != 0){
                    RegressionDTO regression = controller.getRegressionModelStats("SimpleRegression", regressionParameter, significanceLevel);
                    System.out.println(regression.getReport());

                    String input = "asd";
                    while (!input.toUpperCase().equals("N")){
                        System.out.println("Do you want to predict the price of a property? (Y/N) ");
                        input = requestPersonalPrediction();
                        if(input.toUpperCase().equals("Y")){
                            double parameter = requestParameter();
                            System.out.println(controller.predictSimple(regression.getSimple(), parameter));
                        } else if (!input.toUpperCase().equals("N")) {
                            System.out.println(">");
                        }
                    }
                }

            } else if (option == 2) {
                significanceLevel = requestSignificance();
                RegressionDTO regression = controller.getRegressionModelStats("OLSMultipleLinearRegression", 0, significanceLevel);
                System.out.println(regression.getReport());
                System.out.println("Do you want to predict the price of a property? (Y/N) ");
                String input = requestPersonalPrediction();
                if(input.toUpperCase().equals("Y")){
                    double[] parameters = RequestPredictionParametersMulti();
                    System.out.println(controller.predictMulti(regression.getMulti(), parameters));
                }
            }





        }while(option != 0);
    }

    /**
     * Request Parameters
     * @return double
     */
    public double requestParameter(){
        Scanner read = new Scanner(System.in);
        double parameter;
        System.out.println("Type the parameter value:");{
            parameter = read.nextDouble();
            while(parameter<=0){
                System.out.println("Invalid, type again: ");
                parameter = read.nextDouble();
            }
        }
        return parameter;
    }

    /**
     * Requests Prediction Parameters Multi
     * @return double[]
     */
    private double[] RequestPredictionParametersMulti() {
        double propertyArea = Utils.requestAreaOfProperty();
        double distanceFromCentre = Utils.requestDistanceFromCentre();
        double bedrooms = Utils.requestBedrooms();
        double bathrooms = Utils.requestBathrooms();
        double parkingSpaces = Utils.requestParkingSpaces();

        double[] parametersMulti = new double[5];
        parametersMulti[0] = (propertyArea);
        parametersMulti[1] = (distanceFromCentre);
        parametersMulti[2] = (bedrooms);
        parametersMulti[3] = (bathrooms);
        parametersMulti[4] = (parkingSpaces);
        return parametersMulti;
    }

    /**
     * Request Personal Prediction
     * @return String
     */
    private String requestPersonalPrediction(){
        Scanner read = new Scanner(System.in);
        String option = read.nextLine();
        if(!Utils.validateYNQuestion(option)){
            System.out.println("Invalid response type again (Y/N):");
            option = read.nextLine();
        }
        return option;
    }

    /**
     * Request Significance Level
     * @return double
     */
    private double requestSignificance() {
        Scanner read = new Scanner(System.in);
        double sig = read.nextDouble();
        while((sig <= 0) | (sig >= 1)){
            System.out.println("Invalid, input another: ");
            sig = read.nextInt();
        }
        return sig;
    }
}
