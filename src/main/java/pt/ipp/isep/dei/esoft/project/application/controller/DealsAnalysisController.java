package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.domain.dtos.RegressionDTO;
import pt.ipp.isep.dei.esoft.project.domain.mappers.RegressionMapper;
import pt.ipp.isep.dei.esoft.project.repository.PurchaseOrderRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;


public class DealsAnalysisController {

    /**
     * Gets the Regression Report
     * @param regressionModelName String
     * @param parameter int
     * @param significanceLevel double
     * @return RegressionDTO
     */
    public RegressionDTO getRegressionModelStats(String regressionModelName, int parameter, double significanceLevel){

        double[][] parameters = getRegressionModelParameters(parameter);
        double[] coefficients = new double[6];
        String report = null;
        MultiLinear multiLinear = null;
        SimpleLinear simpleLinear = null;
        if(regressionModelName.equals("OLSMultipleLinearRegression")){
            RegressionModel multi = new MultiLinearRegression();
            multiLinear = (MultiLinear) multi.getRegressionModel(parameters, significanceLevel);

            report = multiLinear.generateAnalysisReport();

        } else if (regressionModelName.equals("SimpleRegression")) {
            RegressionModel simple = new SimpleLinearRegression();
            simpleLinear = (SimpleLinear) simple.getRegressionModel(parameters, significanceLevel);

            report = simpleLinear.generateAnalysisReport();
        }

        RegressionDTO regressionDto = RegressionMapper.toDto(simpleLinear, multiLinear, report);



        return regressionDto;
    }

    /**
     * Gets the RegressionModel Parameters
     * @param parameterOption int
     * @return double[][]
     */
    public static double[][] getRegressionModelParameters(int parameterOption) {
        int size =6;
        if(parameterOption !=0){size =2;}

        Repositories repositories = Repositories.getInstance();
        PurchaseOrderRepository purchaseOrderRepository = repositories.getPurchaseOrderRepository();

        Double[][] announcementList = purchaseOrderRepository.getParameters(parameterOption);
        double[][] parameters = new double[size][];

        for (int i = 0; i < announcementList.length; i++) {
            parameters[i] = new double[announcementList[i].length];

            for (int j = 0; j < announcementList[i].length; j++) {
                double temp = announcementList[i][j].doubleValue();
                parameters[i][j] = temp;
            }
        }
        return parameters;
    }

    /**
     * Predicts by using the MultiLinear Regression
     * @param multi MultiLinear
     * @param parameters double[]
     * @return String
     */
    public String predictMulti( MultiLinear multi, double[] parameters) {
        return multi.predictMulti(parameters);
    }

    /**
     * Predicts by using the SimpleLinear Regression
     * @param simple SimpleLinear
     * @param parameters double
     * @return String
     */
    public String predictSimple(SimpleLinear simple, double parameters) {
        return simple.predictSimple(parameters);
    }

}
