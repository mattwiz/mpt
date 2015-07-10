/*******************************************************************************
 * Administrative Information (automatically filled in)
 *
 * @ Project: ModernPortfolioTheory
 * @ File Name: PortfolioTest.java
 * @ Author: Matthias Wiselka
 * @ Date: Jul 9, 2015 9:33:18 AM
 *
 * $Revision$
 * $LastChangedBy$
 * $LastChangedDate$
 *
 ******************************************************************************/
package com.personalcapital.mc;

import org.junit.Before;
import org.junit.Test;

import com.personalcapital.mc.Portfolio;

import static org.junit.Assert.assertEquals;

/**
 * The Class PortfolioTest.
 */
public class PortfolioTest extends BaseTest {

    private static final double INVESTMENT = 100000;
    private static final double MEAN_RETURN = 0.5;
    private static final double RISK = 0.05;

    private Portfolio objectToTest;

    /**
     * Sets the up.
     *
     * @throws Exception
     *             the exception
     */
    @Before
    public void setUp()
        throws Exception {

        this.objectToTest = new Portfolio(INVESTMENT, MEAN_RETURN, RISK);
    }

    /**
     * Test get risk.
     */
    @Test
    public void testGetRisk() {

        assertEquals(RISK, this.objectToTest.getRisk(), DELTA);
    }

    /**
     * Test get mean return.
     */
    @Test
    public void testGetMeanReturn() {

        assertEquals(MEAN_RETURN, this.objectToTest.getMeanReturn(), DELTA);
    }

    /**
     * Test get investment.
     */
    @Test
    public void testGetInvestment() {

        assertEquals(INVESTMENT, this.objectToTest.getInvestment(), DELTA);
    }
}
