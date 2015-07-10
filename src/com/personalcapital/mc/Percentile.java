/*******************************************************************************
 * Administrative Information (automatically filled in)
 *
 * @ Project: ModernPortfolioTheory
 * @ File Name: Percentile.java
 * @ Author: Matthias Wiselka
 * @ Date: Jul 8, 2015 11:20:41 AM
 *
 * $Revision$
 * $LastChangedBy$
 * $LastChangedDate$
 *
 ******************************************************************************/

package com.personalcapital.mc;

/**
 * The Class Percentile is a utility class for percentile determination.
 *
 * @Author Matthias Wiselka
 */
public final class Percentile {

    /**
     * Instantiates a new percentile.
     */
    private Percentile() {

        // prevent outside instantiation
    }

    /**
     * Gets the value for a percentile if given a sorted list of values.
     *
     * @param sortedList
     *            the sorted list in ascending order
     * @param percentile
     *            the percentile
     * @return the value representing the percentile
     */
    public static double get(final double[] sortedList, final int percentile) {

        if (sortedList == null || sortedList.length == 0) {
            throw new IllegalArgumentException("Empty sorted list");
        }

        if (percentile <= 0 || percentile > 100) {
            throw new IllegalArgumentException("Invalid percentile");
        }

        return sortedList[Math.max((int) ( ( sortedList.length / 100.0 ) * percentile ) - 1, 0)];
    }
}
