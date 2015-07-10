/*******************************************************************************
 * Administrative Information (automatically filled in)
 *
 * @ Project: ModernPortfolioTheory
 * @ File Name: PercentileTest.java
 * @ Author: Matthias Wiselka
 * @ Date: Jul 9, 2015 11:37:19 AM
 *
 * $Revision$
 * $LastChangedBy$
 * $LastChangedDate$
 *
 ******************************************************************************/

package com.personalcapital.mc;

import org.junit.Before;
import org.junit.Test;

import com.personalcapital.mc.Percentile;

import static org.junit.Assert.assertEquals;

/**
 * The Class PercentileTest.
 *
 * @Author Matthias Wiselka
 */
public class PercentileTest extends BaseTest {

    private final static double[] LIST_NULL = null;
    private final static double[] LIST_EMPTY = new double[0];
    private final static double[] LIST_ONE = new double[1];
    private final static double[] LIST_FULL_EVEN = new double[100];
    private final static double[] LIST_FULL_ODD = new double[101];

    private static final int PERCENTILE_NEGATIVE = -1;
    private static final int PERCENTILE_ZERO = 0;
    private static final int PERCENTILE_ONE = 1;
    private static final int PERCENTILE_TEN = 10;
    private static final int PERCENTILE_FIFTY = 50;
    private static final int PERCENTILE_NINTEY = 90;
    private static final int PERCENTILE_HUNDRED = 100;
    private static final int PERCENTILE_HIGH = 101;

    /**
     * Sets the up.
     *
     * @throws Exception
     *             the exception
     */
    @Before
    public void setUp()
        throws Exception {

        fillData(LIST_ONE);
        fillData(LIST_FULL_EVEN);
        fillData(LIST_FULL_ODD);
    }

    /**
     * Test list is null.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGet_ListNull() {

        Percentile.get(LIST_NULL, PERCENTILE_ZERO);
    }

    /**
     * Test list is empty.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGet_ListEmpty() {

        Percentile.get(LIST_EMPTY, PERCENTILE_ZERO);
    }

    /**
     * Test zero percentile.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGet_Percentile_Zero() {

        Percentile.get(LIST_FULL_EVEN, PERCENTILE_ZERO);
    }

    /**
     * Test 101 percentile.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGet_Percentile_101() {

        Percentile.get(LIST_FULL_EVEN, PERCENTILE_HIGH);
    }

    /**
     * Test zero percentile.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGet_Percentile_Negative() {

        Percentile.get(LIST_FULL_EVEN, PERCENTILE_NEGATIVE);
    }

    /**
     * Test percentile one on one element list.
     */
    @Test
    public void testGet_ListOne_Percentile_One() {

        assertEquals(LIST_ONE[0], Percentile.get(LIST_ONE, PERCENTILE_ONE), DELTA);
    }

    /**
     * Test percentile 100 on one element list.
     */
    @Test
    public void testGet_ListOne_Percentile_Hundred() {

        assertEquals(LIST_ONE[0], Percentile.get(LIST_ONE, PERCENTILE_HUNDRED), DELTA);
    }

    /**
     * Test percentile 100 on one element list.
     */
    @Test
    public void testGet_ListOne_Percentile_50() {

        assertEquals(LIST_ONE[0], Percentile.get(LIST_ONE, PERCENTILE_FIFTY), DELTA);
    }

    /**
     * Test percentile one on an even element count list.
     */
    @Test
    public void testGet_ListEven_Percentile_One() {

        assertEquals(LIST_FULL_EVEN[0], Percentile.get(LIST_FULL_EVEN, PERCENTILE_ONE), DELTA);
    }

    /**
     * Test percentile 100 on an even element count list.
     */
    @Test
    public void testGet_ListEven_Percentile_Hundred() {

        assertEquals(LIST_FULL_EVEN[99], Percentile.get(LIST_FULL_EVEN, PERCENTILE_HUNDRED), DELTA);
    }

    /**
     * Test percentile 10 on an even element count list.
     */
    @Test
    public void testGet_ListEven_Percentile_10() {

        assertEquals(LIST_FULL_EVEN[9], Percentile.get(LIST_FULL_EVEN, PERCENTILE_TEN), DELTA);
    }

    /**
     * Test percentile 90 on an even element count list.
     */
    @Test
    public void testGet_ListEven_Percentile_90() {

        assertEquals(LIST_FULL_EVEN[89], Percentile.get(LIST_FULL_EVEN, PERCENTILE_NINTEY), DELTA);
    }

    /**
     * Test percentile 50 on an even element count list.
     */
    @Test
    public void testGet_ListEven_Percentile_50() {

        assertEquals(LIST_FULL_EVEN[49], Percentile.get(LIST_FULL_EVEN, PERCENTILE_FIFTY), DELTA);
    }

    /**
     * Test percentile one on an odd element count list.
     */
    @Test
    public void testGet_ListOdd_Percentile_One() {

        assertEquals(LIST_FULL_ODD[0], Percentile.get(LIST_FULL_ODD, PERCENTILE_ONE), DELTA);
    }

    /**
     * Test percentile 100 on an odd element count list.
     */
    @Test
    public void testGet_ListOdd_Percentile_Hundred() {

        assertEquals(LIST_FULL_ODD[100], Percentile.get(LIST_FULL_ODD, PERCENTILE_HUNDRED), DELTA);
    }

    /**
     * Test percentile 10 on an odd element count list.
     */
    @Test
    public void testGet_ListOdd_Percentile_10() {

        assertEquals(LIST_FULL_ODD[9], Percentile.get(LIST_FULL_ODD, PERCENTILE_TEN), DELTA);
    }

    /**
     * Test percentile 90 on an odd element count list.
     */
    @Test
    public void testGet_ListOdd_Percentile_90() {

        assertEquals(LIST_FULL_ODD[89], Percentile.get(LIST_FULL_ODD, PERCENTILE_NINTEY), DELTA);
    }

    /**
     * Test percentile 50 on an odd element count list.
     */
    @Test
    public void testGet_ListOdd_Percentile_50() {

        assertEquals(LIST_FULL_ODD[49], Percentile.get(LIST_FULL_ODD, PERCENTILE_FIFTY), DELTA);
    }

    /**
     * Fills array with test data.
     *
     * @param list
     *            the list
     */
    private void fillData(final double[] list) {

        for (int i = 0; i < list.length; i++) {
            list[i] = i;
        }
    }
}
