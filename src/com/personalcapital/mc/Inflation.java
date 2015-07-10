/*******************************************************************************
 * Administrative Information (automatically filled in)
 *
 * @ Project: ModernPortfolioTheory
 * @ File Name: Inflation.java
 * @ Author: Matthias Wiselka
 * @ Date: Jul 8, 2015 10:53:43 AM
 *
 * $Revision$
 * $LastChangedBy$
 * $LastChangedDate$
 *
 ******************************************************************************/
package com.personalcapital.mc;

/**
 * The Class Inflation is a utility to adjust values for a given inflation rate.
 */
public final class Inflation {

    /**
     * Instantiates a new inflation.
     */
    private Inflation() {

        // prevent outside instantiation
    }

    /**
     * Adjust a given amount for a given inflation rate over a given amount of years.
     *
     * @param amount
     *            the amount to be adjusted
     * @param rate
     *            the inflation rate ( > 0 ), e.g. 0.035 for 3.5%
     * @param years
     *            the number of years to adjust for
     * @return the inflation rate adjusted amount
     */
    public static double adjust(final double amount, final double rate, final int years) {

        return amount / Math.pow(1d + rate, years);
    }
}
