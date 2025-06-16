package pt.ipp.isep.dei.esoft.project.domain;

import org.apache.commons.math3.distribution.FDistribution;
import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.SimpleLinear;

import java.text.DecimalFormat;

public class SimpleLinearTest {

    private SimpleLinear simpleLinear;
    private DecimalFormat df;

    /**
     *  Initialize SimpleLinear object for testing
     */
    @BeforeEach
    public void setUp() {

        simpleLinear = new SimpleLinear();
        df = new DecimalFormat("#.###");
    }

    /**
     * Test case for retrieving coefficients
     */
    @Test
    public void testGetCoefficients() {
        // Set up test data
        double expectedSlope = 0.5;
        double expectedIntercept = 1.0;
        simpleLinear = new SimpleLinear(null, 0, 0, 0, 0, 0, 0, 0, 0, 0, expectedSlope, expectedIntercept, null, 0);

        // Execute the method being tested
        double[] coefficients = simpleLinear.getCoefficients();

        // Verify the result
        Assertions.assertArrayEquals(new double[]{expectedSlope, expectedIntercept}, coefficients);
    }

    /**
     * Test case for retrieving sum of X's
     */
    @Test
    public void testGetSxx() {
        // Set up test data
        double expectedSxx = 10.0;
        simpleLinear = new SimpleLinear(null, 0, expectedSxx, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, 0);

        // Execute the method being tested
        double result = simpleLinear.getSxx();

        // Verify the result
        Assertions.assertEquals(expectedSxx, result);
    }
    /**
     * Test case for retrieving sum of X's times Y's
     */
    @Test
    public void testGetSxy() {
        // Set up test data
        double expectedSxy = 5.0;
        simpleLinear = new SimpleLinear(null, 0, 0, 0, expectedSxy, 0, 0, 0, 0, 0, 0, 0, null, 0);

        // Execute the method being tested
        double result = simpleLinear.getSxy();

        // Verify the result
        Assertions.assertEquals(expectedSxy, result);
    }

    /**
     * Test case for retrieving sum of Y's
     */
    @Test
    public void testGetSyy() {
        // Set up test data
        double expectedSyy = 15.0;
        simpleLinear = new SimpleLinear(null, 0, 0, expectedSyy, 0, 0, 0, 0, 0, 0, 0, 0, null, 0);

        // Execute the method being tested
        double result = simpleLinear.getSyy();

        // Verify the result
        Assertions.assertEquals(expectedSyy, result);
    }

    /**
     * Test case for retrieving average of X
     */

    @Test
    public void testGetAvgX() {
        // Set up test data
        double expectedAvgX = 10.0;
        simpleLinear = new SimpleLinear(null, 0, 0, 0, 0, 0, 0, expectedAvgX, 0, 0, 0, 0, null, 0);

        // Execute the method being tested
        double result = simpleLinear.getAvgX();

        // Verify the result
        Assertions.assertEquals(expectedAvgX, result);
    }

    /**
     * Test case for retrieving average of Y
     */
    @Test
    public void testGetAvgY() {
        // Set up test data
        double expectedAvgY = 20.0;
        simpleLinear = new SimpleLinear(null, 0, 0, 0, 0, 0, 0, 0, expectedAvgY, 0, 0, 0, null, 0);

        // Execute the method being tested
        double result = simpleLinear.getAvgY();

        // Verify the result
        Assertions.assertEquals(expectedAvgY, result);
    }

    /**
     * Test case for retrieving number of independent variables
     */
    @Test
    public void testGetN() {
        // Set up test data
        int expectedN = 50;
        simpleLinear = new SimpleLinear(null, 0, 0, 0, 0, 0, 0, 0, 0, expectedN, 0, 0, null, 0);

        // Execute the method being tested
        int result = simpleLinear.getN();

        // Verify the result
        Assertions.assertEquals(expectedN, result);
    }

    /**
     * Test case for retrieving standart error
     */
    @Test
    public void testGetRegressionStandardError() {
        // Set up test data
        double expectedRegressionStdErr = 0.577;
        simpleLinear = new SimpleLinear(null, 0,1.2, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, 0);

        // Execute the method being tested
        double result = simpleLinear.getRegression().getSlopeConfidenceInterval();

        // Verify the result
        Assertions.assertEquals(Double.parseDouble(df.format(expectedRegressionStdErr)), result);
    }



    /**
     * Test case for predicting Y
     */
    @Test
    public void testPredictY() {
        // Set up test data
        double[] expectedX = {1.0, 2.0, 3.0, 4.0, 5.0};
        double expectedY = 8.0;
        simpleLinear = new SimpleLinear();

        // Execute the method being tested
        double result = Double.parseDouble(simpleLinear.predictSimple(expectedY));

        // Verify the result
        double result1 = 3.5;
    }
}
