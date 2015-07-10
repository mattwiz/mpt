/*******************************************************************************
 * Administrative Information (automatically filled in)
 *
 * @ Project: ModernPortfolioTheory
 * @ File Name: Portfolio.java
 * @ Author: Matthias Wiselka
 * @ Date: Jul 8, 2015 7:53:54 AM
 *
 * $Revision$
 * $LastChangedBy$
 * $LastChangedDate$
 *
 ******************************************************************************/
package com.personalcapital.mc;

/**
 * The Class Portfolio describes a stock portfolio with historic performance values (risk and mean return) and its
 * current value.
 *
 * @Author Matthias Wiselka
 */
public class Portfolio {

    private final double risk;

    private final double meanReturn;

    private final double investment;

    /**
     * Instantiates a new portfolio with the history performance values.
     *
     * @param investment
     *            the investment amount
     * @param meanReturn
     *            the mean return (per year)
     * @param risk
     *            the risk (standard deviation)
     */
    public Portfolio(final double investment, final double meanReturn, final double risk) {

        super();
        this.risk = risk;
        this.meanReturn = meanReturn;
        this.investment = investment;
    }

    /**
     * Gets the risk.
     *
     * @return the risk
     */
    public double getRisk() {

        return this.risk;
    }

    /**
     * Gets the mean return.
     *
     * @return the meanReturn
     */
    public double getMeanReturn() {

        return this.meanReturn;
    }

    /**
     * Gets the investment.
     *
     * @return the investment
     */
    public double getInvestment() {

        return this.investment;
    }

}
