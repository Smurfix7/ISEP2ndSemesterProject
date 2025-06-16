package pt.ipp.isep.dei.esoft.project.domain;

import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiLinearTest {

    @Test
    void getB() {
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        double[][] params = new double[2][2];
        MultiLinear multi = new MultiLinear(regression, params, 0.05);
        assertEquals(multi.getB(), 0);

    }

    @Test
    void getForecastList() {
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        double[][] params = new double[2][2];
        MultiLinear multi = new MultiLinear(regression, params, 0.05);
        assertEquals(multi.getForecastList(), "");
    }

    @Test
    void testToString() {
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        double[][] params = new double[2][2];
        MultiLinear multi = new MultiLinear(regression, params, 0.05);
        assertEquals(multi.toString(), "");
    }

    @Test
    void anovaSingificanceModel() {
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        double[][] params = new double[2][2];
        MultiLinear multi = new MultiLinear(regression, params, 0.05);
        assertEquals(multi.anovaSingificanceModel(), "");
    }

    @Test
    void calculateCoefficientCondifenceIntervals() {
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        double[][] params = new double[2][2];
        MultiLinear multi = new MultiLinear(regression, params, 0.05);
        assertEquals(multi.calculateCoefficientCondifenceIntervals(), "");
    }

    @Test
    void calculateHypothesisTests() {
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        double[][] params = new double[2][2];
        MultiLinear multi = new MultiLinear(regression, params, 0.05);
        assertEquals(multi.calculateHypothesisTests(), "");
    }

    @Test
    void predictMulti() {
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        double[][] params = new double[2][2];
        MultiLinear multi = new MultiLinear(regression, params, 0.05);
        assertEquals(multi.predictMulti(null), null);
    }

}