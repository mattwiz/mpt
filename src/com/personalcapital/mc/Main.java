/*******************************************************************************
 * Administrative Information (automatically filled in)
 *
 * @ Project: ModernPortfolioTheory
 * @ File Name: Main.java
 * @ Author: Matthias Wiselka
 * @ Date: Jul 8, 2015 10:10:01 AM
 *
 * $Revision$
 * $LastChangedBy$
 * $LastChangedDate$
 *
 ******************************************************************************/

package com.personalcapital.mc;

/**
 * The Class Main as the main entry into the program execution. Program runs the monte carlo simulation for the
 * aggressive and very conservative portfolio and determines the median, best and worst case values.
 *
 * @Author Matthias Wiselka
 */
public class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {

        final int years = 20;
        final int runs = 10000;
        final double inflationRate = 0.035;

        /*
         * Aggressuve Portfolio calculation
         */
        Portfolio aggressive = new Portfolio(100000, 0.094324, 0.15675);

        MonteCarloSimulator aggressiveSimulation = new MonteCarloSimulator(aggressive, years, runs);
        double[] aggresiveResults = aggressiveSimulation.run();

        System.out.println("Aggressive portfolio: ");
        System.out.format("50th percentile (median): %,.2f, adjusted for inflation: %,.2f%n",
            Percentile.get(aggresiveResults, 50),
            Inflation.adjust(Percentile.get(aggresiveResults, 50), inflationRate, years));
        System.out.format("90th percentile (best case): %,.2f, adjusted for inflation: %,.2f%n",
            Percentile.get(aggresiveResults, 90),
            Inflation.adjust(Percentile.get(aggresiveResults, 90), inflationRate, years));
        System.out.format("10th percentile (worst case): %,.2f, adjusted for inflation: %,.2f%n",
            Percentile.get(aggresiveResults, 10),
            Inflation.adjust(Percentile.get(aggresiveResults, 10), inflationRate, years));

        System.out.println();

        /*
         * Conservative Portfolio calculation
         */
        Portfolio veryConservative = new Portfolio(100000, 0.06189, 0.063438);

        MonteCarloSimulator conservativeSimulation = new MonteCarloSimulator(veryConservative, years, runs);
        double[] conservativeResults = conservativeSimulation.run();

        System.out.println("Very conservative portfolio: ");
        System.out.format("50th percentile (median): %,.2f, adjusted for inflation: %,.2f%n",
            Percentile.get(conservativeResults, 50),
            Inflation.adjust(Percentile.get(conservativeResults, 50), inflationRate, years));
        System.out.format("90th percentile (best case): %,.2f, adjusted for inflation: %,.2f%n",
            Percentile.get(conservativeResults, 90),
            Inflation.adjust(Percentile.get(conservativeResults, 90), inflationRate, years));
        System.out.format("10th percentile (worst case): %,.2f, adjusted for inflation: %,.2f%n",
            Percentile.get(conservativeResults, 10),
            Inflation.adjust(Percentile.get(conservativeResults, 10), inflationRate, years));

    }
}
