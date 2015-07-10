/*******************************************************************************
 * Administrative Information (automatically filled in)
 *
 * @ Project: ModernPortfolioTheory
 * @ File Name: InflationTest.java
 * @ Author: Matthias Wiselka
 * @ Date: Jul 9, 2015 9:12:52 AM
 *
 * $Revision$
 * $LastChangedBy$
 * $LastChangedDate$
 *
 ******************************************************************************/

package com.personalcapital.mc;

import org.junit.Before;
import org.junit.Test;

import com.personalcapital.mc.Inflation;

import static org.junit.Assert.assertEquals;

/**
 * The Class InflationTest.
 *
 * @Author Matthias Wiselka
 */
public class InflationTest extends BaseTest {

    private static final double AMOUNT_ZERO = 0.0;
    private static final double AMOUNT_HIGH = 10000.0;

    private static final double EXPECTED_AMOUNT_HIGH_INT_ZERO_Y = AMOUNT_HIGH;
    private static final double EXPECTED_AMOUNT_HIGH_INT_ONE_Y = 9900.99;
    private static final double EXPECTED_AMOUNT_HIGH_INT_TEN_Y = 9052.87;

    private static final double INTEREST_ZERO = 0.0;
    private static final double INTEREST_HIGH = 0.01;

    private static final int YEARS_ZERO = 0;
    private static final int YEARS_ONE = 1;
    private static final int YEARS_TEN = 10;

    /**
     * Sets the up.
     *
     * @throws Exception
     *             the exception
     */
    @Before
    public void setUp()
        throws Exception {

    }

    /**
     * Testing interest on the amount zero.
     */
    @Test
    public void testAdjust_AmountZero() {

        assertEquals(AMOUNT_ZERO, Inflation.adjust(AMOUNT_ZERO, INTEREST_ZERO, YEARS_ZERO), DELTA);
        assertEquals(AMOUNT_ZERO, Inflation.adjust(AMOUNT_ZERO, INTEREST_ZERO, YEARS_TEN), DELTA);

        assertEquals(AMOUNT_ZERO, Inflation.adjust(AMOUNT_ZERO, INTEREST_HIGH, YEARS_ZERO), DELTA);
        assertEquals(AMOUNT_ZERO, Inflation.adjust(AMOUNT_ZERO, INTEREST_HIGH, YEARS_TEN), DELTA);
    }

    /**
     * Testing interest on a high amount with rising interest rates for zero years.
     */
    @Test
    public void testAdjust_AmountHigh_InterestsRising_ZeroYears() {

        assertEquals(AMOUNT_HIGH, Inflation.adjust(AMOUNT_HIGH, INTEREST_ZERO, YEARS_ZERO), DELTA);
        assertEquals(AMOUNT_HIGH, Inflation.adjust(AMOUNT_HIGH, INTEREST_HIGH, YEARS_ZERO), DELTA);
    }

    /**
     * Testing interest on a high amount.
     */
    @Test
    public void testAdjust_AmountHigh_ZeroInterest_OverYears() {

        assertEquals(AMOUNT_HIGH, Inflation.adjust(AMOUNT_HIGH, INTEREST_ZERO, YEARS_ZERO), DELTA);
        assertEquals(AMOUNT_HIGH, Inflation.adjust(AMOUNT_HIGH, INTEREST_ZERO, YEARS_ONE), DELTA);
        assertEquals(AMOUNT_HIGH, Inflation.adjust(AMOUNT_HIGH, INTEREST_ZERO, YEARS_TEN), DELTA);
    }

    /**
     * Testing interest on a high amount with high interest over multiple years.
     */
    @Test
    public void testAdjust_AmountHigh_HighInterest_OverYears() {

        assertEquals(EXPECTED_AMOUNT_HIGH_INT_ZERO_Y, Inflation.adjust(AMOUNT_HIGH, INTEREST_HIGH, YEARS_ZERO), DELTA);
        assertEquals(EXPECTED_AMOUNT_HIGH_INT_ONE_Y, Inflation.adjust(AMOUNT_HIGH, INTEREST_HIGH, YEARS_ONE), DELTA);
        assertEquals(EXPECTED_AMOUNT_HIGH_INT_TEN_Y, Inflation.adjust(AMOUNT_HIGH, INTEREST_HIGH, YEARS_TEN), DELTA);
    }
}
