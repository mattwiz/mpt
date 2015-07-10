/*******************************************************************************
 * Administrative Information (automatically filled in)
 *
 * @ Project: ModernPortfolioTheory
 * @ File Name: MonteCarloSimulatorTest.java
 * @ Author: WIM1WA2
 * @ Date: Jul 9, 2015 12:16:05 PM
 *
 * $Revision$
 * $LastChangedBy$
 * $LastChangedDate$
 *
 ******************************************************************************/

package com.personalcapital.mc;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * The Class MonteCarloSimulatorTest.
 *
 * @Author Matthias Wiselka
 */
public class MonteCarloSimulatorTest extends BaseTest {

    private static final double RISK_NONE = 0.0;
    private static final double RISK_HIGH = 0.1;
    private static final double RETURN_NONE = 0.0;
    private static final double RETURN_HIGH = 0.1;
    private static final double INVESTMENT = 100000;
    private static final Portfolio PORTFOLIO_STATIC = new Portfolio(INVESTMENT, RETURN_NONE, RISK_NONE);
    private static final Portfolio PORTFOLIO_RISK_NONE = new Portfolio(INVESTMENT, RETURN_HIGH, RISK_NONE);
    private static final Portfolio PORTFOLIO_RETURN_NONE = new Portfolio(INVESTMENT, RETURN_NONE, RISK_HIGH);
    private static final Portfolio PORTFOLIO_DYNAMIC = new Portfolio(INVESTMENT, RETURN_HIGH, RISK_HIGH);

    private static final int YEARS_NEGATIVE = -1;
    private static final int YEARS_ZERO = 0;
    private static final int YEARS_ONE = 1;
    private static final int YEARS_TEN = 0;

    private static final int RUNS_ZERO = 0;
    private static final int RUNS_ONE = 1;
    private static final int RUNS_THOUSAND = 1000;

    private MonteCarloSimulator simulatorToTest;

    /**
     * Sets the up.
     *
     * @throws Exception
     *             the exception
     */
    @Before
    public void setUp()
        throws Exception {

        this.simulatorToTest = new MonteCarloSimulator(PORTFOLIO_STATIC, YEARS_ZERO, RUNS_ONE);
    }

    /**
     * Test constructor for negative years.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_NegativeYears() {

        new MonteCarloSimulator(PORTFOLIO_STATIC, YEARS_NEGATIVE, RUNS_ONE);
    }

    /**
     * Test constructor for zero runs.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_ZeroRuns() {

        new MonteCarloSimulator(PORTFOLIO_STATIC, YEARS_ONE, RUNS_ZERO);
    }

    /**
     * Test constructor for no portfolio.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_NoPortfolio() {

        new MonteCarloSimulator(null, YEARS_ONE, RUNS_ONE);
    }

    /**
     * Test method for {@link com.personalcapital.mc.MonteCarloSimulator#getYears()}.
     */
    @Test
    public void testGetYears() {

        assertEquals(YEARS_ZERO, this.simulatorToTest.getYears());
    }

    /**
     * Test method for {@link com.personalcapital.mc.MonteCarloSimulator#getNumberOfRuns()}.
     */
    @Test
    public void testGetNumberOfRuns() {

        assertEquals(RUNS_ONE, this.simulatorToTest.getNumberOfRuns());
    }

    /**
     * Test method for {@link com.personalcapital.mc.MonteCarloSimulator#getPortfolio()}.
     */
    @Test
    public void testGetPortfolio() {

        assertEquals(PORTFOLIO_STATIC, this.simulatorToTest.getPortfolio());
    }

    /**
     * Test method for {@link com.personalcapital.mc.MonteCarloSimulator#run()}. Single run.
     */
    @Test
    public void testRun_OneRun() {

        double[] result = this.simulatorToTest.run();
        assertEquals(RUNS_ONE, result.length);
        assertEquals(INVESTMENT, result[0], DELTA);
    }

    /**
     * Test method for {@link com.personalcapital.mc.MonteCarloSimulator#run()}. 1000 runs.
     */
    @Test
    public void testRun_ThousandRuns() {

        this.simulatorToTest = new MonteCarloSimulator(PORTFOLIO_STATIC, YEARS_ZERO, RUNS_THOUSAND);
        double[] result = this.simulatorToTest.run();
        assertEquals(RUNS_THOUSAND, result.length);

        for (int i = 0; i < RUNS_THOUSAND; i++) {
            assertEquals(INVESTMENT, result[i], DELTA);
        }
    }

    /**
     * Test simulation run with static portfolio.
     */
    @Test
    public void testSimulateResult_OneYear_PortfolioStatic() {

        this.simulatorToTest = new MonteCarloSimulator(PORTFOLIO_STATIC, YEARS_ONE, RUNS_THOUSAND);

        assertEquals(INVESTMENT, this.simulatorToTest.simulateResult(), DELTA);
    }

    /**
     * Test simulation run with a portfolio without a mean return.
     */
    @Test
    public void testSimulateResult_OneYear_PortfolioNoReturn() {

        this.simulatorToTest = new MonteCarloSimulator(PORTFOLIO_RETURN_NONE, YEARS_ONE, RUNS_THOUSAND);

        double result = this.simulatorToTest.simulateResult();
        assertTrue(INVESTMENT <= result && result <= INVESTMENT * ( 1d + RISK_HIGH ));
    }

    /**
     * Test simulation run with a portfolio without a risk.
     */
    @Test
    public void testSimulateResult_OneYear_PortfolioNoRisk() {

        this.simulatorToTest = new MonteCarloSimulator(PORTFOLIO_RISK_NONE, YEARS_ONE, RUNS_THOUSAND);

        double result = this.simulatorToTest.simulateResult();
        assertEquals(INVESTMENT * ( 1d + RETURN_HIGH ), result, DELTA);
    }

    /**
     * Test simulation run with a dynamic portfolio.
     */
    @Test
    public void testSimulateResult_OneYear_PortfolioDynamic() {

        this.simulatorToTest = new MonteCarloSimulator(PORTFOLIO_DYNAMIC, YEARS_ONE, RUNS_THOUSAND);

        double result = this.simulatorToTest.simulateResult();
        assertTrue(INVESTMENT <= result && result <= INVESTMENT * ( 1d + RETURN_HIGH + RISK_HIGH ));
    }
}
