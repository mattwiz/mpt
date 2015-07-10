/*******************************************************************************
 * Administrative Information (automatically filled in)
 *
 * @ Project: ModernPortfolioTheory
 * @ File Name: MonteCarloSimulator.java
 * @ Author: Matthias Wiselka
 * @ Date: Jul 8, 2015 10:09:16 AM
 *
 * $Revision$
 * $LastChangedBy$
 * $LastChangedDate$
 *
 ******************************************************************************/

package com.personalcapital.mc;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * The Class MonteCarloSimulator runs a Monte Carlo Simulation for a given portfolio. The simulation can be configured
 * for the number of years to simulate as well as how often we want to run it (how many results we want to generate).
 *
 * @Author Matthias Wiselka
 */
public class MonteCarloSimulator {

    private final int years;

    private final int numberOfRuns;

    private final Portfolio portfolio;

    private final Random random;

    /**
     * Instantiates a new monte carlo simulator.
     *
     * @param portfolio
     *            the portfolio
     * @param years
     *            the years ( > 0 )
     * @param numberOfRuns
     *            the number of runs ( > 0 )
     */
    public MonteCarloSimulator(final Portfolio portfolio, final int years, final int numberOfRuns) {

        super();

        if (years < 0) {
            throw new IllegalArgumentException("Years cannot be negative");
        }

        if (numberOfRuns <= 0) {
            throw new IllegalArgumentException("Number of runs has to be greater than 0");
        }

        if (portfolio == null) {
            throw new IllegalArgumentException("Portfolio is required");
        }

        this.portfolio = portfolio;
        this.years = years;
        this.numberOfRuns = numberOfRuns;
        this.random = new Random(); // random seed used each time
    }

    /**
     * Gets the years.
     *
     * @return the years
     */
    public int getYears() {

        return this.years;
    }

    /**
     * Gets the number of runs.
     *
     * @return the numberOfRuns
     */
    public int getNumberOfRuns() {

        return this.numberOfRuns;
    }

    /**
     * Gets the portfolio.
     *
     * @return the portfolio
     */
    public Portfolio getPortfolio() {

        return this.portfolio;
    }

    /**
     * Run the simulation for the given simulation parameters and returns the results in an ascending order.
     *
     * @return the results of the different simulation runs in ascending order
     */
    public double[] run() {

        // run #numberOfRuns simulations in a parallel stream, sort and return as array
        return IntStream.range(0, this.numberOfRuns).parallel().mapToDouble(i -> simulateResult()).sorted().toArray();
    }

    /**
     * Simulate the portfolio growth for the given amount of years.
     *
     * @return the simulated size of the investment after the given investment time
     */
    protected double simulateResult() {

        double result = this.portfolio.getInvestment();

        for (int i = 0; i < this.years; i++) {
            // calculation based on Black-Scholes model
            // return = meanReturn * deltaTime + risk * epsilon * sqrt(deltaTime), epsilon = random number 0 <= e <= 1 and detaTime = 1 to represent a year
            double riskFreeMeanReturn = ( this.portfolio.getMeanReturn() + 1d ); // adjusting mean return for growth percentage
            double randomDeviation = this.portfolio.getRisk() * this.random.nextGaussian();
            result *= ( riskFreeMeanReturn + randomDeviation );
        }

        return result;
    }
}
